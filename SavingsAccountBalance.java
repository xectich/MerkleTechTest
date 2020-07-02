
public class SavingsAccountBalance {
    public static double balance(int openingSum, int interestRate,int taxFreeLimit,int taxRate,int numMonths){
        int i = 0;
        double currentSum = openingSum;
        while(i < numMonths){
            double monthlyInterest = (currentSum*(interestRate/100.0));
            double monthlyTax = 0.0;
            if(currentSum > taxFreeLimit){
                monthlyTax = ((currentSum - taxFreeLimit)*(taxRate/100.0));
            }
            currentSum += monthlyInterest - monthlyTax;
            i++;
        }
        return currentSum;
    }

    public static void main(String[] args){
        System.out.println(balance(10000,1,20000,1,2));
        System.out.println(balance(25000,2,20000,1,2));
        System.out.println(balance(19800,2,20000,1,2));

    }
}