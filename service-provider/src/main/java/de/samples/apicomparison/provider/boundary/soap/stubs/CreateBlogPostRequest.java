
package de.samples.apicomparison.provider.boundary.soap.stubs;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für BlogPostInputRequest complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType name="BlogPostInputRequest">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="input" type="{http://samples.de/spring/soap/blog/types}BlogPostInput"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BlogPostInputRequest", propOrder = {
    "input"
})
@XmlRootElement(name = "createBlogPostRequest")
public class CreateBlogPostRequest {

    @XmlElement(namespace = "", required = true)
    protected BlogPostInput input;

    /**
     * Ruft den Wert der input-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BlogPostInput }
     *     
     */
    public BlogPostInput getInput() {
        return input;
    }

    /**
     * Legt den Wert der input-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BlogPostInput }
     *     
     */
    public void setInput(BlogPostInput value) {
        this.input = value;
    }

}
