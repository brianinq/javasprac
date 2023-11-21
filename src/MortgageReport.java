import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat
                .getCurrencyInstance();
    }

    public void printMortgage() {
        System.out.println("welcome to the Mortgage Calculator.");
        String formattedAmount = currency
                .format(calculator.calculateMortgage());
        System.out.println("Mortgage payable per month: " + formattedAmount);
    }

    public void printPaymentSchedule() {
        System.out.println("---------------------------------------------");
        System.out.println("******* PAYMENT SCHEDULE *******");
        for(double bal: calculator.getRemainingBalances()){
            System.out.println(
                    currency
                    .format(bal)
            );
        }
    }
}
