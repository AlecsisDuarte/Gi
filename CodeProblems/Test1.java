/* 
    Havind 2 String A and B
        A = abcd
        B = cdabcdab
    If you can't make B a substring of A return -1,
    else you must count how many times you have to repeat A in order
    to B be a Substring of it, in this case you mus repeat A 3 times
    like: abcdabcdabcd in order to B(cdabcdab) be a substring of A
    
        Output: 3
*/

import java.util.Scanner;
import java.util.HashSet;

public class Test1{
    public static int solution(String a, String b){
        int bIndex = 0;
        int count = 1;
        while(a.charAt(0) != b.charAt(bIndex++)){
            if(bIndex == b.length()) return -1;
        }
        --bIndex;
        for(int i = 0; i < a.length(); i++){
            if(bIndex == b.length()) bIndex = 0;
            if(a.charAt(i) != b.charAt(bIndex)) return -1;
            ++bIndex;
        }
        while(!a.contains(b)){
            a += a;
            ++count;
        }
        return count;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        in.close();
        System.out.println(solution(a, b));
    }
}