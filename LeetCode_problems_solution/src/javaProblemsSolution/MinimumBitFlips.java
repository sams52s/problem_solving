class MinimumBitFlips {
    public int minBitFlips(int start, int goal) {
        int[] startBinary = convertBinarry(start);
        int[] goalBinary = convertBinarry(goal);
        int count = 0;
        for(int i= startBinary.length-1; 0<=i; i--)
        {
            if(startBinary[i] != goalBinary[i]){
                count++;
            }
        }
        return count;
    }
    public int[] convertBinarry(int num){
        int[] binary = new int[35];
        int id = 0;
        while (num > 0) {
            binary[id++] = num % 2;
            num = num / 2;
        }
        return binary;
    }
}
