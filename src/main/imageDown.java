package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.ImageIcon;

public class ImageDown extends Parsing {

	public void downloadImg() {
		Parsing parsing = new Parsing();
		String website = parsing.parimg();
		// System.out.println(""+website+"사이트에서 이미지를 다운로드 합니다.");
		try {
			URL url = new URL(website);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream("./location");
			byte[] b = new byte[2048];
			int length;
			while ((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}
			is.close();
			os.close();

		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	public ImageIcon getImg() {
		return new ImageIcon(
				(new ImageIcon("./location")).getImage().getScaledInstance(280, 337, java.awt.Image.SCALE_SMOOTH));
	}

	public void fileDelete(String fileName) {
		File f = new File(fileName);
		f.delete();
	}
}
