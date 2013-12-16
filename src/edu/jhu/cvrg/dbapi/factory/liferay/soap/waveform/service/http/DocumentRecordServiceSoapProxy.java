package edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http;

public class DocumentRecordServiceSoapProxy implements edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.DocumentRecordServiceSoap {
  private String _endpoint = null;
  private edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.DocumentRecordServiceSoap documentRecordServiceSoap = null;
  
  public DocumentRecordServiceSoapProxy() {
    _initDocumentRecordServiceSoapProxy();
  }
  
  public DocumentRecordServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initDocumentRecordServiceSoapProxy();
  }
  
  private void _initDocumentRecordServiceSoapProxy() {
    try {
      documentRecordServiceSoap = (new edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.DocumentRecordServiceSoapServiceLocator()).getPlugin_Database_DocumentRecordService();
      if (documentRecordServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)documentRecordServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)documentRecordServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (documentRecordServiceSoap != null)
      ((javax.xml.rpc.Stub)documentRecordServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.DocumentRecordServiceSoap getDocumentRecordServiceSoap() {
    if (documentRecordServiceSoap == null)
      _initDocumentRecordServiceSoapProxy();
    return documentRecordServiceSoap;
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap deleteDocumentRecord(java.lang.String recordID) throws java.rmi.RemoteException{
    if (documentRecordServiceSoap == null)
      _initDocumentRecordServiceSoapProxy();
    return documentRecordServiceSoap.deleteDocumentRecord(recordID);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap[] getByFileFormat(java.lang.String originalFormat) throws java.rmi.RemoteException{
    if (documentRecordServiceSoap == null)
      _initDocumentRecordServiceSoapProxy();
    return documentRecordServiceSoap.getByFileFormat(originalFormat);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap[] getByFileFormat(java.lang.String originalFormat, int start, int end) throws java.rmi.RemoteException{
    if (documentRecordServiceSoap == null)
      _initDocumentRecordServiceSoapProxy();
    return documentRecordServiceSoap.getByFileFormat(originalFormat, start, end);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap[] getBySubjectID(java.lang.String subjectID) throws java.rmi.RemoteException{
    if (documentRecordServiceSoap == null)
      _initDocumentRecordServiceSoapProxy();
    return documentRecordServiceSoap.getBySubjectID(subjectID);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap[] getBySubjectID(java.lang.String subjectID, int start, int end) throws java.rmi.RemoteException{
    if (documentRecordServiceSoap == null)
      _initDocumentRecordServiceSoapProxy();
    return documentRecordServiceSoap.getBySubjectID(subjectID, start, end);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap addDocumentRecord(long liferayUserId, long liferayGroupId, long liferayCompanyId, java.lang.String recordName, java.lang.String subjectID, java.lang.String originalFormat, double samplingRate, java.lang.String fileTreePath, int leadCount, int numPoints, java.util.Calendar dateUploaded, int age, java.lang.String gender, java.util.Calendar dateRecorded, double aduGain) throws java.rmi.RemoteException{
    if (documentRecordServiceSoap == null)
      _initDocumentRecordServiceSoapProxy();
    return documentRecordServiceSoap.addDocumentRecord(liferayUserId, liferayGroupId, liferayCompanyId, recordName, subjectID, originalFormat, samplingRate, fileTreePath, leadCount, numPoints, dateUploaded, age, gender, dateRecorded, aduGain);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap deleteDocumentRecord(java.lang.String recordName, long username, java.lang.String subjectID, java.lang.String fileTreePath) throws java.rmi.RemoteException{
    if (documentRecordServiceSoap == null)
      _initDocumentRecordServiceSoapProxy();
    return documentRecordServiceSoap.deleteDocumentRecord(recordName, username, subjectID, fileTreePath);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap[] getByScreenName(long userID) throws java.rmi.RemoteException{
    if (documentRecordServiceSoap == null)
      _initDocumentRecordServiceSoapProxy();
    return documentRecordServiceSoap.getByScreenName(userID);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap[] getByScreenName(long userID, int start, int end) throws java.rmi.RemoteException{
    if (documentRecordServiceSoap == null)
      _initDocumentRecordServiceSoapProxy();
    return documentRecordServiceSoap.getByScreenName(userID, start, end);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap getRecord(java.lang.String recordName, long userID, java.lang.String subjectID, java.lang.String fileTreePath) throws java.rmi.RemoteException{
    if (documentRecordServiceSoap == null)
      _initDocumentRecordServiceSoapProxy();
    return documentRecordServiceSoap.getRecord(recordName, userID, subjectID, fileTreePath);
  }
  
  public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap updateDocumentRecord(long recordID, long userID, java.lang.String recordName, java.lang.String subjectID, java.lang.String originalFormat, double samplingRate, java.lang.String fileTreePath, int leadCount, int numPoints, java.util.Calendar dateUploaded, int age, java.lang.String gender, java.util.Calendar dateRecorded, double aduGain) throws java.rmi.RemoteException{
    if (documentRecordServiceSoap == null)
      _initDocumentRecordServiceSoapProxy();
    return documentRecordServiceSoap.updateDocumentRecord(recordID, userID, recordName, subjectID, originalFormat, samplingRate, fileTreePath, leadCount, numPoints, dateUploaded, age, gender, dateRecorded, aduGain);
  }
  
  
}