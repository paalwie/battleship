import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int schiffeGesetztZahl = 0;
    static boolean hit;
    static int randomZahl;
    static int randomZahl2;

    public static void main(String[] args) {

        Texte texte = new Texte();
        texte.introText();

        System.out.println("PLAYER VS AI");
        System.out.println();

        Spielfeld spielfeld = new Spielfeld();
        spielfeld.zeichneSpielfeld();

        texte.schiffeSeztenAnleitung();

        while(schiffeGesetztZahl < 5){

            System.out.println("Durchgang: " + (schiffeGesetztZahl + 1) );;
            System.out.println("Geben Sie an in welcher Spalte (A bis J) Sie das Schiff setzen möchten:");
            String eingabeBuchstabe = scanner.nextLine();

            System.out.println("Geben Sie an in welcher Reihen (1 bis 10) Sie das Schiff setzen möchten:");
            String eingabeZahl = scanner.nextLine();

            int zahl1 = Logik.buchstabeZuZahl(eingabeBuchstabe);
            int zahl2 = Logik.zahlZuZahl(eingabeZahl);

            if (spielfeld.fehlerEingabe(zahl1, zahl2)){
                continue;
            }

            if (spielfeld.checkeFeld(zahl1, zahl2)){
                continue;
            }

            spielfeld.setzeSchiff(zahl1, zahl2, 3, true);
            spielfeld.zeichneSpielfeld();
            schiffeGesetztZahl++;
        }

        texte.vsKIShoot();

        int i = 0;
        while (i < 70){

            if(hit){
                while (hit) {

                    // Rechts prüfen
                    if (randomZahl2 + 1 < 10) {
                        hit = spielfeld.randomShoot(randomZahl, randomZahl2 + 1);
                        i++;
                        if (!hit) {
                            // Links prüfen, wenn kein Treffer rechts
                            if (randomZahl2 - 1 >= 0) {
                                hit = spielfeld.randomShoot(randomZahl, randomZahl2 - 1);
                                i++;
                            }
                        }
                    } else {
                        // Links prüfen, wenn kein rechts möglich
                        if (randomZahl2 - 1 >= 0) {
                            hit = spielfeld.randomShoot(randomZahl, randomZahl2 - 1);
                            i++;
                        }
                    }
                }
                continue;
            }

            randomZahl = Logik.randomZahl();
            randomZahl2 = Logik.randomZahl();

            if (spielfeld.checkAlreadyHit(randomZahl, randomZahl2)){
                continue;
            }

            hit = spielfeld.randomShoot(randomZahl, randomZahl2);
            i++;
        }

        spielfeld.zeichneSpielfeld();

        spielfeld.checkWin();

        scanner.close();
        System.out.println("Das Spiel ist beendet!");
    }
}