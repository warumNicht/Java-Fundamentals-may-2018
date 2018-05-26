import java.util.*;
import java.util.function.Function;

public class _9_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums=Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<int[],int[]> customComparator= arr->{
            int[] res=new int[arr.length];
            List<Integer> odds=new ArrayList<>();
            List<Integer> evens=new ArrayList<>();

            for (int i : arr) {
                if(i%2==0){
                    evens.add(i);
                }else {
                    odds.add(i);
                }
            }
            Collections.sort(evens);
            Collections.sort(odds);
            for(int i=0; i<evens.size(); i++){
                res[i]=evens.get(i);
            }
            int j=0;
            for(int i=evens.size(); i<arr.length; i++){
                res[i]=odds.get(j);
                j++;
            }
            return res;
        };

        int[] sorted=customComparator.apply(nums);

        for (int i : sorted) {
            System.out.print(i+" ");
        }
    }
}
