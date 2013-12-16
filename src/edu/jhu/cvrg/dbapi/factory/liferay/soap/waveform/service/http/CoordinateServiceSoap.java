/**
 * CoordinateServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http;

public interface CoordinateServiceSoap extends java.rmi.Remote {
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.CoordinateSoap addCoordinate(long liferayUserId, long liferayGroupId, long liferayCompanyId, double xCoord, double yCoord) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.CoordinateSoap deleteCoordinate(long coordID) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.CoordinateSoap getCoordinate(long coordID) throws java.rmi.RemoteException;
    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.CoordinateSoap updateCoordinate(long coordID, double xCoord, double yCoord) throws java.rmi.RemoteException;
}
