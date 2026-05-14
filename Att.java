import java.util.Scanner;
public class Att {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int [] attendance = new int[5];
        int presentCount = 0;
        System.out.println("=== 1단계: 단일 학급 출석부 ===");
        System.out.println(attendance.length + "명의 출석 데이터를 입력하세요. (1:출석, 0:결석)");
        for (int i = 0; i < attendance.length; i++){
            System.out.print((i+1) + "번 학생: ");
            attendance[i] = sc.nextInt();
        }
        System.out.println("\n--- 오늘의 출석 현황 ---");
        for (int i = 0; i < attendance.length; i++){
            System.out.print((i + 1) + "번: " + (attendance[i] == 1? "출석 ": "결석 ") + "| ");
            if (attendance[i] == 1){
                presentCount++;
            }
        }
        System.out.println("\n\n총원:" + attendance.length + "명");
        System.out.println("출석:" + presentCount + "명");
        System.out.println("결석:" + (attendance.length - presentCount) + "명");
        sc.close();
    }
}
