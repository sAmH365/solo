package dbset;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class setDB {
	int [] arr = new int[] {1,2,3,4,5,6,7,8,31,32,33,34,35,36,37,38,39};
	String [] ar = new String[] {"����","��õ","����","�뱸","����","�λ�","���","����Ư����ġ��","��⵵","������","��û�ϵ�","��û����","���ϵ�","��󳲵�","����ϵ�","���󳲵�","���ֵ�"};
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	String sql;
		
	//������
	public void setDB() {
	connDB();
	
	try {//�Ľ� ����
		int i=0;
		stmt = con.createStatement();
		
		try {
			
			
  	  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
  	  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
  	   
  	  
  		  
  	  Document doc = dBuilder.parse("./A0203/A0203_"+arr[16]);
  	  doc.getDocumentElement().normalize();
  	  
  	  Element body = (Element) doc.getElementsByTagName("body").item(0);
  	  Element items = (Element) body.getElementsByTagName("items").item(0);
  	  Element item = (Element) items.getElementsByTagName("item").item(0);
  	  
  	  Node title = null;
  	  Node cat2 =null;
  	  Node contentId = null;
  	  Node areaCode = null;
  	   	 
  	  while(true) {
  	    item = (Element) items.getElementsByTagName("item").item(i++);
        if(item==null) 
  		  break;
      title = item.getElementsByTagName("title").item(0);
  	  System.out.println(title.getNodeName()+" : "+title.getChildNodes().item(0).getNodeValue());
  	  cat2 = item.getElementsByTagName("cat2").item(0);
  	  contentId = item.getElementsByTagName("contentid").item(0);
  	  areaCode = item.getElementsByTagName("areacode").item(0);
  	    	  
  	  sql = "INSERT INTO LIST values ("+contentId.getChildNodes().item(0).getNodeValue()+",'"+title.getChildNodes().item(0).getNodeValue()+"','"+cat2.getChildNodes().item(0).getNodeValue()+"',"+areaCode.getChildNodes().item(0).getNodeValue()+")"; 
  	  stmt.executeQuery(sql);//������ ����
  	  if(stmt != null) 
  		  System.out.println("insert success");
  	  	  }//while end
  	  
         }catch(Exception e) {
	      e.printStackTrace();
         }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}
	
	//DB ����
	public void connDB() {
		try {
						Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
						
						
				} catch (Exception e) {
			e.printStackTrace();
		}
	}
}