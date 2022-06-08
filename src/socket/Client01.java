package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client01 { // ���񽺸� �����޴� ��ǻ��
	public static void main(String[] args) throws IOException {
		Socket sock = new Socket("192.168.7.105", 12345); //������ ���� IP�� Port�� �Է��� ���� ���� ����
		OutputStream os = sock.getOutputStream(); //�⺻ ��Ʈ�� //������ �����͸� ����
		DataOutputStream dos = new DataOutputStream(os); //�����͸� �ٸ� ������� ������ �ְ� ��ȯ
		
		Scanner sc = new Scanner(System.in);
		/*
		int sendData;
		System.out.println("���� �Է�");
		sendData = sc.nextInt();
		os.write(sendData);
		*/
		System.out.println("������ �Է�");
		String sendData = sc.next(); //������ �Է� ����
		dos.writeUTF(sendData); //�ش� ������ ����
		
		System.out.println("�����͸� �����Ͽ����ϴ�!!!");
		
		InputStream in = sock.getInputStream(); //������ ����ڷκ��� �Է��� �޾ƿ��� ��� //Stream: �������ִ� ��
		DataInputStream dis = new DataInputStream(in);
		
		System.out.println("���� ������ : " + dis.readUTF());
		System.out.println("Ŭ���̾�Ʈ ����");
	}
}
