/**
 * FilesInfoServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http;

public interface FilesInfoServiceSoap extends java.rmi.Remote {
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.FilesInfoSoap addFilesInfo(long liferayUserId, long liferayGroupId, long liferayCompanyId, long documentID, long fileListID) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.FilesInfoSoap deleteFilesInfo(long docID) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.FilesInfoSoap getFile(long fileID) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.FilesInfoSoap[] getFiles(long recordID) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.FilesInfoSoap[] getFiles(long recordID, int start, int end) throws java.rmi.RemoteException;
}
