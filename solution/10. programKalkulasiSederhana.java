// author @ell

import java.util.ArrayList;
import java.util.Scanner;

public class programKalkulasiSederhana {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum1 =0, max=0, min=0, sum2=0;
        double avg;
        ArrayList <Integer> data = new ArrayList<>();
        boolean lagi = true;

        do {
        System.out.println("""
                \n
                ==========Laprak 4.1==========
                Nilai Opsi: 
                1. Input Data
                2. Lihat Data
                3. Avg
                4. Sum
                5. Max
                6. Min
                7. Exit                
                ==============================
                """);
        System.out.print("Masukkan Nilai: ");
        int opsi = sc.nextInt();
        if(opsi<= 0 || opsi>7){
            System.out.println("Opsi tidak valid! ");
        }
        if(opsi==7){
            lagi=false;
            continue;
        }

            switch (opsi){
                case 1:
                    System.out.print("Masukkan angka: ");
                    int angka = sc.nextInt();
                    data.add(angka);
                    break;
                case 2:
                    System.out.print("isi data: ");
                    for (int i = 0; i < data.size();i++) {
                        System.out.print(data.get(i));
                        if(i< data.size()-1)System.out.print(", ");
                    }
                    break;
                case 3:
                    for(int isiData: data){
                        sum1+= isiData;
                    }
                    avg = (double) sum1 /data.size();
                    System.out.println("Nilai rata ratanya adalah: "+ avg);
                    break;
                case 4:
                    sum2=0
                    for(int isiData: data){
                        sum2+= isiData;
                    }
                    System.out.println("Total penjumlahan adalah: " +sum2);
                    break;
                case 5:
                    for(int i=0; i<data.size();i++){
                    int tempMax = data.getFirst();
                    if(data.get(i)>= tempMax) max= data.get(i);

                    }
                    System.out.println("Angka terbesar adalah: " + max);
                    break;
                case 6:
                    for(int i=0; i<data.size();i++){
                        int tempMin = data.getFirst();
                        if(data.get(i)<= tempMin) min= data.get(i);

                    }
                    System.out.println("Angka terkecil adalah: " + min);
                    break;





            }
        }while (lagi);
        System.out.println("======== Terimakasih ========");
    }
}
