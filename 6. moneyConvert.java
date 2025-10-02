import java.util.Scanner;
public class moneyConvert {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String[] currencies = {"USD", "JPY", "GBP", "EUR", "SAR"};
        int[] exchangeRates = {8000, 4000, 10500, 8900, 1100};

        // Menampilkan pilihan mata uang
        System.out.println("Tipe Mata uang yang tersedia");
        for (int i = 0; i < currencies.length; i++) {
            System.out.println((i + 1) + ". " + currencies[i] + " (kurs 1 " + currencies[i] + " = Rp " + exchangeRates[i] + ",-)");
        }

        // Input pilihan
        System.out.print("Masukkan jenis mata uang anda: ");
        int pilihan = in.nextInt();

        // Validasi pilihan
        if (pilihan < 1 || pilihan > currencies.length) {
            System.out.println("Pilihan tidak valid");
            return;
        }

        // Input jumlah uang dan konversi
        System.out.print("Masukkan banyak uang anda (dalam " + currencies[pilihan - 1] + "): ");
        int uang = in.nextInt();

        int convertedAmount = uang * exchangeRates[pilihan - 1];
        System.out.println("Uang yang diterima: Rp " + convertedAmount + ",-");
