import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.regex.Matcher;

public class _2_SimpleExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder text=new StringBuilder(reader.readLine());

        String regex="\\d+";


        Pattern pat=Pattern.compile(regex);

        BigDecimal sumRes=new BigDecimal(0);

        Matcher match=pat.matcher(text);
        int endIndexlast=0;
        BigDecimal lastNum=new BigDecimal(0);
        if(match.find()){

            endIndexlast=match.end();
            lastNum=new BigDecimal(match.group().replaceAll("\\s+",""));

            sumRes=sumRes.add(lastNum);
        }

        while (match.find()){

            int startNew=match.start();
            BigDecimal newNum=new BigDecimal(match.group().replaceAll("\\s+",""));

            String medium=text.substring(endIndexlast,startNew).toString();
            if(medium.length()%2==0){
                sumRes=sumRes.add(newNum);
            }else {
                sumRes=sumRes.subtract(newNum);
            }

            lastNum=newNum;
            endIndexlast=match.end();

        }

        BigDecimal scaled = sumRes.round(new MathContext(7, RoundingMode.HALF_UP));
        DecimalFormat form=new DecimalFormat("#.#######");
        String formatted= form.format(scaled);
        System.out.println(scaled);


    }
}