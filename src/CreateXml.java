import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;



public class CreateXml {
			 public static void main(String[] args) throws IOException {
		ImageIcon img = new ImageIcon("./test.jpg");
		
		JFrame f = new JFrame();
		f.setSize(800,600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		f.setIconImage(img.getImage());
				
}
}