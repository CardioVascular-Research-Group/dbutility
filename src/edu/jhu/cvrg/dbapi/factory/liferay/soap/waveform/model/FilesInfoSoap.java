/**
 * FilesInfoSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model;

public class FilesInfoSoap  implements java.io.Serializable {
    private long documentRecordID;

    private long fileID;

    private long primaryKey;

    public FilesInfoSoap() {
    }

    public FilesInfoSoap(
           long documentRecordID,
           long fileID,
           long primaryKey) {
           this.documentRecordID = documentRecordID;
           this.fileID = fileID;
           this.primaryKey = primaryKey;
    }


    /**
     * Gets the documentRecordID value for this FilesInfoSoap.
     * 
     * @return documentRecordID
     */
    public long getDocumentRecordID() {
        return documentRecordID;
    }


    /**
     * Sets the documentRecordID value for this FilesInfoSoap.
     * 
     * @param documentRecordID
     */
    public void setDocumentRecordID(long documentRecordID) {
        this.documentRecordID = documentRecordID;
    }


    /**
     * Gets the fileID value for this FilesInfoSoap.
     * 
     * @return fileID
     */
    public long getFileID() {
        return fileID;
    }


    /**
     * Sets the fileID value for this FilesInfoSoap.
     * 
     * @param fileID
     */
    public void setFileID(long fileID) {
        this.fileID = fileID;
    }


    /**
     * Gets the primaryKey value for this FilesInfoSoap.
     * 
     * @return primaryKey
     */
    public long getPrimaryKey() {
        return primaryKey;
    }


    /**
     * Sets the primaryKey value for this FilesInfoSoap.
     * 
     * @param primaryKey
     */
    public void setPrimaryKey(long primaryKey) {
        this.primaryKey = primaryKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FilesInfoSoap)) return false;
        FilesInfoSoap other = (FilesInfoSoap) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.documentRecordID == other.getDocumentRecordID() &&
            this.fileID == other.getFileID() &&
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
        _hashCode += new Long(getDocumentRecordID()).hashCode();
        _hashCode += new Long(getFileID()).hashCode();
        _hashCode += new Long(getPrimaryKey()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FilesInfoSoap.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.dbpersistence.main.waveform.cvrg.jhu.edu", "FilesInfoSoap"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentRecordID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "documentRecordID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fileID"));
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
