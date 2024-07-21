public class Logik {

    static int buchstabeZuZahl(String inputBuchstabe){

        String buchstabe = inputBuchstabe.toUpperCase();
        switch (buchstabe){
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            case "G":
                return 6;
            case "H":
                return 7;
            case "I":
                return 8;
            case "J":
                return 9;
            default:
                return -1;
        }
    }

    static int zahlZuZahl(String zahl){

        switch (zahl){
            case "1":
                return 0;
            case "2":
                return 1;
            case "3":
                return 2;
            case "4":
                return 3;
            case "5":
                return 4;
            case "6":
                return 5;
            case "7":
                return 6;
            case "8":
                return 7;
            case "9":
                return 8;
            case "10":
                return 9;
            default:
                return -1;
        }
    }

    //dürfen nur Zahlen zwischen 0 und 9 rauskommen
    static int randomZahl(){
        return (int) (Math.random() * 10);
    }
}
