//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.12.18 at 04:52:56 AM EET 
//


package org.itroi.user;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import org.itroi.entityuser.EntityUser;


/**
 * <p>Java class for userType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.itroi.org/entityUser}EntityUser">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.itroi.org/user}email"/>
 *         &lt;element name="login" type="{http://www.itroi.org/user}login"/>
 *         &lt;element name="password" type="{http://www.itroi.org/user}password"/>
 *         &lt;element name="gender" type="{http://www.itroi.org/user}gender" minOccurs="0"/>
 *         &lt;element name="memberOfGroups" type="{http://www.itroi.org/user}memberOfGroups"/>
 *       &lt;/sequence>
 *       &lt;attribute name="role" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userType", propOrder = {
    "rest"
})
public class UserType
    extends EntityUser
{

    @XmlElementRefs({
        @XmlElementRef(name = "memberOfGroups", namespace = "http://www.itroi.org/user", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "email", namespace = "http://www.itroi.org/user", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gender", namespace = "http://www.itroi.org/user", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "surname", namespace = "http://www.itroi.org/user", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "password", namespace = "http://www.itroi.org/user", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "name", namespace = "http://www.itroi.org/user", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "login", namespace = "http://www.itroi.org/user", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> rest;
    @XmlAttribute(name = "role")
    protected String role;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Email" is used by two different parts of a schema. See: 
     * line 49 of file:/C:/labs/-_-/ITROI%20v2.0/src/XML/User.xsd
     * line 8 of file:/C:/labs/-_-/ITROI%20v2.0/src/XML/EntityUser.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the rest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link MemberOfGroups }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<?>>();
        }
        return this.rest;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
    }

}
