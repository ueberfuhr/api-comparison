
package de.samples.apicomparison.provider.boundary.soap.stub.messages;

import java.util.ArrayList;
import java.util.List;
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
@XmlType(name = "", propOrder = {
    "blogPosts"
})
@XmlRootElement(name = "findAllBlogPostsResponse")
public class FindAllBlogPostsResponse {

    @XmlElement(name = "blogPost")
    protected List<BlogPost> blogPosts;

    /**
     * Gets the value of the blogPosts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the blogPosts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlogPosts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BlogPost }
     * 
     * 
     * @return
     *     The value of the blogPosts property.
     */
    public List<BlogPost> getBlogPosts() {
        if (blogPosts == null) {
            blogPosts = new ArrayList<>();
        }
        return this.blogPosts;
    }

}
