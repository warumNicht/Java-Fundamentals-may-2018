import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _4_Ranking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String,String> contParoles=new LinkedHashMap<>();

        String input=reader.readLine();
        String regex1="^([^:=>]+):([^:=>]+)$";
        Pattern pat1=Pattern.compile(regex1);

        while ("end of contests".equals(input)==false){
            String[] tockens=input.split(":");
            Matcher mat1=pat1.matcher(input);

            if(mat1.find()){
                String contest=mat1.group(1);
                String password=mat1.group(2);

                contParoles.put(contest,password);
            }
            input=reader.readLine();
        }

        input=reader.readLine();

        LinkedHashMap<String,LinkedHashMap<String,Integer>> users=new LinkedHashMap<>();

        while ("end of submissions".equals(input)==false){

            String[] tokens=input.split("=>");
            String curCont=tokens[0];
            String curPassword=tokens[1];

            if(contParoles.containsKey(curCont)&&contParoles.get(curCont).equals(curPassword)){

                String curUser=tokens[2];
                int curPoints=Integer.parseInt(tokens[3]);

                if(users.containsKey(curUser)==false){
                    users.put(curUser,new LinkedHashMap<>());
                }
                if(users.get(curUser).containsKey(curCont)==false){
                    users.get(curUser).put(curCont,curPoints);
                }else {
                    int curUserPoints=users.get(curUser).get(curCont);
                    if(curUserPoints<curPoints){
                        users.get(curUser).put(curCont,curPoints);
                    }
                }
            }
            input=reader.readLine();
        }

        List<Map.Entry> thebest= users.entrySet().stream()
                .sorted((x,y)->{
                    int xPoints=x.getValue().values().stream()
                            .mapToInt(Integer::intValue)
                            .sum();
                    int yPoints=y.getValue().values().stream()
                            .mapToInt(Integer::intValue)
                            .sum();
                    return Integer.compare(yPoints,xPoints);
                })
                .limit(1)
                .collect(Collectors.toList());

        for (Map.Entry entry : thebest) {
            int bestPoints=    users.get(entry.getKey()).values().stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            System.out.printf("Best candidate is %s with total %d points.%n",entry.getKey(),bestPoints);
        }

        System.out.println("Ranking:");

        users.entrySet().stream()
                .sorted((x,y)->{
                    return x.getKey().compareTo(y.getKey());
                })
                .forEach(kv->{
                    System.out.println(kv.getKey());
                    users.get(kv.getKey()).entrySet().stream()
                            .sorted((a,b)->{
                                return Integer.compare(b.getValue(),a.getValue());
                            })
                            .forEach(st->{
                                System.out.printf("#  %s -> %d%n",st.getKey(),st.getValue());

                            });
                });

    }
}