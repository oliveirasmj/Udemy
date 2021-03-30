
package client.escola;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client.escola package. 
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

    private final static QName _ListarAlunosResponse_QNAME = new QName("http://exercicio5.world.hello/", "listarAlunosResponse");
    private final static QName _ListarAlunos_QNAME = new QName("http://exercicio5.world.hello/", "listarAlunos");
    private final static QName _InserirAlunoResponse_QNAME = new QName("http://exercicio5.world.hello/", "inserirAlunoResponse");
    private final static QName _RemoverAluno_QNAME = new QName("http://exercicio5.world.hello/", "removerAluno");
    private final static QName _RemoverAlunoResponse_QNAME = new QName("http://exercicio5.world.hello/", "removerAlunoResponse");
    private final static QName _InserirAluno_QNAME = new QName("http://exercicio5.world.hello/", "inserirAluno");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client.escola
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InserirAluno }
     * 
     */
    public InserirAluno createInserirAluno() {
        return new InserirAluno();
    }

    /**
     * Create an instance of {@link RemoverAlunoResponse }
     * 
     */
    public RemoverAlunoResponse createRemoverAlunoResponse() {
        return new RemoverAlunoResponse();
    }

    /**
     * Create an instance of {@link InserirAlunoResponse }
     * 
     */
    public InserirAlunoResponse createInserirAlunoResponse() {
        return new InserirAlunoResponse();
    }

    /**
     * Create an instance of {@link RemoverAluno }
     * 
     */
    public RemoverAluno createRemoverAluno() {
        return new RemoverAluno();
    }

    /**
     * Create an instance of {@link ListarAlunos }
     * 
     */
    public ListarAlunos createListarAlunos() {
        return new ListarAlunos();
    }

    /**
     * Create an instance of {@link ListarAlunosResponse }
     * 
     */
    public ListarAlunosResponse createListarAlunosResponse() {
        return new ListarAlunosResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarAlunosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exercicio5.world.hello/", name = "listarAlunosResponse")
    public JAXBElement<ListarAlunosResponse> createListarAlunosResponse(ListarAlunosResponse value) {
        return new JAXBElement<ListarAlunosResponse>(_ListarAlunosResponse_QNAME, ListarAlunosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarAlunos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exercicio5.world.hello/", name = "listarAlunos")
    public JAXBElement<ListarAlunos> createListarAlunos(ListarAlunos value) {
        return new JAXBElement<ListarAlunos>(_ListarAlunos_QNAME, ListarAlunos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InserirAlunoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exercicio5.world.hello/", name = "inserirAlunoResponse")
    public JAXBElement<InserirAlunoResponse> createInserirAlunoResponse(InserirAlunoResponse value) {
        return new JAXBElement<InserirAlunoResponse>(_InserirAlunoResponse_QNAME, InserirAlunoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoverAluno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exercicio5.world.hello/", name = "removerAluno")
    public JAXBElement<RemoverAluno> createRemoverAluno(RemoverAluno value) {
        return new JAXBElement<RemoverAluno>(_RemoverAluno_QNAME, RemoverAluno.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoverAlunoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exercicio5.world.hello/", name = "removerAlunoResponse")
    public JAXBElement<RemoverAlunoResponse> createRemoverAlunoResponse(RemoverAlunoResponse value) {
        return new JAXBElement<RemoverAlunoResponse>(_RemoverAlunoResponse_QNAME, RemoverAlunoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InserirAluno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exercicio5.world.hello/", name = "inserirAluno")
    public JAXBElement<InserirAluno> createInserirAluno(InserirAluno value) {
        return new JAXBElement<InserirAluno>(_InserirAluno_QNAME, InserirAluno.class, null, value);
    }

}
