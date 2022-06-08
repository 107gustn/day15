package day15;

class A01 extends Thread{//스레드
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("A01 : " + i);
		}
	}
}
class B01 extends Thread{ //스레드
	public void run() {//스레드 동작시 run() 메소드 필요
		for(int i=0; i<100; i++) {
			System.out.println("B01 : " + i);
		}
	}
}
public class Ex01 {
	public static void main(String[] args) { //기본 메인 스레드
		//스레드(Thread): 프로그램을 구동하기위한 최소한의 단위(= 일꾼)
		//멀리스레드: 여러개의 스레드
		A01 a = new A01(); //객체 생성
		B01 b = new B01();
		//a.run();
		//b.run();
		
		//메인이 종료되면 다른 스레드들도 종료되어야 한다.
		a.setDaemon(true);
		b.setDaemon(true);
		
		a.start(); //.start(): 스레드 동작시 호출을 통해 실행
		b.start();
		
		System.out.println("프로그램 종료");
		System.out.println("프로그램 종료");
		System.out.println("프로그램 종료");
	}
}
