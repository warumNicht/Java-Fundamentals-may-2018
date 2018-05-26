import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _8_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums=Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[],Integer> findTheSmallestElemIndex=arr->{
            int cur=arr[0];
            int index=0;
            for(int i=1; i<arr.length; i++){
                if(arr[i]<=cur){
                    cur=arr[i];
                    index=i;
                }
            }

            return index;
        };

        System.out.println(findTheSmallestElemIndex.apply(nums));


    }
}
