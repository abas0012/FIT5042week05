package fit5042.tutex.calculator;

import javax.ejb.Stateless;

/**
 * A simple monthly payment calculator implementation
 *
 * @author originally created by Eddie Leung, but been changed for the purpose of students'lab exercises
 */

@Stateless //adding a @Stateless state, means that ejb objects are shared amongst a number of clients.
//Monthly Payment Calculator does not contain any specific varaible so Stateless can be used here
public class MonthlyPaymentCalculatorBean implements MonthlyPaymentCalculator {

    @Override
    public double calculate(double principle, int year, double interestRate) {
        double monthlyPayment = 0.0;
        int numberOfPayments = year * 12;
        if (interestRate > 0) {
            monthlyPayment = principle * (interestRate * (Math.pow((1 + interestRate), numberOfPayments))) / ((Math.pow((1 + interestRate), numberOfPayments)) - 1);
        } else {
            monthlyPayment = 1000;
        }

        return monthlyPayment;
    }
}
