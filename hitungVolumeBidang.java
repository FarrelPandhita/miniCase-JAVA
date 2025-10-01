import java.util.Scanner;

import static java.lang.Math.pow;

public class hitungVolumeBidang {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean lanjut = true;
        int r,tinggi;
        double volume=0;
        do{

        System.out.print("""
                =====================================
                                                MENU
                0. KELUAR
                1. HITUNG VOLUME BALOK
                2. HITUNG VOLUME BOLA
                3. HITUNG VOLUME KERUCUT
                4. HITUNG VOLUME SILINDER
                5. HITUNG VOLUME LIMAS SEGITIGA
                
                =====================================
                
                """);
        System.out.print("MASUKKAN PILIHAN ANDA: ");
        int choice = sc.nextInt();
        if(choice<0 || choice>5){
            System.out.println("OPSI Tidak Valid");
            return;
        }
        if(choice == 0){
            System.out.println("=======================");
            System.out.println("Terimakasih! ");
            System.out.println("=======================");
            lanjut = false;
            continue;
        }

        switch (choice){
            case 1:
                System.out.print("Masukkan panjang: ");
                int panjang = sc.nextInt();
                System.out.print("Masukkan lebar: ");
                int lebar = sc.nextInt();
                System.out.print("Masukkan tinggi: ");
                tinggi = sc.nextInt();
                volume = panjang*lebar*tinggi;
                break;
            case 2:
                System.out.print("Masukkan jari-jari: ");
                r = sc.nextInt();
                volume =  (double) 4 /3 * 3.14 * pow(r,3);
                break;
            case 3:
                System.out.print("Masukkan jari-jari: ");
                r = sc.nextInt();
                System.out.print("Masukkan tinggi: ");
                tinggi = sc.nextInt();
                volume= (double) 1/3 * 3.14 * pow(r,2) * tinggi;
                break;
            case 4:
                System.out.print("Masukkan jari-jari: ");
                r = sc.nextInt();
                System.out.print("Masukkan tinggi: ");
                tinggi = sc.nextInt();
                volume = (double) 3.14 * pow(r,2) * tinggi;
                break;
            case 5:
                System.out.print("Masukkan Luas Alas: ");
                int lAlas = sc.nextInt();
                System.out.print("Masukkan tinggi: ");
                tinggi = sc.nextInt();
                volume = (double) 1/3 * lAlas * tinggi;

        }
            System.out.printf("Volumenya: %.2f %n", volume);

        }while(lanjut);



    }
}
