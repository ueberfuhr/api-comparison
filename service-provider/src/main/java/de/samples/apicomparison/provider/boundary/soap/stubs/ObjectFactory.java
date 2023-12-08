
package de.samples.apicomparison.provider.boundary.soap.stubs;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.samples.apicomparison.provider.boundary.soap.stubs package. 
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

    private static final QName _FindAllBlogPostsRequest_QNAME = new QName("http://samples.de/spring/soap/blog/messages", "findAllBlogPostsRequest");
    private static final QName _FindAllBlogPostsResponse_QNAME = new QName("http://samples.de/spring/soap/blog/messages", "findAllBlogPostsResponse");
    private static final QName _CreateBlogPostRequest_QNAME = new QName("http://samples.de/spring/soap/blog/messages", "createBlogPostRequest");
    private static final QName _DeleteBlogPostRequest_QNAME = new QName("http://samples.de/spring/soap/blog/messages", "deleteBlogPostRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.samples.apicomparison.provider.boundary.soap.stubs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Void }
     * 
     * @return
     *     the new instance of {@link Void }
     */
    public Void createVoid() {
        return new Void();
    }

    /**
     * Create an instance of {@link BlogPostListResponse }
     * 
     * @return
     *     the new instance of {@link BlogPostListResponse }
     */
    public BlogPostListResponse createBlogPostListResponse() {
        return new BlogPostListResponse();
    }

    /**
     * Create an instance of {@link BlogPostInputRequest }
     * 
     * @return
     *     the new instance of {@link BlogPostInputRequest }
     */
    public BlogPostInputRequest createBlogPostInputRequest() {
        return new BlogPostInputRequest();
    }

    /**
     * Create an instance of {@link UuidRequest }
     * 
     * @return
     *     the new instance of {@link UuidRequest }
     */
    public UuidRequest createUuidRequest() {
        return new UuidRequest();
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

    /**
     * Create an instance of {@link BlogPostInput }
     * 
     * @return
     *     the new instance of {@link BlogPostInput }
     */
    public BlogPostInput createBlogPostInput() {
        return new BlogPostInput();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Void }{@code >}
     */
    @XmlElementDecl(namespace = "http://samples.de/spring/soap/blog/messages", name = "findAllBlogPostsRequest")
    public JAXBElement<Void> createFindAllBlogPostsRequest(Void value) {
        return new JAXBElement<>(_FindAllBlogPostsRequest_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BlogPostListResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BlogPostListResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://samples.de/spring/soap/blog/messages", name = "findAllBlogPostsResponse")
    public JAXBElement<BlogPostListResponse> createFindAllBlogPostsResponse(BlogPostListResponse value) {
        return new JAXBElement<>(_FindAllBlogPostsResponse_QNAME, BlogPostListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BlogPostInputRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BlogPostInputRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://samples.de/spring/soap/blog/messages", name = "createBlogPostRequest")
    public JAXBElement<BlogPostInputRequest> createCreateBlogPostRequest(BlogPostInputRequest value) {
        return new JAXBElement<>(_CreateBlogPostRequest_QNAME, BlogPostInputRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UuidRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UuidRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://samples.de/spring/soap/blog/messages", name = "deleteBlogPostRequest")
    public JAXBElement<UuidRequest> createDeleteBlogPostRequest(UuidRequest value) {
        return new JAXBElement<>(_DeleteBlogPostRequest_QNAME, UuidRequest.class, null, value);
    }

}
