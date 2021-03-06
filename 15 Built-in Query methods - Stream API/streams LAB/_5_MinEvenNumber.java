import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class _5_MinEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Optional<Double> min=Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(x->x.isEmpty()==false)
                .map(Double::valueOf)
                .filter(x->x%2==0)
                .min(Double::compare);
        if(min.isPresent()){
            System.out.printf("%.2f",min.get());
        }else{
            System.out.println("No match");
        }

    }
}
