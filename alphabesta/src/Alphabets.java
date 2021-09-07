import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alphabets {
    public static void main(String[] args) {
        char[] s1 = {'A', 'B', 'C'};
        char[] s2 = {'B', 'C'};

        System.out.println(findTheSum(s1, s2));
    }
    public static int findTheSum(char[] s1, char[] s2) {
        int n = 0, flag = 0;
        for (int i = 0; i < Math.max(s1.length, s2.length); i++) {
            for (int j = 0; j < Math.min(s1.length,s2.length); j++) {
                if(s1[i]==s2[j]) flag = 1;
                else continue;
            }
            if(flag==0) {
                n+=(int)s1[i];
            }
        }
        int sum = 0;
        while (n > 0 || sum > 9) {
            if (n == 0) {
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
