import java.util.*;

public class UTP1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jumlahNama = sc.nextInt();
        sc.nextLine();
        
        String[] nama = new String[jumlahNama];
        String[] namaAsli = new String[jumlahNama];
        int totalHuruf = 0;
        
        System.out.println("Masukkan " + jumlahNama + " nama lengkap: ");
        
        // Input and normalize names
        for(int i = 0; i < jumlahNama; i++){
            System.out.print("Nama ke-" + (i+1) + ": ");
            String input = sc.nextLine().trim().replaceAll("\\s+", " ");
            namaAsli[i] = input;
            
            String[] words = input.split(" ");
            StringBuilder namaProper = new StringBuilder();
            
            for(String word : words){
                namaProper.append(word.substring(0, 1).toUpperCase())
                          .append(word.substring(1).toLowerCase())
                          .append(" ");
                totalHuruf += word.length();
            }
            
            nama[i] = namaProper.toString().trim();
        }
        
        // Display initials
        System.out.println("\nInisial dari setiap nama:");
        for(int i = 0; i < jumlahNama; i++){
            System.out.print(namaAsli[i] + " -> ");
            for(String bagian : namaAsli[i].split(" "))
                System.out.print(Character.toUpperCase(bagian.charAt(0)) + ".");
            System.out.println();
        }
        
        // Search by initial
        String awalan = sc.nextLine().toUpperCase();
        System.out.println("\nNama yang berawalan huruf '" + awalan + "':");
        
        boolean found = false;
        for(String n : nama){
            if(n.toUpperCase().charAt(0) == awalan.charAt(0)){
                System.out.println(n);
                found = true;
            }
        }
        
        if(!found) System.out.println("Tidak ada nama yang berawalan '" + awalan + "'");
        
        System.out.println("\nTotal huruf (tanpa spasi): " + totalHuruf);
    }
}
