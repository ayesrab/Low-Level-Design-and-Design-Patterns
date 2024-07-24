import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String s = scanner.nextLine();
        String a = "asaf";
        String b = "vt";
        //System.out.printf("%s %s", a,b);
        System.out.println(1<<2);
        System.out.println(64 >>> 2);
        StringBuffer sb = new StringBuffer("ashab");
        sb.setCharAt(0,'e');
        String s1 = new String("aaa");
        String s2 = "aaa";
        System.out.println(s1==s2);
        System.out.println(sb);
        //System.out.println(s);
        //System.out.println(isPalindrome(s,0,s.length()-1));
        //reverseString(s);
        int z = 5;
        Integer zz = z;
        change(zz);
        System.out.println(zz);

    }
    static void change(Integer integer){
        integer = 10;
    }
    public static boolean isPalindrome(String s,int l,int r) {
        if(l > r)
            return true;
        if(s.charAt(l) != s.charAt(r))
            return false;
        return isPalindrome(s, l+1, r - 1);
    }
    public static void reverseString(String s) {
        if(s == null || s.length() <= 1){
            System.out.println(s);
        }
        else{
            System.out.print(s.charAt(s.length()-1));
            reverseString(s.substring(0, s.length()-1));
        }

    }
}