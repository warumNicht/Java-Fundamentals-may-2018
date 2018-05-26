import java.util.Scanner;
import java.util.function.Predicate;

public class _4_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowerBound=scanner.nextInt();
        int upperBound=scanner.nextInt();
        scanner.nextLine();
        String command=scanner.next();

        Predicate<Integer> evenOrOdd=createEvenOddPredic(command);

        printNumbers(lowerBound,upperBound,evenOrOdd);
    }

    private static void printNumbers(int lowerBound, int upperBound, Predicate<Integer> evenOrOdd) {
        for (int i = lowerBound; i <=upperBound ; i++) {
            if(evenOrOdd.test(i)){
                System.out.print(i+" ");
            }

        }
    }

    private static Predicate<Integer> createEvenOddPredic(String command) {
        switch (command){
            case "odd":
                return x->x%2!=0;
            case "even":
                return x->x%2==0;
                default:
                    return null;
        }
    }
}
