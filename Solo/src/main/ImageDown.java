package main;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ImageDown extends Parsing {
		public void img() {
	Parsing parsing = new Parsing();
			
	String website = parsing.parimg();
	System.out.println(""+website+"사이트에서 이미지를 다운로드 합니다.");
	URL url = null;
	try {
		url = new URL(website);
	} catch (MalformedURLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	byte[]buffer = new byte[2048];
	try (InputStream in = url.openStream();
			FileOutputStream out = new FileOutputStream("./test.jpg");){
		int length = 0;
		while((length = in.read(buffer))!=-1) {
			System.out.println(""+length + "바이트 만큼 읽었음!");
			out.write(buffer,0,length);
		}
		in.close();
		out.close();
	}catch(Exception e) {
		System.out.println("예외 :"+ e.getMessage());
	}
	
}
}
