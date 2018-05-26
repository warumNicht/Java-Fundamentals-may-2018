import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _11_PredicatePary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests= Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input=scanner.nextLine();

        while ("Party!".equals(input)==false){
            Consumer<List<String>> arrange=reorder(input);
            arrange.accept(guests);
            input=scanner.nextLine();
        }
        if(guests.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else{
            System.out.printf("%s are going to the party!",String.join(", ",guests));
        }

    }

    private static Consumer<List<String>> reorder(String input) {
        Predicate<String> isRemove=x->"Remove".equals(x);

        Predicate<String> startsWith=x->"StartsWith".equals(x);
        Predicate<String> endsWith=x->"EndsWith".equals(x);

        String[] tockens=input.split("\\s+");

        if(isRemove.test(tockens[0])){
            if(startsWith.test(tockens[1])){
                return list->list.removeIf(x->x.startsWith(tockens[2]));
            }else if(endsWith.test(tockens[1])){
                return list->list.removeIf(x->x.endsWith(tockens[2]));
            }else{
                return list->list.removeIf(x->x.length()==Integer.parseInt(tockens[2]));
            }
        }else {
            if(startsWith.test(tockens[1])){
                return list->{
                    List<String> toDouble=new ArrayList<>();
                    for (String s : list) {
                        if(s.startsWith(tockens[2])){
                            toDouble.add(s);
                        }
                    }
                    for (String s : toDouble) {
                        int index=list.indexOf(s);
                        list.add(index+1,s);
                    }
                };
            }else if(endsWith.test(tockens[1])){
                return list->{
                    List<String> toDouble=new ArrayList<>();
                    for (String s : list) {
                        if(s.endsWith(tockens[2])){
                            toDouble.add(s);
                        }
                    }
                    for (String s : toDouble) {
                        int index=list.indexOf(s);
                        list.add(index+1,s);
                    }
                };
            }else{
                return list->{
                    List<String> toDouble=new ArrayList<>();
                    for (String s : list) {
                        if(s.length()==Integer.parseInt(tockens[2])){
                            toDouble.add(s);
                        }
                    }
                    for (String s : toDouble) {
                        int index=list.indexOf(s);
                        list.add(index+1,s);
                    }
                };
            }
        }

    }
}
