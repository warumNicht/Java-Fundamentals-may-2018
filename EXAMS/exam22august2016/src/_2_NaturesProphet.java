import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2_NaturesProphet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] boundaries=reader.readLine().split("\\s+");
        int n=Integer.parseInt(boundaries[0]);
        int m=Integer.parseInt(boundaries[1]);

        short[][] garden=new short [n][m];

        String input=reader.readLine();

        while ("Bloom Bloom Plow".equals(input)==false){
            String[] tokens=input.split("\\s+");
            short row=Short.parseShort(tokens[0]);
            short col=Short.parseShort(tokens[1]);

            for (int i = 0; i <m ; i++) {
                garden[row][i]+=1;
            }
            for (int j = 0; j <n ; j++) {
                garden[j][col]+=1;
            }
            garden[row][col]-=1;

            input=reader.readLine();
        }
        StringBuilder res=new StringBuilder();
        for(int i=0; i<n; i++){
            for (int j = 0; j <m ; j++) {
                res.append(garden[i][j]+" ");

            }
            res.append("\n");
        }
        System.out.println(res);
    }
}