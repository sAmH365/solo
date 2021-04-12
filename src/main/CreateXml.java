package main;
import java.io.BufferedReader; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.text.Document;



public class CreateXml {
	
		 public void info(int n) {
			 try {
		    	StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon"); /*URL*/
		        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=qPbvF1dptkf%2BXXhYU23B5nqx70dG0PRzXiL9tJC4EM%2Fs39vXxdjXzpUbnpIIFt4zOX7pzl2GQ7z5EvqBwv8TTw%3D%3D"); /*Service Key*/
		        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*한 페이지 결과수*/ //한페이지 결과수
		        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
		        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); //서비스명 = 어플명
		        urlBuilder.append("&" +"contentId"+ "="+n);//컨텐츠아이디
		        urlBuilder.append("&" + URLEncoder.encode("firstImageYN","UTF-8") + "=" + URLEncoder.encode( "Y" , "UTF-8")); //대표이미지
		        urlBuilder.append("&" + URLEncoder.encode("addrinfoYN","UTF-8") + "=" + URLEncoder.encode( "Y" , "UTF-8")); //주소
		        urlBuilder.append("&" + URLEncoder.encode("mapinfoYN","UTF-8") + "=" + URLEncoder.encode("N", "UTF-8")); //좌표조회
		        urlBuilder.append("&" + URLEncoder.encode("overviewYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); //오버뷰조회
		       		        
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
		        	
		        		        		    	  
		    	  FileOutputStream output = new FileOutputStream("./infomation");  //create file
		    	  output.write(sb.toString().getBytes());
		    	  output.close();
		    	 
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			
		 }
       }

