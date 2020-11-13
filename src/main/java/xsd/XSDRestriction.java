//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.11.10 时间 05:26:48 PM CST 
//


package xsd;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{}pattern"/>
 *           &lt;element ref="{}enumeration" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;sequence>
 *             &lt;element ref="{}minLength"/>
 *             &lt;element ref="{}maxLength"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element ref="{}minInclusive" minOccurs="0"/>
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{}fractionDigits"/>
 *           &lt;element ref="{}totalDigits"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="base" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pattern",
    "enumeration",
    "minLength",
    "maxLength",
    "minInclusive",
    "fractionDigits",
    "totalDigits"
})
@XmlRootElement(name = "restriction")
public class XSDRestriction {

    protected XSDPattern pattern;
    protected List<XSDEnumeration> enumeration;
    protected XSDMinLength minLength;
    protected XSDMaxLength maxLength;
    protected XSDMinInclusive minInclusive;
    protected XSDFractionDigits fractionDigits;
    protected XSDTotalDigits totalDigits;
    @XmlAttribute(name = "base", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String base;

    /**
     * 获取pattern属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XSDPattern }
     *     
     */
    public XSDPattern getPattern() {
        return pattern;
    }

    /**
     * 设置pattern属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XSDPattern }
     *     
     */
    public void setPattern(XSDPattern value) {
        this.pattern = value;
    }

    /**
     * Gets the value of the enumeration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enumeration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnumeration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XSDEnumeration }
     * 
     * 
     */
    public List<XSDEnumeration> getEnumeration() {
        if (enumeration == null) {
            enumeration = new ArrayList<XSDEnumeration>();
        }
        return this.enumeration;
    }

    /**
     * 获取minLength属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XSDMinLength }
     *     
     */
    public XSDMinLength getMinLength() {
        return minLength;
    }

    /**
     * 设置minLength属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XSDMinLength }
     *     
     */
    public void setMinLength(XSDMinLength value) {
        this.minLength = value;
    }

    /**
     * 获取maxLength属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XSDMaxLength }
     *     
     */
    public XSDMaxLength getMaxLength() {
        return maxLength;
    }

    /**
     * 设置maxLength属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XSDMaxLength }
     *     
     */
    public void setMaxLength(XSDMaxLength value) {
        this.maxLength = value;
    }

    /**
     * 获取minInclusive属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XSDMinInclusive }
     *     
     */
    public XSDMinInclusive getMinInclusive() {
        return minInclusive;
    }

    /**
     * 设置minInclusive属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XSDMinInclusive }
     *     
     */
    public void setMinInclusive(XSDMinInclusive value) {
        this.minInclusive = value;
    }

    /**
     * 获取fractionDigits属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XSDFractionDigits }
     *     
     */
    public XSDFractionDigits getFractionDigits() {
        return fractionDigits;
    }

    /**
     * 设置fractionDigits属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XSDFractionDigits }
     *     
     */
    public void setFractionDigits(XSDFractionDigits value) {
        this.fractionDigits = value;
    }

    /**
     * 获取totalDigits属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XSDTotalDigits }
     *     
     */
    public XSDTotalDigits getTotalDigits() {
        return totalDigits;
    }

    /**
     * 设置totalDigits属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XSDTotalDigits }
     *     
     */
    public void setTotalDigits(XSDTotalDigits value) {
        this.totalDigits = value;
    }

    /**
     * 获取base属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBase() {
        return base;
    }

    /**
     * 设置base属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBase(String value) {
        this.base = value;
    }

}
