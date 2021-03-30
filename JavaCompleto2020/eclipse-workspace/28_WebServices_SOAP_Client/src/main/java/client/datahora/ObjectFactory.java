
package client.datahora;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client.datahora package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayDataHoraResponse_QNAME = new QName("http://world.hello/", "sayDataHoraResponse");
    private final static QName _SayDataHora_QNAME = new QName("http://world.hello/", "sayDataHora");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client.datahora
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayDataHoraResponse }
     * 
     */
    public SayDataHoraResponse createSayDataHoraResponse() {
        return new SayDataHoraResponse();
    }

    /**
     * Create an instance of {@link SayDataHora }
     * 
     */
    public SayDataHora createSayDataHora() {
        return new SayDataHora();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayDataHoraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://world.hello/", name = "sayDataHoraResponse")
    public JAXBElement<SayDataHoraResponse> createSayDataHoraResponse(SayDataHoraResponse value) {
        return new JAXBElement<SayDataHoraResponse>(_SayDataHoraResponse_QNAME, SayDataHoraResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayDataHora }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://world.hello/", name = "sayDataHora")
    public JAXBElement<SayDataHora> createSayDataHora(SayDataHora value) {
        return new JAXBElement<SayDataHora>(_SayDataHora_QNAME, SayDataHora.class, null, value);
    }

}
