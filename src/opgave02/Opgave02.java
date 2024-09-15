package opgave02;

public class Opgave02 {
    public static void main(String[] args) {
        char[] characterArray = getCharacterArray();


        //Kald metoden der tæller vokaler
        int[] talteVokaler = tællerAfVokaler(characterArray);

        //Print resultater
        char[] vokaler = {'a', 'e', 'i', 'o', 'u', 'y', 'æ', 'ø', 'å'};
        for (int i = 0; i < talteVokaler.length; i++) {
            System.out.println("Opgave 2A " + "Antal " + vokaler[i] + ": " + talteVokaler[i]);
            System.out.println();
        }

        //Hent udregninger fra metoden
        int antalPunktummer = tællerAfPunktummer(characterArray);
        int antalOrd = tællerAfOrd(characterArray);
        int antalLangeord = tællerAfLangeOrd(characterArray);
        double Lixtal = beregnLixTal(antalOrd,antalPunktummer,antalLangeord);
        System.out.println("Opgave b");
        System.out.println("Antal punktummer: " + antalPunktummer);
        System.out.println("Antal ord " + antalOrd);
        System.out.println("Antal Lange ord (Over 6 bogstaver): " + antalLangeord);
        System.out.println("Lix-tal: " + Lixtal);
    }

    private static char[] getCharacterArray() {
        return ("Der var så dejligt ude på landet; det var sommer, kornet stod gult, havren grøn, " +
                "høet var rejst i stakke nede i de grønne enge, og der gik storken på sine lange, " +
                "røde ben og snakkede ægyptisk, for det sprog havde han lært af sin moder. Rundt om" +
                " ager og eng var der store skove, og midt i skovene dybe søer; jo, der var rigtignok " +
                "dejligt derude på landet! Midt i solskinnet lå der en gammel herregård med dybe kanaler" +
                " rundt om, og fra muren og ned til vandet voksede store skræppeblade, der var så høje," +
                " at små børn kunne stå oprejste under de største; der var lige så vildsomt derinde, som " +
                "i den tykkeste skov, og her lå en and på sin rede; hun skulle ruge sine små ællinger ud, " +
                "men nu var hun næsten ked af det, fordi det varede så længe, og hun sjælden fik visit;" +
                " de andre ænder holdt mere af at svømme om i kanalerne, end at løbe op og sidde under " +
                "et skræppeblad for at snadre med hende." +
                "Endelig knagede det ene æg efter det andet: pip! pip! sagde det, alle æggeblommerne " +
                "var blevet levende og stak hovedet ud." +
                "Rap! rap! sagde hun, og så rappede de sig alt hvad de kunne, og så til alle sider " +
                "under de grønne blade, og moderen lod dem se så meget de ville, for det grønne er godt for " +
                "øjnene. Hvor dog verden er stor! sagde alle ungerne; thi de havde nu rigtignok ganske " +
                "anderledes plads, end da de lå inde i ægget. Tror I, det er hele verden! sagde moderen, " +
                "den strækker sig langt på den anden side haven, lige ind i præstens mark! " +
                "men der har jeg aldrig været! – I er her dog vel alle sammen! – og så rejste hun sig" +
                " op, nej, jeg har ikke alle! det største æg ligger der endnu; hvor længe skal det vare! nu er " +
                "jeg snart ked af det! og så lagde hun sig igen.").toCharArray();
    }

    private static int[] tællerAfVokaler(char[] characterArray) {
        //Array til at holde tælleren af hvert vokal
        int[] vokalTæller = new int[9];

        //gå igennem hvert tegn i characterArray
        for (char c : characterArray) {
            c = Character.toLowerCase(c); //Konverter små bogstaver til store.
            if (c == 'a') {
                vokalTæller[0]++;
            } else if (c == 'e') {
                vokalTæller[1]++;
            } else if (c == 'i') {
                vokalTæller[2]++;
            } else if (c == 'o') {
                vokalTæller[3]++;
            } else if (c == 'u') {
                vokalTæller[4]++;
            } else if (c == 'y') {
                vokalTæller[5]++;
            } else if (c == 'æ') {
                vokalTæller[6]++;
            } else if (c == 'ø') {
                vokalTæller[7]++;
            } else if (c == 'å') {
                vokalTæller[8]++;
            }
        }
        return vokalTæller;
    }

    private static int tællerAfPunktummer(char[] CharacterArray) {
        int antalPunktummer = 0;
        for (char c : CharacterArray) {
            if (c == '.') {
                antalPunktummer++;
            }
        }
        return antalPunktummer;
    }

    private static int tællerAfOrd(char[] CharacterArray) {
        int antalOrd = 0;
        boolean Ord = false;

        for (char c : CharacterArray) {
            if (Character.isLetter(c)) {
                if (!Ord) {
                    antalOrd++;
                    Ord = true;
                }
            } else {
                Ord = false;
            }
        }

        return antalOrd;
    }

    private static int tællerAfLangeOrd(char[] CharacterArray) {
        int antalLangeOrd = 0;
        int ordLængde = 0;
        boolean ord = false;


        for (char c : CharacterArray) {
            if (Character.isLetter(c)) {
                if (!ord) {
                    ord = true;
                }
                ordLængde++;
            } else {
                if (ord) {
                    if (ordLængde > 6) {
                        antalLangeOrd++;
                    }
                    ordLængde = 0;
                    ord = false;
                }
            }
        }

        // Tjek sidste ord, hvis der ikke er noget tegn bagefter
        if (ord && ordLængde > 6) {
            antalLangeOrd++;
        }

        return antalLangeOrd;
    }

    private static double beregnLixTal(int O, int P, int L) {
        if (P == 0) P = 1; // For at undgå division med 0
        return O / (double) P + L * 100.0 / O;
    }
}
