package main;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Parsing {
	String address;
	String overview;

	public String address() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse("./infomation");
			doc.getDocumentElement().normalize();

			Element body = (Element) doc.getElementsByTagName("body").item(0);
			Element items = (Element) body.getElementsByTagName("items").item(0);
			Element item = (Element) items.getElementsByTagName("item").item(0);

			Node add = null;
			Node firstimage = null;
			Node overview = null;

			item = (Element) items.getElementsByTagName("item").item(0);

			add = item.getElementsByTagName("addr1").item(0);
			//System.out.println(add.getChildNodes().item(0).getNodeValue());

			overview = item.getElementsByTagName("overview").item(0);
			//System.out.println(overview.getChildNodes().item(0).getNodeValue());

			address = add.getChildNodes().item(0).getNodeValue().toString();
			//System.out.println(address);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return address;
	}

	public String overview() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse("./infomation");
			doc.getDocumentElement().normalize();

			Element body = (Element) doc.getElementsByTagName("body").item(0);
			Element items = (Element) body.getElementsByTagName("items").item(0);
			Element item = (Element) items.getElementsByTagName("item").item(0);

			Node ov = null;

			item = (Element) items.getElementsByTagName("item").item(0);

			ov = item.getElementsByTagName("overview").item(0);
			
			overview = ov.getChildNodes().item(0).getNodeValue().toString();

		} catch (Exception e) {
			//e.printStackTrace();
		}
		return overview;

	}

	public String parimg() {
		String website = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse("./infomation");
			doc.getDocumentElement().normalize();

			Element body = (Element) doc.getElementsByTagName("body").item(0);
			Element items = (Element) body.getElementsByTagName("items").item(0);
			Element item = (Element) items.getElementsByTagName("item").item(0);

			Node firstimage = null;

			item = (Element) items.getElementsByTagName("item").item(0);

			firstimage = item.getElementsByTagName("firstimage").item(0);
			//System.out.println(firstimage.getNodeName() + " : " + firstimage.getChildNodes().item(0).getNodeValue());
			website = firstimage.getChildNodes().item(0).getNodeValue();
			//System.out.println(website);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return website;
	}
}
