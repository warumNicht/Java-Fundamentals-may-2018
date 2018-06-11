import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2_Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int snakeLen=1;
        int n=Integer.parseInt(reader.readLine());
        String[] com=reader.readLine().split(", ");
        int foodCount=0;

        int startRow=0;
        int startCol=0;

        char[][] matrix=new char[n][n];

        for(int i=0; i<n; i++){
            String[] tokens=reader.readLine().split(" ");
            for (int j = 0; j <n ; j++) {
                char curChar=tokens[j].charAt(0);
                if(curChar=='s'){
                    startRow=i;
                    startCol=j;
                }else if(curChar=='f'){
                    foodCount++;
                }
                matrix[i][j]=curChar;
            }
        }
        boolean isKilled=false;
        boolean win=false;

        for (String order : com) {

            switch (order){
                case "left":{
                    int nextCol=startCol-1;
                    if(nextCol<0){
                        startCol=n-1;
                    }else {
                        startCol=nextCol;
                    }

                }break;
                case "right":{
                    int precedCol=startCol+1;
                    if(precedCol>n-1){
                        startCol=0;
                    }else {
                        startCol=precedCol;
                    }
                }break;
                case "up":{

                    int nextRow=startRow-1;
                    if(nextRow<0){
                        startRow=n-1;
                    }else {
                        startRow=nextRow;
                    }

                }break;
                case "down":{
                    int nextRow=startRow+1;
                    if(nextRow>n-1){
                        startRow=0;
                    }else {
                        startRow=nextRow;
                    }

                }break;
            }
            if(matrix[startRow][startCol]=='f'){
                foodCount--;
                snakeLen++;

                if(foodCount==0){
                    win=true;
                    break;
                }

            }else if(matrix[startRow][startCol]=='e'){
                isKilled=true;
            }
            if(isKilled||win){
                break;
            }
        }

        if(isKilled){
            System.out.println("You lose! Killed by an enemy!");
        }else if(win){
            System.out.printf("You win! Final snake length is %d",snakeLen);
        }else {
            System.out.printf("You lose! There is still %d food to be eaten.",foodCount);
        }

    }
}