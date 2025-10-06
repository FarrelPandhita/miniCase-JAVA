import java.util.Scanner;
import java.util.ArrayList;

public class tugasDekripsiEnkripsi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> angkaInvalid= new ArrayList<>();
        int id, n;

//        System.out.print("Masukkan ID: ");
        id = input.nextInt();
//        System.out.print("N jumlah angka: ");
        n = input.nextInt();
//        System.out.println("Masukkan angka yang ingin enkripsi: ");
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i] = input.nextInt();

        }
        int batasAtas = id + 25;
        int spasi = id + 26;
        for(int i=0;i< arr.length;i++){
            if(arr[i] >=id && arr[i]<= batasAtas){
//              misal angka[0] = 15, dan id = 10, maka offset = 5 yang mana 5 adalah "F"
                int offset = arr[i] - id;
                char huruf = (char) ('A' +offset);
                sb.append(huruf);

                }else if(arr[i] == spasi){
                char huruf = ' ';
                sb.append(huruf);
                }else{
                angkaInvalid.add(arr[i]);

                }
        }
        String pesanFinal = sb.toString();
        System.out.println("Output pesan: "+pesanFinal);

        System.out.print("Elemen tidak valid ditemukan: " );
        for(int i=0; i< angkaInvalid.size();i++){
            System.out.print(angkaInvalid.get(i));
//            agar tidak ada koma di ujung line
            if(i < angkaInvalid.size()-1){
                System.out.print(", ");
            }
        }


    }
}
