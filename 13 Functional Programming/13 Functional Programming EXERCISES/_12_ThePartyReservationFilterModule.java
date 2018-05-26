import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _12_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests=Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input=scanner.nextLine();
        List<String[]> filters=new ArrayList<>();

        while ("Print".equals(input)==false){
            String[] tockens=input.split(";");
            String[] curFilter={tockens[1],tockens[2]};
            if(input.startsWith("Add")){
                filters.add(curFilter);
            }else {
                filters.removeIf(x->x[0].equals(tockens[1])&&x[1].equals(tockens[2]));
            }
            input=scanner.nextLine();
        }

        for (String[] filter : filters) {
            Consumer<List<String>> filtering=filterByListOfFilters(filter);
            filtering.accept(guests);
        }
        System.out.println(String.join(" ",guests));
    }

    private static Consumer<List<String>> filterByListOfFilters(String[] filter) {
        switch (filter[0]){
            case "Starts with":
                return  list->list.removeIf(x->x.startsWith(filter[1]));
            case "Ends with":
                return  list->list.removeIf(x->x.endsWith(filter[1]));
            case "Length":
                return list->list.removeIf(x->x.length()==Integer.parseInt(filter[1]));
            case "Contains":
                return  list->list.removeIf(x->x.contains(filter[1]));
            default:
                return null;
        }
    }
}
