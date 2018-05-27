import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;

public class _4_AverageofDoubles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements=scanner.nextLine().split("\\s+");

        OptionalDouble average= Arrays.stream(elements)
                .filter(x->x.isEmpty()==false)
                .mapToDouble(Double::valueOf)
                .average();
        if(average.isPresent()){
            System.out.printf("%.2f", average.getAsDouble());
        }else {
            System.out.println("No match");
        }
    }
}
