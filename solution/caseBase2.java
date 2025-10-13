import java.util.Scanner;
public class casebase2 {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            // Variabel ini dideklarasikan di luar loop agar nilainya tidak ter-reset.
            int hargaSubtotal = 0;
            String detailPesanan = ""; // String untuk menyimpan semua detail pesanan.
            String checkLanjut = "";
            int jumlahPesanan = 0; // Ini akan menjadi total semua item untuk biaya bungkus


            do {
                menu();
                System.out.print("Silahkan masukkan kode pesanan yang diinginkan (1-5): ");
                int kodePesanan = input.nextInt();
                if (kodePesanan < 1 || kodePesanan > 5) {
                    System.out.println("\nKode pesanan tidak valid. Harap masukkan angka antara 1 dan 5.\n");

                    continue; // Mengulang loop dari awal
                }
                System.out.print("Silahkan masukkan jumlah pesanan yang diinginkan: ");
                // Buat variabel baru untuk menampung jumlah per item
                int jumlahItemSaatIni = input.nextInt();

                if(jumlahItemSaatIni <= 0){
                    System.out.println("Jumlah Pesanan tidak valid! ");
                    System.out.println(); // Merapikan output
                    continue;
                }
                input.nextLine(); // Membersihkan buffer

                //  Akumulasikan jumlah total pesanan setelah validasi
                jumlahPesanan += jumlahItemSaatIni;

                String namaMenu = "";
                int hargaSatuan = 0;

                // Menentukan nama menu dan harga berdasarkan kode
                switch (kodePesanan) {
                    case 1:
                        namaMenu = "Nasi Goreng Spesial";
                        hargaSatuan = 15000;
                        break;
                    case 2:
                        namaMenu = "Ayam Bakar Madu";
                        hargaSatuan = 25000;
                        break;
                    case 3:
                        namaMenu = "Soto Ayam Lamongan";
                        hargaSatuan = 12000;
                        break;
                    case 4:
                        namaMenu = "Es Teh Manis";
                        hargaSatuan = 5000;
                        break;
                    case 5:
                        namaMenu = "Es Jeruk";
                        hargaSatuan = 7000;
                        break;
                    default:
                        // Meskipun sudah ada pengecekan di atas, ini sebagai pengaman
                        System.out.println("Maaf, kode pesanan tidak tersedia.");
                        continue;
                }

                // Gunakan jumlahItemSaatIni untuk kalkulasi subtotal dan detail pesanan
                hargaSubtotal += hargaSatuan * jumlahItemSaatIni;
                detailPesanan += namaMenu + " x " + jumlahItemSaatIni + "\n";

                System.out.println("Pesanan berhasil ditambahkan!");
                System.out.println("---------------------------------");
                System.out.print("Mau pesan lagi? (y/n): ");
                checkLanjut = input.nextLine().toLowerCase();
                System.out.println();

            } while (!checkLanjut.equals("n"));

            // === PROSES KALKULASI AKHIR SETELAH SELESAI MEMESAN ===
            System.out.println("============== PROSES PEMBAYARAN ==============");
            System.out.print("Bungkus/Makan tempat (y/n): ");
            String takeaway = input.nextLine();
            System.out.print("Apakah hari ini Jumat? (y/n): ");
            String cekHariJumat = input.nextLine();

            double totalDiskon = 0;
            double biayaBungkus = 0;
            double promoJumat = 0;

            // Menghitung diskon berdasarkan subtotal
            if (hargaSubtotal > 100000) {
                totalDiskon = hargaSubtotal * 0.15; // Diskon 15%
            } else if (hargaSubtotal > 50000) {
                totalDiskon = hargaSubtotal * 0.10; // Diskon 10%
            }

            // Mengecek apakah ada pesanan Ayam Bakar untuk promo Jumat
            if (cekHariJumat.equalsIgnoreCase("y") && detailPesanan.contains("Ayam Bakar Madu")) {
                promoJumat = 5000;
            }

            // Menambah biaya bungkus
            if (takeaway.equalsIgnoreCase("y")) {
                // Biaya bungkus dihitung dari total semua item yang dipesan
                biayaBungkus = jumlahPesanan * 2000;
            }

            // Kalkulasi harga total
            double hargaTotal = hargaSubtotal - totalDiskon - promoJumat + biayaBungkus;
            double pajak = hargaTotal * 0.1;
            double totalPembayaran = hargaTotal + pajak;

            // === STRUK PEMBAYARAN ===
           struk(detailPesanan, hargaSubtotal, totalDiskon, promoJumat, biayaBungkus, pajak, totalPembayaran);

            input.close();
        }

        static void menu(){

            System.out.println("""
                    ===============SELAMAT DATANG DI WARUNG NUSANTARA=================
                    |Kode Pesanan|     Menu              | Harga                     |
                    |Kode 1      : Nasi Goreng Spesial    (Harga: Rp15.000)          |
                    |Kode 2      : Ayam Bakar Madu        (Harga: Rp25.000)          |
                    |Kode 3      : Soto Ayam Lamongan     (Harga: Rp12.000)          |
                    |Kode 4      : Es Teh Manis           (Harga: Rp5.000)           |
                    |Kode 5      : Es Jeruk               (Harga: Rp7.000)           |
                    =================================================================
                    """);

        }
        static void struk(String detailPesanan, int hargaSubtotal, double totalDiskon, double promoJumat, double biayaBungkus, double pajak, double totalPembayaran){
            System.out.println("\n\n=============== STRUK PEMBAYARAN ===============");
            System.out.println("Detail Pesanan Anda:");
            System.out.print(detailPesanan);
            System.out.println("------------------------------------------------");
            System.out.printf("Subtotal         : Rp%,d\n", hargaSubtotal);

            if (totalDiskon > 0) {
                System.out.printf("Diskon           : -Rp%,.0f\n", totalDiskon);
            }
            if (promoJumat > 0) {
                System.out.printf("Promo Jumat      : -Rp%,.0f\n", promoJumat);
            }
            if (biayaBungkus > 0) {
                System.out.printf("Biaya Bungkus    : +Rp%,.0f\n", biayaBungkus);
            }
            System.out.printf("Pajak (10%%)      : +Rp%,.0f\n", pajak);

            System.out.println("------------------------------------------------");
            System.out.printf("Total Pembayaran : Rp%,.0f\n", totalPembayaran);
            System.out.println("================================================");
            System.out.println("         Terima Kasih Atas Kunjungan Anda!        ");
            System.out.println("================================================");

        }

}
