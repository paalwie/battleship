public class Texte {

    public void introText(){

        System.out.println("\n" +
                "\n" +
                "__________    ___________________________.____     ___________ _________ ___ ___ ._____________ \n" +
                "\\______   \\  /  _  \\__    ___/\\__    ___/|    |    \\_   _____//   _____//   |   \\|   \\______   \\\n" +
                " |    |  _/ /  /_\\  \\|    |     |    |   |    |     |    __)_ \\_____  \\/    ~    \\   ||     ___/\n" +
                " |    |   \\/    |    \\    |     |    |   |    |___  |        \\/        \\    Y    /   ||    |    \n" +
                " |______  /\\____|__  /____|     |____|   |_______ \\/_______  /_______  /\\___|_  /|___||____|    \n" +
                "        \\/         \\/                            \\/        \\/        \\/       \\/                \n" +
                "\n");
    }

    public void manual(){

        System.out.println("Spielanleitung:");
    }

    public void schiffeSeztenAnleitung(){

        System.out.println("Sie haben 5 Schiffe, mit je Länge 3");
        System.out.println("Die Schiffe werden alle waagerecht (von links nach rechts) platziert");
        System.out.println("Geben Sie an, an welchem Feld das linke Teil des Schiffs platziert werden soll");
    }

    public void vsKIShoot(){
        System.out.println("Die KI wird jetzt 70 mal schießen");
        System.out.println("Wenn alle Schiffe getroffen werden hast du verloren");
    }
}
