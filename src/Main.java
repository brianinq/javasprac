public class Main {
    public static void main(String[] args) {
        int principal = (int) Console.readNumber("please Enter the Principal amount ($1K - $1M):", 1000, 1_000_000);
        float interest = (float) Console.readNumber("Please enter the annual interest rate:", 1, 30);
        byte years = (byte) Console.readNumber("Period of repayment in years:", 1, 30);

        var calculator = new MortgageCalculator(principal, years, interest);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}