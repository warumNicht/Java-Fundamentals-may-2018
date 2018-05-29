import java.util.*;
import java.util.stream.Collectors;

public class _11_star_StudentsJoinedtoSpecialties {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Speciality> specialities=new ArrayList<>();
        List<Stud>students=new ArrayList<>();

        while (true){
            String name=scanner.next();
            if("Students:".equals(name)){
                break;
            }
            name+=" "+scanner.next();
            String num=scanner.next();
            scanner.nextLine();

            specialities.add(new Speciality(name,num));
        }

        while (true){
            String num=scanner.next();

            if("END".equals(num)){
                break;
            }
            String name=scanner.next();
            name+=" "+scanner.next();

            scanner.nextLine();
            students.add(new Stud(name,num));
        }

        Map<String,List<Speciality>> groupedSpec=specialities.stream()
                .collect(Collectors.groupingBy(x->x.getNumber()));

        students.stream()
                .filter(x->groupedSpec.keySet().contains(x.getNumber()))
                .sorted((x,y)->x.getName().compareTo(y.getName()))
                .forEach(st->{
                    groupedSpec.get(st.getNumber()).stream()
                            .forEach(spec->{
                                System.out.println(st.getName()+" "+st.getNumber()+" "+spec.getName());
                            });
                });

    }
}

class Speciality{
    private String name;
    private String number;

    public Speciality(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}

class Stud{
    private String name;
    private String number;

    public Stud(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}