class MinimumNumberofSwapstoMaketheStringBalanced {
    public int minSwaps(String s) {
        char[] brackets = s.toCharArray();
        int count =0;
        for(int i=0;i< s.length();i++){
            if(brackets[i]=='[') count++;
            else if(count > 0) count--;
        }
        return (count +1)/2;
    }
}
