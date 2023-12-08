
package de.samples.apicomparison.provider.boundary.soap.stubs;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für BlogPostListResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType name="BlogPostListResponse">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="blogPost" type="{http://samples.de/spring/soap/blog/types}BlogPost" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BlogPostListResponse", propOrder = {
    "blogPost"
})
public class BlogPostListResponse {

    @XmlElement(namespace = "")
    protected List<BlogPost> blogPost;

    /**
     * Gets the value of the blogPost property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the blogPost property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlogPost().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BlogPost }
     * 
     * 
     * @return
     *     The value of the blogPost property.
     */
    public List<BlogPost> getBlogPost() {
        if (blogPost == null) {
            blogPost = new ArrayList<>();
        }
        return this.blogPost;
    }

}
