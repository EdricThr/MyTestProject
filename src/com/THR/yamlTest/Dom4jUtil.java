package com.THR.yamlTest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.StringReader;
import java.util.*;

public class Dom4jUtil {
	/** 
	 * 目前是不完善的，只是做了一个一级的，后续再完善
	 * @param xmlText
	 * @param nodeName
	 * @return
	 */
	public static String getNodeValue(String xmlText,String nodeName) {
		try {
			Document doc = DocumentHelper.parseText(xmlText);
			Element root = doc.getRootElement();
			Element resultCode = root.element(nodeName);
			return resultCode.getText();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Document getDoc(String xmlText) {
		try {
			return DocumentHelper.parseText(xmlText);
		} catch (DocumentException e) {
			return null;
		}
	}
	
	public static Element getRoot(Document doc) {
		return doc.getRootElement();
	}
	
	public static Element getRoot(String xmlText) {
		try {
			Document doc = DocumentHelper.parseText(xmlText);
			return doc.getRootElement();
		} catch (DocumentException e) {
			return null;
		}
	}
	
	public static Element getElement(Element element,String nodeName) {
		try {
			return element.element(nodeName);
		} catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Element> getElements(Element element,String nodeName) {
		try {
			return (List<Element>)element.elements(nodeName);
		} catch (Exception e) {
			return null;
		}
	}

	public static List<Map<String,String>> getElementsDataList(String xmlText, String xpath) throws Exception{
		List<Element> childern = getElements(xmlText,xpath);

		List<Map<String,String>> result = new ArrayList<>();

		for (Object nodeObj : childern) {
			Element e = (Element) nodeObj;
			List<?> elements = e.elements();
			Map<String,String> eleMap = new HashMap<>();;
			for (Object element : elements) {
				Element dd = (Element)element;
				eleMap.put(dd.getName(),dd.getText());
			}
			result.add(eleMap);
		}
		return result;
	}

	public static List<Element> getElements(String xmlText, String xpath) throws Exception{
		try {
			SAXReader saxReader = new SAXReader();
			StringReader reader = new StringReader(xmlText);
			Document document = saxReader.read(reader);
			return document.selectNodes(xpath);
		}
		catch(Exception e) {
			throw new Exception("获取子节点失败！",e);
		}
	}

	public static List<String> getXpathNodesValue(String xmlText, String xpath) throws Exception {
		try {
			SAXReader saxReader = new SAXReader();
			StringReader reader = new StringReader(xmlText);
			Document document = saxReader.read(reader);
			List nodeList = document.selectNodes(xpath);
			List<String> valueList = new LinkedList<>();
			for (Object nodeObj : nodeList) {
				Element e = (Element) nodeObj;
				valueList.add(e.getText());
			}
			return valueList;
		} catch (Exception e) {
			throw new Exception("获取节点值失败！",e);
		}
	}

	public static Element getSingleElement(String xmlText,String xpath) throws Exception{
		SAXReader saxReader = new SAXReader();
		StringReader reader = new StringReader(xmlText);
		Document document = saxReader.read(reader);
		return (Element)document.selectSingleNode(xpath);
	}

	public static String getFirstValue(String xmlText,String xpath) throws Exception{
		Element element = getSingleElement(xmlText,xpath);
		if(null != element) {
			return element.getText();
		}
		return null;
	}

	public static List<String> getFirstValues(String xmlText,String... xpathes) throws Exception{
		if(null == xpathes || xpathes.length == 0) return Collections.emptyList();

		List<String> valueList = new ArrayList<>();

		SAXReader saxReader = new SAXReader();
		StringReader reader = new StringReader(xmlText);
		Document document = saxReader.read(reader);

		Element element;
		for(String xpath : xpathes) {
			element = (Element)document.selectSingleNode(xpath);
			if(null != element) {
				valueList.add(element.getText());
			}
			else {
				valueList.add(null);
			}
		}
		return valueList;
	}
}
