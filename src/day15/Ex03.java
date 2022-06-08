package day15;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex03 {
	public static void main(String[] args) {
		//JFrame
		JFrame frame = new JFrame("연습"); //기본 틀을 만들어줌
		Container c = frame.getContentPane(); //기본 틀로부터 팬을 얻어옴
		JLabel label = new JLabel(); //글씨 생성
		label.setText("test");
		
		Font font = new Font("null", Font.ITALIC, 32); //글씨 크기 지정( 글꼴, 글씨체, 글씨크기)
		label.setFont(font); //글씨 크기 적용
		label.setHorizontalAlignment( JLabel.CENTER ); //글씨 가운데 지정
		
		c.add(label); //팬에 글씨를 올림
		
		frame.setLocation(1000, 2); //틀 생성 위치 지정
		frame.setPreferredSize(new Dimension(500, 200)); //틀 사이즈 지정
		frame.pack();//설정값 적용
		
		frame.setVisible(true); //화면을 보여줌
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 닫기 버튼을 통해 프로그램을 종료함
		
		
		
		for(int i=0; ; i++)
			label.setText(i + ".다른 내용"); //내용을 바꿔줌

	}
}
