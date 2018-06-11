import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _4_Highscore {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Long> playerScores=new LinkedHashMap<>();

        LinkedHashMap<String, List<String[]>> playersGames=new LinkedHashMap<>();

        String input=reader.readLine();

        while ("osu!".equals(input)==false){
            String[]tokens=input.split("<->|\\s");

            Long firstScore=Long.parseLong(tokens[0]);
            String firstname=tokens[1];
            Long secScore=Long.parseLong(tokens[3]);
            String secname=tokens[2];

            if(playerScores.containsKey(firstname)==false){
                playerScores.put(firstname,0L);
                playersGames.put(firstname,new ArrayList<>());
            }
            if(playerScores.containsKey(secname)==false){
                playerScores.put(secname,0L);
                playersGames.put(secname,new ArrayList<>());
            }

            long dif=firstScore-secScore;
            long curFirst=playerScores.get(firstname);
            long curSec=playerScores.get(secname);

            if(dif>0){

                playerScores.put(firstname,curFirst+dif);
                playerScores.put(secname,curSec-dif);

                String[] gameFirst={secname,""+dif};
                String[] gameSec={firstname,"-"+Math.abs(dif)};

                playersGames.get(firstname).add(gameFirst);
                playersGames.get(secname).add(gameSec);

            }else if(dif<0){
                playerScores.put(firstname,curFirst+dif);
                playerScores.put(secname,curSec-dif);

                String[] gameFirst={secname,"-"+Math.abs(dif)};
                String[] gameSec={firstname,""+-dif};

                playersGames.get(firstname).add(gameFirst);
                playersGames.get(secname).add(gameSec);
            }else {
                String[] gameFirst={secname,"0"};
                String[] gameSec={firstname,"0"};

                playersGames.get(firstname).add(gameFirst);
                playersGames.get(secname).add(gameSec);

            }

            input=reader.readLine();
        }

        playerScores.entrySet().stream()
                .sorted((x,y)->{
                    return Long.compare(y.getValue(),x.getValue());
                })
                .forEach(kv->{
                    System.out.printf("%s - (%d)%n",kv.getKey(),kv.getValue());

                    playersGames.get(kv.getKey()).stream()
                            .forEach(s->{
                                System.out.printf("*   %s <-> %s%n",s[0],s[1]);
                            });
                });

    }
}