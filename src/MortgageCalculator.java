import java.text.NumberFormat;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private byte years;
    float interest;

    public MortgageCalculator(int principal, byte years, float interest) {
        this.principal = principal;
        this.years = years;
        this.interest = interest;
    }

    public double calculateMortgage() {
        int totalMonths = getTotalMonths();
        double monthlyInterest = getMonthlyInterest();

        double power = Math.pow((1 + monthlyInterest), totalMonths);
        return principal
                * ((monthlyInterest * power)
                / (power - 1));
    }


    public double calculateBalance(short numberOfPaymentsMade) {
        int totalMonths = getTotalMonths();
        double monthlyInterest = getMonthlyInterest();

        return principal
                * (Math.pow(1 + monthlyInterest, totalMonths) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, totalMonths) - 1);
    }

    public double[] getRemainingBalances(){
        double[] balances = new double[getTotalMonths()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }

    public byte getYears() {
        return years;
    }
    private float getMonthlyInterest() {
        return interest / MONTHS_IN_YEAR / PERCENT;
    }
    private int getTotalMonths() {
        return years * MONTHS_IN_YEAR;
    }
}
