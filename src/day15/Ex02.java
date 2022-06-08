package day15;

import java.util.Scanner;

class A02 extends Thread{
	public void run() {
		for(;;) {//무한 반복 동작
			try {
				Thread.sleep(2000);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("A02 : ");
		}
	}
}
public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String msg;
		A02 a = new A02();
		a.setDaemon(true);
		a.start(); // run()이 개별적으로 동작
		while(true) {// 개별적으로 동작
			System.out.println("입력");
			msg = sc.next();
			System.out.println("출력 : " + msg);
			//a.run();
		}
	}
}
