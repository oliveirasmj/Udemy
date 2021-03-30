
package client.matematica;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client.matematica package. 
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

    private final static QName _MenorPrimo_QNAME = new QName("http://world.hello/", "menorPrimo");
    private final static QName _SomaResponse_QNAME = new QName("http://world.hello/", "somaResponse");
    private final static QName _Soma_QNAME = new QName("http://world.hello/", "soma");
    private final static QName _FatorialResponse_QNAME = new QName("http://world.hello/", "fatorialResponse");
    private final static QName _MaiorPrimo_QNAME = new QName("http://world.hello/", "maiorPrimo");
    private final static QName _MaiorPrimoResponse_QNAME = new QName("http://world.hello/", "maiorPrimoResponse");
    private final static QName _Fatorial_QNAME = new QName("http://world.hello/", "fatorial");
    private final static QName _MenorPrimoResponse_QNAME = new QName("http://world.hello/", "menorPrimoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client.matematica
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Fatorial }
     * 
     */
    public Fatorial createFatorial() {
        return new Fatorial();
    }

    /**
     * Create an instance of {@link MaiorPrimoResponse }
     * 
     */
    public MaiorPrimoResponse createMaiorPrimoResponse() {
        return new MaiorPrimoResponse();
    }

    /**
     * Create an instance of {@link MenorPrimoResponse }
     * 
     */
    public MenorPrimoResponse createMenorPrimoResponse() {
        return new MenorPrimoResponse();
    }

    /**
     * Create an instance of {@link FatorialResponse }
     * 
     */
    public FatorialResponse createFatorialResponse() {
        return new FatorialResponse();
    }

    /**
     * Create an instance of {@link Soma }
     * 
     */
    public Soma createSoma() {
        return new Soma();
    }

    /**
     * Create an instance of {@link MaiorPrimo }
     * 
     */
    public MaiorPrimo createMaiorPrimo() {
        return new MaiorPrimo();
    }

    /**
     * Create an instance of {@link SomaResponse }
     * 
     */
    public SomaResponse createSomaResponse() {
        return new SomaResponse();
    }

    /**
     * Create an instance of {@link MenorPrimo }
     * 
     */
    public MenorPrimo createMenorPrimo() {
        return new MenorPrimo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MenorPrimo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://world.hello/", name = "menorPrimo")
    public JAXBElement<MenorPrimo> createMenorPrimo(MenorPrimo value) {
        return new JAXBElement<MenorPrimo>(_MenorPrimo_QNAME, MenorPrimo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SomaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://world.hello/", name = "somaResponse")
    public JAXBElement<SomaResponse> createSomaResponse(SomaResponse value) {
        return new JAXBElement<SomaResponse>(_SomaResponse_QNAME, SomaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Soma }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://world.hello/", name = "soma")
    public JAXBElement<Soma> createSoma(Soma value) {
        return new JAXBElement<Soma>(_Soma_QNAME, Soma.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FatorialResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://world.hello/", name = "fatorialResponse")
    public JAXBElement<FatorialResponse> createFatorialResponse(FatorialResponse value) {
        return new JAXBElement<FatorialResponse>(_FatorialResponse_QNAME, FatorialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaiorPrimo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://world.hello/", name = "maiorPrimo")
    public JAXBElement<MaiorPrimo> createMaiorPrimo(MaiorPrimo value) {
        return new JAXBElement<MaiorPrimo>(_MaiorPrimo_QNAME, MaiorPrimo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaiorPrimoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://world.hello/", name = "maiorPrimoResponse")
    public JAXBElement<MaiorPrimoResponse> createMaiorPrimoResponse(MaiorPrimoResponse value) {
        return new JAXBElement<MaiorPrimoResponse>(_MaiorPrimoResponse_QNAME, MaiorPrimoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Fatorial }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://world.hello/", name = "fatorial")
    public JAXBElement<Fatorial> createFatorial(Fatorial value) {
        return new JAXBElement<Fatorial>(_Fatorial_QNAME, Fatorial.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MenorPrimoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://world.hello/", name = "menorPrimoResponse")
    public JAXBElement<MenorPrimoResponse> createMenorPrimoResponse(MenorPrimoResponse value) {
        return new JAXBElement<MenorPrimoResponse>(_MenorPrimoResponse_QNAME, MenorPrimoResponse.class, null, value);
    }

}
