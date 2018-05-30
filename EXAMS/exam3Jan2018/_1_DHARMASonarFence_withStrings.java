import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1_DHARMASonarFence_withStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if ("Reprogram".equals(input)){
                break;
            }
            int num = Integer.parseInt(input);

            for (int i = 0; i < 32 - 1; i++) {

                int firstDigit = (int) (num >> (31 - i) & 1);
                int secondDigit = (int) (num >> (31 - i - 1) & 1);

                if (firstDigit == secondDigit) {
                    int position = 31 - i;
                    num = num ^ 1 << (position);
                    num = num ^ 1 << (position - 1);

                    i += 1;
                }
            }
            //System.out.println(Integer.toUnsignedString(num));
            String bin=Integer.toBinaryString(num);
            System.out.println(Long.parseLong(bin,2));
        }
    }
}