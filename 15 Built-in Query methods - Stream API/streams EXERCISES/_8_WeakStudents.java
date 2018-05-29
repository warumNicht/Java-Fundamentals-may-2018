import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _8_WeakStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,List<Integer>> students=new LinkedHashMap<>();

        while (true){
            String firstName=scanner.next();
            if("END".endsWith(firstName)){
                break;
            }
            String name=firstName+" "+scanner.next();

            List<Integer>notes=Arrays.stream(scanner.nextLine().split("\\s+"))
                    .filter(x->x.equals("")==false)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            students.put(name,notes);
        }

        students.entrySet().stream()
                .filter(kv->{
                    int count=0;
                    for (int s : kv.getValue()) {
                        if(s<=3){
                            count++;
                        }
                    }
                    return count>=2;
                })
                .forEach(kv-> System.out.println(kv.getKey()));
    }
}
