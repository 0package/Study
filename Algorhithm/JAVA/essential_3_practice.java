//명품 자바 에센셜 3장
//실습문제
package JAJA;

import java.util.Scanner;
import java.util.InputMismatchException;

public class practice {
	public static void main(String[] args) {
		first();
		second();
		third();
		fourth();
		fifth();
		sixth();
		seventh();
		eighth();
	}
	static void first() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("알파벳 한 문자를 입력하세요>>");
		String al = scanner.next();
		for(char i = 'a';i<=al.charAt(0);i++) {
			for(char k = i;k<=al.charAt(0);k++) {
				if(k<= al.charAt(0)) {
					System.out.print(k);
				}
			}
			System.out.println();
		}
	}
	
	static void second() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수 10개 입력하세요>>");
		int arr[] = new int[10];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = scanner.nextInt();
			if(arr[i] % 3 == 0 && arr[i] != 0) {
				System.out.print(arr[i] + " ");
			}
		}
	}
	
	static void third() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요>>");
		int num = 0, check = 0;
		try {
			num = scanner.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.print("정수를 입력하지 않아 프로그램을 종료합니다.");
			check = 1;
		}
		if(check == 0) {
			if(num % 2 == 0) {
				System.out.println("짝수");
			}
			else {
				System.out.println("홀수");
			}
		}
	}
	
	static void fourth() {
		Scanner scanner = new Scanner(System.in);
		char day[] = {'일', '월', '화', '수', '목', '금', '토'};
		int num = 0, check = 0;
		while(true) {
			System.out.print("정수를 입력하세요>>");
			try {
				num = scanner.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("경고! 정수를 입력하지 않았습니다.");
				scanner.next();
				continue;
			}
			if(num<0) {
				System.out.println("프로그램 종료합니다...");
				break;
			}
			
			System.out.println(day[num%7]);
			
		}
	}
	
	static void fifth() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수 10개 입력하세요>>");
		int arr[] = new int[10];
		int temp = 0;
		
		for(int i = 0;i<arr.length;i++) {
			arr[i] = scanner.nextInt();
		}
		
		for(int i = arr.length - 1;i>=0;i--) {
			for(int k = 0;k<i;k++) {
				if(arr[k] > arr[k+1]) {
					temp = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = temp;
				}
			}
		}
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	static void sixth() {
		Scanner scanner = new Scanner(System.in);
		String eng[] = {"student", "love", "java", "happy", "future"};
		String kor[] = {"하생", "사랑", "자바", "행복한", "미래"};
		while(true) {
			System.out.print("영어단어를 입력하세요>>");
			int i = 0;
			String str;
			str = scanner.next();
			if(str.equals("exit")) {
				System.out.println("종료합니다...");
				break;
			}
			for(i = 0;i<eng.length;i++) {
				if(str.equals(eng[i])) {
					System.out.println(kor[i]);
					break;
				}
			}
			if(i >= eng.length) {
				System.out.println("그런 영어 단어가 없습니다.");
			}
		}
		
	}
	
	static void seventh() {
		
		for(int i = 1;i<100;i++) {
			int count = 0;
			if(i/10 == 3 || i/10 == 6|| i/10 == 9) {
				count++;
			}
			if(i % 10 == 3 || i % 10 == 6 || i%10 == 9) {
				count++;
			}
			
			if(count == 0) {
				continue;
			}
			else if(count == 1) {
				System.out.println(i + " 박수한번");
			}
			else if(count == 2) {
				System.out.println(i + " 박수두번");
			}
		}
	}
	
	static void eighth() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
		String rsp[] = {"가위", "바위", "보"};
		while(true) {
			System.out.print("가위 바위 보!>>");
			String str = scanner.next();
			if(str.equals("그만")) {
				System.out.println("게임을 종료합니다...");
				break;
			}
			int n = (int)(Math.random()*3);
			if(str.equals(rsp[n])) {
				System.out.println("사용자 = " + str + ", 컴퓨터 = " + rsp[n] + ", 비겼습니다.");
			}
			
			switch(str) {
			case "바위":
				if(rsp[n].equals("가위")) {
					System.out.println("사용자 = " + str + ", 컴퓨터 = " + rsp[n] + ", 사용자가 이겼습니다.");
				}
				else if (rsp[n].equals("보")) {
					System.out.println("사용자 = " + str + ", 컴퓨터 = " + rsp[n] + ", 컴퓨터가 이겼습니다..");
				}
				break;
			case "가위":
				if(rsp[n].equals("바위")) {
					System.out.println("사용자 = " + str + ", 컴퓨터 = " + rsp[n] + ", 컴퓨터가 이겼습니다.");
				}
				else if (rsp[n].equals("보")) {
					System.out.println("사용자 = " + str + ", 컴퓨터 = " + rsp[n] + ", 사용자가 이겼습니다.");
				}
				break;
			case "보":
				if(rsp[n].equals("가위")) {
					System.out.println("사용자 = " + str + ", 컴퓨터 = " + rsp[n] + ", 컴퓨터가 이겼습니다.");
				}
				else if (rsp[n].equals("바위")) {
					System.out.println("사용자 = " + str + ", 컴퓨터 = " + rsp[n] + ", 사용자가 이겼습니다.");
				}
				break;
			}
		}
		
	}
		
}


//보너스 문제
package JAJA;

public class RandomArray {
	public static void main(String[] args) {
		int intArray[][];
		intArray = new int[3][4];
		
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<4;j++) {
				intArray[i][j] = (int)(Math.random()*10);
			}
		}
		
		for(int i = 0;i<intArray.length;i++) {
			for(int j = 0;j<intArray[i].length;j++) {
				System.out.print(intArray[i][j] + " ");
			}
			System.out.println();
		}
		
		int i = 0, sum = 0;
		while(i<3) {
			for(int j = 0;j<intArray[i].length;j++) {
				sum += intArray[i][j];
			}
			i++;
		}
		System.out.println("합은 " + sum);
	}
}
