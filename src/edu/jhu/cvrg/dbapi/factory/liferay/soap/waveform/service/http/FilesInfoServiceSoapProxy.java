package edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http;

public class FilesInfoServiceSoapProxy implements edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.FilesInfoServiceSoap {
  private String _endpoint = null;
  private edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.FilesInfoServiceSoap filesInfoServiceSoap = null;
  
  public FilesInfoServiceSoapProxy() {
    _initFilesInfoServiceSoapProxy();
  }
  
  public FilesInfoServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initFilesInfoServiceSoapProxy();
  }
  
  private void _initFilesInfoServiceSoapProxy() {
    try {
      filesInfoServiceSoap = (new edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.FilesInfoServiceSoapServiceLocator()).getPlugin_Database_FilesInfoService();
      if (filesInfoServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)filesInfoServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)filesInfoServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (filesInfoServiceSoap != null)
      ((javax.xml.rpc.Stub)filesInfoServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.FilesInfoServiceSoap getFilesInfoServiceSoap() {
    if (filesInfoServiceSoap == null)
      _initFilesInfoServiceSoapProxy();
    return filesInfoServiceSoap;
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.FilesInfoSoap deleteFilesInfo(long docID) throws java.rmi.RemoteException{
    if (filesInfoServiceSoap == null)
      _initFilesInfoServiceSoapProxy();
    return filesInfoServiceSoap.deleteFilesInfo(docID);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.FilesInfoSoap getFile(long fileID) throws java.rmi.RemoteException{
    if (filesInfoServiceSoap == null)
      _initFilesInfoServiceSoapProxy();
    return filesInfoServiceSoap.getFile(fileID);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.FilesInfoSoap[] getFiles(long recordID) throws java.rmi.RemoteException{
    if (filesInfoServiceSoap == null)
      _initFilesInfoServiceSoapProxy();
    return filesInfoServiceSoap.getFiles(recordID);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.FilesInfoSoap[] getFiles(long recordID, int start, int end) throws java.rmi.RemoteException{
    if (filesInfoServiceSoap == null)
      _initFilesInfoServiceSoapProxy();
    return filesInfoServiceSoap.getFiles(recordID, start, end);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.FilesInfoSoap addFilesInfo(long liferayUserId, long liferayGroupId, long liferayCompanyId, long documentID, long fileListID) throws java.rmi.RemoteException{
    if (filesInfoServiceSoap == null)
      _initFilesInfoServiceSoapProxy();
    return filesInfoServiceSoap.addFilesInfo(liferayUserId, liferayGroupId, liferayCompanyId, documentID, fileListID);
  }
  
  
}