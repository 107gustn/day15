package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client01 { // 서비스를 제공받는 컴퓨터
	public static void main(String[] args) throws IOException {
		Socket sock = new Socket("192.168.7.105", 12345); //서버에 대한 IP와 Port를 입력을 통한 서버 연결
		OutputStream os = sock.getOutputStream(); //기본 스트림 //서버로 데이터를 보냄
		DataOutputStream dos = new DataOutputStream(os); //데이터를 다른 방식으로 보낼수 있게 변환
		
		Scanner sc = new Scanner(System.in);
		/*
		int sendData;
		System.out.println("숫자 입력");
		sendData = sc.nextInt();
		os.write(sendData);
		*/
		System.out.println("데이터 입력");
		String sendData = sc.next(); //데이터 입력 받음
		dos.writeUTF(sendData); //해당 서버로 전송
		
		System.out.println("데이터를 전송하였습니다!!!");
		
		InputStream in = sock.getInputStream(); //접속한 사용자로부터 입력을 받아오는 기능 //Stream: 연결해주는 길
		DataInputStream dis = new DataInputStream(in);
		
		System.out.println("수신 데이터 : " + dis.readUTF());
		System.out.println("클라이언트 종료");
	}
}
