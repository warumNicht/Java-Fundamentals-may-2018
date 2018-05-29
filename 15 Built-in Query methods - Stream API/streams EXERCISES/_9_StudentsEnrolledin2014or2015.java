import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _9_StudentsEnrolledin2014or2015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,String> students=new LinkedHashMap<>();

        while (true){
            String firstName=scanner.next();
            if("END".endsWith(firstName)){
                break;
            }
            students.put(firstName,scanner.nextLine().trim());
        }

        students.keySet().stream()
                .filter(key->key.endsWith("14")||key.endsWith("15"))
                .forEach(key-> System.out.println(students.get(key)));

    }
}
