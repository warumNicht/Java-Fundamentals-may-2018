import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _4_RegularExtentions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input=reader.readLine();
        StringBuffer text=new StringBuffer(input);
        input=reader.readLine();

        while (!"Print".equals(input)){
            if(input.length()>text.length()){
                input=reader.readLine();
                continue;
            }
            input=input.replaceAll("%+","%");
            String[] inputs = input.split("%",-1);
            for (int i = 0; i < inputs.length; i++) {
                inputs[i] = Pattern.quote(inputs[i]);
            }
            Pattern pattern = Pattern.compile(String.join("\\S*", inputs));

            Matcher match=pattern.matcher(text);
            while (match.find()) {

                text.replace(match.start(), match.end(),
                        new StringBuffer(text.substring(match.start(), match.end())).reverse().toString());
            }
            input = reader.readLine();
        }
        System.out.println(text);
    }
}