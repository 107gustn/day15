package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server01 { //���񽺸� �����ϴ� ��ǻ��
	public static void main(String[] args) throws IOException {
		//���� ������ ���� socket
		//socket: �ܺο� ������ ���ֱ� ���� ����
		ServerSocket server = new ServerSocket(12345); //��Ʈ ��ȣ: 12345(2byteũ��)
		System.out.println("������ ��ٸ��ϴ�.....");
		Socket sock = server.accept(); //���� ���� �õ� - Ŭ���̾�Ʈ�� ������ �����ϱ� ���ؼ� ��� //sock - Ŭ���̾�Ʈ�� ���� ������ �����
		System.out.println("���� �Ǿ����ϴ�!!!");
		InputStream in = sock.getInputStream(); //������ ����ڷκ��� �Է��� �޾ƿ��� ��� //Stream: �������ִ� ��
		DataInputStream dis = new DataInputStream(in); //InputStream ���׷��̵�
		
		System.out.println("���� ���.....");
		String readData = dis.readUTF(); //�Է¹��� ���ڿ��� �޾ƿ� //write -> read
		System.out.println("���� ������ : " + readData);
		
		OutputStream os = sock.getOutputStream(); //�⺻ ��Ʈ��
		DataOutputStream dos = new DataOutputStream(os); //�����͸� �ٸ� ������� ������ �ְ� ��ȯ
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		System.out.println("�������� �Է�");
		str = sc.next();
		dos.writeUTF(str); //�ش� Ŭ���̾�Ʈ�� �����͸� ����
		System.out.println("���� ����");
		
//		int readData = in.read();
//		System.out.println("���� ������ : " + readData);
		
	}
}
