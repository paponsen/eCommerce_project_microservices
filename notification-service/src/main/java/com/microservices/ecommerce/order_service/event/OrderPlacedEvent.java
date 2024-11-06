/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.microservices.ecommerce.order_service.event;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class OrderPlacedEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8231963461921526526L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OrderPlacedEvent\",\"namespace\":\"com.microservices.ecommerce.order_service.event\",\"fields\":[{\"name\":\"orderNumber\",\"type\":\"string\"},{\"name\":\"email\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<OrderPlacedEvent> ENCODER =
      new BinaryMessageEncoder<OrderPlacedEvent>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<OrderPlacedEvent> DECODER =
      new BinaryMessageDecoder<OrderPlacedEvent>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<OrderPlacedEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<OrderPlacedEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<OrderPlacedEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<OrderPlacedEvent>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this OrderPlacedEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a OrderPlacedEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a OrderPlacedEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static OrderPlacedEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence orderNumber;
  private java.lang.CharSequence email;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public OrderPlacedEvent() {}

  /**
   * All-args constructor.
   * @param orderNumber The new value for orderNumber
   * @param email The new value for email
   */
  public OrderPlacedEvent(java.lang.CharSequence orderNumber, java.lang.CharSequence email) {
    this.orderNumber = orderNumber;
    this.email = email;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return orderNumber;
    case 1: return email;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: orderNumber = (java.lang.CharSequence)value$; break;
    case 1: email = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'orderNumber' field.
   * @return The value of the 'orderNumber' field.
   */
  public java.lang.CharSequence getOrderNumber() {
    return orderNumber;
  }


  /**
   * Sets the value of the 'orderNumber' field.
   * @param value the value to set.
   */
  public void setOrderNumber(java.lang.CharSequence value) {
    this.orderNumber = value;
  }

  /**
   * Gets the value of the 'email' field.
   * @return The value of the 'email' field.
   */
  public java.lang.CharSequence getEmail() {
    return email;
  }


  /**
   * Sets the value of the 'email' field.
   * @param value the value to set.
   */
  public void setEmail(java.lang.CharSequence value) {
    this.email = value;
  }

  /**
   * Creates a new OrderPlacedEvent RecordBuilder.
   * @return A new OrderPlacedEvent RecordBuilder
   */
  public static com.microservices.ecommerce.order_service.event.OrderPlacedEvent.Builder newBuilder() {
    return new com.microservices.ecommerce.order_service.event.OrderPlacedEvent.Builder();
  }

  /**
   * Creates a new OrderPlacedEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new OrderPlacedEvent RecordBuilder
   */
  public static com.microservices.ecommerce.order_service.event.OrderPlacedEvent.Builder newBuilder(com.microservices.ecommerce.order_service.event.OrderPlacedEvent.Builder other) {
    if (other == null) {
      return new com.microservices.ecommerce.order_service.event.OrderPlacedEvent.Builder();
    } else {
      return new com.microservices.ecommerce.order_service.event.OrderPlacedEvent.Builder(other);
    }
  }

  /**
   * Creates a new OrderPlacedEvent RecordBuilder by copying an existing OrderPlacedEvent instance.
   * @param other The existing instance to copy.
   * @return A new OrderPlacedEvent RecordBuilder
   */
  public static com.microservices.ecommerce.order_service.event.OrderPlacedEvent.Builder newBuilder(com.microservices.ecommerce.order_service.event.OrderPlacedEvent other) {
    if (other == null) {
      return new com.microservices.ecommerce.order_service.event.OrderPlacedEvent.Builder();
    } else {
      return new com.microservices.ecommerce.order_service.event.OrderPlacedEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for OrderPlacedEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OrderPlacedEvent>
    implements org.apache.avro.data.RecordBuilder<OrderPlacedEvent> {

    private java.lang.CharSequence orderNumber;
    private java.lang.CharSequence email;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.microservices.ecommerce.order_service.event.OrderPlacedEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.orderNumber)) {
        this.orderNumber = data().deepCopy(fields()[0].schema(), other.orderNumber);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.email)) {
        this.email = data().deepCopy(fields()[1].schema(), other.email);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing OrderPlacedEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.microservices.ecommerce.order_service.event.OrderPlacedEvent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.orderNumber)) {
        this.orderNumber = data().deepCopy(fields()[0].schema(), other.orderNumber);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.email)) {
        this.email = data().deepCopy(fields()[1].schema(), other.email);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'orderNumber' field.
      * @return The value.
      */
    public java.lang.CharSequence getOrderNumber() {
      return orderNumber;
    }


    /**
      * Sets the value of the 'orderNumber' field.
      * @param value The value of 'orderNumber'.
      * @return This builder.
      */
    public com.microservices.ecommerce.order_service.event.OrderPlacedEvent.Builder setOrderNumber(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.orderNumber = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'orderNumber' field has been set.
      * @return True if the 'orderNumber' field has been set, false otherwise.
      */
    public boolean hasOrderNumber() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'orderNumber' field.
      * @return This builder.
      */
    public com.microservices.ecommerce.order_service.event.OrderPlacedEvent.Builder clearOrderNumber() {
      orderNumber = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'email' field.
      * @return The value.
      */
    public java.lang.CharSequence getEmail() {
      return email;
    }


    /**
      * Sets the value of the 'email' field.
      * @param value The value of 'email'.
      * @return This builder.
      */
    public com.microservices.ecommerce.order_service.event.OrderPlacedEvent.Builder setEmail(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.email = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'email' field has been set.
      * @return True if the 'email' field has been set, false otherwise.
      */
    public boolean hasEmail() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'email' field.
      * @return This builder.
      */
    public com.microservices.ecommerce.order_service.event.OrderPlacedEvent.Builder clearEmail() {
      email = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public OrderPlacedEvent build() {
      try {
        OrderPlacedEvent record = new OrderPlacedEvent();
        record.orderNumber = fieldSetFlags()[0] ? this.orderNumber : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.email = fieldSetFlags()[1] ? this.email : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<OrderPlacedEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<OrderPlacedEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<OrderPlacedEvent>
    READER$ = (org.apache.avro.io.DatumReader<OrderPlacedEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.orderNumber);

    out.writeString(this.email);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.orderNumber = in.readString(this.orderNumber instanceof Utf8 ? (Utf8)this.orderNumber : null);

      this.email = in.readString(this.email instanceof Utf8 ? (Utf8)this.email : null);

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.orderNumber = in.readString(this.orderNumber instanceof Utf8 ? (Utf8)this.orderNumber : null);
          break;

        case 1:
          this.email = in.readString(this.email instanceof Utf8 ? (Utf8)this.email : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










