// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: db.proto

package iiis.systems.os.blockdb;

/**
 * Protobuf type {@code blockdb.TransferRequest}
 */
public  final class TransferRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:blockdb.TransferRequest)
    TransferRequestOrBuilder {
  // Use TransferRequest.newBuilder() to construct.
  private TransferRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TransferRequest() {
    fromID_ = "";
    toID_ = "";
    value_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private TransferRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            fromID_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            toID_ = s;
            break;
          }
          case 24: {

            value_ = input.readInt32();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return iiis.systems.os.blockdb.DBProto.internal_static_blockdb_TransferRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return iiis.systems.os.blockdb.DBProto.internal_static_blockdb_TransferRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            iiis.systems.os.blockdb.TransferRequest.class, iiis.systems.os.blockdb.TransferRequest.Builder.class);
  }

  public static final int FROMID_FIELD_NUMBER = 1;
  private volatile java.lang.Object fromID_;
  /**
   * <code>string FromID = 1;</code>
   */
  public java.lang.String getFromID() {
    java.lang.Object ref = fromID_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      fromID_ = s;
      return s;
    }
  }
  /**
   * <code>string FromID = 1;</code>
   */
  public com.google.protobuf.ByteString
      getFromIDBytes() {
    java.lang.Object ref = fromID_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      fromID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TOID_FIELD_NUMBER = 2;
  private volatile java.lang.Object toID_;
  /**
   * <code>string ToID = 2;</code>
   */
  public java.lang.String getToID() {
    java.lang.Object ref = toID_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      toID_ = s;
      return s;
    }
  }
  /**
   * <code>string ToID = 2;</code>
   */
  public com.google.protobuf.ByteString
      getToIDBytes() {
    java.lang.Object ref = toID_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      toID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int VALUE_FIELD_NUMBER = 3;
  private int value_;
  /**
   * <code>int32 Value = 3;</code>
   */
  public int getValue() {
    return value_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getFromIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, fromID_);
    }
    if (!getToIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, toID_);
    }
    if (value_ != 0) {
      output.writeInt32(3, value_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getFromIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, fromID_);
    }
    if (!getToIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, toID_);
    }
    if (value_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, value_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof iiis.systems.os.blockdb.TransferRequest)) {
      return super.equals(obj);
    }
    iiis.systems.os.blockdb.TransferRequest other = (iiis.systems.os.blockdb.TransferRequest) obj;

    boolean result = true;
    result = result && getFromID()
        .equals(other.getFromID());
    result = result && getToID()
        .equals(other.getToID());
    result = result && (getValue()
        == other.getValue());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + FROMID_FIELD_NUMBER;
    hash = (53 * hash) + getFromID().hashCode();
    hash = (37 * hash) + TOID_FIELD_NUMBER;
    hash = (53 * hash) + getToID().hashCode();
    hash = (37 * hash) + VALUE_FIELD_NUMBER;
    hash = (53 * hash) + getValue();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static iiis.systems.os.blockdb.TransferRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static iiis.systems.os.blockdb.TransferRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static iiis.systems.os.blockdb.TransferRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static iiis.systems.os.blockdb.TransferRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static iiis.systems.os.blockdb.TransferRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static iiis.systems.os.blockdb.TransferRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static iiis.systems.os.blockdb.TransferRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static iiis.systems.os.blockdb.TransferRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static iiis.systems.os.blockdb.TransferRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static iiis.systems.os.blockdb.TransferRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(iiis.systems.os.blockdb.TransferRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code blockdb.TransferRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:blockdb.TransferRequest)
      iiis.systems.os.blockdb.TransferRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return iiis.systems.os.blockdb.DBProto.internal_static_blockdb_TransferRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return iiis.systems.os.blockdb.DBProto.internal_static_blockdb_TransferRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              iiis.systems.os.blockdb.TransferRequest.class, iiis.systems.os.blockdb.TransferRequest.Builder.class);
    }

    // Construct using iiis.systems.os.blockdb.TransferRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      fromID_ = "";

      toID_ = "";

      value_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return iiis.systems.os.blockdb.DBProto.internal_static_blockdb_TransferRequest_descriptor;
    }

    public iiis.systems.os.blockdb.TransferRequest getDefaultInstanceForType() {
      return iiis.systems.os.blockdb.TransferRequest.getDefaultInstance();
    }

    public iiis.systems.os.blockdb.TransferRequest build() {
      iiis.systems.os.blockdb.TransferRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public iiis.systems.os.blockdb.TransferRequest buildPartial() {
      iiis.systems.os.blockdb.TransferRequest result = new iiis.systems.os.blockdb.TransferRequest(this);
      result.fromID_ = fromID_;
      result.toID_ = toID_;
      result.value_ = value_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof iiis.systems.os.blockdb.TransferRequest) {
        return mergeFrom((iiis.systems.os.blockdb.TransferRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(iiis.systems.os.blockdb.TransferRequest other) {
      if (other == iiis.systems.os.blockdb.TransferRequest.getDefaultInstance()) return this;
      if (!other.getFromID().isEmpty()) {
        fromID_ = other.fromID_;
        onChanged();
      }
      if (!other.getToID().isEmpty()) {
        toID_ = other.toID_;
        onChanged();
      }
      if (other.getValue() != 0) {
        setValue(other.getValue());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      iiis.systems.os.blockdb.TransferRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (iiis.systems.os.blockdb.TransferRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object fromID_ = "";
    /**
     * <code>string FromID = 1;</code>
     */
    public java.lang.String getFromID() {
      java.lang.Object ref = fromID_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        fromID_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string FromID = 1;</code>
     */
    public com.google.protobuf.ByteString
        getFromIDBytes() {
      java.lang.Object ref = fromID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        fromID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string FromID = 1;</code>
     */
    public Builder setFromID(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      fromID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string FromID = 1;</code>
     */
    public Builder clearFromID() {
      
      fromID_ = getDefaultInstance().getFromID();
      onChanged();
      return this;
    }
    /**
     * <code>string FromID = 1;</code>
     */
    public Builder setFromIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      fromID_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object toID_ = "";
    /**
     * <code>string ToID = 2;</code>
     */
    public java.lang.String getToID() {
      java.lang.Object ref = toID_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        toID_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string ToID = 2;</code>
     */
    public com.google.protobuf.ByteString
        getToIDBytes() {
      java.lang.Object ref = toID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        toID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string ToID = 2;</code>
     */
    public Builder setToID(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      toID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string ToID = 2;</code>
     */
    public Builder clearToID() {
      
      toID_ = getDefaultInstance().getToID();
      onChanged();
      return this;
    }
    /**
     * <code>string ToID = 2;</code>
     */
    public Builder setToIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      toID_ = value;
      onChanged();
      return this;
    }

    private int value_ ;
    /**
     * <code>int32 Value = 3;</code>
     */
    public int getValue() {
      return value_;
    }
    /**
     * <code>int32 Value = 3;</code>
     */
    public Builder setValue(int value) {
      
      value_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 Value = 3;</code>
     */
    public Builder clearValue() {
      
      value_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:blockdb.TransferRequest)
  }

  // @@protoc_insertion_point(class_scope:blockdb.TransferRequest)
  private static final iiis.systems.os.blockdb.TransferRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new iiis.systems.os.blockdb.TransferRequest();
  }

  public static iiis.systems.os.blockdb.TransferRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TransferRequest>
      PARSER = new com.google.protobuf.AbstractParser<TransferRequest>() {
    public TransferRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new TransferRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TransferRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TransferRequest> getParserForType() {
    return PARSER;
  }

  public iiis.systems.os.blockdb.TransferRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

