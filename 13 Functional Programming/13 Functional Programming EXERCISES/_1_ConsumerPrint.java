import java.util.Scanner;
import java.util.function.Consumer;

public class _1_ConsumerPrint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");

        Consumer<String[]> print = imena -> {
            for (String name : imena) {
                System.out.println(name);
            }
        };
        print.accept(names);
    }
}
