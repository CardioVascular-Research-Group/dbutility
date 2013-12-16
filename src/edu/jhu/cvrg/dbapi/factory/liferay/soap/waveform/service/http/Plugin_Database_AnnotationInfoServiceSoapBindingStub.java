/**
 * Plugin_Database_AnnotationInfoServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http;

public class Plugin_Database_AnnotationInfoServiceSoapBindingStub extends org.apache.axis.client.Stub implements edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.AnnotationInfoServiceSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[8];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addAnnotationInfoList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "liferayUserId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "liferayGroupId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "liferayCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "annotations"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "ArrayOf_tns2_AnnotationInfoSoap"), edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addAnnotationInfoListReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addAnnotationInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "liferayUserId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "liferayGroupId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "liferayCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recordID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "createdBy"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "annotationType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "bioportalID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "bioportalRef"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lead"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "startCoord"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "endCoord"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "unitMeasurement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "description"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "value"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "timestamp"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://model.dbpersistence.main.waveform.cvrg.jhu.edu", "AnnotationInfoSoap"));
        oper.setReturnClass(edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addAnnotationInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteAnnotationInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "annotationID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://model.dbpersistence.main.waveform.cvrg.jhu.edu", "AnnotationInfoSoap"));
        oper.setReturnClass(edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteAnnotationInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAnnotation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recordID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "annotationType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lead"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://model.dbpersistence.main.waveform.cvrg.jhu.edu", "AnnotationInfoSoap"));
        oper.setReturnClass(edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getAnnotationReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAnnotationsByRecord");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recordID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "ArrayOf_tns2_AnnotationInfoSoap"));
        oper.setReturnClass(edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getAnnotationsByRecordReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAnnotationsByRecord");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recordID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "start"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "end"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "ArrayOf_tns2_AnnotationInfoSoap"));
        oper.setReturnClass(edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getAnnotationsByRecordReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAnnotationsByType");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recordID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "annotationType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "ArrayOf_tns2_AnnotationInfoSoap"));
        oper.setReturnClass(edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getAnnotationsByTypeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAnnotationsByType");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recordID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "annotationType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "start"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "end"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "ArrayOf_tns2_AnnotationInfoSoap"));
        oper.setReturnClass(edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getAnnotationsByTypeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[7] = oper;

    }

    public Plugin_Database_AnnotationInfoServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public Plugin_Database_AnnotationInfoServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public Plugin_Database_AnnotationInfoServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://model.dbpersistence.main.waveform.cvrg.jhu.edu", "AnnotationInfoSoap");
            cachedSerQNames.add(qName);
            cls = edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "ArrayOf_tns2_AnnotationInfoSoap");
            cachedSerQNames.add(qName);
            cls = edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://model.dbpersistence.main.waveform.cvrg.jhu.edu", "AnnotationInfoSoap");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public int addAnnotationInfoList(long liferayUserId, long liferayGroupId, long liferayCompanyId, edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[] annotations) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "addAnnotationInfoList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(liferayUserId), new java.lang.Long(liferayGroupId), new java.lang.Long(liferayCompanyId), annotations});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap addAnnotationInfo(long liferayUserId, long liferayGroupId, long liferayCompanyId, long recordID, java.lang.String createdBy, java.lang.String annotationType, java.lang.String name, java.lang.String bioportalID, java.lang.String bioportalRef, int lead, long startCoord, long endCoord, java.lang.String unitMeasurement, java.lang.String description, java.lang.String value, java.util.Calendar timestamp) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "addAnnotationInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(liferayUserId), new java.lang.Long(liferayGroupId), new java.lang.Long(liferayCompanyId), new java.lang.Long(recordID), createdBy, annotationType, name, bioportalID, bioportalRef, new java.lang.Integer(lead), new java.lang.Long(startCoord), new java.lang.Long(endCoord), unitMeasurement, description, value, timestamp});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap) _resp;
            } catch (java.lang.Exception _exception) {
                return (edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap) org.apache.axis.utils.JavaUtils.convert(_resp, edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap deleteAnnotationInfo(java.lang.String annotationID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "deleteAnnotationInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {annotationID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap) _resp;
            } catch (java.lang.Exception _exception) {
                return (edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap) org.apache.axis.utils.JavaUtils.convert(_resp, edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap getAnnotation(long recordID, java.lang.String name, java.lang.String annotationType, int lead) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "getAnnotation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(recordID), name, annotationType, new java.lang.Integer(lead)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap) _resp;
            } catch (java.lang.Exception _exception) {
                return (edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap) org.apache.axis.utils.JavaUtils.convert(_resp, edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[] getAnnotationsByRecord(long recordID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "getAnnotationsByRecord"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(recordID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[]) org.apache.axis.utils.JavaUtils.convert(_resp, edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[] getAnnotationsByRecord(long recordID, int start, int end) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "getAnnotationsByRecord"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(recordID), new java.lang.Integer(start), new java.lang.Integer(end)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[]) org.apache.axis.utils.JavaUtils.convert(_resp, edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[] getAnnotationsByType(long recordID, java.lang.String annotationType) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "getAnnotationsByType"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(recordID), annotationType});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[]) org.apache.axis.utils.JavaUtils.convert(_resp, edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[] getAnnotationsByType(long recordID, java.lang.String annotationType, int start, int end) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:http.service.dbpersistence.main.waveform.cvrg.jhu.edu", "getAnnotationsByType"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(recordID), annotationType, new java.lang.Integer(start), new java.lang.Integer(end)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[]) org.apache.axis.utils.JavaUtils.convert(_resp, edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
