import java.util.HashMap;

class Main {
    public static int removeElement(Integer[] nums, int val) {
        HashMap<Integer,Integer> h=new HashMap<>();
        int i=0;
        while(i< nums.length){
            if(nums[i]!=val){
                h.put(nums[i],h.get(nums[i])+1);
                i++;
            }
            else{
                i++;
            }
        }
        int sum = 0;
        for (int s : h.values()) {
            sum += s;
        }
        return sum;
    }

    public static void main(String[] args) {
        Integer[] n = {3, 2, 2, 3};
        System.out.println(removeElement(n, 2));
    }
}