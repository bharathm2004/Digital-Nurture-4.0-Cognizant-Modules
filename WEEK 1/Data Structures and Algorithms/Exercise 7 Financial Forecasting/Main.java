public class Main {

    // Recursive method to predict future value
    public static double predictValue(int years, double currentValue, double growthRate) {
        if (years == 0) {
            return currentValue;
        }
        return predictValue(years - 1, currentValue, growthRate) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double currentValue = 10000; // Initial investment
        double growthRate = 0.08;    // 8% growth per year
        int years = 5;               // Forecast for 5 years

        double futureValue = predictValue(years, currentValue, growthRate);
        System.out.printf("Future value after %d years: %.2f\n", years, futureValue);
    }
}
