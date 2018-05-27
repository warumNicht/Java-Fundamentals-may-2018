import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _7_star_MapDistricts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String,List<Integer>> cities=new HashMap<>();
        String[] tokens=scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            String[] argums=token.split(":");
            String city=argums[0];
            int districtPopulation=Integer.valueOf(argums[1]);

            cities.putIfAbsent(city, new ArrayList<>());
            cities.get(city).add(districtPopulation);
        }

        int bound=Integer.valueOf(scanner.nextLine());

        cities.entrySet().stream()
                .filter(getFilterByPopulationPredicate(bound))
                .sorted(getSortedByDescendingPopulationComparator())
                .forEach(getPrintMapEntryConsumer());


    }

    private static Consumer<? super Map.Entry<String,List<Integer>>> getPrintMapEntryConsumer() {
        return  kv->{
            System.out.print(kv.getKey()+": ");
            kv.getValue().stream()
                    .sorted((a,b)->b.compareTo(a))
                    .limit(5)
                    .forEach(val-> System.out.print(val+" "));
            System.out.println();
        };
    }

    private static Comparator<? super Map.Entry<String,List<Integer>>> getSortedByDescendingPopulationComparator() {
        return (kv1,kv2)->Integer.compare(
                kv2.getValue().stream().mapToInt(Integer::intValue).sum(),
                kv1.getValue().stream().mapToInt(Integer::intValue).sum()
        );
    }

    private static Predicate<? super Map.Entry<String,List<Integer>>> getFilterByPopulationPredicate(int bound) {
        return kv->kv.getValue().stream()
                .mapToInt(Integer::intValue)
                .sum()>=bound;
    }
}
