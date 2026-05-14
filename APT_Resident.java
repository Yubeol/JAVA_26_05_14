import java.util.Scanner;
import java.util.Random;

public class APT_Resident {
    public static void main(String[] args){
        int [][] apartment = {
            {2, 3, 1},
            {4, 1, 2}
        };
        for (int floor = 0; floor < apartment.length; floor++){
            for (int room = 0; room < apartment[floor].length; room++){
                System.out.print((floor + 1) + "층" + (room + 1) + "호 거주자: ");
                System.out.println(apartment[floor][room] + "명");
            }
            System.out.println("--------------------");
        }
    }
}
