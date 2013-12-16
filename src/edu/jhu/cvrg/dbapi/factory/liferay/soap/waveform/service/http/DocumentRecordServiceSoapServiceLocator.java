/**
 * DocumentRecordServiceSoapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http;

public class DocumentRecordServiceSoapServiceLocator extends org.apache.axis.client.Service implements edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.DocumentRecordServiceSoapService {

    public DocumentRecordServiceSoapServiceLocator() {
    }


    public DocumentRecordServiceSoapServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DocumentRecordServiceSoapServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Plugin_Database_DocumentRecordService
    private java.lang.String Plugin_Database_DocumentRecordService_address = "http://localhost:8080/waveform-persistence-portlet/api/axis/Plugin_Database_DocumentRecordService";

    public java.lang.String getPlugin_Database_DocumentRecordServiceAddress() {
        return Plugin_Database_DocumentRecordService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Plugin_Database_DocumentRecordServiceWSDDServiceName = "Plugin_Database_DocumentRecordService";

    public java.lang.String getPlugin_Database_DocumentRecordServiceWSDDServiceName() {
        return Plugin_Database_DocumentRecordServiceWSDDServiceName;
    }

    public void setPlugin_Database_DocumentRecordServiceWSDDServiceName(java.lang.String name) {
        Plugin_Database_DocumentRecordServiceWSDDServiceName = name;
    }

    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.DocumentRecordServiceSoap getPlugin_Database_DocumentRecordService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Plugin_Database_DocumentRecordService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPlugin_Database_DocumentRecordService(endpoint);
    }

    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.DocumentRecordServiceSoap getPlugin_Database_DocumentRecordService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.Plugin_Database_DocumentRecordServiceSoapBindingStub _stub = new edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.Plugin_Database_DocumentRecordServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getPlugin_Database_DocumentRecordServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPlugin_Database_DocumentRecordServiceEndpointAddress(java.lang.String address) {
        Plugin_Database_DocumentRecordService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.DocumentRecordServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.Plugin_Database_DocumentRecordServiceSoapBindingStub _stub = new edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.Plugin_Database_DocumentRecordServiceSoapBindingStub(new java.net.URL(Plugin_Database_DocumentRecordService_address), this);
                _stub.setPortName(getPlugin_Database_DocumentRecordServiceWSDDServiceName());
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
        if ("Plugin_Database_DocumentRecordService".equals(inputPortName)) {
            return getPlugin_Database_DocumentRecordService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "DocumentRecordServiceSoapService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "Plugin_Database_DocumentRecordService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Plugin_Database_DocumentRecordService".equals(portName)) {
            setPlugin_Database_DocumentRecordServiceEndpointAddress(address);
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
