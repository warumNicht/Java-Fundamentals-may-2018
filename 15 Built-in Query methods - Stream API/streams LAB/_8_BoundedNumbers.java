import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _8_BoundedNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> bounds=Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        List<Integer> numbers=Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .filter(x->Collections.min(bounds)<=x&&x<=Collections.max(bounds))
                .collect(Collectors.toList());

        numbers.stream()
                .forEach(x-> System.out.print(x+" "));



    }
}
