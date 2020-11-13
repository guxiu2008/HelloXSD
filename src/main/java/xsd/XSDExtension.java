//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.11.10 时间 05:26:48 PM CST 
//


package xsd;

import javax.xml.bind.annotation.*;


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
 *         &lt;element ref="{}attribute"/>
 *       &lt;/sequence>
 *       &lt;attribute name="base" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "attribute"
})
@XmlRootElement(name = "extension")
public class XSDExtension {

    @XmlElement(required = true)
    protected XSDAttribute attribute;
    @XmlAttribute(name = "base", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String base;

    /**
     * 获取attribute属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XSDAttribute }
     *     
     */
    public XSDAttribute getAttribute() {
        return attribute;
    }

    /**
     * 设置attribute属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XSDAttribute }
     *     
     */
    public void setAttribute(XSDAttribute value) {
        this.attribute = value;
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
