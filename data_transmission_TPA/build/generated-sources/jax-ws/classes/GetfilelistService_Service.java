
package classes;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "getfilelistService", targetNamespace = "http://Classes/", wsdlLocation = "http://localhost:8084/Data_Transmission_Server1/getfilelistService?wsdl")
public class GetfilelistService_Service
    extends Service
{

    private final static URL GETFILELISTSERVICE_WSDL_LOCATION;
    private final static WebServiceException GETFILELISTSERVICE_EXCEPTION;
    private final static QName GETFILELISTSERVICE_QNAME = new QName("http://Classes/", "getfilelistService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8084/Data_Transmission_Server1/getfilelistService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GETFILELISTSERVICE_WSDL_LOCATION = url;
        GETFILELISTSERVICE_EXCEPTION = e;
    }

    public GetfilelistService_Service() {
        super(__getWsdlLocation(), GETFILELISTSERVICE_QNAME);
    }

    public GetfilelistService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), GETFILELISTSERVICE_QNAME, features);
    }

    public GetfilelistService_Service(URL wsdlLocation) {
        super(wsdlLocation, GETFILELISTSERVICE_QNAME);
    }

    public GetfilelistService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GETFILELISTSERVICE_QNAME, features);
    }

    public GetfilelistService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GetfilelistService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns GetfilelistService
     */
    @WebEndpoint(name = "getfilelistServicePort")
    public GetfilelistService getGetfilelistServicePort() {
        return super.getPort(new QName("http://Classes/", "getfilelistServicePort"), GetfilelistService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GetfilelistService
     */
    @WebEndpoint(name = "getfilelistServicePort")
    public GetfilelistService getGetfilelistServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Classes/", "getfilelistServicePort"), GetfilelistService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GETFILELISTSERVICE_EXCEPTION!= null) {
            throw GETFILELISTSERVICE_EXCEPTION;
        }
        return GETFILELISTSERVICE_WSDL_LOCATION;
    }

}
