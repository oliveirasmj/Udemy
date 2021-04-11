package client.hello;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

public class Exercicio5 {

public static void main(String[] args) throws SOAPException, MalformedURLException {
		
		//Instanciação do objeto que permite a criação de mensagens
        MessageFactory mf = MessageFactory.newInstance();
        //Cria a mensagem SOAP com Header e Body
        SOAPMessage sm = mf.createMessage();
        //Obtenção da instância do Header
        SOAPHeader sh = sm.getSOAPHeader();
        //Obtenção da instância do Body
        SOAPBody sb = sm.getSOAPBody();
        
        //Remove o header da mensagem
        sh.detachNode();
        //Namespace URI , localpart , namespace prefix
        QName bodyName = new QName("http://exercicio5.world.hello/", "listarAlunos", "m");//m é o que envia do genero <m></m>
        //Associação do obje to QName ao elemento Body
        SOAPBodyElement be = sb.addBodyElement(bodyName);
        //Criação de um objeto do tipo QName
        //QName name = new QName("a"); //nome da variavel para o exterior no Server
        
        //Adiciona um novo subelemento ao elemento Body
        //SOAPElement arg0 = be.addChildElement(name);
        //Adiciona um valor ao subelemento criado
        //arg0.addTextNode("Miguel");
        //Identificação do Endpoint
        URL ep = new URL(String.format("http://localhost:9999/escola"));
        //Criar um objeto SOAPConnectionFactory para instanciar uma ligação
        SOAPConnectionFactory scf = SOAPConnectionFactory.newInstance();
        //Criao objeto para estabelecer a ligação
        SOAPConnection sc = scf.createConnection();
        //Realiza a invocação do serviço enviado a mensagem SOAP (sm) para o endpoint ( ep )
        SOAPMessage response = sc.call(sm, ep);
        //Termina a ligação
        sc.close();
        
        //Obtém a referência para o elemento Body da resposta
        SOAPBody respBody = response.getSOAPBody();
        //Obtenção do iterador para percorrer os subelementos do elemento Body
        Iterator it = respBody.getChildElements();
        //Acede ao elemento seguinte
        SOAPBodyElement el = (SOAPBodyElement) it.next();
        //Obtém os subelementos do elemento el
        it = el.getChildElements();
        //Acede ao elemento seguinte
        SOAPBodyElement sbe = (SOAPBodyElement) it.next();
        //Escreve o valor
        System.out.println("Valor: "+sbe.getTextContent());
	}

}
