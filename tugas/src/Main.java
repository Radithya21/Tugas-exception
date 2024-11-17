import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { // Loop utama untuk pengulangan input data transaksi
            try {
                System.out.println("\n=== Input Data Transaksi ===\n");

                // Input data transaksi
                System.out.print("Masukkan No Faktur: ");
                String noFaktur = scanner.nextLine().trim();

                System.out.print("Masukkan Kode Barang: ");
                String kodeBarang = scanner.nextLine().trim();

                System.out.print("Masukkan Nama Barang: ");
                String namaBarang = scanner.nextLine().trim();

                double hargaBarang = 0;
                while (true) {
                    try {
                        System.out.print("Masukkan Harga Barang: ");
                        hargaBarang = Double.parseDouble(scanner.nextLine().trim());
                        if (hargaBarang <= 0) throw new IllegalArgumentException("Harga barang harus lebih besar dari 0.");
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Terjadi kesalahan di bagian harga barang: Input tidak valid.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Terjadi kesalahan di bagian harga barang: " + e.getMessage());
                    }

                    // Konfirmasi ulang
                    if (!konfirmasiUlang(scanner)) {
                        System.out.println("Program dihentikan. Terima kasih.");
                        return;
                    }
                }

                int jumlahBeli = 0;
                while (true) {
                    try {
                        System.out.print("Masukkan Jumlah Beli: ");
                        jumlahBeli = Integer.parseInt(scanner.nextLine().trim());
                        if (jumlahBeli <= 0) throw new IllegalArgumentException("Jumlah beli harus lebih besar dari 0.");
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Terjadi kesalahan di bagian jumlah beli: Input tidak valid.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Terjadi kesalahan di bagian jumlah beli: " + e.getMessage());
                    }

                    // Konfirmasi ulang
                    if (!konfirmasiUlang(scanner)) {
                        System.out.println("Program dihentikan. Terima kasih.");
                        return;
                    }
                }

                // Membuat objek Transaksi dan menghitung total
                Transaksi transaksi = new Transaksi(kodeBarang, namaBarang, hargaBarang, noFaktur, jumlahBeli);
                transaksi.hitungTotal();

                // Menampilkan invoice
                System.out.println("\n--- Faktur Pembelian ---\n");
                System.out.println(transaksi.displayInvoice());

            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }

            // Tanya ulang setelah input selesai
            System.out.print("\nApakah kamu ingin memasukkan data transaksi lain? (y/n): ");
            if (!konfirmasiUlang(scanner)) {
                System.out.println("Program berhasil diselesaikan. Terima kasih.");
                break;
            }
        }

        scanner.close();
    }

    private static boolean konfirmasiUlang(Scanner scanner) {
        while (true) {
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("y")) {
                return true;
            } else if (response.equals("n")) {
                return false;
            } else {
                System.out.print("Input tidak valid. Masukkan 'y' atau 'n' untuk memperbaiki: ");
            }
        }
    }
}
