import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class _3_DHARMAInitiative {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String,String> stationsPurposes=new LinkedHashMap<>();

        stationsPurposes.put("Hydra","Zoological Research.");
        stationsPurposes.put("Arrow","Development of defensive strategies, and Intelligence gathering.");
        stationsPurposes.put("Flame","Communication.");
        stationsPurposes.put("Pearl","Psychological Research and/or Observation.");
        stationsPurposes.put("Orchid","Space-time manipulation research, disguised as a Botanical station.");

        LinkedHashMap<String,LinkedHashMap<Integer,String>> faculties=new LinkedHashMap<>();

        faculties.put("Hydra", new LinkedHashMap<>());
        faculties.put("Arrow", new LinkedHashMap<>());
        faculties.put("Flame", new LinkedHashMap<>());
        faculties.put("Pearl", new LinkedHashMap<>());
        faculties.put("Orchid", new LinkedHashMap<>());

        String input=scanner.nextLine();

        while ("Recruit".equals(input)==false){
            String[] tokens=input.split("\\s*:\\s*");

            String name=tokens[0];
            int facNum=Integer.parseInt(tokens[1]);
            String station=tokens[2];

            if(stationsPurposes.containsKey(station)){

               if( faculties.get(station).containsKey(facNum)==false){
                   faculties.get(station).put(facNum,name);
               }
            }
            input=scanner.nextLine();
        }

        input=scanner.nextLine();

        if("DHARMA Initiative".equals(input)){
            faculties.entrySet().stream()
                    .sorted((x,y)->{
                        int xlen=x.getValue().size();
                        int ylen=y.getValue().size();
                        int res=compare(xlen,ylen); // or int res=Integer.compare(ylen,xlen);

                       if(res==0){
                           return x.getKey().compareTo(y.getKey());
                       }else {
                           return res;
                       }
                    })
                    .forEach(kv->{
                        System.out.printf("The %s has %d DHARMA recruits in it.%n",kv.getKey(),kv.getValue().size());
                    });
        }else{
            if(stationsPurposes.containsKey(input)){

                if(faculties.get(input).isEmpty()){
                    System.out.printf("The %s station: %s%n",input,stationsPurposes.get(input));
                    System.out.println("No recruits.");
                }else{
                    System.out.printf("The %s station: %s%n",input,stationsPurposes.get(input));
                    String station=input;
                    faculties.get(station).keySet()
                            .stream()
                            .sorted(Comparator.reverseOrder())
                            .forEach(x->{

                                System.out.printf("###%s - %d%n",faculties.get(station).get(x),x);
                            });
                }

            }else{
                System.out.println("DHARMA Initiative does not have such a station!");
            }
        }

    }
    public static int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
