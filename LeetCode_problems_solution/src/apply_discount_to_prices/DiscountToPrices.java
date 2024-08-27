package apply_discount_to_prices;

import java.text.DecimalFormat;

public class DiscountToPrices {
    public String discountPrices(String sentence, int discount) {
        DecimalFormat df = new DecimalFormat("$0.00");
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (word.startsWith("$") && word.length() > 1 && word.substring(1).matches("\\d+")) {
                long  price = Long.parseLong(word.substring(1));
                double discountedPrice =price -((double) (price * discount) /100);
                String formattedPrice = df.format(discountedPrice);
                result.append(formattedPrice);
        }
            else {
                result.append(word);
        }
            result.append(" ");
    }
        return result.toString().trim();
    }
}
