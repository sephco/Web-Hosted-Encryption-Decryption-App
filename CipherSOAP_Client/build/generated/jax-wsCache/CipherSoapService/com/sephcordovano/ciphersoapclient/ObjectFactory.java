
package com.sephcordovano.ciphersoapclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sephcordovano.ciphersoapclient package. 
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

    private final static QName _Decipher_QNAME = new QName("http://ciphersoapws.sephcordovano.com/", "decipher");
    private final static QName _ValidateArgumentsResponse_QNAME = new QName("http://ciphersoapws.sephcordovano.com/", "validateArgumentsResponse");
    private final static QName _DecipherResponse_QNAME = new QName("http://ciphersoapws.sephcordovano.com/", "decipherResponse");
    private final static QName _ValidateArguments_QNAME = new QName("http://ciphersoapws.sephcordovano.com/", "validateArguments");
    private final static QName _CipherArgumentException_QNAME = new QName("http://ciphersoapws.sephcordovano.com/", "CipherArgumentException");
    private final static QName _Cipher_QNAME = new QName("http://ciphersoapws.sephcordovano.com/", "cipher");
    private final static QName _CipherResponse_QNAME = new QName("http://ciphersoapws.sephcordovano.com/", "cipherResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sephcordovano.ciphersoapclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CipherArgumentException }
     * 
     */
    public CipherArgumentException createCipherArgumentException() {
        return new CipherArgumentException();
    }

    /**
     * Create an instance of {@link Cipher }
     * 
     */
    public Cipher createCipher() {
        return new Cipher();
    }

    /**
     * Create an instance of {@link ValidateArguments }
     * 
     */
    public ValidateArguments createValidateArguments() {
        return new ValidateArguments();
    }

    /**
     * Create an instance of {@link CipherResponse }
     * 
     */
    public CipherResponse createCipherResponse() {
        return new CipherResponse();
    }

    /**
     * Create an instance of {@link Decipher }
     * 
     */
    public Decipher createDecipher() {
        return new Decipher();
    }

    /**
     * Create an instance of {@link ValidateArgumentsResponse }
     * 
     */
    public ValidateArgumentsResponse createValidateArgumentsResponse() {
        return new ValidateArgumentsResponse();
    }

    /**
     * Create an instance of {@link DecipherResponse }
     * 
     */
    public DecipherResponse createDecipherResponse() {
        return new DecipherResponse();
    }

    /**
     * Create an instance of {@link CipherFaultBean }
     * 
     */
    public CipherFaultBean createCipherFaultBean() {
        return new CipherFaultBean();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Decipher }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ciphersoapws.sephcordovano.com/", name = "decipher")
    public JAXBElement<Decipher> createDecipher(Decipher value) {
        return new JAXBElement<Decipher>(_Decipher_QNAME, Decipher.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateArgumentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ciphersoapws.sephcordovano.com/", name = "validateArgumentsResponse")
    public JAXBElement<ValidateArgumentsResponse> createValidateArgumentsResponse(ValidateArgumentsResponse value) {
        return new JAXBElement<ValidateArgumentsResponse>(_ValidateArgumentsResponse_QNAME, ValidateArgumentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DecipherResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ciphersoapws.sephcordovano.com/", name = "decipherResponse")
    public JAXBElement<DecipherResponse> createDecipherResponse(DecipherResponse value) {
        return new JAXBElement<DecipherResponse>(_DecipherResponse_QNAME, DecipherResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateArguments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ciphersoapws.sephcordovano.com/", name = "validateArguments")
    public JAXBElement<ValidateArguments> createValidateArguments(ValidateArguments value) {
        return new JAXBElement<ValidateArguments>(_ValidateArguments_QNAME, ValidateArguments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CipherArgumentException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ciphersoapws.sephcordovano.com/", name = "CipherArgumentException")
    public JAXBElement<CipherArgumentException> createCipherArgumentException(CipherArgumentException value) {
        return new JAXBElement<CipherArgumentException>(_CipherArgumentException_QNAME, CipherArgumentException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cipher }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ciphersoapws.sephcordovano.com/", name = "cipher")
    public JAXBElement<Cipher> createCipher(Cipher value) {
        return new JAXBElement<Cipher>(_Cipher_QNAME, Cipher.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CipherResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ciphersoapws.sephcordovano.com/", name = "cipherResponse")
    public JAXBElement<CipherResponse> createCipherResponse(CipherResponse value) {
        return new JAXBElement<CipherResponse>(_CipherResponse_QNAME, CipherResponse.class, null, value);
    }

}
