import java.util.Arrays;

public class SimpleCoinOptimizer {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50};
        
        
        boolean improved = true;
        
        // Keep optimizing until we can't find any better changes
        while (improved) {
            improved = false;
            int currentTotalScore = evaluate(coins);
            
            for (int i = 1; i < coins.length; i++) {
                int originalVal = coins[i];
                int bestValForThisSlot = originalVal;
                int bestScoreForThisSlot = currentTotalScore;

                int minVal = coins[i - 1] + 1;
                int maxVal = (i < coins.length - 1) ? coins[i + 1] - 1 : 99;

                for (int testVal = minVal; testVal <= maxVal; testVal++) {
                    coins[i] = testVal;
                    int score = evaluate(coins);
                    
                    if (score < bestScoreForThisSlot) {
                        bestScoreForThisSlot = score;
                        bestValForThisSlot = testVal;
                    }
                }

                if (bestValForThisSlot != originalVal) {
                    coins[i] = bestValForThisSlot;
                    currentTotalScore = bestScoreForThisSlot;
                    improved = true;
                
                } else {
                    // Revert to original if no improvement found
                    coins[i] = originalVal;
                }
            }
        }

        double finalAverage = evaluate(coins) / 99.0;
        
        System.out.println("Optimal Set: " + Arrays.toString(coins));
        System.out.printf("Final Average Coin Count: %.4f%n", finalAverage);
 
    }

    static int evaluate(int[] coins) {
        int[] dp = new int[100];
        Arrays.fill(dp, 9999); 
        dp[0] = 0;

        // We asume coins are mostly sorted, but inner loop handles any order safely
        for (int i = 1; i <= 99; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        int total = 0;
        for (int count : dp) total += count;
        return total;
    }
}