import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _3_Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex="(\\,|\\_)([A-Za-z]+)([0-9])";
        Pattern pat=Pattern.compile(regex);

        LinkedHashMap<String,String> repeted=new LinkedHashMap<>();

        String input=reader.readLine();

        while ("Ascend".equals(input)==false){
            for (Map.Entry<String, String> kv : repeted.entrySet()) {

                input=input.replaceAll(kv.getKey(),kv.getValue());
            }
            StringBuilder curMes=new StringBuilder(input);
            Matcher mat=pat.matcher(curMes.toString());
            while (mat.find()){
                String cql=mat.group(0);
                String start=mat.group(1);
                StringBuilder mess=new StringBuilder(mat.group(2));
                int numFin=Integer.parseInt(mat.group(3));

                String decr=decrypt(start,mess,numFin);
                repeted.put(cql,decr);

                int indRepl=curMes.indexOf(cql);
                while (indRepl>=0){
                    curMes.replace(indRepl,indRepl+cql.length(),decr);
                    indRepl=curMes.indexOf(cql);
                }

            }
            System.out.println(curMes);
            input=reader.readLine();
        }

    }

    private static String decrypt(String start, StringBuilder mess, int numFin) {
        StringBuilder decripted=new StringBuilder();
        if(start.equals("_")){
            for (int i = 0; i <mess.length() ; i++) {
                char curr=(char)(mess.charAt(i)-(char)numFin);
                decripted.append(curr);
            }
        }else {
            for (int i = 0; i <mess.length() ; i++) {
                char curr=(char)(mess.charAt(i)+(char)numFin);
                decripted.append(curr);
            }
        }
        return decripted.toString();
    }
}