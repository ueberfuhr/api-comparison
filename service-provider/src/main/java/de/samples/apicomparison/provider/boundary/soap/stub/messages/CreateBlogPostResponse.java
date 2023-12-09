
package de.samples.apicomparison.provider.boundary.soap.stub.messages;

import de.samples.apicomparison.provider.boundary.soap.stub.model.BlogPost;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="blogPost" type="{http://samples.de/spring/soap/blog/types}BlogPost"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "blogPost"
})
@XmlRootElement(name = "createBlogPostResponse")
public class CreateBlogPostResponse {

    @XmlElement(required = true)
    protected BlogPost blogPost;

    /**
     * Ruft den Wert der blogPost-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BlogPost }
     *     
     */
    public BlogPost getBlogPost() {
        return blogPost;
    }

    /**
     * Legt den Wert der blogPost-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BlogPost }
     *     
     */
    public void setBlogPost(BlogPost value) {
        this.blogPost = value;
    }

}
