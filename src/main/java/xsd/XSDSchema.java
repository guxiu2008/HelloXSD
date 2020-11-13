//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.11.10 时间 05:26:48 PM CST 
//


package xsd;

import javax.xml.bind.annotation.*;
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
 *         &lt;element ref="{}element"/>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element ref="{}complexType"/>
 *           &lt;element ref="{}simpleType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "element",
    "complexTypeOrSimpleType"
})
@XmlRootElement(name = "xs:schema")
public class XSDSchema {

    @XmlElement(required = true)
    protected XSDElement element;
    @XmlElements({
        @XmlElement(name = "complexType", type = XSDComplexType.class),
        @XmlElement(name = "simpleType", type = XSDSimpleType.class)
    })
    protected List<Object> complexTypeOrSimpleType;

    /**
     * 获取element属性的值。
     *
     * @return
     *     possible object is
     *     {@link XSDElement }
     *
     */
    public XSDElement getElement() {
        return element;
    }

    /**
     * 设置element属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link XSDElement }
     *
     */
    public void setElement(XSDElement value) {
        this.element = value;
    }

    /**
     * Gets the value of the complexTypeOrSimpleType property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the complexTypeOrSimpleType property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComplexTypeOrSimpleType().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XSDComplexType }
     * {@link XSDSimpleType }
     *
     *
     */
    public List<Object> getComplexTypeOrSimpleType() {
        if (complexTypeOrSimpleType == null) {
            complexTypeOrSimpleType = new ArrayList<Object>();
        }
        return this.complexTypeOrSimpleType;
    }

}
