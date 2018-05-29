import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _13_star_OfficeStuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex="\\|(.+)\\s+-\\s+(\\d+)\\s+-\\s+(.+)\\|";
        Pattern pat=Pattern.compile(regex);

        LinkedHashMap<String,LinkedHashMap<String,Integer>> companies=new LinkedHashMap<>();


        int n=Integer.parseInt(scanner.nextLine());

        for(int i=0; i<n; i++){
            Matcher match=pat.matcher(scanner.nextLine());

            if(match.find()){
                String company=match.group(1);
                String product=match.group(3);
                int count=Integer.parseInt(match.group(2));

                if(companies.containsKey(company)==false){
                    LinkedHashMap<String,Integer> curProd=new LinkedHashMap<>();
                    curProd.put(product,count);
                    companies.put(company,curProd);
                }else{
                    if(companies.get(company).containsKey(product)==false){
                        companies.get(company).put(product,count);
                    }else {
                        companies.get(company).put(product,companies.get(company).get(product)+  count);
                    }
                }
            }
        }

        companies.entrySet().stream()
                .sorted((x,y)->x.getKey().compareTo(y.getKey()))
                .forEach(kv->{
                    System.out.print(kv.getKey()+": ");
                    List<String> curr=kv.getValue().entrySet().stream()
                            .map(x->{
                                return x.getKey()+"-"+x.getValue();
                            })
                            .collect(Collectors.toList());
                    System.out.println(String.join(", ",curr));
                });

    }
}
