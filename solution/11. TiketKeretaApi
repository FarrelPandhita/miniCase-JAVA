import java.util.Scanner;

public class TiketKeretaApi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Data kereta api dalam array 2D
        String[][] dataKereta = {
            {"Ekonomi", "50000", "2", "Tidak Ada", "Tidak Ada"},
            {"Bisnis", "100000", "5", "Ada", "Tidak Ada"},
            {"Eksekutif", "200000", "7", "Ada", "Tidak Ada"},
            {"Pariwisata", "300000", "10", "Ada", "Ada"}
        };

        // Array untuk menyimpan jumlah tiket yang dipesan untuk setiap jenis
        int[] jumlahTiket = new int[4]; // index 0-3 untuk 4 jenis kereta
        boolean sudahPesan = false;

        int pilihan;

        do {
            // Tampilkan Menu
            System.out.println("\n====================================");
            System.out.println("   SISTEM PEMESANAN TIKET KERETA");
            System.out.println("====================================");
            System.out.println("1. Melihat Daftar Kereta Api");
            System.out.println("2. Melihat Daftar Kereta Api yang ada AC");
            System.out.println("3. Melihat Daftar Kereta Api yang ada Colokan");
            System.out.println("4. Memesan Tiket Kereta Api");
            System.out.println("5. Melihat Pesanan Tiket");
            System.out.println("0. Keluar");
            System.out.println("====================================");
            System.out.print("Masukkan pilihan: ");
            pilihan = input.nextInt();

            // Proses berdasarkan pilihan menggunakan switch case
            switch (pilihan) {
                case 1:
                    // Lihat Daftar Kereta
                    System.out.println("\n========== DAFTAR KERETA API ==========");
                    System.out.println("Jenis           Harga        Diskon     AC           Colokan");
                    System.out.println("=================================================================");

                    for (int i = 0; i < dataKereta.length; i++) {
                        System.out.printf("%-15s Rp %-9s %-10s %-12s %-12s%n",
                            dataKereta[i][0], dataKereta[i][1],
                            dataKereta[i][2] + "%", dataKereta[i][3], dataKereta[i][4]);
                    }
                    break;

                case 2:
                    // Lihat Kereta dengan AC
                    System.out.println("\n===== DAFTAR KERETA API DENGAN AC =====");
                    System.out.println("Jenis           Harga        Diskon");
                    System.out.println("=============================================");

                    for (int i = 0; i < dataKereta.length; i++) {
                        if (dataKereta[i][3].equals("Ada")) {
                            System.out.printf("%-15s Rp %-9s %-10s%n",
                                dataKereta[i][0], dataKereta[i][1], dataKereta[i][2] + "%");
                        }
                    }
                    break;

                case 3:
                    // Lihat Kereta dengan Colokan
                    System.out.println("\n=== DAFTAR KERETA API DENGAN COLOKAN ===");
                    System.out.println("Jenis           Harga        Diskon");
                    System.out.println("=============================================");

                    for (int i = 0; i < dataKereta.length; i++) {
                        if (dataKereta[i][4].equals("Ada")) {
                            System.out.printf("%-15s Rp %-9s %-10s%n",
                                dataKereta[i][0], dataKereta[i][1], dataKereta[i][2] + "%");
                        }
                    }
                    break;

                case 4:
                    // Pemesanan Tiket
                    System.out.println("\n========== PEMESANAN TIKET ==========");
                    System.out.println("Jenis           Harga        Diskon     AC           Colokan");
                    System.out.println("=================================================================");

                    for (int i = 0; i < dataKereta.length; i++) {
                        System.out.printf("%d. %-12s Rp %-9s %-10s %-12s %-12s%n",
                            (i + 1), dataKereta[i][0], dataKereta[i][1],
                            dataKereta[i][2] + "%", dataKereta[i][3], dataKereta[i][4]);
                    }

                    String lanjutPesan;
                    do {
                        System.out.print("\nPilih jenis kereta (1-4): ");
                        int pilihKereta = input.nextInt();

                        if (pilihKereta >= 1 && pilihKereta <= 4) {
                            System.out.print("Masukkan jumlah tiket: ");
                            int jumlah = input.nextInt();

                            // Tambahkan jumlah tiket ke array (bisa menambah jika sudah ada)
                            jumlahTiket[pilihKereta - 1] += jumlah;

                            System.out.println("\n✓ Tiket " + dataKereta[pilihKereta - 1][0] + 
                                             " sebanyak " + jumlah + " berhasil ditambahkan!");

                            sudahPesan = true;
                        } else {
                            System.out.println("\nPilihan tidak valid!");
                        }

                        System.out.print("\nApakah ingin menambah tiket lain? (y/n): ");
                        lanjutPesan = input.next();

                    } while (lanjutPesan.equalsIgnoreCase("y"));

                    // Tampilkan ringkasan pesanan
                    if (sudahPesan) {
                        System.out.println("\n========== RINGKASAN PESANAN ==========");
                        System.out.println("Tiket yang dipesan:");
                        
                        for (int i = 0; i < jumlahTiket.length; i++) {
                            if (jumlahTiket[i] > 0) {
                                System.out.println("  - " + dataKereta[i][0] + ": " + jumlahTiket[i] + " tiket");
                            }
                        }
                        
                        System.out.println("=======================================");
                        System.out.println("✓ Pesanan berhasil disimpan!");
                        System.out.println("  Lihat detail di menu 5");
                    }
                    break;

                case 5:
                    // Lihat Pesanan
                    if (sudahPesan) {
                        System.out.println("\n========== DETAIL PEMESANAN ==========");
                        System.out.println("No  Jenis           Jumlah  Harga Satuan  Subtotal     Diskon      Total");
                        System.out.println("=============================================================================");

                        int grandTotal = 0;
                        int totalPotongan = 0;
                        int nomor = 1;

                        for (int i = 0; i < jumlahTiket.length; i++) {
                            if (jumlahTiket[i] > 0) {
                                int harga = Integer.parseInt(dataKereta[i][1]);
                                int diskon = Integer.parseInt(dataKereta[i][2]);
                                int subtotal = harga * jumlahTiket[i];
                                int potongan = subtotal * diskon / 100;
                                int total = subtotal - potongan;

                                System.out.printf("%-3d %-15s %-7d Rp %-10s Rp %-10d Rp %-8d Rp %-10d%n",
                                    nomor, dataKereta[i][0], jumlahTiket[i], 
                                    dataKereta[i][1], subtotal, potongan, total);

                                grandTotal += total;
                                totalPotongan += potongan;
                                nomor++;
                            }
                        }

                        System.out.println("=============================================================================");
                        System.out.println("Total Potongan    : Rp " + totalPotongan);
                        System.out.println("GRAND TOTAL BAYAR : Rp " + grandTotal);
                        System.out.println("=============================================================================");
                    } else {
                        System.out.println("\n===== BELUM ADA PESANAN =====");
                        System.out.println("Silakan lakukan pemesanan tiket terlebih dahulu");
                        System.out.println("dengan memilih menu nomor 4.");
                    }
                    break;

                case 0:
                    System.out.println("\nTerima kasih telah menggunakan layanan kami!");
                    break;

                default:
                    System.out.println("\nPilihan tidak valid!");
                    break;
            }

            if (pilihan != 0) {
                System.out.println("\nTekan Enter untuk melanjutkan...");
                input.nextLine();
                input.nextLine();
            }

        } while (pilihan != 0);

        input.close();
    }
}
