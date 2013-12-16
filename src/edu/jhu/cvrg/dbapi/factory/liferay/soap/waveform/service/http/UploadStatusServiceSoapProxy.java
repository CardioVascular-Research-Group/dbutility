package edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http;

public class UploadStatusServiceSoapProxy implements edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.UploadStatusServiceSoap {
  private String _endpoint = null;
  private edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.UploadStatusServiceSoap uploadStatusServiceSoap = null;
  
  public UploadStatusServiceSoapProxy() {
    _initUploadStatusServiceSoapProxy();
  }
  
  public UploadStatusServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initUploadStatusServiceSoapProxy();
  }
  
  private void _initUploadStatusServiceSoapProxy() {
    try {
      uploadStatusServiceSoap = (new edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.UploadStatusServiceSoapServiceLocator()).getPlugin_Database_UploadStatusService();
      if (uploadStatusServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)uploadStatusServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)uploadStatusServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (uploadStatusServiceSoap != null)
      ((javax.xml.rpc.Stub)uploadStatusServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.UploadStatusServiceSoap getUploadStatusServiceSoap() {
    if (uploadStatusServiceSoap == null)
      _initUploadStatusServiceSoapProxy();
    return uploadStatusServiceSoap;
  }
  
  
}