public class Main {
    public static void main(String[] args) {
        int[] poleCisel = new int[]{10, 8 , 6, -6, -82};
        int[][] maticaA = new int[][]{{1, 3}, {2, 4}};
        int[][] maticaB = new int[][]{{5, 3}, {2, 9}};
        int[][] vysledok;
        double median;
        Matica matica = new Matica();
        matica.dajDlzkuRetazca(null);
        matica.overParnost();
        matica.vypisPrvokPola(poleCisel, 3);
        try {
            System.out.println(matica.vydel());
        } catch (LessThanZeroException e) {
            System.out.println("Zadavas cislo mensie ako 0");
        }
        try {
            median = matica.vypocitajMedian();
            System.out.println(median);
        } catch (IncorrectAmountOfNumbersException e) {
            System.out.println("Zadal si parny pocet cisel");
        }
        try {
            System.out.println(matica.vydel());
        } catch (LessThanZeroException e) {
            System.out.println("Zadavas cislo mensie ako 0");
        }
        try {
            vysledok = matica.scitajMatice(maticaA, maticaB);
            for (int[] riadok : vysledok) {
                for (int hodnota : riadok) {
                    System.out.print(hodnota + " ");
                }
                System.out.println();
            }
        } catch (IncorrectSizeOfParametersException e) {
            System.out.println("Nespravna velkost matice.");
        }
    }
}