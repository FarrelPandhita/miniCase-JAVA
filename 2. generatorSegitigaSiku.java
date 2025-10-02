// @author - el
// DISCLAIMER !
// Kode ini hanyalah implementasi konsep dasar 

import java.util.Scanner;

public class generatorSegitigaSiku {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nilai n: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print("  "); // Cetak dua spasi agar sejajar dengan "* "
            }

            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            // Pindah ke baris baru setelah satu baris selesai
            System.out.println();
        }



    }
}
