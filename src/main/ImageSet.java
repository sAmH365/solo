package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImageSet extends JPanel{
	Image image;
	Toolkit toolkit = getToolkit(); // �̹����� �������� ���ؼ�

	public void setPath(String src) {
		image = toolkit.getImage(src); // ��� ����
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, 480, 640);
		if (image != null)
			g.drawImage(image, 0, 0, this); // ��ΰ� ������ �� ���
	}

	
}
