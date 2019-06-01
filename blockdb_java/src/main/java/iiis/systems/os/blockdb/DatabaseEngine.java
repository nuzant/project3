package iiis.systems.os.blockdb;

import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class DatabaseEngine {
    private static DatabaseEngine instance = null;

    public static DatabaseEngine getInstance() {
        return instance;
    }

    public static void setup(String dataDir) {
       instance = new DatabaseEngine(dataDir);
       instance.recover();
       instance.print_balance();
    }

    private HashMap<String, Integer> balances = new HashMap<>();
    private int logLength = 0;
    private String dataDir;
    private int blockId = 1;
    private JsonArray blockTransRecord = new JsonArray();
    private File logFile = new File(dataDir + "log.json");
    //private FileWriter logWriter;

    DatabaseEngine(String dataDir) {
        this.dataDir = dataDir;
    }

    private int getOrZero(String userId) {
        if (balances.containsKey(userId)) {
            return balances.get(userId);
        } else {
            return 0;
        }
    }

    public int get(String userId) {
        //logLength++;
        check_output();
        return getOrZero(userId);
    }

    public boolean put(String userId, int value) {
        logLength++;
        balances.put(userId, value);
        output_log(1, userId, "", value);
        check_output();
        return true;
    }

    public boolean deposit(String userId, int value) {
        logLength++;
        int balance = getOrZero(userId);
        balances.put(userId, balance + value);
        output_log(2, userId, "", value);
        check_output();
        return true;
    }

    public boolean withdraw(String userId, int value) {
        int balance = getOrZero(userId);
        if(balance - value < 0){
            return false;
        }
        logLength++;
        balances.put(userId, balance - value);
        output_log(3, userId, "", value);
        check_output();
        return true;
    }

    public boolean transfer(String fromId, String toId, int value) {
        int fromBalance = getOrZero(fromId);
        int toBalance = getOrZero(toId);
        if(fromBalance - value < 0){
            return false;
        }
        logLength++;
        balances.put(fromId, fromBalance - value);
        balances.put(toId, toBalance + value);
        output_log(4, fromId, toId, value);
        check_output();
        return true;
    }

    public int getLogLength() {
        return logLength;
    }

    public void output_log(int type, String fromId, String toId, int value){
        //create log if not exist
        //File createLogFile = new File(dataDir + "log.json");
        if(!logFile.exists()){
            try{
                if(logFile.createNewFile()){
                    System.out.println("Log file created.");
                } 
            } catch(IOException e){
                System.out.println("Logfile fail to create.");
            }
        }

        JsonObject trans = new JsonObject();

        String typeStr = "";
        // 0:get 1:put 2:deposit 3:withdraw 4:transfer
        switch(type){
            case 0:
                typeStr = "GET";
                break;
            case 1:
                typeStr = "PUT";
                break;
            case 2:
                typeStr = "DEPOSIT";
                break;
            case 3:
                typeStr = "WITHDRAW";
                break;
            case 4:
                typeStr = "TRANSFER";
                break;
        }
        

        if(type != 0){
            trans.addProperty("Type", typeStr);
            if(type != 4){   
                trans.addProperty("UserID", fromId);
            } else {
                trans.addProperty("FromID", fromId);
                trans.addProperty("ToID", toId);
            }
            trans.addProperty("Value", value);
            
            blockTransRecord.add(trans);

            try(FileWriter logWriter = new FileWriter(dataDir + "log.json")){
                logWriter.write(blockTransRecord.toString());
                logWriter.flush();
                logWriter.close();
                System.out.println("PRINT LOG");
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    //check loglength, and output
    public boolean check_output(){
        if(logLength == 50){
            output_block();
            logLength = 0;
            return true;
        } else {
            return false;
        }
    }

    //when loglength == 50, output block, clear log
    public void output_block(){
        JsonObject block = new JsonObject();
        block.addProperty("BlockID", blockId);
        block.addProperty("PrevHash", "00000000");
        block.add("Transactions", blockTransRecord);
        block.addProperty("Nonce", "00000000");

        //create blockfile 
        File createBlockFile = new File(dataDir + Integer.toString(blockId) + ".json");
        createBlockFile.delete();
        if(!createBlockFile.exists()){
            try{
                if(createBlockFile.createNewFile()){
                    System.out.println("New block created, blockid:" + Integer.toString(blockId));
                }
            } catch (IOException e){
                e.printStackTrace();
                System.out.println("Creating block failed, blockid:" + Integer.toString(blockId));
            }
        }
        // write new block
        try(FileWriter file = new FileWriter(dataDir + Integer.toString(blockId) + ".json")){
            file.write(block.toString());
            file.flush();

            System.out.println("Writing information to block: " + dataDir + Integer.toString(blockId) + ".json");
        } catch(IOException e){
            //e.printStackTrace();
            System.out.println("Fail to write block: " + dataDir + Integer.toString(blockId) + ".json");
        }

        // delete log.json
        //File logFile = new File(dataDir + "log.json");
        if(logFile.delete()){
            System.out.println("Log file deleted!");
        } else {
            System.out.println("Fail to delete logfile.");
        }

        //update blockid, clear trans record
        blockId ++;
        blockTransRecord = new JsonArray();
    }
    
    public void recover() {
    	for (int i = 1; ; i++) {
    		if(!recover_from_block(dataDir + Integer.toString(i) + ".json", false))
    			break;
    	}
    	recover_from_block(dataDir + "log.json", true);
    }
    
    public boolean recover_from_block(String path, boolean log) {
    	try(FileReader file = new FileReader(path)){
    		JsonParser parser = new JsonParser();
    		JsonArray blockTranRecord;
    		if (!log) {
    		   JsonObject obj = (JsonObject) parser.parse(file);
    		   blockTranRecord = obj.get("Transactions").getAsJsonArray();
    		}
    		else {
    		   blockTranRecord = (JsonArray) parser.parse(file);
    		}
    			
    		if (blockTranRecord.size() > 0) {
    			for (int i = 0; i < blockTranRecord.size(); i++) {
    				JsonObject object = (JsonObject) blockTranRecord.get(i);
    				String type = object.get("Type").getAsString();
    				int value = object.get("Value").getAsInt();  
    				String fromId = null, toId = null;	
    				String userId = null;
    				if(type.equals("TRANSFER")) {
    					fromId = object.get("FromID").getAsString();
    					toId = object.get("ToID").getAsString();
    				}
    				else {
    					userId = object.get("UserID").getAsString();
    				}
    				
    					    
    				int balance = getOrZero(userId);
    		    
    				switch(type) {
    				case "PUT":
    					balances.put(userId, value);
    					break;
    				case "DEPOSIT": 
    					balances.put(userId, balance + value);
    					break;
    				case "WITHDRAW":
    					balances.put(userId, balance - value);
    					break;
    				case "TRANSFER": {
    					int fromBalance = getOrZero(fromId);
    					int toBalance = getOrZero(toId);
    					balances.put(fromId, fromBalance - value);
    					balances.put(toId, toBalance + value);
    					break;
    				}
    			    }
    		    }
    	    }
    		return true;
    	} catch(IOException e){
    		return false;
    	}
    }
    
    public void print_balance() {
    	File createBlockFile = new File(dataDir + "balance.json");
        createBlockFile.delete();
        if(!createBlockFile.exists()){
            try{
                if(createBlockFile.createNewFile()){
                    System.out.println("New block created");
                }
            } catch (IOException e){
                e.printStackTrace();
                System.out.println("Creating block failed");
            }
        }
        
        List<String> list = new ArrayList<>();
        for (Entry<String, Integer> entry: balances.entrySet()) {
        	StringBuilder s = new StringBuilder();
        	s.append(entry.getKey()).append(" ").append(entry.getValue());
        	list.add(s.toString());
        }
        
        try(FileWriter file = new FileWriter(dataDir + "balance.json")){
            file.write(list.toString());
            file.flush();

            System.out.println("Writing information to block");
        } catch(IOException e){
            //e.printStackTrace();
            System.out.println("Fail to write block");
        }
    }
}
