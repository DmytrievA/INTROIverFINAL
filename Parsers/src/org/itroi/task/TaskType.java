//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.12.18 at 04:52:56 AM EET 
//


package org.itroi.task;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.itroi.entity.Entity;

import java.util.Date;



/**
 * <p>Java class for TaskType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaskType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.itroi.org/entity}Entity">
 *       &lt;sequence>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}time" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://www.itroi.org/task}statusType"/>
 *         &lt;element name="user" type="{http://www.itroi.org/task}userType"/>
 *         &lt;element name="reminders" type="{http://www.itroi.org/task}RemindersType"/>
 *         &lt;element name="givenTask" type="{http://www.itroi.org/task}givenTask" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaskType", propOrder = {
    "title",
    "date",
    "time",
    "duration",
    "description",
    "status",
    "user",
    "reminders",
    "givenTask"
})
public class TaskType
    extends Entity
{

    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected String date;
    @XmlElement(required = true)
    @XmlSchemaType(name = "time")
    protected String time;
    @XmlSchemaType(name = "time")
    protected String duration;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected StatusType status = new StatusType();
    @XmlElement(required = true)
    protected UserType user = new UserType();
    @XmlElement(required = true)
    protected RemindersType reminders = new RemindersType();
    protected GivenTask givenTask = new GivenTask();

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTime(String value) {
        this.time = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDuration(String value) {
        this.duration = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatus(StatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link UserType }
     *     
     */
    public UserType getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserType }
     *     
     */
    public void setUser(UserType value) {
        this.user = value;
    }

    /**
     * Gets the value of the reminders property.
     * 
     * @return
     *     possible object is
     *     {@link RemindersType }
     *     
     */
    public RemindersType getReminders() {
        return reminders;
    }

    /**
     * Sets the value of the reminders property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemindersType }
     *     
     */
    public void setReminders(RemindersType value) {
        this.reminders = value;
    }

    /**
     * Gets the value of the givenTask property.
     * 
     * @return
     *     possible object is
     *     {@link GivenTask }
     *     
     */
    public GivenTask getGivenTask() {
        return givenTask;
    }

    /**
     * Sets the value of the givenTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link GivenTask }
     *     
     */
    public void setGivenTask(GivenTask value) {
        this.givenTask = value;
    }

    public String toString(){
        String s = "Task{" +
                "title='" + title + '\'' +'\n'+
               ", time=" + time +
                ", duration='" + duration + '\'' +
                ", date=" + date +
                " description=" + description + '\n'+
                "statusId="+status.getId()+"\n"+
                " status=" + status.getName() +'\n'+
                " user=" + user.getEmail() +'\n'+
                " reminder=" + reminders.toString() +'\n'+
                ", givenTask=" + givenTask.getMentor() +
                '}';
return s;
    }

}
