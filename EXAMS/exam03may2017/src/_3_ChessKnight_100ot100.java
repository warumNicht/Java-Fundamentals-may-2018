import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _3_ChessKnight_100ot100 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[][] deque=new char[8][8];

        for(int i=0; i<8; i++){
            String row=reader.readLine();
            row=row.replaceAll("\\|","");

            deque[i]=row.toCharArray();
        }
        List<Character> vzeti=new ArrayList<>();
        int invalidMoves=0;
        int outMoves=0;

        String com=reader.readLine();

        int lastRow=com.charAt(0)-48;
        int lastCol=com.charAt(1)-48;

        int curRow=0;
        int curCol=0;
        com=reader.readLine();

        while ("END".equals(com)==false){
            String[] tokens=com.split("\\s+->\\s+");

            curRow=tokens[1].charAt(0)-48;
            curCol=tokens[1].charAt(1)-48;
            if(canMove(deque,lastRow,lastCol,curRow,curCol)){

                if(isValidPos(tokens[1])){
                    if(deque[curRow][curCol]!=' '){
                        vzeti.add(deque[curRow][curCol]);
                        deque[curRow][curCol]=' ';
                    }
                    lastRow=curRow;
                    lastCol=curCol;
                }else {
                    outMoves++;
                }
            }else {
                invalidMoves++;
            }
            com=reader.readLine();
        }
        System.out.printf("Pieces take: %s%n",vzeti.toString().replaceAll("\\[|]",""));
        System.out.printf("Invalid moves: %d%n",invalidMoves);
        System.out.printf("Board out moves: %d",outMoves);
    }

    private static boolean canMove(char[][] deque, int lastRow, int lastCol, int curRow, int curCol) {

        if((Math.abs(curRow-lastRow)==2&&Math.abs(curCol-lastCol)==1) ||
                (Math.abs(curRow-lastRow)==1&&Math.abs(curCol-lastCol)==2)){
            return  true;
        }
        return false;
    }

    private static boolean isValidPos(String token) {
        if(token.length()!=2){
            return  false;
        }else {
            if(token.charAt(0)>'7'||token.charAt(0)<'0'||
                    token.charAt(1)>'7'||token.charAt(1)<'0'){
                return false;
            }
        }
        return true;
    }


}