import java.util.*;

public class utp2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ukuran = sc.nextLine().split(" ");
        
        int n = Integer.parseInt(ukuran[0]);
        int m = Integer.parseInt(ukuran[1]);
        boolean[][] kursi = new boolean[n][m];
        Integer hargaKursi = null;
        int totalPendapatan = 0;
        
        for(int i =0;i<n;i++){
            String[] baris = sc.nextLine().split(" ");
            
            for(int j=0;j<m;j++){
                kursi[i][j] = baris[j].equals("true");
            }
        }
        
        int jumlahOperasi = Integer.parseInt(sc.nextLine().trim());
        
        
        for(int ops=0;ops<jumlahOperasi;ops++){
            String[] input = sc.nextLine().split(" ");
            String operasi = input[0];
            
            switch(operasi){
                case "PESAN":
                    int r = Integer.parseInt(input[1])-1;
                    int c = Integer.parseInt(input[2])-1;
                    if(!kursi[r][c]){
                        kursi[r][c] = true;
                        System.out.println("Kursi baris "+ (r+1)+ " kolom "+(c+1)+" berhasil dipesan.");
                        
                        
                        if(hargaKursi != null){
                            totalPendapatan += hargaKursi;
                        }
                    }else{
                        System.out.println("Kursi baris "+ (r+1) + " kolom "+ (c+1) + " sudah dipesan sebelumnya!");
                        
                        
                    }
                    break;
                case "SETHARGA":
                    int harga = Integer.parseInt(input[1]);
                    hargaKursi = harga;
                    System.out.println("Harga kursi diubah menjadi " + harga+".");
                    
                    
                    int jumlahKursiTerisi = 0;
                    for(int i =0;i<kursi.length;i++){
                        for(int j=0; j< kursi[i].length;j++){
                            if(kursi[i][j]){
                                jumlahKursiTerisi++;
                            }
                        }
                    }
                    totalPendapatan = jumlahKursiTerisi * harga;
                    break;
                
                case "HITUNG_PENDAPATAN":
                    if(hargaKursi == null){
                        System.out.println("Harga kursi belum ditetapkan!");
                        
                    }else{
                        System.out.println("Pendapatan: "+totalPendapatan);
                        
                    }
                    break;
                case "KOSONGKAN":
                    for(int i=0;i<kursi.length;i++){
                        for(int j=0;j<kursi[i].length;j++){
                            kursi[i][j] = false;
                        }
                    }
                    System.out.println("Semua kursi telah dikosongkan.");
                    
                    break;
                case "CEK_KURSI":
                    for(int i=0;i<kursi.length;i++){
                        for(int j=0;j<kursi[i].length;j++){
                            System.out.print(kursi[i][j]? "X ":"O ");
                        }
                        System.out.println();
                        
                        
                    }
                    break;
            }
        }
        
        
    }
}
