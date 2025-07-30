//JAVA Time Checker seconds -> day hour minute second

package JAJA;
import java.util.Scanner;

public class Timemaker {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int check = 1;
	while(check != 0) {
		System.out.print("정수를 입력하세요.");
		int time = scanner.nextInt();
		if(time == 0) {
			check = 0;
			break;
		}
		int second = time % 60;
		int minute = (time / 60) % 60;
		int hour = ((time / 60) / 60) % 24;
		int day =((time / 60) / 60) / 24;
		System.out.println("Day " + day + "  " + hour + " : " + minute + " : " + second );
	}
}
}
