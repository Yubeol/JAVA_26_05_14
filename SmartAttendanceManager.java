import java.util.Scanner;

public class SmartAttendanceManager {

    public static double getAttendanceRate(int[] classStatus) {
        int presentCount = 0;

        for (int s : classStatus) {
            if (s == 1)
                presentCount++;
        }

        return (double) presentCount / classStatus.length * 100;
    }

    public static void printFullReport(int[][] ids, String[][] names, int[][] status) {

        System.out.println("\n--- 최종 출석부 명단 ---");
        System.out.println("학번\t\t이름\t상태");
        System.out.println("------------------------------");

        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names[i].length; j++) {

                String result = (status[i][j] == 1) ? "출석" : "결석";

                System.out.println(
                        ids[i][j] + "\t" + names[i][j] + "\t[" + result + "]"
                );
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] ids = {
                {2026123001, 2026123002},
                {2026123003, 2026123004, 2026123005, 2026123006}
        };

        String[][] names = {
                {"김광운", "이전자"},
                {"박통신", "최소프트", "정네트", "강로봇"}
        };

        int[][] status = new int[2][];
        status[0] = new int[2];
        status[1] = new int[4];

        while (true) {

            System.out.println("\n[ 스마트 출석 관리 시스템 ]");
            System.out.println("1. 출석 체크 시작");
            System.out.println("2. 전체 현황 조회");
            System.out.println("3. 반별 통계 보기");
            System.out.println("0. 프로그램 종료");

            System.out.print("\n원하는 작업을 선택해주세요 : ");
            String menu = sc.next();

            if (menu.equals("0")) {

                System.out.println("프로그램을 종료합니다.");
                break;

            } else if (menu.equals("1")) {

                for (int i = 0; i < names.length; i++) {

                    System.out.println("\n[" + (i + 1) + "반 출석 체크]");

                    for (int j = 0; j < names[i].length; j++) {

                        while (true) {

                            System.out.print(
                                    ids[i][j] + " " + names[i][j] + " (1:출석, 0:결석): "
                            );

                            if (sc.hasNextInt()) {

                                int val = sc.nextInt();

                                if (val == 0 || val == 1) {

                                    status[i][j] = val;
                                    break;

                                } else {

                                    System.out.println(">> [경고] 0 또는 1만 입력 가능합니다.");
                                }

                            } else {

                                System.out.println(">> [오류] 정수 숫자를 입력해주세요.");
                                sc.next();
                            }
                        }
                    }
                }

                System.out.println("\n** 모든 출석 체크가 완료되었습니다. **");

            } else if (menu.equals("2")) {

                printFullReport(ids, names, status);

            } else if (menu.equals("3")) {

                System.out.println("\n--- 반별 출석 통계 ---");

                for (int i = 0; i < status.length; i++) {

                    double rate = getAttendanceRate(status[i]);

                    System.out.printf(
                            "%d반(%d명) 출석률: %.1f%%\n",
                            (i + 1),
                            status[i].length,
                            rate
                    );
                }

            } else {

                System.out.println("\n** 잘못된 선택입니다. 다시 선택해주세요. **");
            }
        }

        sc.close();
    }
}