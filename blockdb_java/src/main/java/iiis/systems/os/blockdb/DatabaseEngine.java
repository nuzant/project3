package iiis.systems.os.blockdb;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class DatabaseEngine {
    private static DatabaseEngine instance = null;

    public static DatabaseEngine getInstance() {
        return instance;
    }

    public static void setup(String dataDir) {
        instance = new DatabaseEngine(dataDir);
    }

    private HashMap<String, Integer> balances = new HashMap<>();
    private int logLength = 0;
    private String dataDir;
    private int blockId = 1;
    private JsonArray blockTransRecord = new JsonArray();

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
        check_output();
        logLength++;
        return getOrZero(userId);
    }

    public boolean put(String userId, int value) {
        output_log(1, userId, "", value);
        check_output();
        logLength++;
        balances.put(userId, value);
        return true;
    }

    public boolean deposit(String userId, int value) {
        output_log(2, userId, "", value);
        check_output();
        logLength++;
        int balance = getOrZero(userId);
        balances.put(userId, balance + value);
        return true;
    }

    public boolean withdraw(String userId, int value) {
        output_log(3, userId, "", value);
        check_output();
        logLength++;
        int balance = getOrZero(userId);
        balances.put(userId, balance - value);
        return true;
    }

    public boolean transfer(String fromId, String toId, int value) {
        output_log(4, fromId, toId, value);
        check_output();
        logLength++;
        int fromBalance = getOrZero(fromId);
        int toBalance = getOrZero(toId);
        balances.put(fromId, fromBalance - value);
        balances.put(toId, toBalance + value);
        return true;
    }

    public int getLogLength() {
        return logLength;
    }

    public void output_log(int type, String fromId, String toId, int value){
        //create log if not exist
        File createLogFile = new File(dataDir + "log.json");
        if(!createLogFile.exists()){
            try{
                if(createLogFile.createNewFile()){
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
            case 1:
                typeStr = "PUT";
            case 2:
                typeStr = "DEPOSIT";
            case 3:
                typeStr = "WITHDRAW";
            case 4:
                typeStr = "TRANSFER";
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

            try(FileWriter file = new FileWriter(dataDir + "log.json")){
                file.write(trans.toString());
                file.flush();
                file.close();
            } catch(IOException e){
                e.printStackTrace();
            }

            blockTransRecord.add(trans);
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

        //update blockid, clear trans record
        blockId ++;
        blockTransRecord = new JsonArray();

        //create blockfile 
        File createBlockFile = new File(dataDir + Integer.toString(blockId) + ".json");
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
        File logFile = new File(dataDir + "log.json");
        if(logFile.delete()){
            System.out.println("Log file deleted!");
        } else {
            System.out.println("Fail to delete logfile.");
        }
    }
}
