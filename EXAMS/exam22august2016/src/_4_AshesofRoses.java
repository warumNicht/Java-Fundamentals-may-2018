import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _4_AshesofRoses {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex="^Grow <([A-Z][a-z]+)> <([A-Za-z0-9]+)> (\\d+)$";
        Pattern pattern=Pattern.compile(regex);

        String input=reader.readLine();

        LinkedHashMap<String,LinkedHashMap<String,Long>> regions=new LinkedHashMap<>();


        while ("Icarus, Ignite!".equals(input)==false){
            Matcher mat=pattern.matcher(input);
            if(mat.find()){
                String curRegion=mat.group(1);
                String curCol=mat.group(2);
                Long curAmoutRoses=Long.parseLong(mat.group(3));


                if(regions.containsKey(curRegion)==false){
                    regions.put(curRegion,new LinkedHashMap<>());
                    regions.get(curRegion).put(curCol,curAmoutRoses);
                }else {
                    if(regions.get(curRegion).containsKey(curCol)==false){
                        regions.get(curRegion).put(curCol,curAmoutRoses);
                    }else {
                        long existingRoses=regions.get(curRegion).get(curCol);
                        regions.get(curRegion).put(curCol,existingRoses+curAmoutRoses);
                    }
                }
            }
            input=reader.readLine();
        }

        regions.entrySet().stream()
                .sorted((x,y)->{
                    long xRoses=x.getValue().values().stream()
                            .mapToLong(Long::longValue)
                            .sum();
                    long yRoses=y.getValue().values().stream()
                            .mapToLong(Long::longValue)
                            .sum();
                    int res=Long.compare(yRoses,xRoses);
                    if(res==0){
                        return x.getKey().compareTo(y.getKey());
                    }
                    return res;
                })
                .forEach(kv->{
                    System.out.println(kv.getKey());
                    kv.getValue().entrySet().stream()
                            .sorted((a,b)->{
                                int sort=Long.compare(a.getValue(),b.getValue());
                                if(sort==0){
                                    return a.getKey().compareTo(b.getKey());
                                }
                                return sort;
                            })
                            .forEach(x->{
                                System.out.printf("*--%s | %d%n", x.getKey(),x.getValue());
                            });
                });


    }
}