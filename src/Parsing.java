

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Parsing {
	public static void main(String[] args) {
		int i=0;
		try {
  	  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
  	  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
  	  
  	
  	  Document doc = dBuilder.parse("./A0203/A0203_5");
  	  doc.getDocumentElement().normalize();
  	  
  	  Element body = (Element) doc.getElementsByTagName("body").item(0);
  	  Element items = (Element) body.getElementsByTagName("items").item(0);
  	  Element item = (Element) items.getElementsByTagName("item").item(0);
  	  
  	  Node title = null;
  	  Node cat2 =null;
  	  Node contentId = null;
  	  Node areaCode = null;
  	 
  	 
  	  while(true) {
  	System.out.println("----------------------------");
        item = (Element) items.getElementsByTagName("item").item(i++);
        if(item==null) 
  		  break;
        title = item.getElementsByTagName("title").item(0);
  	  System.out.println(title.getNodeName()+" : "+title.getChildNodes().item(0).getNodeValue());
  	  cat2 = item.getElementsByTagName("cat2").item(0);
  	  System.out.println(cat2.getNodeName()+" : "+cat2.getChildNodes().item(0).getNodeValue());
  	  contentId = item.getElementsByTagName("contentid").item(0);
  	  System.out.println(contentId.getNodeName()+" : "+contentId.getChildNodes().item(0).getNodeValue());
  	  areaCode = item.getElementsByTagName("areacode").item(0);
  	  System.out.println(areaCode.getNodeName()+" : "+areaCode.getChildNodes().item(0).getNodeValue());
  	      		  
  	  }
  	  
}catch(Exception e) {
	e.printStackTrace();
}
}
}
