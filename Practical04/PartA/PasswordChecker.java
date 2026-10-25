public class PasswordChecker {
    public static String strength(String pw){
        int score=0;
        if(pw.length()>=8)score++;
        if(pw.matches(".*[A-Z].*"))score++;
        if(pw.matches(".*[0-9].*"))score++;
        if(pw.matches(".*[^A-Za-z0-9].*"))score++;
        return score<=1?"Weak":score<=3?"Medium":"Strong";
    }
    public static void check(String pw){
        System.out.println("Length >= 8: "+(pw.length()>=8));
        System.out.println("Uppercase: "+pw.matches(".*[A-Z].*"));
        System.out.println("Digit: "+pw.matches(".*[0-9].*"));
        System.out.println("Special: "+pw.matches(".*[^A-Za-z0-9].*"));
        System.out.println("Strength: "+strength(pw));
    }
}
