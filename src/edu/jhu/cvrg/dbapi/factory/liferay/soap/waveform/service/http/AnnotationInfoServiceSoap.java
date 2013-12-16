/**
 * AnnotationInfoServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http;

public interface AnnotationInfoServiceSoap extends java.rmi.Remote {
    public int addAnnotationInfoList(long liferayUserId, long liferayGroupId, long liferayCompanyId, edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[] annotations) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap addAnnotationInfo(long liferayUserId, long liferayGroupId, long liferayCompanyId, long recordID, java.lang.String createdBy, java.lang.String annotationType, java.lang.String name, java.lang.String bioportalID, java.lang.String bioportalRef, int lead, long startCoord, long endCoord, java.lang.String unitMeasurement, java.lang.String description, java.lang.String value, java.util.Calendar timestamp) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap deleteAnnotationInfo(java.lang.String annotationID) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap getAnnotation(long recordID, java.lang.String name, java.lang.String annotationType, int lead) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[] getAnnotationsByRecord(long recordID) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[] getAnnotationsByRecord(long recordID, int start, int end) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[] getAnnotationsByType(long recordID, java.lang.String annotationType) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[] getAnnotationsByType(long recordID, java.lang.String annotationType, int start, int end) throws java.rmi.RemoteException;
}
