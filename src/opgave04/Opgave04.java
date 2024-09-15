package opgave04;

public class Opgave04 {
    public static void main(String[] args) {
        char[] romanNumber = {'M', 'L', 'X', 'I'}; //1061
        System.out.println(romanNumberToArabicNumber(romanNumber));
    }

    private static int romanNumberToArabicNumber(char[] romanNumber) {
        //Din implementering her. - array fra højre til venstre
       int total = 0;
       int prevValue = 0;

        for (int i = romanNumber.length - 1; i >= 0; i--) {
            char romanChar = romanNumber[i];
            int currentValue = SingleRomanNumberToArabicNumber(romanChar);

            // Hvis den nuværende værdi er større eller lig med den tidligere værrdi, plus det. hvis ikke minus det
            if (currentValue >= prevValue) {
                total += currentValue;
            } else {
                total -= currentValue;
            }

            //Opdater den tidligere værdi for det næste loop
            prevValue = currentValue;
        }

        return total;
    }

    private static int SingleRomanNumberToArabicNumber(char roman) {
        return switch (roman) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new IllegalArgumentException(roman + " is not a valid roman number literal.");
        };
    }
}
