package hu.nive.ujratervezes.kepesitovizsga.adddigits;

public class AddDigits {

    public int addDigits(String input) {
        if (input == null || input.isBlank()) {
            return -1;
        } else {
            return getSum(input);
        }
    }

    private int getSum(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                sum += Character.digit(input.charAt(i), 10);
            }
        }
        return sum;
    }
}
