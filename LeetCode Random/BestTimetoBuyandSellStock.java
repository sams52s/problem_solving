public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1})); // 0
        System.out.println(maxProfit(new int[]{2, 4, 1})); // 2
        System.out.println(maxProfit(new int[]{1})); // 0

        System.out.println(maxProfit2ndSolution(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println(maxProfit2ndSolution(new int[]{7, 6, 4, 3, 1})); // 0
        System.out.println(maxProfit2ndSolution(new int[]{2, 4, 1})); // 2
        System.out.println(maxProfit2ndSolution(new int[]{1})); // 0
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE;
        System.out.println("minPrice: " + minPrice);
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
    public static int maxProfit2ndSolution(int[] prices) {
        if (prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price); // Update minPrice if current price is lower
            maxProfit = Math.max(maxProfit, price - minPrice); // Update maxProfit if current price - minPrice is greater
            System.out.println("minPrice: " + minPrice);
            System.out.println("maxProfit: " + maxProfit);
        }

        return maxProfit;
    }
}
