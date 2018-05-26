import java.util.Scanner;
import java.util.function.Consumer;

public class _2_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        Consumer<String[]> knightPrint=knight->{
            for (String s : knight) {
                System.out.println("Sir "+s);
            }
        };
        knightPrint.accept(names);
    }
}
