import apply_discount_to_prices.DiscountToPrices;
import twoSum.TwoSum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
      int[] nums = new int[]{2,7,11,15};
      int target = 9;
        TwoSum ts = new TwoSum();
        System.out.println(Arrays.toString(ts.twoSum(nums, target)));

        DiscountToPrices dt = new DiscountToPrices();
        System.out.println(dt.discountPrices("there are $1 $2 and 5$ candies in the shop",50));
        System.out.println(dt.discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$",100));

    }
}