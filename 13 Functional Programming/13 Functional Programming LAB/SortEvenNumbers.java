import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums=Arrays
                .stream(scanner.nextLine().split("\\s*,\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        nums.removeIf(x->x%2!=0);

        System.out.println(nums.stream()
                .map(number -> String.valueOf(number))
                .collect(Collectors.joining(", ")));

        nums.sort((x,y)->x.compareTo(y));

        System.out.println(nums.stream()
                .map(number -> String.valueOf(number))
                .collect(Collectors.joining(", ")));

    }
}
