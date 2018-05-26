import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10_ListofPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());

        int[] nums=Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        BiPredicate<Integer,int[]> isDividible= (x,arr)->{
            boolean res=true;
            for (Integer element : arr) {
                if(x%element!=0){
                    res= false;
                    break;
                }
            }
            return res;
        };

        for(int i=1; i<=n; i++){
            if(isDividible.test(i,nums)){
                System.out.print(i+" ");
            }
        }



    }
}
