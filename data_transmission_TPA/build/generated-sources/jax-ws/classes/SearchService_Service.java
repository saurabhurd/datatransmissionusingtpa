
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
@WebServiceClient(name = "SearchService", targetNamespace = "http://Classes/", wsdlLocation = "http://localhost:8084/Data_Transmission_Server1/SearchService?wsdl")
public class SearchService_Service
    extends Service
{

    private final static URL SEARCHSERVICE_WSDL_LOCATION;
    private final static WebServiceException SEARCHSERVICE_EXCEPTION;
    private final static QName SEARCHSERVICE_QNAME = new QName("http://Classes/", "SearchService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8084/Data_Transmission_Server1/SearchService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SEARCHSERVICE_WSDL_LOCATION = url;
        SEARCHSERVICE_EXCEPTION = e;
    }

    public SearchService_Service() {
        super(__getWsdlLocation(), SEARCHSERVICE_QNAME);
    }

    public SearchService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SEARCHSERVICE_QNAME, features);
    }

    public SearchService_Service(URL wsdlLocation) {
        super(wsdlLocation, SEARCHSERVICE_QNAME);
    }

    public SearchService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SEARCHSERVICE_QNAME, features);
    }

    public SearchService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SearchService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SearchService
     */
    @WebEndpoint(name = "SearchServicePort")
    public SearchService getSearchServicePort() {
        return super.getPort(new QName("http://Classes/", "SearchServicePort"), SearchService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SearchService
     */
    @WebEndpoint(name = "SearchServicePort")
    public SearchService getSearchServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Classes/", "SearchServicePort"), SearchService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SEARCHSERVICE_EXCEPTION!= null) {
            throw SEARCHSERVICE_EXCEPTION;
        }
        return SEARCHSERVICE_WSDL_LOCATION;
    }

}
