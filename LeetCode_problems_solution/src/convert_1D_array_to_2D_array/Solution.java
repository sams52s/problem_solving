package convert_1D_array_to_2D_array;

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] output = new int[m][n];
        int x=0;

        if(original.length == m*n){
            for(int i=0; i < m; i++)
            {
                for(int j=0; j<n; j++)
                {
                    output[i][j]=original[x];
                    x++;
                }
            }
            return output;
        }else{
            return new int[0][0];
        }


    }
}