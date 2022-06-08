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
		SimpleDateFormat simpl = new SimpleDateFormat("yyyy�� MM�� dd�� hh�� mm�� ss��");
		String result = null;

		
		JFrame frame = new JFrame("NowTime"); //�⺻ Ʋ�� �������
		Container c = frame.getContentPane(); //�⺻ Ʋ�κ��� ���� ����
		JLabel label = new JLabel(); //�۾� ����
		
		
		Font font = new Font("null", Font.ITALIC, 32); //�۾� ũ�� ����( �۲�, �۾�ü, �۾�ũ��)
		label.setFont(font); //�۾� ũ�� ����
		label.setHorizontalAlignment( JLabel.CENTER ); //�۾� ��� ����
		
		c.add(label); //�ҿ� �۾��� �ø�
		
		frame.setLocation(1000, 500); //Ʋ ���� ��ġ ����
		frame.setPreferredSize(new Dimension(700, 200)); //Ʋ ������ ����
		frame.pack();//������ ����
		
		frame.setVisible(true); //ȭ���� ������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â �ݱ� ��ư�� ���� ���α׷��� ������
		
		for(;;) {
			Date date = new Date();
			try {
				Thread.sleep(1000); //1�� ����
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
			System.out.println("1.�α��� 2.���� 3.�α׾ƿ�");
			System.out.print(">>> ");
			num = sc.nextInt();
			
			switch(num) {
			case 1:
				System.out.print("���̵� �Է� : ");
				id = sc.next();
				itemp = idArr.indexOf(id);
				if(itemp == -1) { //�ش簪�� ���ٸ� -1, �ش簪�� ������ �ε��� ��ȣ�� ������
					System.out.println("�������� �ʴ� ���̵� �Դϴ�.");
				}else {
					System.out.print("��й�ȣ �Է� : ");
					pw = sc.nextInt();
					ptemp = pwArr.indexOf(pw);
					if(ptemp != itemp) {
						System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
					}else {
						System.out.println("���� ���");
						lNum = 1;
						tl.setDaemon(true);
						tl.start();
						System.out.println("===== ȯ���մϴ� =====");
						while(sflag) {
							System.out.println("1. ���");
							System.out.println("2. off");
							System.out.print("�Է� >>>> ");
							num = sc.nextInt();
							switch(num) {
							case 1:
								System.out.println("�� ����̿�");
								break;
							case 2:
								sflag = false;
								break;
							default:
								System.out.println("�ٽ� �Է��ϼ���.");
							}							
						}
					}
				}
				break;
			case 2:
				while(true) {
					System.out.print("���̵� �Է� : "); //���̵� �Է�
					id = sc.next(); //���̵� �Է� ����
					if(idArr.indexOf(id) == -1) { //�ش� ���̵��� ���ٸ� -1
						break;
					}
					System.out.println("�����ϴ� ���̵� �Դϴ�."); //�ߺ� ���̵� ����
				}
				System.out.print("��й�ȣ �Է� : ");
				pw = sc.nextInt();
				idArr.add(id);
				pwArr.add(pw);
				System.out.println("���� �Ϸ�");
				break;
			case 3:
				if(lNum == 1) {
					System.out.println("�α׾ƿ� �մϴ�.");
					fflag = false;
				}else {
					System.out.println("�α����� �Ǿ����� �ʽ��ϴ�.");
				}
				break;
			}
		}
		
	}
}
