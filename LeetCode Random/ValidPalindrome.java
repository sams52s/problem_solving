public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        System.out.println(isPalindrome(s)); // Output: true
        System.out.println(isPalindrome(s2)); // Output: false
    }
    private static boolean isPalindrome(String s){
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", ""); // Remove non-alphanumeric characters
        int n = s.length();
        for(int i = 0; i < n/2; i++){
            if(s.charAt(i) != s.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
}