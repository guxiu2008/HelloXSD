package util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultAttribute;
import xsd.*;

import java.math.BigInteger;
import java.util.*;

public class XSDReader {


    private List<String> listTagName = Arrays.asList("Attribute",
            "Choice",
            "ComplexType",
            "Element",
            "Enumeration",
            "Extension",
            "FractionDigits",
            "MaxLength",
            "MinInclusive",
            "MinLength",
            "Pattern",
            "Restriction",
            "Schema",
            "Sequence",
            "SimpleContent",
            "SimpleType",
            "TotalDigits");

    private XSDObjectFactory objectFactory = new XSDObjectFactory();

    private XSDSchema xsdSchema;

    private Map<String, Object> mapObject = new HashMap<String, Object>();

    public void parseXSD(String xsd) throws Exception {

        SAXReader saxReader = new SAXReader();

        Document doc = saxReader.read(xsd);
        Element element = doc.getRootElement();

        parseDom4jElement(element);
        System.out.println(xsdSchema);
    }

    public int parseDom4jElement(Element element) {
        return parseDom4jElement(element, null);
    }

    public int parseDom4jElement(Element element, Object parentObj) {
        if (element.getName() == null || element.getName().equals("")) {
            System.out.println("Error! Can not get element name!");
            return -1;
        }

        char[] cs = element.getName().toCharArray();
        cs[0] = Character.toUpperCase(cs[0]);
        String xsdEntityClassName = String.valueOf(cs);
        Object currentObj = null;

        switch (xsdEntityClassName) {
            case "Attribute":
                currentObj = parseAttribute(element, parentObj);
                break;
            case "Choice":
                currentObj = parseChoice(element, parentObj);
                break;
            case "ComplexType":
                currentObj = parseComplexType(element, parentObj);
                break;
            case "Element":
                currentObj = parseElement(element, parentObj);
                break;
            case "Enumeration":
                currentObj = parseEnumeration(element, parentObj);
                break;
            case "Extension":
                currentObj = parseExtension(element, parentObj);
                break;
            case "FractionDigits":
                currentObj = parseFractionDigits(element, parentObj);
                break;
            case "MaxLength":
                currentObj = parseMaxLength(element, parentObj);
                break;
            case "MinInclusive":
                currentObj = parseMinInclusive(element, parentObj);
                break;
            case "MinLength":
                currentObj = parseMinLength(element, parentObj);
                break;
            case "Pattern":
                currentObj = parsePattern(element, parentObj);
                break;
            case "Restriction":
                currentObj = parseRestriction(element, parentObj);
                break;
            case "Schema":
                currentObj = parseSchema(element, parentObj);
                break;
            case "Sequence":
                currentObj = parseSequence(element, parentObj);
                break;
            case "SimpleContent":
                currentObj = parseSimpleContent(element, parentObj);
                break;
            case "SimpleType":
                currentObj = parseSimpleType(element, parentObj);
                break;
            case "TotalDigits":
                currentObj = parseTotalDigits(element, parentObj);
                break;
            default:
                System.out.println(String.format("Warning! This XSD file contains a tag that process can not support! Please ask administrator to develop! [%s]", element.toString()));
        }

        Iterator it = element.elementIterator();
        while (it.hasNext()) {
            parseDom4jElement((Element) it.next(), currentObj);
        }

        return 0;
    }

    private XSDAttribute parseAttribute(Element element, Object parentObj) {
        XSDAttribute xsdAttribute = new XSDAttribute();
        for (DefaultAttribute defaultAttribute: (List<DefaultAttribute>) element.attributes()) {
            if (defaultAttribute != null && defaultAttribute.getQName() != null && defaultAttribute.getQName().getName() != null)
                switch (defaultAttribute.getQName().getName()) {
                    case "name":
                        xsdAttribute.setName(defaultAttribute.getStringValue());
                        break;
                    case "type":
                        xsdAttribute.setType(defaultAttribute.getStringValue());
                        break;
                    case "use":
                        xsdAttribute.setUse(defaultAttribute.getStringValue());
                        break;
                    default:
                        System.out.println(String.format("Warning! This attribute contains an attribute that process can not support! Please ask administrator to develop! [%s]", element.toString()));
                }
        }

        if (parentObj != null) {
            String parentClassFullName = parentObj.getClass().getName();
            String [] arr = parentClassFullName.split("\\.", -1);
            String parentClassName = arr[arr.length - 1];
            switch (parentClassName) {
                case "XSDExtension":
                    XSDExtension xsdExtension = (XSDExtension) parentObj;
                    xsdExtension.setAttribute(xsdAttribute);
                    break;
                default:
                    System.out.println(String.format("Warning! This attribute currently can not be the children of class named [%s] in the program, Please ask administrator to develop! [%s]", parentClassName, element.toString()));
            }
        }

        return xsdAttribute;
    }

    private XSDChoice parseChoice(Element element, Object parentObj) {
        XSDChoice xsdChoice = objectFactory.createChoice();
        for (DefaultAttribute defaultAttribute: (List<DefaultAttribute>) element.attributes()) {
            if (defaultAttribute != null && defaultAttribute.getQName() != null && defaultAttribute.getQName().getName() != null)
                switch (defaultAttribute.getQName().getName()) {
                    default:
                        System.out.println(String.format("Warning! This choice contains an attribute that process can not support! Please ask administrator to develop! [%s]", element.toString()));
                }
        }

        if (parentObj != null) {
            String parentClassFullName = parentObj.getClass().getName();
            String[] arr = parentClassFullName.split("\\.", -1);
            String parentClassName = arr[arr.length - 1];
            switch (parentClassName) {
                case "XSDSequence":
                    XSDSequence xsdSequence = (XSDSequence) parentObj;
                    xsdSequence.setChoice(xsdChoice);
                    break;
                default:
                    System.out.println(String.format("Warning! This choice currently can not be the children of class named [%s] in the program, Please ask administrator to develop! [%s]", parentClassName, element.toString()));
            }
        }

        return xsdChoice;
    }

    private XSDComplexType parseComplexType(Element element, Object parentObj) {
        XSDComplexType xsdComplexType = objectFactory.createComplexType();
        for (DefaultAttribute defaultAttribute: (List<DefaultAttribute>) element.attributes()) {
            if (defaultAttribute != null && defaultAttribute.getQName() != null && defaultAttribute.getQName().getName() != null)
                switch (defaultAttribute.getQName().getName()) {
                    case "name":
                        xsdComplexType.setName(defaultAttribute.getStringValue());
                        break;
                    default:
                        System.out.println(String.format("Warning! This complexType contains an attribute that process can not support! Please ask administrator to develop! [%s]", element.toString()));
                }
        }

        if (parentObj != null) {
            String parentClassFullName = parentObj.getClass().getName();
            String [] arr = parentClassFullName.split("\\.", -1);
            String parentClassName = arr[arr.length - 1];
            switch (parentClassName) {
                case "XSDSchema":
                    XSDSchema xsdSchema = (XSDSchema) parentObj;
                    xsdSchema.getComplexTypeOrSimpleType().add(xsdComplexType);
                    break;
                default:
                    System.out.println(String.format("Warning! This complexType currently can not be the children of class named [%s] in the program, Please ask administrator to develop! [%s]", parentClassName, element.toString()));
            }
        }

        return xsdComplexType;
    }

    private XSDElement parseElement(Element element, Object parentObj) {
        XSDElement xsdElement = objectFactory.createElement();
        for (DefaultAttribute defaultAttribute: (List<DefaultAttribute>) element.attributes()) {
            if (defaultAttribute != null && defaultAttribute.getQName() != null && defaultAttribute.getQName().getName() != null)
            switch (defaultAttribute.getQName().getName()) {
                case "name":
                    xsdElement.setName(defaultAttribute.getStringValue());
                    break;
                case "type":
                    xsdElement.setType(defaultAttribute.getStringValue());
                    break;
                case "minOccurs":
                    xsdElement.setMinOccurs(new BigInteger(defaultAttribute.getStringValue()));
                    break;
                case "maxOccurs":
                    xsdElement.setMaxOccurs(defaultAttribute.getStringValue());
                    break;
                default:
                    System.out.println(String.format("Warning! This element contains an attribute that process can not support! Please ask administrator to develop! [%s]", element.toString()));
            }
        }

        if (parentObj != null) {
            String parentClassFullName = parentObj.getClass().getName();
            String [] arr = parentClassFullName.split("\\.", -1);
            String parentClassName = arr[arr.length - 1];
            switch (parentClassName) {
                case "XSDSchema":
                    XSDSchema xsdSchema = (XSDSchema) parentObj;
                    xsdSchema.setElement(xsdElement);
                    break;
                case "XSDSequence":
                    XSDSequence xsdSequence = (XSDSequence) parentObj;
                    xsdSequence.getElement().add(xsdElement);
                    break;
                case "XSDChoice":
                    XSDChoice xsdChoice = (XSDChoice) parentObj;
                    xsdChoice.getElement().add(xsdElement);
                    break;
                default:
                    System.out.println(String.format("Warning! This element currently can not be the children of class named [%s] in the program, Please ask administrator to develop! [%s]", parentClassName, element.toString()));
            }
        }

        return xsdElement;
    }

    private XSDEnumeration parseEnumeration(Element element, Object parentObj) {
        XSDEnumeration xsdEnumeration = objectFactory.createEnumeration();
        for (DefaultAttribute defaultAttribute: (List<DefaultAttribute>) element.attributes()) {
            if (defaultAttribute != null && defaultAttribute.getQName() != null && defaultAttribute.getQName().getName() != null)
                switch (defaultAttribute.getQName().getName()) {
                    case "value":
                        xsdEnumeration.setValue(defaultAttribute.getStringValue());
                        break;
                    default:
                        System.out.println(String.format("Warning! This enumeration contains an attribute that process can not support! Please ask administrator to develop! [%s]", element.toString()));
                }
        }

        if (parentObj != null) {
            String parentClassFullName = parentObj.getClass().getName();
            String [] arr = parentClassFullName.split("\\.", -1);
            String parentClassName = arr[arr.length - 1];
            switch (parentClassName) {
                case "XSDRestriction":
                    XSDRestriction xsdRestriction = (XSDRestriction) parentObj;
                    xsdRestriction.getEnumeration().add(xsdEnumeration);
                    break;
                default:
                    System.out.println(String.format("Warning! This enumeration currently can not be the children of class named [%s] in the program, Please ask administrator to develop! [%s]", parentClassName, element.toString()));
            }
        }
        return xsdEnumeration;
    }

    private XSDExtension parseExtension(Element element, Object parentObj) {
        XSDExtension xsdExtension = objectFactory.createExtension();
        for (DefaultAttribute defaultAttribute: (List<DefaultAttribute>) element.attributes()) {
            if (defaultAttribute != null && defaultAttribute.getQName() != null && defaultAttribute.getQName().getName() != null)
                switch (defaultAttribute.getQName().getName()) {
                    case "base":
                        xsdExtension.setBase(defaultAttribute.getStringValue());
                        break;
                    default:
                        System.out.println(String.format("Warning! This extension contains an attribute that process can not support! Please ask administrator to develop! [%s]", element.toString()));
                }
        }

        if (parentObj != null) {
            String parentClassFullName = parentObj.getClass().getName();
            String [] arr = parentClassFullName.split("\\.", -1);
            String parentClassName = arr[arr.length - 1];
            switch (parentClassName) {
                case "XSDSimpleContent":
                    XSDSimpleContent xsdSimpleContent = (XSDSimpleContent) parentObj;
                    xsdSimpleContent.setExtension(xsdExtension);
                    break;
                default:
                    System.out.println(String.format("Warning! This extension currently can not be the children of class named [%s] in the program, Please ask administrator to develop! [%s]", parentClassName, element.toString()));
            }
        }
        return xsdExtension;
    }

    private XSDFractionDigits parseFractionDigits(Element element, Object parentObj) {
        XSDFractionDigits xsdFractionDigits = objectFactory.createFractionDigits();
        for (DefaultAttribute defaultAttribute: (List<DefaultAttribute>) element.attributes()) {
            if (defaultAttribute != null && defaultAttribute.getQName() != null && defaultAttribute.getQName().getName() != null)
                switch (defaultAttribute.getQName().getName()) {
                    case "value":
                        xsdFractionDigits.setValue(new BigInteger(defaultAttribute.getStringValue()));
                        break;
                    default:
                        System.out.println(String.format("Warning! This fractionDigits contains an attribute that process can not support! Please ask administrator to develop! [%s]", element.toString()));
                }
        }

        if (parentObj != null) {
            String parentClassFullName = parentObj.getClass().getName();
            String [] arr = parentClassFullName.split("\\.", -1);
            String parentClassName = arr[arr.length - 1];
            switch (parentClassName) {
                case "XSDRestriction":
                    XSDRestriction xsdRestriction = (XSDRestriction) parentObj;
                    xsdRestriction.setFractionDigits(xsdFractionDigits);
                    break;
                default:
                    System.out.println(String.format("Warning! This fractionDigits currently can not be the children of class named [%s] in the program, Please ask administrator to develop! [%s]", parentClassName, element.toString()));
            }
        }
        return xsdFractionDigits;
    }

    private XSDMaxLength parseMaxLength(Element element, Object parentObj) {
        XSDMaxLength xsdMaxLength = objectFactory.createMaxLength();
        for (DefaultAttribute defaultAttribute: (List<DefaultAttribute>) element.attributes()) {
            if (defaultAttribute != null && defaultAttribute.getQName() != null && defaultAttribute.getQName().getName() != null)
                switch (defaultAttribute.getQName().getName()) {
                    case "value":
                        xsdMaxLength.setValue(new BigInteger(defaultAttribute.getStringValue()));
                        break;
                    default:
                        System.out.println(String.format("Warning! This maxLength contains an attribute that process can not support! Please ask administrator to develop! [%s]", element.toString()));
                }
        }

        if (parentObj != null) {
            String parentClassFullName = parentObj.getClass().getName();
            String [] arr = parentClassFullName.split("\\.", -1);
            String parentClassName = arr[arr.length - 1];
            switch (parentClassName) {
                case "XSDRestriction":
                    XSDRestriction xsdRestriction = (XSDRestriction) parentObj;
                    xsdRestriction.setMaxLength(xsdMaxLength);
                    break;
                default:
                    System.out.println(String.format("Warning! This maxLength currently can not be the children of class named [%s] in the program, Please ask administrator to develop! [%s]", parentClassName, element.toString()));
            }
        }
        return xsdMaxLength;
    }

    private XSDMinInclusive parseMinInclusive(Element element, Object parentObj) {
        XSDMinInclusive xsdMinInclusive = objectFactory.createMinInclusive();
        for (DefaultAttribute defaultAttribute: (List<DefaultAttribute>) element.attributes()) {
            if (defaultAttribute != null && defaultAttribute.getQName() != null && defaultAttribute.getQName().getName() != null)
                switch (defaultAttribute.getQName().getName()) {
                    case "value":
                        xsdMinInclusive.setValue(new BigInteger(defaultAttribute.getStringValue()));
                        break;
                    default:
                        System.out.println(String.format("Warning! This minInclusive contains an attribute that process can not support! Please ask administrator to develop! [%s]", element.toString()));
                }
        }

        if (parentObj != null) {
            String parentClassFullName = parentObj.getClass().getName();
            String [] arr = parentClassFullName.split("\\.", -1);
            String parentClassName = arr[arr.length - 1];
            switch (parentClassName) {
                case "XSDRestriction":
                    XSDRestriction xsdRestriction = (XSDRestriction) parentObj;
                    xsdRestriction.setMinInclusive(xsdMinInclusive);
                    break;
                default:
                    System.out.println(String.format("Warning! This minInclusive currently can not be the children of class named [%s] in the program, Please ask administrator to develop! [%s]", parentClassName, element.toString()));
            }
        }
        return xsdMinInclusive;
    }

    private XSDMinLength parseMinLength(Element element, Object parentObj) {
        XSDMinLength xsdMinLength = objectFactory.createMinLength();
        for (DefaultAttribute defaultAttribute: (List<DefaultAttribute>) element.attributes()) {
            if (defaultAttribute != null && defaultAttribute.getQName() != null && defaultAttribute.getQName().getName() != null)
                switch (defaultAttribute.getQName().getName()) {
                    case "value":
                        xsdMinLength.setValue(new BigInteger(defaultAttribute.getStringValue()));
                        break;
                    default:
                        System.out.println(String.format("Warning! This minLength contains an attribute that process can not support! Please ask administrator to develop! [%s]", element.toString()));
                }
        }

        if (parentObj != null) {
            String parentClassFullName = parentObj.getClass().getName();
            String [] arr = parentClassFullName.split("\\.", -1);
            String parentClassName = arr[arr.length - 1];
            switch (parentClassName) {
                case "XSDRestriction":
                    XSDRestriction xsdRestriction = (XSDRestriction) parentObj;
                    xsdRestriction.setMinLength(xsdMinLength);
                    break;
                default:
                    System.out.println(String.format("Warning! This minLength currently can not be the children of class named [%s] in the program, Please ask administrator to develop! [%s]", parentClassName, element.toString()));
            }
        }
        return xsdMinLength;
    }

    private XSDPattern parsePattern(Element element, Object parentObj) {
        XSDPattern xsdPattern = objectFactory.createPattern();
        for (DefaultAttribute defaultAttribute: (List<DefaultAttribute>) element.attributes()) {
            if (defaultAttribute != null && defaultAttribute.getQName() != null && defaultAttribute.getQName().getName() != null)
                switch (defaultAttribute.getQName().getName()) {
                    case "value":
                        xsdPattern.setValue(defaultAttribute.getStringValue());
                        break;
                    default:
                        System.out.println(String.format("Warning! This pattern contains an attribute that process can not support! Please ask administrator to develop! [%s]", element.toString()));
                }
        }

        if (parentObj != null) {
            String parentClassFullName = parentObj.getClass().getName();
            String [] arr = parentClassFullName.split("\\.", -1);
            String parentClassName = arr[arr.length - 1];
            switch (parentClassName) {
                case "XSDRestriction":
                    XSDRestriction xsdRestriction = (XSDRestriction) parentObj;
                    xsdRestriction.setPattern(xsdPattern);
                    break;
                default:
                    System.out.println(String.format("Warning! This pattern currently can not be the children of class named [%s] in the program, Please ask administrator to develop! [%s]", parentClassName, element.toString()));
            }
        }
        return xsdPattern;
    }

    private XSDRestriction parseRestriction(Element element, Object parentObj) {
        XSDRestriction xsdRestriction = objectFactory.createRestriction();
        for (DefaultAttribute defaultAttribute: (List<DefaultAttribute>) element.attributes()) {
            if (defaultAttribute != null && defaultAttribute.getQName() != null && defaultAttribute.getQName().getName() != null)
                switch (defaultAttribute.getQName().getName()) {
                    case "base":
                        xsdRestriction.setBase(defaultAttribute.getStringValue());
                        break;
                    default:
                        System.out.println(String.format("Warning! This restriction contains an attribute that process can not support! Please ask administrator to develop! [%s]", element.toString()));
                }
        }

        if (parentObj != null) {
            String parentClassFullName = parentObj.getClass().getName();
            String [] arr = parentClassFullName.split("\\.", -1);
            String parentClassName = arr[arr.length - 1];
            switch (parentClassName) {
                case "XSDSimpleType":
                    XSDSimpleType xsdSimpleType = (XSDSimpleType) parentObj;
                    xsdSimpleType.setRestriction(xsdRestriction);
                    break;
                default:
                    System.out.println(String.format("Warning! This restriction currently can not be the children of class named [%s] in the program, Please ask administrator to develop! [%s]", parentClassName, element.toString()));
            }
        }
        return xsdRestriction;
    }

    private XSDSchema parseSchema(Element element, Object parentObj) {
        xsdSchema = objectFactory.createXSDSchema();

        return xsdSchema;
    }

    private XSDSequence parseSequence(Element element, Object parentObj) {
        XSDSequence xsdSequence = objectFactory.createSequence();
        for (DefaultAttribute defaultAttribute: (List<DefaultAttribute>) element.attributes()) {
            if (defaultAttribute != null && defaultAttribute.getQName() != null && defaultAttribute.getQName().getName() != null)
                switch (defaultAttribute.getQName().getName()) {
                    default:
                        System.out.println(String.format("Warning! This sequence contains an attribute that process can not support! Please ask administrator to develop! [%s]", element.toString()));
                }
        }

        if (parentObj != null) {
            String parentClassFullName = parentObj.getClass().getName();
            String [] arr = parentClassFullName.split("\\.", -1);
            String parentClassName = arr[arr.length - 1];
            switch (parentClassName) {
                case "XSDComplexType":
                    XSDComplexType xsdComplexType = (XSDComplexType) parentObj;
                    xsdComplexType.setSequence(xsdSequence);
                    break;
                default:
                    System.out.println(String.format("Warning! This sequence currently can not be the children of class named [%s] in the program, Please ask administrator to develop! [%s]", parentClassName, element.toString()));
            }
        }

        return xsdSequence;
    }

    private XSDSimpleContent parseSimpleContent(Element element, Object parentObj) {
        XSDSimpleContent xsdSimpleContent = objectFactory.createSimpleContent();
        for (DefaultAttribute defaultAttribute: (List<DefaultAttribute>) element.attributes()) {
            if (defaultAttribute != null && defaultAttribute.getQName() != null && defaultAttribute.getQName().getName() != null)
                switch (defaultAttribute.getQName().getName()) {
                    default:
                        System.out.println(String.format("Warning! This simpleContent contains an attribute that process can not support! Please ask administrator to develop! [%s]", element.toString()));
                }
        }

        if (parentObj != null) {
            String parentClassFullName = parentObj.getClass().getName();
            String [] arr = parentClassFullName.split("\\.", -1);
            String parentClassName = arr[arr.length - 1];
            switch (parentClassName) {
                case "XSDComplexType":
                    XSDComplexType xsdComplexType = (XSDComplexType) parentObj;
                    xsdComplexType.setSimpleContent(xsdSimpleContent);
                    break;
                default:
                    System.out.println(String.format("Warning! This simpleContent currently can not be the children of class named [%s] in the program, Please ask administrator to develop! [%s]", parentClassName, element.toString()));
            }
        }
        return xsdSimpleContent;
    }

    private XSDSimpleType parseSimpleType(Element element, Object parentObj) {
        XSDSimpleType xsdSimpleType = objectFactory.createSimpleType();
        for (DefaultAttribute defaultAttribute: (List<DefaultAttribute>) element.attributes()) {
            if (defaultAttribute != null && defaultAttribute.getQName() != null && defaultAttribute.getQName().getName() != null)
                switch (defaultAttribute.getQName().getName()) {
                    case "name":
                        xsdSimpleType.setName(defaultAttribute.getStringValue());
                        break;
                    default:
                        System.out.println(String.format("Warning! This simpleType contains an attribute that process can not support! Please ask administrator to develop! [%s]", element.toString()));
                }
        }

        if (parentObj != null) {
            String parentClassFullName = parentObj.getClass().getName();
            String [] arr = parentClassFullName.split("\\.", -1);
            String parentClassName = arr[arr.length - 1];
            switch (parentClassName) {
                case "XSDSchema":
                    XSDSchema xsdSchema = (XSDSchema) parentObj;
                    xsdSchema.getComplexTypeOrSimpleType().add(xsdSimpleType);
                    break;
                default:
                    System.out.println(String.format("Warning! This simpleType currently can not be the children of class named [%s] in the program, Please ask administrator to develop! [%s]", parentClassName, element.toString()));
            }
        }

        return xsdSimpleType;
    }

    private XSDTotalDigits parseTotalDigits(Element element, Object parentObj) {
        XSDTotalDigits xsdTotalDigits = objectFactory.createTotalDigits();
        for (DefaultAttribute defaultAttribute: (List<DefaultAttribute>) element.attributes()) {
            if (defaultAttribute != null && defaultAttribute.getQName() != null && defaultAttribute.getQName().getName() != null)
                switch (defaultAttribute.getQName().getName()) {
                    case "value":
                        xsdTotalDigits.setValue(new BigInteger(defaultAttribute.getStringValue()));
                        break;
                    default:
                        System.out.println(String.format("Warning! This totalDigits contains an attribute that process can not support! Please ask administrator to develop! [%s]", element.toString()));
                }
        }

        if (parentObj != null) {
            String parentClassFullName = parentObj.getClass().getName();
            String [] arr = parentClassFullName.split("\\.", -1);
            String parentClassName = arr[arr.length - 1];
            switch (parentClassName) {
                case "XSDRestriction":
                    XSDRestriction xsdRestriction = (XSDRestriction) parentObj;
                    xsdRestriction.setTotalDigits(xsdTotalDigits);
                    break;
                default:
                    System.out.println(String.format("Warning! This simpleType currently can not be the children of class named [%s] in the program, Please ask administrator to develop! [%s]", parentClassName, element.toString()));
            }
        }
        return xsdTotalDigits;
    }
}
