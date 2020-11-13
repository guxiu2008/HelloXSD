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


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{}sequence"/>
 *         &lt;element ref="{}simpleContent"/>
 *       &lt;/choice>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sequence",
    "simpleContent"
})
@XmlRootElement(name = "complexType")
public class XSDComplexType {

    protected XSDSequence sequence;
    protected XSDSimpleContent simpleContent;
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String name;

    /**
     * 获取sequence属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XSDSequence }
     *     
     */
    public XSDSequence getSequence() {
        return sequence;
    }

    /**
     * 设置sequence属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XSDSequence }
     *     
     */
    public void setSequence(XSDSequence value) {
        this.sequence = value;
    }

    /**
     * 获取simpleContent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XSDSimpleContent }
     *     
     */
    public XSDSimpleContent getSimpleContent() {
        return simpleContent;
    }

    /**
     * 设置simpleContent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XSDSimpleContent }
     *     
     */
    public void setSimpleContent(XSDSimpleContent value) {
        this.simpleContent = value;
    }

    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
