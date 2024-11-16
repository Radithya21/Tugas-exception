import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== Input Data Transaksi ===\n");

            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine().trim();

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine().trim();

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine().trim();

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = 0;
            while (true) {
                try {
                    hargaBarang = Double.parseDouble(scanner.nextLine().trim());
                    if (hargaBarang <= 0) throw new IllegalArgumentException("Harga barang harus lebih besar dari 0.");
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Input tidak valid. Masukkan angka untuk harga barang: ");
                } catch (IllegalArgumentException e) {
                    System.out.print(e.getMessage() + " Masukkan ulang: ");
                }
            }

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = 0;
            while (true) {
                try {
                    jumlahBeli = Integer.parseInt(scanner.nextLine().trim());
                    if (jumlahBeli <= 0) throw new IllegalArgumentException("Jumlah beli harus lebih besar dari 0.");
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Input tidak valid. Masukkan bilangan bulat untuk jumlah beli: ");
                } catch (IllegalArgumentException e) {
                    System.out.print(e.getMessage() + " Masukkan ulang: ");
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
        } finally {
            scanner.close();
        }
    }
}
