import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _3_V_logger {
    public static final int A = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String,TreeSet<String>> vlogers=new LinkedHashMap<>();
        LinkedHashMap<String,TreeSet<String>> folgende=new LinkedHashMap<>();

        while (true){
            String input=reader.readLine();
            if("Statistics".equals(input)){
                break;
            }
            String[] tokens=input.split("\\s+");
            String firstName=tokens[0];

            if(tokens[1].equals("joined")){
                vlogers.putIfAbsent(firstName,new TreeSet<>());
                folgende.putIfAbsent(firstName,new TreeSet<>());
            }else{
                String secName=tokens[2];
                if(vlogers.containsKey(firstName)&&vlogers.containsKey(secName)){

                    if(firstName.equals(secName)==false){

                            vlogers.get(secName).add(firstName);
                            folgende.get(firstName).add(secName);
                    }
                }
            }
        }
        System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n",vlogers.size());

        int count=0;
        List<Map.Entry>fin =vlogers.entrySet().stream()
                .sorted((x,y)->{
                    int xFow=vlogers.get(x.getKey()).size();
                    int yFow=vlogers.get(y.getKey()).size();

                    int res=Integer.compare(yFow,xFow);
                    if(res==0){
                        int xIsFolgend=folgende.get(x.getKey()).size();
                        int yIsFolgend=folgende.get(y.getKey()).size();

                        return Integer.compare(xIsFolgend,yIsFolgend);
                    }
                    return res;
                })
                .collect(Collectors.toList());

        for (Map.Entry entry : fin) {
            count++;
            System.out.printf("%d. %s : %d followers, %d following%n",count,entry.getKey(),vlogers.get(entry.getKey()).size(),
                    folgende.get(entry.getKey()).size());
            if(count==1){
                for (String s : vlogers.get(entry.getKey())) {
                    System.out.printf("*  %s%n",s);
                }
            }
        }
    }
}