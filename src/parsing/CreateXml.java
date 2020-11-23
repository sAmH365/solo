package parsing;
import java.io.BufferedReader; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;



public class CreateXml {
			 public static void main(String[] args) throws IOException {
		    	int j=0;
		    	int [] arr = new int[] {1,2,3,4,5,6,7,8,31,32,33,34,35,36,37,38,39}; //area code
		    	
		    	for(j=0;j<arr.length;j++) {
		    		
		    	StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"); /*URL*/
		        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=qokmPyxe0TV6bE1qcpfC6ZULpVzPIhhTybDc6GqQyE5pg1iiKi6JaUrz0zRDYJ%2BFcojCKJK1Pr98PyYbWEiDFg%3D%3D"); /*Service Key*/
		        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("300", "UTF-8")); /*한 페이지 결과수*/ //한페이지 결과수
		        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/ // 현재페이지 번호
		        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
		        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); //서비스명 = 어플명
		        urlBuilder.append("&" +"areaCode"+ "=" +arr[j]);
		       // urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("5", "UTF-8"));  //지역코드
		        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("O", "UTF-8"));  //대표이미지 정렬 
		        urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("12", "UTF-8"));  //관광타입 
		        urlBuilder.append("&" + URLEncoder.encode("cat1","UTF-8") + "=" + URLEncoder.encode("A02", "UTF-8"));   
		        urlBuilder.append("&" + URLEncoder.encode("cat2","UTF-8") + "=" + URLEncoder.encode("A0201", "UTF-8"));  
		        
		        
		        URL url = new URL(urlBuilder.toString());
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("Accept", "application/xml");
		        System.out.println("Response code: " + conn.getResponseCode());
		        BufferedReader rd;
		        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        } else {
		            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		        }
		        StringBuilder sb = new StringBuilder();
		        String line;
		        while ((line = rd.readLine()) != null) {
		        	     sb.append(line);
		        	    sb.append("\n");
		        }
		        		        		    	  
		    	  FileOutputStream output = new FileOutputStream("./A0201_"+arr[j]);  //create file
		    	  output.write(sb.toString().getBytes());
		    	  output.close();
		    	  System.out.println("create file : " +arr[j]);
		    	  System.out.println(url);
		   }
	 }
}
