import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(numberOfDays(25, 5));
//        ArrayList<Integer> primes = setOfPrimes(3);
//        for (int i = 0; i < 3; i++) {
//            System.out.println(primes.get(i));
//        }
    }
    static int numberOfDays(int finalL, int exercises) {
        ArrayList<Integer> primes = setOfPrimes(exercises);
        int n = primes.get(exercises-1);
        int m = primes.get(exercises);
        if(finalL%n==0) {
            return finalL/n;
        } else {
            return (finalL/n)+1;
        }
    }
    static ArrayList<Integer> setOfPrimes(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        int count=0,index=0,i=1,j=1;
        while(index<(n+1))
        {
            j=1;
            count=0;
            while(j<=i)
            {
                if(i%j==0)
                    count++;
                j++;
            }
            if(count==2)
            {
                primes.add(i);
                index++;
            }
            i++;
        }
        return primes;
    }
}
