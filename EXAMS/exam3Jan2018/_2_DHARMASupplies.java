import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _2_DHARMASupplies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String reg="\\[.*?]";
        Pattern patCrates=Pattern.compile(reg);

        List<String> allCrates=new ArrayList<String>();
        String input=scanner.nextLine();

        int lineNum=0;
        while ("Collect".equals(input)==false){
            lineNum++;
            Matcher matCrates=patCrates.matcher(input);
            while (matCrates.find()){
                allCrates.add(matCrates.group());
            }
            input=scanner.nextLine();
        }
        int n=allCrates.size()/lineNum;

        String secReg="\\[#(?<tag>(\\d{"+ n +"}|[a-z]{" + n + "}))(?<body>[A-Za-z0-9\\s]*)#\\1]";

        Pattern secPat=Pattern.compile(secReg);

        int validCreates=0;
        int foodCollected=0;
        int drikCollected=0;

        for (String crate : allCrates) {

            Matcher matSec=secPat.matcher(crate);
            if(matSec.find()){
                validCreates++;

                String tag=matSec.group("tag");
                String drink=matSec.group("body");

                if(Character.isDigit(tag.charAt(0))){

                    HashSet<Character> distinct=new HashSet<>();
                    for (char c : drink.toCharArray()) {
                        distinct.add(c);
                    }
                    int sum=0;
                    for (Character ch : distinct) {
                        sum+=ch;
                    }
                    foodCollected+=sum*n;
                }else{
                    int sum1=0;
                    for (char c : drink.toCharArray()) {
                        sum1+=c;
                    }
                    int sum2=0;
                    for (char c : tag.toCharArray()) {
                        sum2+=c;
                    }
                    drikCollected+=sum1*sum2;
                }
            }
        }

        if(validCreates==0){
            System.out.println("No supplies found!");
        }else{
            System.out.println("Number of supply crates: "+validCreates);

            System.out.println("Amount of food collected: "+foodCollected);

            System.out.println("Amount of drinks collected: "+drikCollected);
        }
    }
}
