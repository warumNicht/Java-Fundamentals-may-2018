import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _1_Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Scanner scanner = new Scanner(System.in);

        int n=scanner.nextInt();
        int m=scanner.nextInt();
        scanner.nextLine();

        int[][] plate=new int[n][m];

        String input=scanner.nextLine();
        while ("Here We Go".equals(input)==false){
            String[] tokens=input.split(" ");
            int x1=Integer.parseInt(tokens[0]);
            int y1=Integer.parseInt(tokens[1]);
            int x2=Integer.parseInt(tokens[2]);
            int y2=Integer.parseInt(tokens[3]);

            for (int i = x1; i <=x2 ; i++) {
                for (int j = y1; j <=y2 ; j++) {
                    plate[i][j]++;
                }
            }
            input=scanner.nextLine();
        }

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                System.out.print(plate[i][j]+" ");
            }
            System.out.println();
        }
    }
}