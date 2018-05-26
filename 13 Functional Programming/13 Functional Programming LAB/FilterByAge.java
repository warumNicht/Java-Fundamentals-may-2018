import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String,Integer> users=new LinkedHashMap<>();

        for (int i = 0; i <n ; i++) {
            //String[]tockens=scanner.nextLine().split(",\\s+");
            String name=scanner.next();
            users.put(name.substring(0,name.length()-1),scanner.nextInt());
        }
        scanner.nextLine();
        String condition=scanner.nextLine();
        int age=Integer.parseInt(scanner.nextLine());
        String format=scanner.nextLine();

        Predicate<Integer> tester= createTester(condition,age);

        Consumer<Map.Entry<String,Integer>> printer= createPrinter(format);

        printFilteredStudents(users,tester,printer);

    }

    private static void printFilteredStudents(LinkedHashMap<String,Integer> users, Predicate<Integer> tester, Consumer<Map.Entry<String,Integer>> printer) {
        for (Map.Entry<String,Integer> person : users.entrySet()) {
            if(tester.test(users.get(person.getKey()))){
                printer.accept(person);
            }

        }
    }

    private static Consumer<Map.Entry<String,Integer>> createPrinter(String format) {

        if("name age".equals(format)){
            return person-> System.out.printf("%s - %d%n", person.getKey(),person.getValue());
        }else if("name".equals(format)){
            return person-> System.out.println(person.getKey());
        }else {
            return person-> System.out.println(person.getValue());
        }
    }

    private static Predicate<Integer> createTester(String condition, int age) {

        if("younger".equals(condition)){
            return x->x<age;
        }else {
            return x->x>=age;
        }
    }
}
