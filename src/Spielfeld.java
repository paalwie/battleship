public class Spielfeld {

    private static final char WASSER = ' ';
    private static final char SCHIFF = '\u2666'; // Schiffs-Symbol (Unicode-Zeichen)
    private static final char TREFFER = '\u2713'; // Treffer-Symbol (Unicode-Zeichen)
    private static final char MISS = '\u25CF'; // Miss-Symbol (Unicode-Zeichen)

    private char[][] feld;

    public Spielfeld() {
        feld = new char[10][10];
        initSpielfeld();
    }

    public boolean fehlerEingabe(int x, int y) {
        if (x < 0 || x > 9 || y < 0 || y > 9 || x > 7) {
            System.out.println("Falsche Eingabe!");
            return true;
        }
        return false;
    }

    // Initialisiert das Spielfeld mit Wasser
    private void initSpielfeld() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                feld[y][x] = WASSER;
            }
        }
    }

    // Zeichnet das Spielfeld mit System.out.format
    public void zeichneSpielfeld() {
        System.out.println("    A    B   C   D   E   F   G   H   I   J");
        for (int y = 0; y < 10; y++) {

            if(y == 9){
                System.out.print((y + 1) + " ");
            }
            else {
                System.out.print("0" + (y + 1) + " ");
            }
            for (int x = 0; x < 10; x++) {
                System.out.print(String.format("| %c ", feld[y][x]));
            }
            System.out.println("|");
        }
    }

    public void setzeSchiff(int x, int y, int schiffLaenge, boolean schiffAnDerReihe) {
        if (schiffAnDerReihe) {
            for (int i = 0; i < schiffLaenge; i++) {
                feld[y][x + i] = SCHIFF;
            }
        } else {
            for (int i = 0; i < schiffLaenge; i++) {
                feld[y + i][x] = SCHIFF;
            }
        }
    }

    public boolean checkeFeld(int x, int y){
        int i = 0;
        while (i < 3){
            if (feld[y][x+i] == SCHIFF){
                System.out.println("Feld schon belegt!");
                return true;
            }
            else{
                i++;
            }
        }
        return false;
    }

    public boolean randomShoot(int x, int y){

        if(feld[x][y] == SCHIFF){
            feld[x][y] = TREFFER;
            System.out.println("Treffer bei " + (x + 1) + " " + (y + 1));
            return true;
        }

        if(feld[x][y] == WASSER){
            feld[x][y] = MISS;
            System.out.println("Miss bei " + (x + 1) + " " + (y + 1));
            return false;
        }
        else{
            return false;
        }
    }

    public boolean checkAlreadyHit(int x, int y){

        if(feld[y][x] == MISS || feld[y][x] == TREFFER){
            System.out.println("Feld bereits getroffen!");
            return true;
        }
        return false;
    }

    public void checkWin(){

        int schiffe = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(feld[i][j] == SCHIFF){
                    schiffe++;
                }
            }
        }
        if(schiffe > 0){
            System.out.println("Du hast gewonnen!");
        }

        if(schiffe == 0){
            System.out.println("Du hast verloren!");
        }
    }
}
