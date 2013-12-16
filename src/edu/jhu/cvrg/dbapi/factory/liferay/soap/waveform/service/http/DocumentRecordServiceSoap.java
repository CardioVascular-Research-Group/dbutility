/**
 * DocumentRecordServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http;

public interface DocumentRecordServiceSoap extends java.rmi.Remote {
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap addDocumentRecord(long liferayUserId, long liferayGroupId, long liferayCompanyId, java.lang.String recordName, java.lang.String subjectID, java.lang.String originalFormat, double samplingRate, java.lang.String fileTreePath, int leadCount, int numPoints, java.util.Calendar dateUploaded, int age, java.lang.String gender, java.util.Calendar dateRecorded, double aduGain) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap deleteDocumentRecord(java.lang.String recordID) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap deleteDocumentRecord(java.lang.String recordName, long username, java.lang.String subjectID, java.lang.String fileTreePath) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap[] getByFileFormat(java.lang.String originalFormat) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap[] getByFileFormat(java.lang.String originalFormat, int start, int end) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap[] getByScreenName(long userID) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap[] getByScreenName(long userID, int start, int end) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap[] getBySubjectID(java.lang.String subjectID) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap[] getBySubjectID(java.lang.String subjectID, int start, int end) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap getRecord(java.lang.String recordName, long userID, java.lang.String subjectID, java.lang.String fileTreePath) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap updateDocumentRecord(long recordID, long userID, java.lang.String recordName, java.lang.String subjectID, java.lang.String originalFormat, double samplingRate, java.lang.String fileTreePath, int leadCount, int numPoints, java.util.Calendar dateUploaded, int age, java.lang.String gender, java.util.Calendar dateRecorded, double aduGain) throws java.rmi.RemoteException;
}
