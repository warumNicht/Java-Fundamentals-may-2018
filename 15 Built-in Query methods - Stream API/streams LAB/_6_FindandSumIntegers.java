import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class _6_FindandSumIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Optional<Integer> sumOfInt=Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(x->isNumber(x))
                .map(Integer::valueOf)
                .reduce((x,y)->x+y);
        if(sumOfInt.isPresent()){
            System.out.println(sumOfInt.get());
        }else{
            System.out.println("No match");
        }
    }
    private static boolean isNumber(String str){
        try {
            int n =Integer.parseInt(str);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
