import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _3_Genome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex="([a-z!@#$?]+)=(\\d+)--(\\d+)<<([a-z]+)";
        Pattern pat=Pattern.compile(regex);

        String input=reader.readLine();

        LinkedHashMap<String,Integer> animals=new LinkedHashMap<>();

        while ("Stop!".equals(input)==false){

            Matcher mat=pat.matcher(input);

            if(mat.find()){
                String name=mat.group(1);
                int lentName=Integer.parseInt(mat.group(2));
                int countGen=Integer.parseInt(mat.group(3));
                String animal=mat.group(4);

                name=name.replaceAll("[!@#$?]","");
                if(name.length()==lentName){

                    if(animals.containsKey(animal)==false){
                        animals.put(animal,countGen);
                    }else {
                        int existingGen=animals.get(animal);
                        animals.put(animal,existingGen+countGen);
                    }
                }

            }
            input=reader.readLine();
        }

        StringBuilder res=new StringBuilder();

        animals.entrySet().stream()
                .sorted((x,y)->{
                    return Integer.compare(y.getValue(),x.getValue());
                })
                .forEach(kv->{
                    res.append(String.format("%s has genome size of %d%n",kv.getKey(),kv.getValue()));

                });

        System.out.println(res);

    }
}