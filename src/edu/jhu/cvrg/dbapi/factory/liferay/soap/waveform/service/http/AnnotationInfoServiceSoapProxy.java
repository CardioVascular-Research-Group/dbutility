package edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http;

public class AnnotationInfoServiceSoapProxy implements edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.AnnotationInfoServiceSoap {
  private String _endpoint = null;
  private edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.AnnotationInfoServiceSoap annotationInfoServiceSoap = null;
  
  public AnnotationInfoServiceSoapProxy() {
    _initAnnotationInfoServiceSoapProxy();
  }
  
  public AnnotationInfoServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initAnnotationInfoServiceSoapProxy();
  }
  
  private void _initAnnotationInfoServiceSoapProxy() {
    try {
      annotationInfoServiceSoap = (new edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.AnnotationInfoServiceSoapServiceLocator()).getPlugin_Database_AnnotationInfoService();
      if (annotationInfoServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)annotationInfoServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)annotationInfoServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (annotationInfoServiceSoap != null)
      ((javax.xml.rpc.Stub)annotationInfoServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.AnnotationInfoServiceSoap getAnnotationInfoServiceSoap() {
    if (annotationInfoServiceSoap == null)
      _initAnnotationInfoServiceSoapProxy();
    return annotationInfoServiceSoap;
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap deleteAnnotationInfo(java.lang.String annotationID) throws java.rmi.RemoteException{
    if (annotationInfoServiceSoap == null)
      _initAnnotationInfoServiceSoapProxy();
    return annotationInfoServiceSoap.deleteAnnotationInfo(annotationID);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[] getAnnotationsByRecord(long recordID) throws java.rmi.RemoteException{
    if (annotationInfoServiceSoap == null)
      _initAnnotationInfoServiceSoapProxy();
    return annotationInfoServiceSoap.getAnnotationsByRecord(recordID);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[] getAnnotationsByRecord(long recordID, int start, int end) throws java.rmi.RemoteException{
    if (annotationInfoServiceSoap == null)
      _initAnnotationInfoServiceSoapProxy();
    return annotationInfoServiceSoap.getAnnotationsByRecord(recordID, start, end);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[] getAnnotationsByType(long recordID, java.lang.String annotationType) throws java.rmi.RemoteException{
    if (annotationInfoServiceSoap == null)
      _initAnnotationInfoServiceSoapProxy();
    return annotationInfoServiceSoap.getAnnotationsByType(recordID, annotationType);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[] getAnnotationsByType(long recordID, java.lang.String annotationType, int start, int end) throws java.rmi.RemoteException{
    if (annotationInfoServiceSoap == null)
      _initAnnotationInfoServiceSoapProxy();
    return annotationInfoServiceSoap.getAnnotationsByType(recordID, annotationType, start, end);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap getAnnotation(long recordID, java.lang.String name, java.lang.String annotationType, int lead) throws java.rmi.RemoteException{
    if (annotationInfoServiceSoap == null)
      _initAnnotationInfoServiceSoapProxy();
    return annotationInfoServiceSoap.getAnnotation(recordID, name, annotationType, lead);
  }
  
  public int addAnnotationInfoList(long liferayUserId, long liferayGroupId, long liferayCompanyId, edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[] annotations) throws java.rmi.RemoteException{
    if (annotationInfoServiceSoap == null)
      _initAnnotationInfoServiceSoapProxy();
    return annotationInfoServiceSoap.addAnnotationInfoList(liferayUserId, liferayGroupId, liferayCompanyId, annotations);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap addAnnotationInfo(long liferayUserId, long liferayGroupId, long liferayCompanyId, long recordID, java.lang.String createdBy, java.lang.String annotationType, java.lang.String name, java.lang.String bioportalID, java.lang.String bioportalRef, int lead, long startCoord, long endCoord, java.lang.String unitMeasurement, java.lang.String description, java.lang.String value, java.util.Calendar timestamp) throws java.rmi.RemoteException{
    if (annotationInfoServiceSoap == null)
      _initAnnotationInfoServiceSoapProxy();
    return annotationInfoServiceSoap.addAnnotationInfo(liferayUserId, liferayGroupId, liferayCompanyId, recordID, createdBy, annotationType, name, bioportalID, bioportalRef, lead, startCoord, endCoord, unitMeasurement, description, value, timestamp);
  }
  
  
}