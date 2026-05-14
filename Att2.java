import java.util.Scanner;

public class Att2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] ids = {
                { 2026123001, 2026123002, 2026123003 },
                { 2026123004, 2026123005, 2026123006 }
        };
        String[][] names = {
                { "김광운", "이전자", "박통신"},
                { "최소프트", "정네트", "강로봇"}
        };
        int[][] status = new int[2][3];
        System.out.println("===상세 출석부===");

        for (int i = 0; i < names.length; i++) {
            System.out.println("\n[" + (i + 1) + "반 출석 체크]");

            for (int j = 0; j < names[i].length; j++) {
                while (true) {
                    System.out.print(ids[i][j] + "" + names[i][j] + "학생 - 출석했나요?(1/0):");
                    if (sc.hasNextInt()) { // hasNextInt 정수값이 들어왔냐 안들어왔냐
                        int check = sc.nextInt();
                        if (check == 0 || check == 1) {
                            status[i][j] = check;
                            break;
                        } else {
                            System.out.println(">> [1경고] 0 또는 1 만 입력 가능합니다.");
                        }
                    } else {
                        System.out.println(">> [오류] 정수 숫자를 입력해주세요.");
                        sc.next();
                    }
                }
            }
        }
        System.out.println("\n--- 최종 출석부 명단 ---");
        System.out.println("학번\t\t이름\t상태");
        System.out.println("--------------------------");
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names[i].length; j++) {
                String result = (status[i][j] == 1) ? "출석" : "결석";
                System.out.println(ids[i][j] + "\t" + names[i][j] + "\t{" + result + "]");
            }
        }
        sc.close();
    }
}
