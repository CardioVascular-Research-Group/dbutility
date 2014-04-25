/**
 * UploadStatusServiceSoapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http;

public class UploadStatusServiceSoapServiceLocator extends org.apache.axis.client.Service implements edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.UploadStatusServiceSoapService {

    public UploadStatusServiceSoapServiceLocator() {
    }


    public UploadStatusServiceSoapServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UploadStatusServiceSoapServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Plugin_Database_UploadStatusService
    private java.lang.String Plugin_Database_UploadStatusService_address = "http://localhost:8080/waveform-persistence-portlet/api/axis/Plugin_Database_UploadStatusService";

    public java.lang.String getPlugin_Database_UploadStatusServiceAddress() {
        return Plugin_Database_UploadStatusService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Plugin_Database_UploadStatusServiceWSDDServiceName = "Plugin_Database_UploadStatusService";

    public java.lang.String getPlugin_Database_UploadStatusServiceWSDDServiceName() {
        return Plugin_Database_UploadStatusServiceWSDDServiceName;
    }

    public void setPlugin_Database_UploadStatusServiceWSDDServiceName(java.lang.String name) {
        Plugin_Database_UploadStatusServiceWSDDServiceName = name;
    }

    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.UploadStatusServiceSoap getPlugin_Database_UploadStatusService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Plugin_Database_UploadStatusService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPlugin_Database_UploadStatusService(endpoint);
    }

    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.UploadStatusServiceSoap getPlugin_Database_UploadStatusService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.Plugin_Database_UploadStatusServiceSoapBindingStub _stub = new edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.Plugin_Database_UploadStatusServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getPlugin_Database_UploadStatusServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPlugin_Database_UploadStatusServiceEndpointAddress(java.lang.String address) {
        Plugin_Database_UploadStatusService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.UploadStatusServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.Plugin_Database_UploadStatusServiceSoapBindingStub _stub = new edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.Plugin_Database_UploadStatusServiceSoapBindingStub(new java.net.URL(Plugin_Database_UploadStatusService_address), this);
                _stub.setPortName(getPlugin_Database_UploadStatusServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Plugin_Database_UploadStatusService".equals(inputPortName)) {
            return getPlugin_Database_UploadStatusService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "UploadStatusServiceSoapService");
    }

    private java.util.HashSet ports = null;

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "Plugin_Database_UploadStatusService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Plugin_Database_UploadStatusService".equals(portName)) {
            setPlugin_Database_UploadStatusServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
