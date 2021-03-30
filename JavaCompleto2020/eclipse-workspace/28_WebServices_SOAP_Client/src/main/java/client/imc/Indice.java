
package client.imc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for indice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="indice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="peso" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="altura" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "indice", propOrder = {
    "peso",
    "altura"
})
public class Indice {

    protected double peso;
    protected double altura;

    /**
     * Gets the value of the peso property.
     * 
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Sets the value of the peso property.
     * 
     */
    public void setPeso(double value) {
        this.peso = value;
    }

    /**
     * Gets the value of the altura property.
     * 
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Sets the value of the altura property.
     * 
     */
    public void setAltura(double value) {
        this.altura = value;
    }

}
