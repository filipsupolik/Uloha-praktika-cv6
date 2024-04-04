import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Matica {
    private final Scanner sc;

    public Matica() {
        this.sc = new Scanner(System.in);
    }

    public int dajDlzkuRetazca(String paRetazec) {
        int dlzkaRetazca = 0;
        try {
            dlzkaRetazca = paRetazec.length();
        } catch (NullPointerException e) {
            System.out.println("Chyba pri zadani parametra.");
        }
        return dlzkaRetazca;
    }

    public int[][] scitajMatice(int[][] maticaA, int[][] maticaB) throws IncorrectSizeOfParametersException {
        int rowsA = maticaA.length;
        int colsA = maticaA[0].length;
        int rowsB = maticaB.length;
        int colsB = maticaB[0].length;
        if (rowsA != rowsB || colsB != colsA) {
            throw new IncorrectSizeOfParametersException();
        }
        int[][] vyslednaMatica = new int[rowsA][colsA];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                vyslednaMatica[i][j] = maticaA[i][j] + maticaB[i][j];
            }
        }
        return vyslednaMatica;
    }

    public void overParnost() {
        int vstup = 0;
        boolean validneCislo = false;

        while (!validneCislo) {
            System.out.print("Zadajte číslo: ");
            try {
                vstup = this.sc.nextInt();
                validneCislo = true;
            } catch (InputMismatchException e) {
                System.out.println("Zadajte platné celé číslo.");
                this.sc.nextLine();
            }
        }
        if (vstup % 2 == 0) {
            System.out.println("Tvoje cislo je parne.");
        } else {
            System.out.println("Tvoje cislo je neparne");
        }
    }

    public double vydel() throws LessThanZeroException {
        double vysledok = 0;
        double prveCislo = 0;
        double druheCislo = 0;
        boolean spravnyVysledok = false;
        while (!spravnyVysledok) {
            try {
                System.out.println("Nacitaj prve cislo");
                prveCislo = this.sc.nextInt();
                System.out.println("Nacitaj druhe cislo");
                druheCislo = this.sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Zadaj spravne cislo");
            }
            try {
                if (druheCislo != 0) {
                    vysledok = prveCislo / druheCislo;
                    spravnyVysledok = true;
                }
            } catch (ArithmeticException e) {
                System.out.println("Delenie nulou");
            }

            if (druheCislo < 0) {
                throw new LessThanZeroException();
            }
        }
        return vysledok;
    }
    public double vypocitajMedian() throws IncorrectAmountOfNumbersException {
        double median = 0;
        System.out.println("Zadaj neparny pocet cisel");
        int pocetCisel = this.sc.nextInt();
        double[] cisla = new double[pocetCisel];
        if (pocetCisel % 2 == 0) {
            throw new IncorrectAmountOfNumbersException();
        }
        for (int i = 0; i < pocetCisel; i++) {
            System.out.println("Zadaj cisla, z ktorych ides robit median");
            cisla[i] = this.sc.nextInt();
        }
        Arrays.sort(cisla);
        median = cisla[pocetCisel / 2];
        return median;
    }

    public void vypisPrvokPola(int[] pole, int poziciaPrvku) {
        try {
            int prvok = pole[poziciaPrvku];
            System.out.format("Prvok na pozicii %d, je %d%n", poziciaPrvku, prvok);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Zadana pozicia neexistuje");
        }
    }
}
