package src;

import java.util.*;
import java.lang.String;

public class TabunganMahasiswaUpdate { // Version 1.2 update 2
    static String username1, password1;
    static final int batasUser = 10;
    static String[] username = new String[batasUser];
    static String[] password = new String[batasUser];
    static int[] saldo = new int[batasUser];
    static int a = 0;

    public static void main(String[] args) {
        username[0] = "";
        username[1] = "";
        password[0] = "";
        password[1] = "";
        menuUtama();
    }

    public static void menuUtama() {
        Scanner input = new Scanner(System.in);
        boolean kondisi = true;
        do {
            cls();
            System.out.println("Selamat datang di program Tabungan Mahasiswa!");
            System.out.println("==============================================================================");
            System.out.println("Sebelum menggunakan program, Anda diharuskan untuk login terlebih dahulu...");
            System.out.println(
                    "Jika belum memiliki akun, maka Anda diharuskan untuk mendaftar terlebih dahulu\nPilihan Menu:");
            System.out.println("1. Daftar\n2. Login\n3. Tentang\n4. Keluar dari program");
            System.out.print("Pilihan Anda: ");
            String pilihan = input.next();

            switch (pilihan) {
                case "1":
                    daftar();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    cls();
                    System.out.println("<<\t\tTentang Pembuat\t\t\t>>");
                    System.out.println("==================================================");
                    System.out.println("\nNama\t\t\t: Muhammad Dicky Setiawan");
                    System.out.println("NIM\t\t\t: 2211016310014");
                    System.out.println("Program Studi\t\t: S-1 Ilmu Komputer");
                    System.out.println("E-Mail\t\t\t: dickys729@gmail.com");
                    System.out.println("Nomor Telepon/Whatsapp\t: 0895803790033");
                    System.out.println(
                            "\nCatatan:\nApabila Anda menemukan bug di program ini, silahkan hubungi saya lewat E-Mail atau Whatsapp agar bisa segera diperbaiki.");
                    System.out.println(
                            "========================================================================================================================");
                    System.out.println("Tekan enter untuk kembali..");
                    enter();
                    break;
                case "4":
                    System.out.println("Keluar dari Program...");
                    kondisi = false;
                    System.exit(0);
                default:
                    System.out.println("Harap masukkan pilihan yang benar");
                    enter();
            }
        } while (kondisi = true);
        input.close();
    }

    public static void daftar() {
        Scanner input = new Scanner(System.in);
        cls();
        if (a < username.length) {
            System.out.println("<< Selamat Datang di Menu Pendaftaran >>");
            System.out.println("========================================");
            System.out.print("Masukkan Username: ");
            username[a] = input.next();
            for (int i = 0; i < username.length; i++) {
                if (i == a) {
                    continue;
                } else if (username[a].equals(username[i])) {
                    System.out.println("================================================");
                    System.out.println("Maaf, Username yang Anda masukkan tidak tersedia");
                    enter();
                    menuUtama();
                }
            }
            System.out.print("Masukkan Password: ");
            password[a] = input.next();
            System.out.println("==============================");
            System.out.println("Anda telah berhasil mendaftar!");
            a++;
            enter();
            menuUtama();
        } else {
            System.out.println("<< Selamat Datang di Menu Pendaftaran >>");
            System.out.println("========================================");
            System.out.println("Maaf, Anda tidak dapat mendaftar dikarenakan sistem kami penuh");
            enter();
            menuUtama();
        }
        input.close();
    }

    public static void login() {
        Scanner input = new Scanner(System.in);
        boolean kondisi = true;
        int a = 0;
        while (kondisi = true) {
            if (username[0].equals("") || username[1].equals("")) {
                System.out.println("Untuk dapat menggunakan program ini, minimal 2 user yang terdaftar..");
                enter();
                menuUtama();
            }
            cls();
            System.out.println("<< Selamat datang di menu Login >>");
            System.out.println("==================================");
            System.out.print("Masukkan Username: ");
            username1 = input.next();
            System.out.print("Masukkan Password: ");
            password1 = input.next();

            while (a < username.length) {
                if (username1.equals(username[a])) {
                    if (password1.equals(password[a])) {
                        System.out.println("=============================================");
                        System.out.println("Login berhasil, tekan enter untuk melanjutkan");
                        enter();
                        programUtama(a);
                    } else {
                        System.out.println("Password salah!");
                        enter();
                        menuUtama();
                    }
                }
                a++;
            }
            System.out.println("Username atau Password salah!");
            enter();
            menuUtama();
        }
        input.close();
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void enter() {
        try {
            System.in.read();
        } catch (Exception e) {

        }
    }

    public static void programUtama(int a) {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        int jmlSimpan = 0, jmlAmbil = 0, jmlTransfer = 0;
        final int batasSimpan = 10000000;

        while (true) {
            cls();
            System.out.println("Selamat Datang, " + username[a] + "!");
            System.out.println(
                    "Berikut pilihan menu yang tersedia: \n1. Cek Saldo Tabungan\n2. Simpan Uang\n3. Ambil Uang\n4. Transfer Uang\n5. Ganti Username\n6. Ganti Password\n7. Log Out");
            System.out.print("Pilihan Anda: ");
            String pilihan = input.next();

            switch (pilihan) {
                case "1":
                    cls();
                    System.out.println("<< Menu Cek Saldo >>");
                    System.out.println("====================");
                    System.out.printf("Jumlah Saldo Anda saat ini adalah: Rp %,3d\n", saldo[a]);
                    // System.out.println("Jumlah Saldo Anda saat ini adalah: Rp " + saldo[a]);
                    System.out.println("Tekan enter untuk kembali ke beranda");
                    enter();
                    break;
                case "2":
                    while (true) {
                        cls();
                        System.out.println("<< Menu Simpan Uang >>");
                        System.out.println("======================");
                        try {
                            System.out.print("Masukkan jumlah uang yang akan disimpan: ");
                            jmlSimpan = input2.nextInt();
                        } catch (Exception e) {
                            System.out.println(e);
                            System.err.println("Harap masukkan nilai yang benar!");
                            enter();
                            programUtama(a);
                        }
                        if (jmlSimpan % 1000 == 0) {
                            if (jmlSimpan > batasSimpan) {
                                System.out.println("Anda hanya dapat menyimpan uang maksimal sebanyak Rp 10.000.000");
                                System.out.print("Kembali ke beranda? (Y/N) ");
                                String keputusan = input.next();
                                if (keputusan.equalsIgnoreCase("Y")) {
                                    break;
                                } else {
                                    continue;
                                }
                            } else {
                                saldo[a] = simpan(saldo[a], jmlSimpan);
                                System.out.printf("Simpan uang berhasil!\nJumlah saldo Anda Sekarang adalah: Rp %,3d",
                                        saldo[a]);
                                enter();
                                break;
                            }
                        } else {
                            System.out.println("Anda hanya dapat menyimpan uang kelipatan 1.000");
                            System.out.println("Tekan enter untuk melanjutkan...");
                            enter();
                            programUtama(a);
                        }
                    }
                    break;
                case "3":
                    boolean kondisi = true;
                    while (kondisi = true) {
                        cls();
                        System.out.println("<< Menu Ambil Uang >>");
                        System.out.println("=====================");
                        System.out.printf("Saldo saat ini: Rp %,3d\n", saldo[a]);
                        try {
                            System.out.print("Masukkan Jumlah uang yang akan diambil: ");
                            jmlAmbil = input2.nextInt();
                        } catch (Exception e) {
                            System.out.println(e);
                            System.err.println("Harap masukkan nilai yang benar!");
                            enter();
                            programUtama(a);
                        }
                        if (jmlAmbil % 1000 == 0) {
                            if (jmlAmbil > saldo[a]) {
                                System.out.println("Saldo Anda tidak mencukupi");
                                System.out.print("Kembali ke beranda? (Y/N) ");
                                String keputusan = input.next();
                                if (keputusan.equalsIgnoreCase("Y")) {
                                    break;
                                } else {
                                    continue;
                                }
                            } else {
                                saldo[a] = ambil(saldo[a], jmlAmbil);
                                System.out.printf(
                                        "Penarikan uang berhasil!\nJumlah saldo Anda Sekarang adalah: Rp %,3d",
                                        saldo[a]);
                                enter();
                                break;
                            }
                        } else {
                            System.out.println("Anda hanya dapat mengambil uang kelipatan 1.000");
                            System.out.println("Tekan enter untuk melanjutkan...");
                            enter();
                            programUtama(a);
                        }
                    }
                    break;
                case "4":
                    boolean kondisi4 = true;
                    boolean kondisi5 = true;
                    while (kondisi4 == true) {
                        cls();
                        System.out.println("<<< Menu Transfer Uang >>>");
                        System.out.println("==========================");
                        System.out.printf("Saldo saat ini: Rp %,3d\n", saldo[a]);
                        try {
                            System.out.print("Jumlah uang yang akan ditransfer: ");
                            jmlTransfer = input.nextInt();
                        } catch (Exception e) {
                            System.out.println(e);
                            System.err.println("Harap masukkan nilai yang benar!");
                            enter();
                            programUtama(a);
                        }
                        if (jmlTransfer % 1000 == 0) {
                            if (jmlTransfer > saldo[a]) {
                                System.out.println("Saldo Anda tidak mencukupi");
                                System.out.print("Kembali ke beranda? (Y/N) ");
                                String keputusan = input.next();
                                if (keputusan.equalsIgnoreCase("Y")) {
                                    break;
                                } else {
                                    continue;
                                }
                            } else {
                                System.out.print("Username tujuan transfer: ");
                                String tujuan = input2.next();
                                for (int t = 0; t < username.length; t++) {
                                    if (t == a) {
                                        continue;
                                    } else if (tujuan.equals(username[t])) {
                                        System.out.printf(
                                                "Apakah Anda yakin ingin mentransfer uang sebanyak Rp %,3d ke %s? (Y/N) ",
                                                jmlTransfer, tujuan);
                                        String keputusan2 = input2.next();
                                        if (keputusan2.equalsIgnoreCase("y")) {
                                            for (int r = 0; r < username.length; r++) {
                                                if (r == a) {
                                                    continue;
                                                } else if (tujuan.equals(username[r])) {
                                                    cls();
                                                    saldo[a] -= jmlTransfer;
                                                    saldo[r] += jmlTransfer;
                                                    System.out.printf(
                                                            "Transfer berhasil!\nSaldo Anda sekarang tersisa Rp %,3d\n",
                                                            saldo[a]);
                                                    System.out.println("Tekan enter untuk kembali...");
                                                    kondisi4 = false;
                                                    kondisi5 = false;
                                                    enter();
                                                    break;
                                                }
                                            }
                                            break;
                                        } else {
                                            System.out.println("Anda telah membatalkan transfer...");
                                            enter();
                                            break;
                                        }
                                    }
                                }
                                if (kondisi5 == true) {
                                    System.out.println("Username yang Anda masukkan tidak valid");
                                    enter();
                                    kondisi4 = false;
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Anda hanya dapat mentransfer uang kelipatan 1.000");
                            System.out.println("Tekan enter untuk melanjutkan...");
                            enter();
                            programUtama(a);
                        }
                    }
                    break;
                case "5":
                    gantiUsername(a);
                case "6":
                    gantiPass(a);
                case "7":
                    menuUtama();
                    break;
                default:
                    System.out.println("Harap masukkan pilihan yang benar");
                    enter();
            }
        }
    }

    public static int simpan(int saldo, int jmlSimpan) {
        int a = saldo + jmlSimpan;
        return a;
    }

    public static int ambil(int saldo, int jmlAmbil) {
        int b = saldo - jmlAmbil;
        return b;
    }

    public static void gantiPass(int a) {
        Scanner gantiPass = new Scanner(System.in);
        String pass, passBaru;
        cls();
        System.out.println("<<< Menu Ganti Password >>>");
        System.out.println("===========================");
        System.out.println("Untuk melanjutkan, konfirmasikan diri Anda terlebih dahulu");
        System.out.print("Masukkan Password Anda: ");
        pass = gantiPass.next();
        if (pass.equals(password[a])) {
            System.out.print("Masukkan password yang baru: ");
            passBaru = gantiPass.next();
            password[a] = passBaru;
            System.out.println("Password Anda telah berhasil diganti");
            System.out.println("Tekan enter untuk melanjutkan...");
            enter();
            programUtama(a);
        } else {
            System.out.println("Password yang Anda masukkan salah!");
            enter();
            programUtama(a);
        }
        gantiPass.close();
    }

    public static void gantiUsername(int a) {
        Scanner gantiUsername = new Scanner(System.in);
        String pass, usernameBaru;
        cls();
        System.out.println("<<< Menu Ganti Username >>>");
        System.out.println("===========================");
        System.out.println("Untuk melanjutkan, konfirmasikan diri Anda terlebih dahulu");
        System.out.print("Masukkan Password Anda: ");
        pass = gantiUsername.next();
        if (pass.equals(password[a])) {
            System.out.print("Masukkan username yang baru: ");
            usernameBaru = gantiUsername.next();
            for (int i = 0; i < username.length; i++) {
                if (i == a) {
                    continue;
                } else if (usernameBaru.equals(username[i])) {
                    System.out.println("================================================");
                    System.out.println("Maaf, Username yang Anda masukkan tidak tersedia");
                    enter();
                    programUtama(a);
                }
            }
            username[a] = usernameBaru;
            System.out.println("Username Anda telah berhasil diganti");
            System.out.println("Tekan enter untuk melanjutkan...");
            enter();
            programUtama(a);
        } else {
            System.out.println("Password yang Anda masukkan salah!");
            enter();
            programUtama(a);
        }
        gantiUsername.close();
    }
}