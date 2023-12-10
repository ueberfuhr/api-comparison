
package de.samples.apicomparison.consumer.clients.soap.stub.model;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.samples.apicomparison.consumer.clients.soap.stub.model package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.samples.apicomparison.consumer.clients.soap.stub.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HashTag }
     * 
     * @return
     *     the new instance of {@link HashTag }
     */
    public HashTag createHashTag() {
        return new HashTag();
    }

    /**
     * Create an instance of {@link Author }
     * 
     * @return
     *     the new instance of {@link Author }
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link BlogPost }
     * 
     * @return
     *     the new instance of {@link BlogPost }
     */
    public BlogPost createBlogPost() {
        return new BlogPost();
    }

}
