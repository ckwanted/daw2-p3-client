
package com.ckwanted.ss;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ckwanted.ss package. 
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

    private final static QName _EliminarResponse_QNAME = new QName("http://ckwanted.com/ss", "eliminarResponse");
    private final static QName _Eliminar_QNAME = new QName("http://ckwanted.com/ss", "eliminar");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ckwanted.ss
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EliminarT }
     * 
     */
    public EliminarT createEliminarT() {
        return new EliminarT();
    }

    /**
     * Create an instance of {@link ConcatResponse }
     * 
     */
    public ConcatResponse createConcatResponse() {
        return new ConcatResponse();
    }

    /**
     * Create an instance of {@link EliminarResponseT }
     * 
     */
    public EliminarResponseT createEliminarResponseT() {
        return new EliminarResponseT();
    }

    /**
     * Create an instance of {@link Concat }
     * 
     */
    public Concat createConcat() {
        return new Concat();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarResponseT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ckwanted.com/ss", name = "eliminarResponse")
    public JAXBElement<EliminarResponseT> createEliminarResponse(EliminarResponseT value) {
        return new JAXBElement<EliminarResponseT>(_EliminarResponse_QNAME, EliminarResponseT.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ckwanted.com/ss", name = "eliminar")
    public JAXBElement<EliminarT> createEliminar(EliminarT value) {
        return new JAXBElement<EliminarT>(_Eliminar_QNAME, EliminarT.class, null, value);
    }

}
