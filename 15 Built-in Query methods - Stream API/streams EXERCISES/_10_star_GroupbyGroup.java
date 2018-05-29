import java.util.*;
import java.util.stream.Collectors;

public class _10_star_GroupbyGroup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students=new ArrayList<>();

        while (true){
            String firstName=scanner.next();
            if("END".endsWith(firstName)){
                break;
            }
            firstName+=" "+scanner.next();
            int gr=scanner.nextInt();

            students.add(new Student(firstName,gr));

            scanner.nextLine();
        }

        Map<Integer,List<Student>> groupedSt=students.stream()
                .collect(Collectors.groupingBy(Student::getGroup));

        groupedSt.keySet().stream()
                .sorted()
                .forEach(key->{
                    System.out.print(key+" - ");
                    List<String> names=new ArrayList<>();

                    groupedSt.get(key).stream().forEach(x->names.add(x.getName()));
                    System.out.println(String.join(", ",names));
                });

    }
}

class Student{
    private String name;
    private  int group;

    public Student(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public int getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }
}
