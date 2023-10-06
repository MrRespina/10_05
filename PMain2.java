package Practice;

import java.util.Random;
import java.util.Scanner;

public class PMain2 {

	// 함수 , 로또? 1. 로또번호 총 6개 있음. 중복X. 자동으로 번호 6개 뽑기
	// 2. 내가 숫자 6개 입력하게 할 것.
	// 3. 6개 일치 : 1등 / 5개 일치 : 2등 / 4개 일치 : 3등 / 3개 이하 : 꽝
	// 4. 로또 번호의 범위 : 1~45

	public static int[] buyLotto() {

		Scanner s = new Scanner(System.in);
		int arr[] = new int[6];
		for (int i = 0; i < arr.length; i++) {

			System.out.print("값 입력 : ");
			arr[i] = s.nextInt();
			if (arr[i] >= 46 || arr[i] <= 0) {
				System.out.println("1~45 사이의 숫자를 입력해주세요!");
				i--;
			}

			for (int j = 0; j < i; j++) {

				if (arr[i] == arr[j]) {
					System.out.println("중복값 입력 불가!");
					i--;
				}

			}

		}
		System.out.println("===== 내가 입력한 숫자들 =====");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		s.close();

		return arr;

	}

	public static int[] getLottoNum() {

		int num[] = new int[6];

		for (int i = 0; i < num.length; i++) {

			int r = new Random().nextInt(44) + 1;
			num[i] = r;

			for (int j = 0; j < i; j++) {

				if (num[i] == num[j]) {
					i--;
				}

			}

		}

		return num;

	}

	public static void calc(int arr[], int num[]) {

		int count = 0;
		System.out.println("======== 당첨 숫자 ========");
		for(int i = 0 ; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("========================");
		
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j <= i; j++) {

				if (num[i] == arr[j]) {
					count++;
				}

			}

		}
		System.out.println("맞은 숫자의 갯수 : " + count);
		if (count <= 3) {
			System.out.println("꽝 입니다.");
		} else if (count == 4) {
			System.out.println("3등 입니다!");
		} else if (count == 5) {
			System.out.println("2등 입니다!");
		} else if (count == 6) {
			System.out.println("1등 입니다!");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calc(getLottoNum(), buyLotto());

	}

}
