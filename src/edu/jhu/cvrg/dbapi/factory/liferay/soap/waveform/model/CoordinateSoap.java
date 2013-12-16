/**
 * CoordinateSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model;

public class CoordinateSoap  implements java.io.Serializable {
    private double XCoordinate;

    private double YCoordinate;

    private long coordinateID;

    private long primaryKey;

    public CoordinateSoap() {
    }

    public CoordinateSoap(
           double XCoordinate,
           double YCoordinate,
           long coordinateID,
           long primaryKey) {
           this.XCoordinate = XCoordinate;
           this.YCoordinate = YCoordinate;
           this.coordinateID = coordinateID;
           this.primaryKey = primaryKey;
    }


    /**
     * Gets the XCoordinate value for this CoordinateSoap.
     * 
     * @return XCoordinate
     */
    public double getXCoordinate() {
        return XCoordinate;
    }


    /**
     * Sets the XCoordinate value for this CoordinateSoap.
     * 
     * @param XCoordinate
     */
    public void setXCoordinate(double XCoordinate) {
        this.XCoordinate = XCoordinate;
    }


    /**
     * Gets the YCoordinate value for this CoordinateSoap.
     * 
     * @return YCoordinate
     */
    public double getYCoordinate() {
        return YCoordinate;
    }


    /**
     * Sets the YCoordinate value for this CoordinateSoap.
     * 
     * @param YCoordinate
     */
    public void setYCoordinate(double YCoordinate) {
        this.YCoordinate = YCoordinate;
    }


    /**
     * Gets the coordinateID value for this CoordinateSoap.
     * 
     * @return coordinateID
     */
    public long getCoordinateID() {
        return coordinateID;
    }


    /**
     * Sets the coordinateID value for this CoordinateSoap.
     * 
     * @param coordinateID
     */
    public void setCoordinateID(long coordinateID) {
        this.coordinateID = coordinateID;
    }


    /**
     * Gets the primaryKey value for this CoordinateSoap.
     * 
     * @return primaryKey
     */
    public long getPrimaryKey() {
        return primaryKey;
    }


    /**
     * Sets the primaryKey value for this CoordinateSoap.
     * 
     * @param primaryKey
     */
    public void setPrimaryKey(long primaryKey) {
        this.primaryKey = primaryKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CoordinateSoap)) return false;
        CoordinateSoap other = (CoordinateSoap) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.XCoordinate == other.getXCoordinate() &&
            this.YCoordinate == other.getYCoordinate() &&
            this.coordinateID == other.getCoordinateID() &&
            this.primaryKey == other.getPrimaryKey();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += new Double(getXCoordinate()).hashCode();
        _hashCode += new Double(getYCoordinate()).hashCode();
        _hashCode += new Long(getCoordinateID()).hashCode();
        _hashCode += new Long(getPrimaryKey()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CoordinateSoap.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.dbpersistence.main.waveform.cvrg.jhu.edu", "CoordinateSoap"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XCoordinate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "XCoordinate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("YCoordinate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "YCoordinate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coordinateID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coordinateID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaryKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "primaryKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
