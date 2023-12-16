// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: blogposts.proto

// Protobuf Java Version: 3.25.1
package de.samples.apicomparison.consumer.clients.grpc.stub;

/**
 * Protobuf type {@code BlogPostInput}
 */
public final class BlogPostInput extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:BlogPostInput)
    BlogPostInputOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BlogPostInput.newBuilder() to construct.
  private BlogPostInput(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BlogPostInput() {
    title_ = "";
    content_ = "";
    hashTags_ =
        com.google.protobuf.LazyStringArrayList.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new BlogPostInput();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return de.samples.apicomparison.consumer.clients.grpc.stub.Blogposts.internal_static_BlogPostInput_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return de.samples.apicomparison.consumer.clients.grpc.stub.Blogposts.internal_static_BlogPostInput_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput.class, de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput.Builder.class);
  }

  private int bitField0_;
  public static final int TITLE_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object title_ = "";
  /**
   * <code>string title = 2;</code>
   * @return The title.
   */
  @java.lang.Override
  public java.lang.String getTitle() {
    java.lang.Object ref = title_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      title_ = s;
      return s;
    }
  }
  /**
   * <code>string title = 2;</code>
   * @return The bytes for title.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTitleBytes() {
    java.lang.Object ref = title_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      title_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CONTENT_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object content_ = "";
  /**
   * <code>string content = 3;</code>
   * @return The content.
   */
  @java.lang.Override
  public java.lang.String getContent() {
    java.lang.Object ref = content_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      content_ = s;
      return s;
    }
  }
  /**
   * <code>string content = 3;</code>
   * @return The bytes for content.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getContentBytes() {
    java.lang.Object ref = content_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      content_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AUTHOR_ID_FIELD_NUMBER = 5;
  private de.samples.apicomparison.consumer.clients.grpc.stub.UUID authorId_;
  /**
   * <code>optional .UUID author_id = 5;</code>
   * @return Whether the authorId field is set.
   */
  @java.lang.Override
  public boolean hasAuthorId() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional .UUID author_id = 5;</code>
   * @return The authorId.
   */
  @java.lang.Override
  public de.samples.apicomparison.consumer.clients.grpc.stub.UUID getAuthorId() {
    return authorId_ == null ? de.samples.apicomparison.consumer.clients.grpc.stub.UUID.getDefaultInstance() : authorId_;
  }
  /**
   * <code>optional .UUID author_id = 5;</code>
   */
  @java.lang.Override
  public de.samples.apicomparison.consumer.clients.grpc.stub.UUIDOrBuilder getAuthorIdOrBuilder() {
    return authorId_ == null ? de.samples.apicomparison.consumer.clients.grpc.stub.UUID.getDefaultInstance() : authorId_;
  }

  public static final int HASHTAGS_FIELD_NUMBER = 6;
  @SuppressWarnings("serial")
  private com.google.protobuf.LazyStringArrayList hashTags_ =
      com.google.protobuf.LazyStringArrayList.emptyList();
  /**
   * <code>repeated string hashTags = 6;</code>
   * @return A list containing the hashTags.
   */
  public com.google.protobuf.ProtocolStringList
      getHashTagsList() {
    return hashTags_;
  }
  /**
   * <code>repeated string hashTags = 6;</code>
   * @return The count of hashTags.
   */
  public int getHashTagsCount() {
    return hashTags_.size();
  }
  /**
   * <code>repeated string hashTags = 6;</code>
   * @param index The index of the element to return.
   * @return The hashTags at the given index.
   */
  public java.lang.String getHashTags(int index) {
    return hashTags_.get(index);
  }
  /**
   * <code>repeated string hashTags = 6;</code>
   * @param index The index of the value to return.
   * @return The bytes of the hashTags at the given index.
   */
  public com.google.protobuf.ByteString
      getHashTagsBytes(int index) {
    return hashTags_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(title_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, title_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(content_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, content_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(5, getAuthorId());
    }
    for (int i = 0; i < hashTags_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, hashTags_.getRaw(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(title_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, title_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(content_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, content_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, getAuthorId());
    }
    {
      int dataSize = 0;
      for (int i = 0; i < hashTags_.size(); i++) {
        dataSize += computeStringSizeNoTag(hashTags_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getHashTagsList().size();
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput)) {
      return super.equals(obj);
    }
    de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput other = (de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput) obj;

    if (!getTitle()
        .equals(other.getTitle())) return false;
    if (!getContent()
        .equals(other.getContent())) return false;
    if (hasAuthorId() != other.hasAuthorId()) return false;
    if (hasAuthorId()) {
      if (!getAuthorId()
          .equals(other.getAuthorId())) return false;
    }
    if (!getHashTagsList()
        .equals(other.getHashTagsList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TITLE_FIELD_NUMBER;
    hash = (53 * hash) + getTitle().hashCode();
    hash = (37 * hash) + CONTENT_FIELD_NUMBER;
    hash = (53 * hash) + getContent().hashCode();
    if (hasAuthorId()) {
      hash = (37 * hash) + AUTHOR_ID_FIELD_NUMBER;
      hash = (53 * hash) + getAuthorId().hashCode();
    }
    if (getHashTagsCount() > 0) {
      hash = (37 * hash) + HASHTAGS_FIELD_NUMBER;
      hash = (53 * hash) + getHashTagsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
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
   * Protobuf type {@code BlogPostInput}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:BlogPostInput)
      de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInputOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return de.samples.apicomparison.consumer.clients.grpc.stub.Blogposts.internal_static_BlogPostInput_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return de.samples.apicomparison.consumer.clients.grpc.stub.Blogposts.internal_static_BlogPostInput_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput.class, de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput.Builder.class);
    }

    // Construct using de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput.newBuilder()
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
        getAuthorIdFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      title_ = "";
      content_ = "";
      authorId_ = null;
      if (authorIdBuilder_ != null) {
        authorIdBuilder_.dispose();
        authorIdBuilder_ = null;
      }
      hashTags_ =
          com.google.protobuf.LazyStringArrayList.emptyList();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return de.samples.apicomparison.consumer.clients.grpc.stub.Blogposts.internal_static_BlogPostInput_descriptor;
    }

    @java.lang.Override
    public de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput getDefaultInstanceForType() {
      return de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput.getDefaultInstance();
    }

    @java.lang.Override
    public de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput build() {
      de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput buildPartial() {
      de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput result = new de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.title_ = title_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.content_ = content_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.authorId_ = authorIdBuilder_ == null
            ? authorId_
            : authorIdBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        hashTags_.makeImmutable();
        result.hashTags_ = hashTags_;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput) {
        return mergeFrom((de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput other) {
      if (other == de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput.getDefaultInstance()) return this;
      if (!other.getTitle().isEmpty()) {
        title_ = other.title_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getContent().isEmpty()) {
        content_ = other.content_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (other.hasAuthorId()) {
        mergeAuthorId(other.getAuthorId());
      }
      if (!other.hashTags_.isEmpty()) {
        if (hashTags_.isEmpty()) {
          hashTags_ = other.hashTags_;
          bitField0_ |= 0x00000008;
        } else {
          ensureHashTagsIsMutable();
          hashTags_.addAll(other.hashTags_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 18: {
              title_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 18
            case 26: {
              content_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 26
            case 42: {
              input.readMessage(
                  getAuthorIdFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000004;
              break;
            } // case 42
            case 50: {
              java.lang.String s = input.readStringRequireUtf8();
              ensureHashTagsIsMutable();
              hashTags_.add(s);
              break;
            } // case 50
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object title_ = "";
    /**
     * <code>string title = 2;</code>
     * @return The title.
     */
    public java.lang.String getTitle() {
      java.lang.Object ref = title_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        title_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string title = 2;</code>
     * @return The bytes for title.
     */
    public com.google.protobuf.ByteString
        getTitleBytes() {
      java.lang.Object ref = title_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        title_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string title = 2;</code>
     * @param value The title to set.
     * @return This builder for chaining.
     */
    public Builder setTitle(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      title_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string title = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTitle() {
      title_ = getDefaultInstance().getTitle();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string title = 2;</code>
     * @param value The bytes for title to set.
     * @return This builder for chaining.
     */
    public Builder setTitleBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      title_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object content_ = "";
    /**
     * <code>string content = 3;</code>
     * @return The content.
     */
    public java.lang.String getContent() {
      java.lang.Object ref = content_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        content_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string content = 3;</code>
     * @return The bytes for content.
     */
    public com.google.protobuf.ByteString
        getContentBytes() {
      java.lang.Object ref = content_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        content_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string content = 3;</code>
     * @param value The content to set.
     * @return This builder for chaining.
     */
    public Builder setContent(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      content_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string content = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearContent() {
      content_ = getDefaultInstance().getContent();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string content = 3;</code>
     * @param value The bytes for content to set.
     * @return This builder for chaining.
     */
    public Builder setContentBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      content_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private de.samples.apicomparison.consumer.clients.grpc.stub.UUID authorId_;
    private com.google.protobuf.SingleFieldBuilderV3<
        de.samples.apicomparison.consumer.clients.grpc.stub.UUID, de.samples.apicomparison.consumer.clients.grpc.stub.UUID.Builder, de.samples.apicomparison.consumer.clients.grpc.stub.UUIDOrBuilder> authorIdBuilder_;
    /**
     * <code>optional .UUID author_id = 5;</code>
     * @return Whether the authorId field is set.
     */
    public boolean hasAuthorId() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>optional .UUID author_id = 5;</code>
     * @return The authorId.
     */
    public de.samples.apicomparison.consumer.clients.grpc.stub.UUID getAuthorId() {
      if (authorIdBuilder_ == null) {
        return authorId_ == null ? de.samples.apicomparison.consumer.clients.grpc.stub.UUID.getDefaultInstance() : authorId_;
      } else {
        return authorIdBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .UUID author_id = 5;</code>
     */
    public Builder setAuthorId(de.samples.apicomparison.consumer.clients.grpc.stub.UUID value) {
      if (authorIdBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        authorId_ = value;
      } else {
        authorIdBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>optional .UUID author_id = 5;</code>
     */
    public Builder setAuthorId(
        de.samples.apicomparison.consumer.clients.grpc.stub.UUID.Builder builderForValue) {
      if (authorIdBuilder_ == null) {
        authorId_ = builderForValue.build();
      } else {
        authorIdBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>optional .UUID author_id = 5;</code>
     */
    public Builder mergeAuthorId(de.samples.apicomparison.consumer.clients.grpc.stub.UUID value) {
      if (authorIdBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0) &&
          authorId_ != null &&
          authorId_ != de.samples.apicomparison.consumer.clients.grpc.stub.UUID.getDefaultInstance()) {
          getAuthorIdBuilder().mergeFrom(value);
        } else {
          authorId_ = value;
        }
      } else {
        authorIdBuilder_.mergeFrom(value);
      }
      if (authorId_ != null) {
        bitField0_ |= 0x00000004;
        onChanged();
      }
      return this;
    }
    /**
     * <code>optional .UUID author_id = 5;</code>
     */
    public Builder clearAuthorId() {
      bitField0_ = (bitField0_ & ~0x00000004);
      authorId_ = null;
      if (authorIdBuilder_ != null) {
        authorIdBuilder_.dispose();
        authorIdBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>optional .UUID author_id = 5;</code>
     */
    public de.samples.apicomparison.consumer.clients.grpc.stub.UUID.Builder getAuthorIdBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getAuthorIdFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .UUID author_id = 5;</code>
     */
    public de.samples.apicomparison.consumer.clients.grpc.stub.UUIDOrBuilder getAuthorIdOrBuilder() {
      if (authorIdBuilder_ != null) {
        return authorIdBuilder_.getMessageOrBuilder();
      } else {
        return authorId_ == null ?
            de.samples.apicomparison.consumer.clients.grpc.stub.UUID.getDefaultInstance() : authorId_;
      }
    }
    /**
     * <code>optional .UUID author_id = 5;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        de.samples.apicomparison.consumer.clients.grpc.stub.UUID, de.samples.apicomparison.consumer.clients.grpc.stub.UUID.Builder, de.samples.apicomparison.consumer.clients.grpc.stub.UUIDOrBuilder> 
        getAuthorIdFieldBuilder() {
      if (authorIdBuilder_ == null) {
        authorIdBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            de.samples.apicomparison.consumer.clients.grpc.stub.UUID, de.samples.apicomparison.consumer.clients.grpc.stub.UUID.Builder, de.samples.apicomparison.consumer.clients.grpc.stub.UUIDOrBuilder>(
                getAuthorId(),
                getParentForChildren(),
                isClean());
        authorId_ = null;
      }
      return authorIdBuilder_;
    }

    private com.google.protobuf.LazyStringArrayList hashTags_ =
        com.google.protobuf.LazyStringArrayList.emptyList();
    private void ensureHashTagsIsMutable() {
      if (!hashTags_.isModifiable()) {
        hashTags_ = new com.google.protobuf.LazyStringArrayList(hashTags_);
      }
      bitField0_ |= 0x00000008;
    }
    /**
     * <code>repeated string hashTags = 6;</code>
     * @return A list containing the hashTags.
     */
    public com.google.protobuf.ProtocolStringList
        getHashTagsList() {
      hashTags_.makeImmutable();
      return hashTags_;
    }
    /**
     * <code>repeated string hashTags = 6;</code>
     * @return The count of hashTags.
     */
    public int getHashTagsCount() {
      return hashTags_.size();
    }
    /**
     * <code>repeated string hashTags = 6;</code>
     * @param index The index of the element to return.
     * @return The hashTags at the given index.
     */
    public java.lang.String getHashTags(int index) {
      return hashTags_.get(index);
    }
    /**
     * <code>repeated string hashTags = 6;</code>
     * @param index The index of the value to return.
     * @return The bytes of the hashTags at the given index.
     */
    public com.google.protobuf.ByteString
        getHashTagsBytes(int index) {
      return hashTags_.getByteString(index);
    }
    /**
     * <code>repeated string hashTags = 6;</code>
     * @param index The index to set the value at.
     * @param value The hashTags to set.
     * @return This builder for chaining.
     */
    public Builder setHashTags(
        int index, java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureHashTagsIsMutable();
      hashTags_.set(index, value);
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string hashTags = 6;</code>
     * @param value The hashTags to add.
     * @return This builder for chaining.
     */
    public Builder addHashTags(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureHashTagsIsMutable();
      hashTags_.add(value);
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string hashTags = 6;</code>
     * @param values The hashTags to add.
     * @return This builder for chaining.
     */
    public Builder addAllHashTags(
        java.lang.Iterable<java.lang.String> values) {
      ensureHashTagsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, hashTags_);
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string hashTags = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearHashTags() {
      hashTags_ =
        com.google.protobuf.LazyStringArrayList.emptyList();
      bitField0_ = (bitField0_ & ~0x00000008);;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string hashTags = 6;</code>
     * @param value The bytes of the hashTags to add.
     * @return This builder for chaining.
     */
    public Builder addHashTagsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      ensureHashTagsIsMutable();
      hashTags_.add(value);
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:BlogPostInput)
  }

  // @@protoc_insertion_point(class_scope:BlogPostInput)
  private static final de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput();
  }

  public static de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BlogPostInput>
      PARSER = new com.google.protobuf.AbstractParser<BlogPostInput>() {
    @java.lang.Override
    public BlogPostInput parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<BlogPostInput> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BlogPostInput> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

