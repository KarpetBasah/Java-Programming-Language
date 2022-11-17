import java.util.Scanner;
import java.io.Console;

public class BookingKamar {
    static Scanner input = new Scanner(System.in);
    static String pilihan;
    public static void main(String[] args) {
        boolean kondisi = true;
        while (kondisi = true) {
        System.out.println("Selamat Datang di Program Reservasi Hotel");
        System.out.println("Berikut menu yang tersedia: ");
        System.out.println("1. Pesan Kamar\n2. Login Admin\n3. Keluar");
        System.out.print("Pilihan Anda: ");
        pilihan = input.next();

        if (pilihan.equals("1")) {
            menuUser();
        } else if (pilihan.equals("2")) {
            loginAdmin();
        } else if (pilihan.equals("3")) {
            System.out.println("Keluar dari program...");
            kondisi = false;
            System.exit(0);
        } else {
            System.out.println("Harap masukkan pilihan yang benar");
        }
        try {
            System.in.read();
        } catch (Exception e) {
            // TODO: handle exception
        }
        cls();
        }
    }
    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void loginAdmin() {
        String username1 = "Admin";
        String password1 = "Admin";
        Scanner input = new Scanner(System.in);
        cls();
        System.out.println("Halaman Login Admin");
        System.out.print("Input '1' untuk kembali ke menu utama "); // Kosongkan aja di terminalnya kalo mau lanjut
        Console console = System.console();
        String menuUtama = console.readLine();
        // System.in.read();
        if (menuUtama.equals("1")) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            main(null);
        }
        System.out.println("=========================");
        System.out.print("Masukkan Username: ");
        String username = input.next();
        System.out.print("Masukkan Password: ");
        String password = input.next();

        if (username.equals(username1) && password.equals(password1)) {
            System.out.println("Login Berhasil!");
            System.out.print("\033[H\033[2J");
            System.out.flush();
            menuAdmin();
        } else {
            System.out.println("Username atau password Salah!");
            try {
                System.in.read();
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
            loginAdmin();
        }
    }
    public static void menuUser() {
        Scanner input = new Scanner(System.in);
        cls();
        System.out.println("<<< Selamat Datang di Hotel Compelle >>>");
        System.out.println("Pilihan Menu:");
        System.out.println("1. Booking Kamar\n2. Lihat Denah dan Cek Ketersediaan kamar\n3. Kembali ke Menu Utama");
        System.out.print("Pilihan Anda: ");
        String pilihanUser = input.next();
    }
    public static void menuAdmin() {
        Scanner input = new Scanner(System.in);
        System.out.println("<<< Menu Admin hotel Compelle >>>");
        System.out.println("Pilihan Menu:");
        System.out.println("1. Delete Costumer Berdasarkan nomor kamar yang dipilih");
        System.out.println("2. Liat denah ketersediaan kamar dan nama pemesannya");
        System.out.println("3. Ganti Password Admin");
        System.out.println("4. Ganti Harga Paket kamar ke harga terbaru");
        System.out.println("5. Kembali ke Menu Utama");
    }
}
