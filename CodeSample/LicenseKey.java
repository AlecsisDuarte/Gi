import java.util.Scanner;

public class LicenseKey{
    public static String Solution(String s, int k){
        String license = "";
        int count = 0;
        for(int i = s.length() -1 ; i >= 0; i--){
            char c = s.charAt(i);
            if(c > 47){
                c = (c > 96 && c < 123)?(char) (c - 32) : c;
                license = c + license;
                if(++count == k && i > 0) {
                    license = "-" + license;
                    count = 0;
                }
            }
        }
        return license;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String line = in.next();
        int k = in.nextInt();
        String result = Solution(line, k);
        System.out.println(result);
        in.close();
    }
}