
package de.samples.apicomparison.provider.boundary.soap.stub.messages;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlEnum;
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
 *         <element name="status">
 *           <simpleType>
 *             <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               <enumeration value="DELETED"/>
 *               <enumeration value="NOT_FOUND"/>
 *             </restriction>
 *           </simpleType>
 *         </element>
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
    "status"
})
@XmlRootElement(name = "deleteBlogPostResponse")
public class DeleteBlogPostResponse {

    @XmlElement(required = true)
    protected DeleteBlogPostResponse.DeleteOperationStatus status;

    /**
     * Ruft den Wert der status-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DeleteBlogPostResponse.DeleteOperationStatus }
     *     
     */
    public DeleteBlogPostResponse.DeleteOperationStatus getStatus() {
        return status;
    }

    /**
     * Legt den Wert der status-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DeleteBlogPostResponse.DeleteOperationStatus }
     *     
     */
    public void setStatus(DeleteBlogPostResponse.DeleteOperationStatus value) {
        this.status = value;
    }


    /**
     * <p>Java-Klasse für null.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * <pre>{@code
     * <simpleType>
     *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *     <enumeration value="DELETED"/>
     *     <enumeration value="NOT_FOUND"/>
     *   </restriction>
     * </simpleType>
     * }</pre>
     * 
     */
    @XmlType(name = "")
    @XmlEnum
    public enum DeleteOperationStatus {

        DELETED,
        NOT_FOUND;

        public String value() {
            return name();
        }

        public static DeleteBlogPostResponse.DeleteOperationStatus fromValue(String v) {
            return valueOf(v);
        }

    }

}
