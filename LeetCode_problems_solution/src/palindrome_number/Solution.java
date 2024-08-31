package palindrome_number;

public class Solution {
    public boolean isPalindrome(int x) {
        String temp = Integer.toString(x);
        int flag =0;
        if(temp.charAt(0)== '-'){
            return false;
        }
        else {
           for(int i=0; i<temp.length(); i++){

               if(temp.charAt(i) != temp.charAt(temp.length()-1-i)){
                   flag++;
               }
           }
            return flag == 0;
        }
    }
}
