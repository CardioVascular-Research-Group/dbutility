/**
 * DocumentRecordSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model;

public class DocumentRecordSoap  implements java.io.Serializable {
    private double aduGain;

    private int age;

    private java.util.Calendar dateOfRecording;

    private java.util.Calendar dateOfUpload;

    private long documentRecordID;

    private java.lang.String fileTreePath;

    private java.lang.String gender;

    private int leadCount;

    private int numberOfPoints;

    private java.lang.String originalFormat;

    private long primaryKey;

    private java.lang.String recordName;

    private double samplingRate;

    private java.lang.String subjectID;

    private long userID;

    public DocumentRecordSoap() {
    }

    public DocumentRecordSoap(
           double aduGain,
           int age,
           java.util.Calendar dateOfRecording,
           java.util.Calendar dateOfUpload,
           long documentRecordID,
           java.lang.String fileTreePath,
           java.lang.String gender,
           int leadCount,
           int numberOfPoints,
           java.lang.String originalFormat,
           long primaryKey,
           java.lang.String recordName,
           double samplingRate,
           java.lang.String subjectID,
           long userID) {
           this.aduGain = aduGain;
           this.age = age;
           this.dateOfRecording = dateOfRecording;
           this.dateOfUpload = dateOfUpload;
           this.documentRecordID = documentRecordID;
           this.fileTreePath = fileTreePath;
           this.gender = gender;
           this.leadCount = leadCount;
           this.numberOfPoints = numberOfPoints;
           this.originalFormat = originalFormat;
           this.primaryKey = primaryKey;
           this.recordName = recordName;
           this.samplingRate = samplingRate;
           this.subjectID = subjectID;
           this.userID = userID;
    }


    /**
     * Gets the aduGain value for this DocumentRecordSoap.
     * 
     * @return aduGain
     */
    public double getAduGain() {
        return aduGain;
    }


    /**
     * Sets the aduGain value for this DocumentRecordSoap.
     * 
     * @param aduGain
     */
    public void setAduGain(double aduGain) {
        this.aduGain = aduGain;
    }


    /**
     * Gets the age value for this DocumentRecordSoap.
     * 
     * @return age
     */
    public int getAge() {
        return age;
    }


    /**
     * Sets the age value for this DocumentRecordSoap.
     * 
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }


    /**
     * Gets the dateOfRecording value for this DocumentRecordSoap.
     * 
     * @return dateOfRecording
     */
    public java.util.Calendar getDateOfRecording() {
        return dateOfRecording;
    }


    /**
     * Sets the dateOfRecording value for this DocumentRecordSoap.
     * 
     * @param dateOfRecording
     */
    public void setDateOfRecording(java.util.Calendar dateOfRecording) {
        this.dateOfRecording = dateOfRecording;
    }


    /**
     * Gets the dateOfUpload value for this DocumentRecordSoap.
     * 
     * @return dateOfUpload
     */
    public java.util.Calendar getDateOfUpload() {
        return dateOfUpload;
    }


    /**
     * Sets the dateOfUpload value for this DocumentRecordSoap.
     * 
     * @param dateOfUpload
     */
    public void setDateOfUpload(java.util.Calendar dateOfUpload) {
        this.dateOfUpload = dateOfUpload;
    }


    /**
     * Gets the documentRecordID value for this DocumentRecordSoap.
     * 
     * @return documentRecordID
     */
    public long getDocumentRecordID() {
        return documentRecordID;
    }


    /**
     * Sets the documentRecordID value for this DocumentRecordSoap.
     * 
     * @param documentRecordID
     */
    public void setDocumentRecordID(long documentRecordID) {
        this.documentRecordID = documentRecordID;
    }


    /**
     * Gets the fileTreePath value for this DocumentRecordSoap.
     * 
     * @return fileTreePath
     */
    public java.lang.String getFileTreePath() {
        return fileTreePath;
    }


    /**
     * Sets the fileTreePath value for this DocumentRecordSoap.
     * 
     * @param fileTreePath
     */
    public void setFileTreePath(java.lang.String fileTreePath) {
        this.fileTreePath = fileTreePath;
    }


    /**
     * Gets the gender value for this DocumentRecordSoap.
     * 
     * @return gender
     */
    public java.lang.String getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this DocumentRecordSoap.
     * 
     * @param gender
     */
    public void setGender(java.lang.String gender) {
        this.gender = gender;
    }


    /**
     * Gets the leadCount value for this DocumentRecordSoap.
     * 
     * @return leadCount
     */
    public int getLeadCount() {
        return leadCount;
    }


    /**
     * Sets the leadCount value for this DocumentRecordSoap.
     * 
     * @param leadCount
     */
    public void setLeadCount(int leadCount) {
        this.leadCount = leadCount;
    }


    /**
     * Gets the numberOfPoints value for this DocumentRecordSoap.
     * 
     * @return numberOfPoints
     */
    public int getNumberOfPoints() {
        return numberOfPoints;
    }


    /**
     * Sets the numberOfPoints value for this DocumentRecordSoap.
     * 
     * @param numberOfPoints
     */
    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }


    /**
     * Gets the originalFormat value for this DocumentRecordSoap.
     * 
     * @return originalFormat
     */
    public java.lang.String getOriginalFormat() {
        return originalFormat;
    }


    /**
     * Sets the originalFormat value for this DocumentRecordSoap.
     * 
     * @param originalFormat
     */
    public void setOriginalFormat(java.lang.String originalFormat) {
        this.originalFormat = originalFormat;
    }


    /**
     * Gets the primaryKey value for this DocumentRecordSoap.
     * 
     * @return primaryKey
     */
    public long getPrimaryKey() {
        return primaryKey;
    }


    /**
     * Sets the primaryKey value for this DocumentRecordSoap.
     * 
     * @param primaryKey
     */
    public void setPrimaryKey(long primaryKey) {
        this.primaryKey = primaryKey;
    }


    /**
     * Gets the recordName value for this DocumentRecordSoap.
     * 
     * @return recordName
     */
    public java.lang.String getRecordName() {
        return recordName;
    }


    /**
     * Sets the recordName value for this DocumentRecordSoap.
     * 
     * @param recordName
     */
    public void setRecordName(java.lang.String recordName) {
        this.recordName = recordName;
    }


    /**
     * Gets the samplingRate value for this DocumentRecordSoap.
     * 
     * @return samplingRate
     */
    public double getSamplingRate() {
        return samplingRate;
    }


    /**
     * Sets the samplingRate value for this DocumentRecordSoap.
     * 
     * @param samplingRate
     */
    public void setSamplingRate(double samplingRate) {
        this.samplingRate = samplingRate;
    }


    /**
     * Gets the subjectID value for this DocumentRecordSoap.
     * 
     * @return subjectID
     */
    public java.lang.String getSubjectID() {
        return subjectID;
    }


    /**
     * Sets the subjectID value for this DocumentRecordSoap.
     * 
     * @param subjectID
     */
    public void setSubjectID(java.lang.String subjectID) {
        this.subjectID = subjectID;
    }


    /**
     * Gets the userID value for this DocumentRecordSoap.
     * 
     * @return userID
     */
    public long getUserID() {
        return userID;
    }


    /**
     * Sets the userID value for this DocumentRecordSoap.
     * 
     * @param userID
     */
    public void setUserID(long userID) {
        this.userID = userID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentRecordSoap)) return false;
        DocumentRecordSoap other = (DocumentRecordSoap) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.aduGain == other.getAduGain() &&
            this.age == other.getAge() &&
            ((this.dateOfRecording==null && other.getDateOfRecording()==null) || 
             (this.dateOfRecording!=null &&
              this.dateOfRecording.equals(other.getDateOfRecording()))) &&
            ((this.dateOfUpload==null && other.getDateOfUpload()==null) || 
             (this.dateOfUpload!=null &&
              this.dateOfUpload.equals(other.getDateOfUpload()))) &&
            this.documentRecordID == other.getDocumentRecordID() &&
            ((this.fileTreePath==null && other.getFileTreePath()==null) || 
             (this.fileTreePath!=null &&
              this.fileTreePath.equals(other.getFileTreePath()))) &&
            ((this.gender==null && other.getGender()==null) || 
             (this.gender!=null &&
              this.gender.equals(other.getGender()))) &&
            this.leadCount == other.getLeadCount() &&
            this.numberOfPoints == other.getNumberOfPoints() &&
            ((this.originalFormat==null && other.getOriginalFormat()==null) || 
             (this.originalFormat!=null &&
              this.originalFormat.equals(other.getOriginalFormat()))) &&
            this.primaryKey == other.getPrimaryKey() &&
            ((this.recordName==null && other.getRecordName()==null) || 
             (this.recordName!=null &&
              this.recordName.equals(other.getRecordName()))) &&
            this.samplingRate == other.getSamplingRate() &&
            ((this.subjectID==null && other.getSubjectID()==null) || 
             (this.subjectID!=null &&
              this.subjectID.equals(other.getSubjectID()))) &&
            this.userID == other.getUserID();
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
        _hashCode += new Double(getAduGain()).hashCode();
        _hashCode += getAge();
        if (getDateOfRecording() != null) {
            _hashCode += getDateOfRecording().hashCode();
        }
        if (getDateOfUpload() != null) {
            _hashCode += getDateOfUpload().hashCode();
        }
        _hashCode += new Long(getDocumentRecordID()).hashCode();
        if (getFileTreePath() != null) {
            _hashCode += getFileTreePath().hashCode();
        }
        if (getGender() != null) {
            _hashCode += getGender().hashCode();
        }
        _hashCode += getLeadCount();
        _hashCode += getNumberOfPoints();
        if (getOriginalFormat() != null) {
            _hashCode += getOriginalFormat().hashCode();
        }
        _hashCode += new Long(getPrimaryKey()).hashCode();
        if (getRecordName() != null) {
            _hashCode += getRecordName().hashCode();
        }
        _hashCode += new Double(getSamplingRate()).hashCode();
        if (getSubjectID() != null) {
            _hashCode += getSubjectID().hashCode();
        }
        _hashCode += new Long(getUserID()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentRecordSoap.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.dbpersistence.main.waveform.cvrg.jhu.edu", "DocumentRecordSoap"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aduGain");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aduGain"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("age");
        elemField.setXmlName(new javax.xml.namespace.QName("", "age"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateOfRecording");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateOfRecording"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateOfUpload");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateOfUpload"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentRecordID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "documentRecordID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileTreePath");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fileTreePath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gender");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leadCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "leadCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfPoints");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfPoints"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "originalFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaryKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "primaryKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recordName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recordName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("samplingRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "samplingRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subjectID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userID"));
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
