package Practice;

import java.util.Random;
import java.util.Scanner;

//함수 / 컴퓨터 vs 나 가위바위보 게임?

public class PMain1 {

	static Scanner s = new Scanner(System.in);
	
	public static int myAnswer() {
		
		
		boolean b = true;
		int myAns = 0;
		while (b == true) {
			System.out.print("내가 낼 것 : ");
			String my = s.nextLine();
			if (my.equals("가위")) {
				myAns = 1;
				b = false;
			} else if (my.equals("바위")) {
				myAns = 0;
				b = false;
			} else if (my.equals("보")) {
				myAns = 2;
				b = false;
			} else {
				System.out.println("정확한 값을 입력해주세요!");
			}
		}
		return myAns;
	}

	public static int aiAnswer() {

		int r = new Random().nextInt(3);
		return r;

	}

	public static int whosWinner(int myAns, int aiAns) {
	
		int result = myAns - aiAns;
		
		return result;

	}
	
	public static void print(int myAns,int aiAns,int result) {
		
		String myAnswer="",aiAnswer="";
		switch (myAns) {
		case 0:
			myAnswer = "바위";
			break;
		case 1:
			myAnswer = "가위";
			break;
		case 2:
			myAnswer = "보";
			break;
		}
		switch (aiAns) {
		case 0:
			aiAnswer = "바위";
			break;
		case 1:
			aiAnswer = "가위";
			break;
		case 2:
			aiAnswer = "보";
			break;
		}
		System.out.println("===============");
		System.out.println("내가 낸 것 : "+myAnswer);
		System.out.println("내가 낸 것 : "+aiAnswer);
		if (result == 0) {
			System.out.println("무승부입니다 !");
		} else if (result == -2 || result == 1) {
			System.out.println("패배했습니다 !");
		} else if (result == 2 || result == -1) {
			System.out.println("승리했습니다 !");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int my,ai,winner=0,wincount=0;
		
		while(winner==0||winner==2||winner==-1) {
			my=myAnswer();
			ai=aiAnswer();
			winner=whosWinner(my,ai);
			print(my,ai,winner);
			if(winner==-1||winner==2) {
				wincount++;
			}
		}
		System.out.println("연승 횟수 : "+wincount);
		s.close();

	}

}
