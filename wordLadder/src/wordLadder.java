import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class wordLadder {
    static int shortestDistance(String start, String target, Set<String> dictionary){
        if(start==target) return 0;
        if(!dictionary.contains(target)) return 0;//base cases

        int level=0;//current chain length
        int wordLength = start.length();

        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            ++level;
            int sizeOfqueue = queue.size();

            for (int i = 0; i < sizeOfqueue; ++i) {
                char[] word = queue.peek().toCharArray();
                queue.remove();

                for (int pos = 0; pos < wordLength; ++pos) {
                    char orig_char = word[pos];
                    for(char c = 'a'; c<='z'; c++) {
                        word[pos] = c;

                        if(String.valueOf(word).equals(target)) return level+1;

                        if(!dictionary.contains(String.valueOf(word))) continue;
                        dictionary.remove(String.valueOf(word));

                        queue.add(String.valueOf(word));
                    }
                    word[pos] = orig_char;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Set<String> D = new HashSet<>();
        D.add("poon");
        D.add("plee");
        D.add("same");
        D.add("poie");
        D.add("plie");
        D.add("poin");
        D.add("plea");
        String start = "toon";
        String target = "plea";
        System.out.print("Length of shortest chain is: "
                + shortestDistance(start, target, D));
    }
}
