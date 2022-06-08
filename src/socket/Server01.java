package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server01 { //서비스를 제공하는 컴퓨터
	public static void main(String[] args) throws IOException {
		//서버 구동을 위한 socket
		//socket: 외부와 연결을 해주기 위한 도구
		ServerSocket server = new ServerSocket(12345); //포트 번호: 12345(2byte크기)
		System.out.println("접속을 기다립니다.....");
		Socket sock = server.accept(); //접속 연결 시도 - 클라이언트가 서버로 접속하기 위해서 대기 //sock - 클라이언트에 대한 정보가 저장됨
		System.out.println("접속 되었습니다!!!");
		InputStream in = sock.getInputStream(); //접속한 사용자로부터 입력을 받아오는 기능 //Stream: 연결해주는 길
		DataInputStream dis = new DataInputStream(in); //InputStream 업그레이드
		
		System.out.println("수신 대기.....");
		String readData = dis.readUTF(); //입력받은 문자열을 받아옴 //write -> read
		System.out.println("수신 데이터 : " + readData);
		
		OutputStream os = sock.getOutputStream(); //기본 스트림
		DataOutputStream dos = new DataOutputStream(os); //데이터를 다른 방식으로 보낼수 있게 변환
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		System.out.println("서버에서 입력");
		str = sc.next();
		dos.writeUTF(str); //해당 클라이언트로 데이터를 보냄
		System.out.println("서버 종료");
		
//		int readData = in.read();
//		System.out.println("수신 데이터 : " + readData);
		
	}
}
