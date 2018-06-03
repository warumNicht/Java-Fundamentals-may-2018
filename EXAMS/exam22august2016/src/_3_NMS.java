import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _3_NMS {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder text=new StringBuilder();
        List<String> words=new ArrayList<>();

        String input=reader.readLine();

        while ("---NMS SEND---".equals(input)==false){
            text.append(input);

            input=reader.readLine();
        }
        int count=1;
        if(text.length()==1){
            System.out.println(text.charAt(0));
        }

        for(int i=1; i<text.length(); i++){
            char a=Character.toLowerCase(text.charAt(i-1));
            char b= Character.toLowerCase(text.charAt(i));
            if(a<=b){
                count++;
                if(i==text.length()-1){
                    String currWord=text.substring(i-count+1,i+1);
                    words.add(currWord);
                }
            }else {
                String currWord=text.substring(i-count,i);
                words.add(currWord);
                if(i==text.length()-1){
                    String lastChar=text.substring(text.length()-1,text.length());
                    words.add(lastChar);
                }
                count=1;
            }
        }

        String delimiter=reader.readLine();

        System.out.println(String.join(delimiter,words));



    }
}