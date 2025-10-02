// @author - el
// DISCLAIMER !
// Kode ini hanyalah implementasi konsep dasar (belum clean) dari tugas
/*
        Tugas Toko dengan fungsi
        1. Melihat daftar nama buah, stok, harga
        2. Merubah stok
        3. Melihat stok terkecil ada pada buah apa

 */
import java.util.Arrays;
import java.util.Scanner;

public class ManajemenStokBuah {
        public static void main(String[] args){
            Scanner input = new Scanner(System.in);

            String belanja="";
            int[] stocks ={4,6,8};
            String[] buah = {"Apel","Semangka","Pisang"};

            System.out.println("Menu Buah: ");
            for(int i = 0; i<stocks.length; i++){
                System.out.println((i+1)+". "+ buah[i] +" dengan stock: "+ stocks[i]);
            }
            System.out.print("Buah apa yang ingin anda beli: " );
            int choice = input.nextInt();
            if(choice<=0 || choice>stocks.length){
                System.out.println("Invalid choice!");
                return;
            }
            System.out.print("Masukkan jumlah beli: ");
            int n = input.nextInt();
            if(n > stocks[choice-1]){
                System.out.println("Barang sudah habis! /stock tidak cukup ");
//                System.out.println("Stock awal: "+ Arrays.toString(stocks));
                return;
            }
            System.out.println();
            switch(choice){
                case 1:
                    belanja = buah[0];
                    stocks[0] -= n;
                    break;
                case 2:
                    belanja = buah[1];
                    stocks[1] -= n;
                    break;
                case 3:
                    belanja = buah[2];
                    stocks[2] -= n;
                    break;
            }

            System.out.println("belanja : " + belanja + " Beli: " + n +" Sisa stock: "+ stocks[choice-1]);
            System.out.println();
            System.out.println("Updated stock: " );

            int minStock = stocks[0];
            int minIndex = 0;
            for(int i = 1; i < stocks.length; i++){
                if(stocks[i] <= minStock){
                    minStock = stocks[i];
                    minIndex = i;
                }
            }
            for(int i = 0; i<stocks.length; i++){
                System.out.println((i+1)+". "+ buah[i] +" dengan stock: "+ stocks[i]);
            }

            System.out.println("Stock buah terendah adalah buah: " + buah[minIndex]);

        }
    }

