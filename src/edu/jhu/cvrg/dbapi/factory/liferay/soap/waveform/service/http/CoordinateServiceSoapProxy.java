package edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http;

public class CoordinateServiceSoapProxy implements edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.CoordinateServiceSoap {
  private String _endpoint = null;
  private edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.CoordinateServiceSoap coordinateServiceSoap = null;
  
  public CoordinateServiceSoapProxy() {
    _initCoordinateServiceSoapProxy();
  }
  
  public CoordinateServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initCoordinateServiceSoapProxy();
  }
  
  private void _initCoordinateServiceSoapProxy() {
    try {
      coordinateServiceSoap = (new edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.CoordinateServiceSoapServiceLocator()).getPlugin_Database_CoordinateService();
      if (coordinateServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)coordinateServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)coordinateServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (coordinateServiceSoap != null)
      ((javax.xml.rpc.Stub)coordinateServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.CoordinateServiceSoap getCoordinateServiceSoap() {
    if (coordinateServiceSoap == null)
      _initCoordinateServiceSoapProxy();
    return coordinateServiceSoap;
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.CoordinateSoap addCoordinate(long liferayUserId, long liferayGroupId, long liferayCompanyId, double xCoord, double yCoord) throws java.rmi.RemoteException{
    if (coordinateServiceSoap == null)
      _initCoordinateServiceSoapProxy();
    return coordinateServiceSoap.addCoordinate(liferayUserId, liferayGroupId, liferayCompanyId, xCoord, yCoord);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.CoordinateSoap deleteCoordinate(long coordID) throws java.rmi.RemoteException{
    if (coordinateServiceSoap == null)
      _initCoordinateServiceSoapProxy();
    return coordinateServiceSoap.deleteCoordinate(coordID);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.CoordinateSoap getCoordinate(long coordID) throws java.rmi.RemoteException{
    if (coordinateServiceSoap == null)
      _initCoordinateServiceSoapProxy();
    return coordinateServiceSoap.getCoordinate(coordID);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.CoordinateSoap updateCoordinate(long coordID, double xCoord, double yCoord) throws java.rmi.RemoteException{
    if (coordinateServiceSoap == null)
      _initCoordinateServiceSoapProxy();
    return coordinateServiceSoap.updateCoordinate(coordID, xCoord, yCoord);
  }
  
  
}