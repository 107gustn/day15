package day15;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

class timeLog extends Thread {
	public void run() {
		SimpleDateFormat simpl = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String result = null;

		
		JFrame frame = new JFrame("NowTime"); //기본 틀을 만들어줌
		Container c = frame.getContentPane(); //기본 틀로부터 팬을 얻어옴
		JLabel label = new JLabel(); //글씨 생성
		
		
		Font font = new Font("null", Font.ITALIC, 32); //글씨 크기 지정( 글꼴, 글씨체, 글씨크기)
		label.setFont(font); //글씨 크기 적용
		label.setHorizontalAlignment( JLabel.CENTER ); //글씨 가운데 지정
		
		c.add(label); //팬에 글씨를 올림
		
		frame.setLocation(1000, 500); //틀 생성 위치 지정
		frame.setPreferredSize(new Dimension(700, 200)); //틀 사이즈 지정
		frame.pack();//설정값 적용
		
		frame.setVisible(true); //화면을 보여줌
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 닫기 버튼을 통해 프로그램을 종료함
		
		for(;;) {
			Date date = new Date();
			try {
				Thread.sleep(1000); //1초 단위
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			result = simpl.format(date);
			label.setText(result);
		}
	}
}
public class Quiz01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList idArr = new ArrayList();
		ArrayList pwArr = new ArrayList();
		
		boolean fflag = true, sflag = true, lflag = false;
		int num, pw, itemp, ptemp, lNum = 0;
		String id;
		
		timeLog tl = new timeLog();


		
		while(fflag) {
			System.out.println("1.로그인 2.가입 3.로그아웃");
			System.out.print(">>> ");
			num = sc.nextInt();
			
			switch(num) {
			case 1:
				System.out.print("아이디 입력 : ");
				id = sc.next();
				itemp = idArr.indexOf(id);
				if(itemp == -1) { //해당값이 없다면 -1, 해당값이 있으면 인덱스 번호를 가져옴
					System.out.println("존재하지 않는 아이디 입니다.");
				}else {
					System.out.print("비밀번호 입력 : ");
					pw = sc.nextInt();
					ptemp = pwArr.indexOf(pw);
					if(ptemp != itemp) {
						System.out.println("비밀번호가 일치하지 않습니다.");
					}else {
						System.out.println("인증 통과");
						lNum = 1;
						tl.setDaemon(true);
						tl.start();
						System.out.println("===== 환영합니다 =====");
						while(sflag) {
							System.out.println("1. 기능");
							System.out.println("2. off");
							System.out.print("입력 >>>> ");
							num = sc.nextInt();
							switch(num) {
							case 1:
								System.out.println("뭔 기능이여");
								break;
							case 2:
								sflag = false;
								break;
							default:
								System.out.println("다시 입력하세요.");
							}							
						}
					}
				}
				break;
			case 2:
				while(true) {
					System.out.print("아이디 입력 : "); //아이디 입력
					id = sc.next(); //아이디 입력 받음
					if(idArr.indexOf(id) == -1) { //해당 아이디값이 없다면 -1
						break;
					}
					System.out.println("존재하는 아이디 입니다."); //중복 아이디 존재
				}
				System.out.print("비밀번호 입력 : ");
				pw = sc.nextInt();
				idArr.add(id);
				pwArr.add(pw);
				System.out.println("가입 완료");
				break;
			case 3:
				if(lNum == 1) {
					System.out.println("로그아웃 합니다.");
					fflag = false;
				}else {
					System.out.println("로그인이 되어있지 않습니다.");
				}
				break;
			}
		}
		
	}
}
