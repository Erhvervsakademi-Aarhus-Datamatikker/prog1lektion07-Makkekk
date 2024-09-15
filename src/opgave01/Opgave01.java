package opgave01;

public class Opgave01 {
    public static void main(String[] args) {
        int[] integerArray = getIntegerArray(); //Hent array

        // Print alle elementer af arrayet direkte i main metoden.
        for (int i = 0; i < integerArray.length; i++) {
            System.out.println("Opgave1A " + integerArray[i]);
            System.out.println();
        }


        int sumOfArray = sum(integerArray);
        System.out.println("Opgave 1B " + "Sum af alle array integers: " + sumOfArray);
        System.out.println();

        double averageOfArray = average(integerArray);
        System.out.println("opgave 1C " + "Gennemsnittet af alle array ints: " + averageOfArray);
        System.out.println();


        /////////////////////////////////////////////////////////////////////////////////////


        // Udskriv resultatet
        int tværsum = sumDigits(sumOfArray);
        System.out.println("Opgave 1D " + "Summen af cifrene i " + sumOfArray + " tværsummen er: " + tværsum);
        System.out.println();
        //Print opgave E

        int[] frekvens = BeregnTværsumFrekvens(integerArray);
        for (int i = 0; i < frekvens.length; i++) {
            System.out.println("Opgave 1E" + " Tværsum " + (i + 1) + ": " + frekvens[i] + " gange");
        }
    }


    private static int[] getIntegerArray() {
        int[] integerArray = {1095, 12, 9065, 387, 700, 20, 5, 2065, 97654, 103, 789, 50, 1972, 200, 35, 98, 1002};
        return integerArray;
    }

    private static int sum(int[] integerArray) {

        int sum = 0;
        for (int i = 0; i < integerArray.length; i++) {
            sum += integerArray[i];
        }
        return sum;
    }

    private static double average(int[] integerArray) {
        if (integerArray.length == 0) {
            return 0; //For at undgå division med 0
        }
        int sum = sum(integerArray);
        return (double) sum / integerArray.length;
    }


    // Metode der summerer cifrene i et heltal
    public static int sumDigits(int sum) {

        int tværsum = 0;

        // Hvis tallet er negativt, gør det positivt
        if (sum < 0) {
            sum = -sum;
        }

        // Gentag, så længe der er cifre i tallet
        while (sum > 0) {
            // Hent sidste ciffer ved at bruge modulus 10
            int lastDigit = sum % 10;

            // Tilføj cifferet til summen
            tværsum += lastDigit;

            // Fjern sidste ciffer ved at bruge integer division
            sum = sum / 10;

            // Gør brug af summen af cifrene
            int result = tværsum    ;
        }

        return tværsum;
    }

    //Opgave E


//metoden der beregner tværsum af et tal
    private static int getSingleDigits(int number) {
        while (number >= 10) {
            number = tværSum(number);
        }

        return number;
    }

    //metoden der beregner tværsum af tal

    private static int tværSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10; //Brug de sidste cifre og læg til summen
            number /= 10; //fjern de sidste ciffre.
        }
        return sum;
    }

    //Metoden til at udregne antallet af tværsum resultater for tal i et array
    public static int [] BeregnTværsumFrekvens(int[] integerArray) {
        int [] frekvens = new int [9];

        for (int number : integerArray) {
            int enCifretsum = getSingleDigits(number);
            frekvens[enCifretsum - 1]++; //Øg tælleren for det tilsvarede ciffer [1 bliver [0] 9 bliver 8
        }
return frekvens;

    }



}


