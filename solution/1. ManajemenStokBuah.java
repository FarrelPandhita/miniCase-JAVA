// @author - el
// DISCLAIMER !
// Kode ini hanyalah implementasi konsep dasar (belum clean) dari tugas
/*
        Tugas Toko dengan fungsi
        1. Melihat daftar nama buah, stok, harga
        2. Merubah stok
        3. Melihat stok terkecil ada pada buah apa
        4. hitung kembalian

 */

import java.util.Scanner;

public class tugasArrhitungStockTerkecil {
        public static void main(String[] args){
            Scanner input = new Scanner(System.in);

            String belanja ="";
            int[] stocks ={4,6,8};
            int [] harga= {4000,60000,8000};
            String[] buah = {"Apel","Semangka","Pisang"};

            System.out.println("\n╔════════════════════════════════════════════════════╗");
            System.out.println("║                   MENU BUAH TOKO                   ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
            for (int i = 0; i < buah.length; i++) {
                System.out.printf("║ %d. %-15s Stock: %-5d Harga: Rp %-8d ║\n",
                        (i + 1), buah[i], stocks[i], harga[i]);
            }
            System.out.println("╚════════════════════════════════════════════════════╝");
            System.out.print("\nBuah apa yang ingin anda beli (1-" +buah.length+") :" );
            int choice = input.nextInt();

            if(choice<=0 || choice>stocks.length){
                System.out.println("Invalid choice!");
                return;
            }
            int indexChoice = choice - 1;
            System.out.print("Masukkan jumlah beli: ");
            int jumlahBeli = input.nextInt();
            if(jumlahBeli > stocks[choice-1] || jumlahBeli<=0){
                System.out.println("stock tidak cukup ");
                return;
            }
            System.out.println();

            int totalHarga = harga[indexChoice] * jumlahBeli;
            stocks[indexChoice] -= jumlahBeli;

            System.out.println("\n=== INFO PEMBELIAN ===");
            System.out.println("Belanja: " + buah[indexChoice]);
            System.out.println("Jumlah: " + jumlahBeli);
            System.out.println("Total Harga: Rp " + totalHarga);
            System.out.println("Sisa stock: " + stocks[indexChoice]);

            System.out.print("\nMasukkan jumlah uang: Rp ");
            int uangBayar = input.nextInt();

            if (uangBayar < totalHarga) {
                System.out.println("Uang tidak cukup! Kurang: Rp " + (totalHarga - uangBayar));
            } else {
                int kembalian = uangBayar - totalHarga;
                System.out.println("Kembalian: Rp " + kembalian);
            }

            System.out.println("\n╔════════════════════════════════════════════════════╗");
            System.out.println("║                     UPDATED STOCK                  ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
            for (int i = 0; i < buah.length; i++) {
                System.out.printf("║ %d. %-15s Stock: %-5d Harga: Rp %-8d ║\n",
                        (i + 1), buah[i], stocks[i], harga[i]);
            }
            System.out.println("╚════════════════════════════════════════════════════╝");

            int minStock = stocks[0];
            int minIndex = 0;
            for(int i = 1; i < stocks.length; i++){
                if(stocks[i] <= minStock){
                    minStock = stocks[i];
                    minIndex = i;
                }
            }

            System.out.println("\n=== STOCK TERENDAH ===");
            System.out.println("Stock buah terendah saat ini  adalah buah: " + buah[minIndex]);

        }
    }

