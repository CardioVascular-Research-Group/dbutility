/**
 * AnnotationInfoSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model;

public class AnnotationInfoSoap  implements java.io.Serializable {
    private long annotationID;

    private java.lang.String annotationType;

    private java.lang.String bioportalID;

    private java.lang.String bioportalReference;

    private java.lang.String createdBy;

    private java.lang.String description;

    private long documentRecordID;

    private java.lang.Long endingCoordinateID;

    private java.lang.Integer leadIndex;

    private java.lang.String name;

    private long primaryKey;

    private java.lang.Long startingCoordinateID;

    private java.util.Calendar timestamp;

    private java.lang.String unitOfMeasurement;

    private java.lang.String value;

    public AnnotationInfoSoap() {
    }

    public AnnotationInfoSoap(
           long annotationID,
           java.lang.String annotationType,
           java.lang.String bioportalID,
           java.lang.String bioportalReference,
           java.lang.String createdBy,
           java.lang.String description,
           long documentRecordID,
           java.lang.Long endingCoordinateID,
           java.lang.Integer leadIndex,
           java.lang.String name,
           long primaryKey,
           java.lang.Long startingCoordinateID,
           java.util.Calendar timestamp,
           java.lang.String unitOfMeasurement,
           java.lang.String value) {
           this.annotationID = annotationID;
           this.annotationType = annotationType;
           this.bioportalID = bioportalID;
           this.bioportalReference = bioportalReference;
           this.createdBy = createdBy;
           this.description = description;
           this.documentRecordID = documentRecordID;
           this.endingCoordinateID = endingCoordinateID;
           this.leadIndex = leadIndex;
           this.name = name;
           this.primaryKey = primaryKey;
           this.startingCoordinateID = startingCoordinateID;
           this.timestamp = timestamp;
           this.unitOfMeasurement = unitOfMeasurement;
           this.value = value;
    }


    /**
     * Gets the annotationID value for this AnnotationInfoSoap.
     * 
     * @return annotationID
     */
    public long getAnnotationID() {
        return annotationID;
    }


    /**
     * Sets the annotationID value for this AnnotationInfoSoap.
     * 
     * @param annotationID
     */
    public void setAnnotationID(long annotationID) {
        this.annotationID = annotationID;
    }


    /**
     * Gets the annotationType value for this AnnotationInfoSoap.
     * 
     * @return annotationType
     */
    public java.lang.String getAnnotationType() {
        return annotationType;
    }


    /**
     * Sets the annotationType value for this AnnotationInfoSoap.
     * 
     * @param annotationType
     */
    public void setAnnotationType(java.lang.String annotationType) {
        this.annotationType = annotationType;
    }


    /**
     * Gets the bioportalID value for this AnnotationInfoSoap.
     * 
     * @return bioportalID
     */
    public java.lang.String getBioportalID() {
        return bioportalID;
    }


    /**
     * Sets the bioportalID value for this AnnotationInfoSoap.
     * 
     * @param bioportalID
     */
    public void setBioportalID(java.lang.String bioportalID) {
        this.bioportalID = bioportalID;
    }


    /**
     * Gets the bioportalReference value for this AnnotationInfoSoap.
     * 
     * @return bioportalReference
     */
    public java.lang.String getBioportalReference() {
        return bioportalReference;
    }


    /**
     * Sets the bioportalReference value for this AnnotationInfoSoap.
     * 
     * @param bioportalReference
     */
    public void setBioportalReference(java.lang.String bioportalReference) {
        this.bioportalReference = bioportalReference;
    }


    /**
     * Gets the createdBy value for this AnnotationInfoSoap.
     * 
     * @return createdBy
     */
    public java.lang.String getCreatedBy() {
        return createdBy;
    }


    /**
     * Sets the createdBy value for this AnnotationInfoSoap.
     * 
     * @param createdBy
     */
    public void setCreatedBy(java.lang.String createdBy) {
        this.createdBy = createdBy;
    }


    /**
     * Gets the description value for this AnnotationInfoSoap.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this AnnotationInfoSoap.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the documentRecordID value for this AnnotationInfoSoap.
     * 
     * @return documentRecordID
     */
    public long getDocumentRecordID() {
        return documentRecordID;
    }


    /**
     * Sets the documentRecordID value for this AnnotationInfoSoap.
     * 
     * @param documentRecordID
     */
    public void setDocumentRecordID(long documentRecordID) {
        this.documentRecordID = documentRecordID;
    }


    /**
     * Gets the endingCoordinateID value for this AnnotationInfoSoap.
     * 
     * @return endingCoordinateID
     */
    public java.lang.Long getEndingCoordinateID() {
        return endingCoordinateID;
    }


    /**
     * Sets the endingCoordinateID value for this AnnotationInfoSoap.
     * 
     * @param endingCoordinateID
     */
    public void setEndingCoordinateID(java.lang.Long endingCoordinateID) {
        this.endingCoordinateID = endingCoordinateID;
    }


    /**
     * Gets the leadIndex value for this AnnotationInfoSoap.
     * 
     * @return leadIndex
     */
    public java.lang.Integer getLeadIndex() {
        return leadIndex;
    }


    /**
     * Sets the leadIndex value for this AnnotationInfoSoap.
     * 
     * @param leadIndex
     */
    public void setLeadIndex(java.lang.Integer leadIndex) {
        this.leadIndex = leadIndex;
    }


    /**
     * Gets the name value for this AnnotationInfoSoap.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this AnnotationInfoSoap.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the primaryKey value for this AnnotationInfoSoap.
     * 
     * @return primaryKey
     */
    public long getPrimaryKey() {
        return primaryKey;
    }


    /**
     * Sets the primaryKey value for this AnnotationInfoSoap.
     * 
     * @param primaryKey
     */
    public void setPrimaryKey(long primaryKey) {
        this.primaryKey = primaryKey;
    }


    /**
     * Gets the startingCoordinateID value for this AnnotationInfoSoap.
     * 
     * @return startingCoordinateID
     */
    public java.lang.Long getStartingCoordinateID() {
        return startingCoordinateID;
    }


    /**
     * Sets the startingCoordinateID value for this AnnotationInfoSoap.
     * 
     * @param startingCoordinateID
     */
    public void setStartingCoordinateID(java.lang.Long startingCoordinateID) {
        this.startingCoordinateID = startingCoordinateID;
    }


    /**
     * Gets the timestamp value for this AnnotationInfoSoap.
     * 
     * @return timestamp
     */
    public java.util.Calendar getTimestamp() {
        return timestamp;
    }


    /**
     * Sets the timestamp value for this AnnotationInfoSoap.
     * 
     * @param timestamp
     */
    public void setTimestamp(java.util.Calendar timestamp) {
        this.timestamp = timestamp;
    }


    /**
     * Gets the unitOfMeasurement value for this AnnotationInfoSoap.
     * 
     * @return unitOfMeasurement
     */
    public java.lang.String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }


    /**
     * Sets the unitOfMeasurement value for this AnnotationInfoSoap.
     * 
     * @param unitOfMeasurement
     */
    public void setUnitOfMeasurement(java.lang.String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }


    /**
     * Gets the value value for this AnnotationInfoSoap.
     * 
     * @return value
     */
    public java.lang.String getValue() {
        return value;
    }


    /**
     * Sets the value value for this AnnotationInfoSoap.
     * 
     * @param value
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AnnotationInfoSoap)) return false;
        AnnotationInfoSoap other = (AnnotationInfoSoap) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.annotationID == other.getAnnotationID() &&
            ((this.annotationType==null && other.getAnnotationType()==null) || 
             (this.annotationType!=null &&
              this.annotationType.equals(other.getAnnotationType()))) &&
            ((this.bioportalID==null && other.getBioportalID()==null) || 
             (this.bioportalID!=null &&
              this.bioportalID.equals(other.getBioportalID()))) &&
            ((this.bioportalReference==null && other.getBioportalReference()==null) || 
             (this.bioportalReference!=null &&
              this.bioportalReference.equals(other.getBioportalReference()))) &&
            ((this.createdBy==null && other.getCreatedBy()==null) || 
             (this.createdBy!=null &&
              this.createdBy.equals(other.getCreatedBy()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.documentRecordID == other.getDocumentRecordID() &&
            ((this.endingCoordinateID==null && other.getEndingCoordinateID()==null) || 
             (this.endingCoordinateID!=null &&
              this.endingCoordinateID.equals(other.getEndingCoordinateID()))) &&
            ((this.leadIndex==null && other.getLeadIndex()==null) || 
             (this.leadIndex!=null &&
              this.leadIndex.equals(other.getLeadIndex()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.primaryKey == other.getPrimaryKey() &&
            ((this.startingCoordinateID==null && other.getStartingCoordinateID()==null) || 
             (this.startingCoordinateID!=null &&
              this.startingCoordinateID.equals(other.getStartingCoordinateID()))) &&
            ((this.timestamp==null && other.getTimestamp()==null) || 
             (this.timestamp!=null &&
              this.timestamp.equals(other.getTimestamp()))) &&
            ((this.unitOfMeasurement==null && other.getUnitOfMeasurement()==null) || 
             (this.unitOfMeasurement!=null &&
              this.unitOfMeasurement.equals(other.getUnitOfMeasurement()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue())));
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
        _hashCode += new Long(getAnnotationID()).hashCode();
        if (getAnnotationType() != null) {
            _hashCode += getAnnotationType().hashCode();
        }
        if (getBioportalID() != null) {
            _hashCode += getBioportalID().hashCode();
        }
        if (getBioportalReference() != null) {
            _hashCode += getBioportalReference().hashCode();
        }
        if (getCreatedBy() != null) {
            _hashCode += getCreatedBy().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += new Long(getDocumentRecordID()).hashCode();
        if (getEndingCoordinateID() != null) {
            _hashCode += getEndingCoordinateID().hashCode();
        }
        if (getLeadIndex() != null) {
            _hashCode += getLeadIndex().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += new Long(getPrimaryKey()).hashCode();
        if (getStartingCoordinateID() != null) {
            _hashCode += getStartingCoordinateID().hashCode();
        }
        if (getTimestamp() != null) {
            _hashCode += getTimestamp().hashCode();
        }
        if (getUnitOfMeasurement() != null) {
            _hashCode += getUnitOfMeasurement().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AnnotationInfoSoap.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.dbpersistence.main.waveform.cvrg.jhu.edu", "AnnotationInfoSoap"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annotationID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "annotationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annotationType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "annotationType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bioportalID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bioportalID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bioportalReference");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bioportalReference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createdBy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "createdBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentRecordID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "documentRecordID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endingCoordinateID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endingCoordinateID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leadIndex");
        elemField.setXmlName(new javax.xml.namespace.QName("", "leadIndex"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
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
        elemField.setFieldName("startingCoordinateID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startingCoordinateID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timestamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timestamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unitOfMeasurement");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unitOfMeasurement"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
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
