package day15;

class A01 extends Thread{//������
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("A01 : " + i);
		}
	}
}
class B01 extends Thread{ //������
	public void run() {//������ ���۽� run() �޼ҵ� �ʿ�
		for(int i=0; i<100; i++) {
			System.out.println("B01 : " + i);
		}
	}
}
public class Ex01 {
	public static void main(String[] args) { //�⺻ ���� ������
		//������(Thread): ���α׷��� �����ϱ����� �ּ����� ����(= �ϲ�)
		//�ָ�������: �������� ������
		A01 a = new A01(); //��ü ����
		B01 b = new B01();
		//a.run();
		//b.run();
		
		//������ ����Ǹ� �ٸ� ������鵵 ����Ǿ�� �Ѵ�.
		a.setDaemon(true);
		b.setDaemon(true);
		
		a.start(); //.start(): ������ ���۽� ȣ���� ���� ����
		b.start();
		
		System.out.println("���α׷� ����");
		System.out.println("���α׷� ����");
		System.out.println("���α׷� ����");
	}
}
