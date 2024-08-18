package ua.example;

public class SumCalculator {
    public int sum(int number){
        if(number <= 0){
            throw new IllegalArgumentException();
        }
        int result = 0;
        for(int i = 0; i <= number; i++){
            if (result > Integer.MAX_VALUE - i) {
                throw new ArithmeticException("Integer overflow");
            }
            result += i;
        }
        return result;
    }
}
