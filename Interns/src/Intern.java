public class Intern {
    public static void main(String[] args) {
        int n = internNumber(10, 25003);
        System.out.println(n);
    }

    static int internNumber(int N, int P) {
        //N is the number of interns and P is the password'
        int label=0;
        if(P%5000 == 0 && P/5000 <= N){
            label = P/5000;
            return label;
        }
        int n = P%5000;
        int number = 5000*(P/5000);
        int count = 0;
        int days = 0;
        for (int i = 1; i <= N; i++) {
            if(count==n) {
                days = i;
            }
            count+=i;
        }
        System.out.print("Intern have worked " + days + " days. and the label is " );
        int inital = number - (5000*(days-1));
        return inital/5000;
    }
}
