import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _5_AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums=Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Consumer<int[]> add=arr->{
           for(int i=0; i<arr.length; i++){
                arr[i]+=1;
           }
        };
        Consumer<int[]> multiply=arr->{
            for(int i=0; i<arr.length; i++){
                arr[i]*=2;
            }
        };
        Consumer<int[]> substract=arr->{
            for(int i=0; i<arr.length; i++){
                arr[i]-=1;
            }
        };
        Consumer<int[]> print=arr->{
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
        };

        String input=scanner.nextLine();
        while ("end".equals(input)==false){

            switch (input){
                case"add": add.accept(nums);
                break;
                case "subtract": substract.accept(nums);
                break;
                case "multiply": multiply.accept(nums);
                break;
                case "print": print.accept(nums);
                break;
            }
            input=scanner.nextLine();
        }

    }

}
