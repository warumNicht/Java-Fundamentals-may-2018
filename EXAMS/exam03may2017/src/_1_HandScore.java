import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1_HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] cards=reader.readLine().split("\\s+");
        int curCount=1;
        int curStart=0;
        int curSum=0;
        int sum=0;
        for (int i = 0; i <cards.length-1 ; i++) {

            if(cards[i].charAt(cards[i].length()-1)==cards[i+1].charAt(cards[i+1].length()-1)){
                if(curCount==1){
                    curStart=i;
                }
                curCount++;
            }else {
                if(curCount>1){

                    for (int j = curStart; j <curStart+curCount ; j++) {
                        curSum+=calculateSum(cards[j]);
                    }
                    curSum*=curCount;
                    sum+=curSum;

                    curCount=1;
                    curSum=0;
                }else {
                    sum+=calculateSum(cards[i]);
                }
            }
        }

        if(curCount>1){
            for (int j = curStart; j <curStart+curCount ; j++) {
                curSum+=calculateSum(cards[j]);
            }
            curSum*=curCount;
            sum+=curSum;
        }else {
            sum+=calculateSum(cards[cards.length-1]);
        }
        System.out.println(sum);


    }

    private static int calculateSum(String card) {

        int res=0;

        if(card.length()==3){
            res=10;
        }else {
            switch (card.charAt(0)){
                case '2':
                    res=2;
                    break;
                case '3':
                    res=3;
                    break;
                case '4':
                    res=4;
                    break;
                case '5':
                    res=5;
                    break;
                case '6':
                    res=6;
                    break;
                case '7':
                    res=7;
                    break;
                case '8':
                    res=8;
                    break;
                case '9':
                    res=9;
                    break;
                case 'J':
                    res=12;
                    break;
                case 'Q':
                    res=13;
                    break;
                case 'K':
                    res=14;
                    break;
                case 'A':
                    res=15;
                    break;
            }
        }
        return res;
    }
}