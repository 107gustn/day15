package day15;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex03 {
	public static void main(String[] args) {
		//JFrame
		JFrame frame = new JFrame("����"); //�⺻ Ʋ�� �������
		Container c = frame.getContentPane(); //�⺻ Ʋ�κ��� ���� ����
		JLabel label = new JLabel(); //�۾� ����
		label.setText("test");
		
		Font font = new Font("null", Font.ITALIC, 32); //�۾� ũ�� ����( �۲�, �۾�ü, �۾�ũ��)
		label.setFont(font); //�۾� ũ�� ����
		label.setHorizontalAlignment( JLabel.CENTER ); //�۾� ��� ����
		
		c.add(label); //�ҿ� �۾��� �ø�
		
		frame.setLocation(1000, 2); //Ʋ ���� ��ġ ����
		frame.setPreferredSize(new Dimension(500, 200)); //Ʋ ������ ����
		frame.pack();//������ ����
		
		frame.setVisible(true); //ȭ���� ������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â �ݱ� ��ư�� ���� ���α׷��� ������
		
		
		
		for(int i=0; ; i++)
			label.setText(i + ".�ٸ� ����"); //������ �ٲ���

	}
}
