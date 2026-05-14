public class CGV {
    public static void main(String[]args){
        int[][] seats = {
            {1, 0, 1},
            {0, 1, 0},
            {1, 1, 0}
        };

        System.out.println("--- 영화관 좌석 현황 ---");

        for (int row = 0; row < seats.length; row++){
            char rowName = (char)('A' + row);
            System.out.println(rowName + "열: ");
            for(int col = 0; col < seats[row].length; col++){
                if (seats[row][col] == 1){
                    System.out.println("[X] ");
                }else {
                    System.out.println("[] ");
                }
            }
            System.out.println();
        }
    }    
}
