import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

public class _4_FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex="\\s+-\\s+|\\s+result\\s+";

        String input=reader.readLine();

        LinkedHashMap<String,TreeMap<String,List<String>>> teams=new LinkedHashMap<>();

        while ("Season End".equals(input)==false){

            String[] tockens=input.split(regex);
            String firstTeam=tockens[0];
            String secTeam=tockens[1];
            String result=tockens[2];

            if(teams.containsKey(firstTeam)==false){
                List<String> curr=new ArrayList<>();
                curr.add(result);
                TreeMap<String,List<String>> currMap=new TreeMap<>();
                currMap.put(secTeam,curr);
                teams.put(firstTeam,currMap);
            }else {
                if(teams.get(firstTeam).containsKey(secTeam)==false){
                    teams.get(firstTeam).put(secTeam,new ArrayList<>());
                }
                teams.get(firstTeam).get(secTeam).add(result);
            }

            StringBuilder toReverse=new StringBuilder(result);
            toReverse.reverse();

            if(teams.containsKey(secTeam)==false){
                List<String> currList=new ArrayList<>();
                currList.add(toReverse.toString());
                TreeMap<String,List<String>> currMap=new TreeMap<>();
                currMap.put(firstTeam,currList);
                teams.put(secTeam,currMap);
            }else {
                if(teams.get(secTeam).containsKey(firstTeam)==false){
                    teams.get(secTeam).put(firstTeam,new ArrayList<>());
                }
                teams.get(secTeam).get(firstTeam).add(toReverse.toString());
            }
            input=reader.readLine();
        }
        String[] listToPrint=reader.readLine().split(",\\s+");

        for (String s : listToPrint) {

            if(teams.containsKey(s)){
                teams.get(s).entrySet().stream()
                        .forEach(kv->{
                            kv.getValue().stream()
                                    .forEach(x->{
                                        System.out.printf("%s - %s -> %s%n",s,kv.getKey(),x);
                                    });

                        });
            }

        }
    }
}