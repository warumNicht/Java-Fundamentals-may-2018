import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] prices=Arrays.stream(scanner.nextLine().split("\\s*,\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Function<Double, Double> addVat=x->x*1.2;

        System.out.println("Prices with VAT:");

        for (double price : prices) {
            System.out.println(String.format("%.2f", addVat.apply(price)).replace('.',','));
        }

    }
}
