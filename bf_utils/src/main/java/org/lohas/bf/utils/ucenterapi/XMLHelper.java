package org.lohas.bf.utils.ucenterapi;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;

/**
 * ================================================
 * Discuz! Ucenter API for JAVA
 * ================================================
 * XML工具类，处理UC Client接收到返回结果。
 * UC Client会收到UC Server返回的XML结果
 * 该类将XML中的数据提取成一个List按顺序读取即可。
 * 
 * 更多信息：http://code.google.com/p/discuz-ucenter-api-for-java/
 */
public class XMLHelper {
	private static Logger logger = LoggerFactory.getLogger(XMLHelper.class);

	public static LinkedList<String> uc_unserialize(String input){
		
		LinkedList<String> result = new LinkedList<String>();
		
		DOMParser parser = new DOMParser();
		try {			
			parser.parse(new InputSource(new StringReader(input)));
			Document doc = parser.getDocument();
			NodeList nl = doc.getChildNodes().item(0).getChildNodes();
			int length = nl.getLength();
			for(int i=0;i<length;i++){
				if(nl.item(i).getNodeType()==Document.ELEMENT_NODE)
					result.add(nl.item(i).getTextContent());
			}
		} catch (SAXException e) {
			logger.error(e.getMessage(),e);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}
		return result;
	}
}
