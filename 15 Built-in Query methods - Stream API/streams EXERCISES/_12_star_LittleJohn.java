import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12_star_LittleJohn {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String patBigArrow="(>>>----->>)|(>>----->)|(>----->)";

        Pattern bigPat=Pattern.compile(patBigArrow);


        int bigCount=0;
        int medCount=0;
        int smallCount=0;

        for(int i=0; i<4; i++){
            StringBuilder input=new StringBuilder(reader.readLine());
            Matcher big=bigPat.matcher(input);
            while (big.find()){

                if(big.group(1)!=null){
                    bigCount++;
                }
                if(big.group(2)!=null){
                    medCount++;
                }
                if (big.group(3)!=null){
                    smallCount++;
                }
            }

        }
        String resNum=""+smallCount+medCount+bigCount;
        String orig=Long.toBinaryString(Long.parseLong(resNum));
        StringBuilder torev=new StringBuilder(orig);
        torev.reverse();
        String origRev=torev.toString();

        String fin=orig+origRev;

        StringBuilder bin=new StringBuilder(Integer.toBinaryString(Integer.parseInt(resNum)));
        StringBuilder res=new StringBuilder(bin);

        res.append(bin.reverse());

        int number=Integer.parseInt(fin,2);
        System.out.println(number);
    }
}
