// JAVA ESSENTIAL Chapter2

package JAJA;

import java.util.Scanner;

public class Arithmetic {
	public static void main(String[] args) {
	      //실습 보너스 문제
	      Scanner scanner = new Scanner(System.in);
	      System.out.print("식을 입력하세요>>");
	      
	      double op1 = scanner.nextDouble();
	      String operator = scanner.next();
	      double op2 = scanner.nextDouble();
	      double result = 0;
	      
	      switch(operator) {
	      case "+":
	         result = op1 + op2; break;
	      case "-":
	         result = op1 - op2; break;
	      case "*":
	         result = op1 * op2; break;
	      case "/":
	         if(op2 == 0) {
	            System.out.println("0으로 나눌 수 없습니다.");
	            return;
	         }
	         result = op1 / op2; break;
	      default: System.out.println("연산 기호가 잘못되었습니다.");
	      }
	      System.out.println(result);
	      
	      //실습분제 1~10
	      first();
	      second();
	      third();
	      fourth();
	      fifth();
	      sixth();
	      seventh();
	      eighth();
	      ninth();
	      tenth();
	   }
	   
	   static void first(){
	      Scanner scanner = new Scanner(System.in);
	      System.out.printf("두 정수를 입력하세요>>");
	      int i = scanner.nextInt();
	      int j = scanner.nextInt();
	      System.out.println( i + "+" +j+"은 " + (i+j));
	   }

	   static void second() {
	      Scanner scanner = new Scanner(System.in);
	      System.out.printf("몇 층인지 입력하세요>>");
	      int i = scanner.nextInt();
	      System.out.println( (5 *i) +"m 입니다." );
	   }

	   static void third() {
	      Scanner scanner = new Scanner(System.in);
	      System.out.printf("x 값을 입력하세요>>");
	      int x = scanner.nextInt();
	      double y = Math.pow(x, 2) -(3*x) + 7;
	      System.out.println( "x=" + x + ", y=" + (int)y);
	   }

	   static void fourth() {
	      Scanner scanner = new Scanner(System.in);
	      System.out.printf("점 (x,y)의 좌표를 입력하세요>>");
	      int x = scanner.nextInt();
	      int y = scanner.nextInt();
	      if(x >=50 && x <= 100) {
	         if(y>=50 && y<=100) {
	            System.out.println("점(" + x + "," + y + ")은 사각형 내에 있습니다.");
	         }
	      }
	   }

	   static void fifth() {
	      int i = 0;
	      Scanner scanner = new Scanner(System.in);
	      System.out.printf( "논리 연산을 입력하세요>>");
	      boolean a = scanner.nextBoolean();
	      String s = scanner.next();
	      boolean b = scanner.nextBoolean();
	      
	      String and = "AND";
	      String or = "OR";
	      //문자열 비교
	      if(s.equals(or)) {
	         i = 1;
	      }
	      else if(s.equals(and)) {
	         i = 2;
	      }

	      switch(i) {
	      case 1:
	         System.out.println(a || b);
	         break;
	      case 2:
	         System.out.println(a && b);
	         break;
	      }
	      
	      /*
	      switch(s) {
	      case "OR":
	         System.out.println(a || b);
	         break;
	         
	      case "AND":
	         System.out.println(a && b);
	         break;
	      }*/
	      
	         
	   }

	   static void sixth() {
	      Scanner scanner = new Scanner(System.in);
	      System.out.printf( "돈의 액수를 입력하세요>>");
	      int money = scanner.nextInt();
	      int i=0, j=0, k=0, r=0, l=0, m=0, n=0;
	      
	      if(money >= 50000) {
	         i = money / 50000;
	         money = money%50000;
	      }
	      if(money >= 10000) {
	         j = money / 10000;
	         money = money % 10000;
	      }
	      if(money >= 1000) {
	         k = money / 1000;
	         money = money%1000;
	      }
	      if(money >= 500) {
	         r = money / 500;
	         money = money %500;
	      }
	      if(money >= 100) {
	         l = money / 100;
	         money = money % 100;
	      }
	      if(money >=10) {
	         m = money / 10;
	         money = money % 10;
	      }
	      if(money >=1) {
	         n = money / 1;
	      }
	      /*
	      System.out.printf("오만원" + (money / 50000) + "개, ");
	      money = money %50000;
	      
	      System.out.printf("만원" + (money / 10000) + "개, ");
	      money = money %10000;
	      
	      System.out.printf("천원" + (money / 1000) + "개, ");
	      money = money%1000;
	      
	      System.out.printf("500원" + (money / 500) + "개, ");
	      money = money%500;
	      
	      System.out.printf("100원" + (money / 100) + "개, ");
	      money = money%100;
	      
	      System.out.printf("10원" + (money / 10) + "개, ");
	      money = money%10;
	      
	      System.out.printf("1원" + (money / 50000) + "개");
	      */
	      System.out.println("오만원" + i + "개, 만원" + j + "개, 천원" + k + "개, 500원" + r + "개, 100원" + l + "개, 10원" + m + "개, 1원" + n);
	   }

	   static void seventh() {
	      Scanner scanner = new Scanner(System.in);
	      System.out.printf( "학점을 입력하세요>>");
	      String score = scanner.next();
	      switch(score) {
	      case "A":
	         System.out.println("Excellent");
	         break;
	      case "B":
	         System.out.println("Excellent");
	         break;
	      case "C":
	         System.out.println("Good");
	         break;
	      case "D":
	         System.out.println("Good");
	         break;
	      case "F":
	         System.out.println("Bye");
	         break;
	      }
	   }

	   static void eighth() {
	      Scanner scanner = new Scanner(System.in);
	      System.out.printf( "커피를 주문하세요>>");
	      String coffee = scanner.next();
	      int n = scanner.nextInt();
	      int price = 0;
	      //if문 사용
	      /*if(coffee.equals("에스프레소")) {
	         price = n*2000;
	      }
	      else if(coffee.equals("아메리카노")) {
	         price = n*2500;
	      }
	      else if(coffee.equals("카푸치노")) {
	         price = n*3000;
	      }
	      else if(coffee.equals("카페라떼")) {
	         price = n*3500;
	      }
	      */
	      //while문 사용
	      switch(커피) {
	      case "에스프레소":
	         price = n*2000;
	         break;
	      case "아메리카노":
	         price = n*2500;
	         break;
	      case "카푸치노":
	         price = n*3000;
	         break;
	      case "카페라떼":
	         price = n*3500;
	         break;
	      }
	      System.out.println(price + "원입니다.");
	   }

	   static void ninth() {
	      Scanner scanner = new Scanner(System.in);
	      System.out.printf( "1~99 사이의 정수를 입력하세요>>");
	      int n = scanner.nextInt();
	      int count = 0;
	      
	      if(n/10 == 3 || n/10 == 6 || n/10 == 9) {
	         count++;
	         n = n%10;
	      }
	      
	      if(n%3==0||n%6 == 0) {
	         count++;
	      }
	      
	      if(count == 1) {
	         System.out.println("박수짝");
	      }
	      else if(count == 2) {
	         System.out.println("박수짝짝");
	      }
	      else {
	         System.out.println("박수없음");
	      }
	   }

	   static void tenth() {
	      Scanner scanner = new Scanner(System.in);
	      System.out.printf( "커피를 주문하세요>>");
	      String coffee = scanner.next();
	      int n = scanner.nextInt();
	      float price = 0.0f;
	      if(n >= 10) {
	         
	      }
	      //if문 사용
	      if(coffee.equals("에스프레소")) {
	         price = n*2000;
	      }
	      else if(coffee.equals("아메리카노")) {
	         price = n*2500;
	      }
	      else if(coffee.equals("카푸치노")) {
	         price = n*3000;
	      }
	      else if(coffee.equals("카페라떼")) {
	         price = n*3500;
	      }
	      if(n>=10) {
	         price = price * 0.95f;
	      }
	      System.out.println((int)price + "원입니다.");
	      
	   }

}
