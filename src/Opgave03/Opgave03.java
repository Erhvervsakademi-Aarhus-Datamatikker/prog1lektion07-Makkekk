package Opgave03;

import java.util.Scanner;

public class Opgave03 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        //Array of the week
        String[] dageIUgen = {
                "Søndag", "Mandag", "Tirdsag", "Onsdag", "Torsdag", "Fredag", "Lørdag", "Søndag"
        };

        //Prompt brugeren til at skriver den nuværende dag i ugen.
        System.out.println("Skriv dagens dato i ugen. (0 for Søndag, 1 for mandag osv.)");
        int nuværendedag = scanner.nextInt();

        String nuværendeDagNavn = dageIUgen[nuværendedag];
        System.out.println("Dag i ugen " + nuværendeDagNavn);

        //Prompt brugeren til at skrive dagene efter indsatte dag
        System.out.println("Skriv dagene efter idag som du gerne vil finde");
        int tilføjetDage = scanner.nextInt();


        //Beregn fremtidsdato
        int fremtidsdatoberegning = (nuværendedag + tilføjetDage) % 7;
        String fremtidsDag = dageIUgen[fremtidsdatoberegning];

        //Print fremtidsdagen i ugen
        System.out.println("Fremtidsdatoen er: " + fremtidsDag);

    }
}