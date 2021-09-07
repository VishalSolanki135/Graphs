public class Main {
//    static int n = 6;
//    static int[] sideArr = new int[n];

    static int swap(int[] arr, int[] sideArr, int n) {
        if(arr.length==1) return 0;
        int cE=0, cO=0, count=0, ans=0;
        for (int i = 0; i < n; i++) {
            if(i%2==0) {
                sideArr[i] = 0;
            }
            else {
                sideArr[i] = 1;
            }
            if(arr[i]%2==0) {
                cE++;
                arr[i] = 0;
            } else {
                cO++;
                arr[i] = 1;
            }
        }

        if(Math.abs(cE-cO)>1) return -1;
        else {
            for (int i = 0; i < n; i++) {
                if (arr[i] != sideArr[i]) {
                    if(arr[0]==1) {
                        if (arr[i] == 1) {
                            count++;
                            ans += count;
                        } else {
                            count--;
                        }
                    } else {
                        if (arr[i] == 0) {
                            count++;
                            ans += count;
                        } else {
                            count--;
                        }
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2};
        int[] sideArr = new int[6];
        int ans = swap(arr, sideArr, 6);
        System.out.println(ans);
    }
}