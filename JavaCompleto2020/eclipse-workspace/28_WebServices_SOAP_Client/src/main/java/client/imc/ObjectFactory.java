
package client.imc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client.imc package. 
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

    private final static QName _Indice_QNAME = new QName("http://world.hello/", "indice");
    private final static QName _IndiceResponse_QNAME = new QName("http://world.hello/", "indiceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client.imc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IndiceResponse }
     * 
     */
    public IndiceResponse createIndiceResponse() {
        return new IndiceResponse();
    }

    /**
     * Create an instance of {@link Indice }
     * 
     */
    public Indice createIndice() {
        return new Indice();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Indice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://world.hello/", name = "indice")
    public JAXBElement<Indice> createIndice(Indice value) {
        return new JAXBElement<Indice>(_Indice_QNAME, Indice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://world.hello/", name = "indiceResponse")
    public JAXBElement<IndiceResponse> createIndiceResponse(IndiceResponse value) {
        return new JAXBElement<IndiceResponse>(_IndiceResponse_QNAME, IndiceResponse.class, null, value);
    }

}
