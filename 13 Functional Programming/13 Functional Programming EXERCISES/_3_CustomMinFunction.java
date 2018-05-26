import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _3_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums=Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[],Integer> min=x->findMin(x);
        System.out.println(min.apply(nums));
    }

    private static Integer findMin(int[] x) {
        int res=Integer.MAX_VALUE;
        for (int i : x) {
            if(i<res){
                res=i;
            }
        }
        return res;
    }

}
