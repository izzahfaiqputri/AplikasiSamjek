// Farah Meytha Aisha 235150200111030
// Gladys Abel Veneta George 235150201111038
// Izzah Faiq Putri Madani 235150201111039

import java.util.Scanner;

public class AplikasiSamjek {
    private static int banyakSaldo = 0;
    private static double cashback = 0.02;


    public static void topUpSaldo(){
        Scanner inp = new Scanner(System.in);
        System.out.println("=============================");
        System.out.printf("   %-8s    |    %-8s\n", "10.000","50.000" );
        System.out.println("-----------------------------");
        System.out.printf("   %-8s    |    %-8s\n", "100.000","200.000" );
        System.out.println("=============================");
        System.out.printf("   %-8s    |  %-8s\n", "500.000","ISI SENDIRI" );
        System.out.println("=============================");
        System.out.print("Masukkan nominal: ");
        String nominal = inp.nextLine();
        if (nominal.equals("10.000") || nominal.equals("10000")){
            banyakSaldo += 10000;
            System.out.println("BERHASIL TOP UP Rp10.000!");
        } else if (nominal.equals("50.000") || nominal.equals("50000")) {
            banyakSaldo += 50000;
            System.out.println("BERHASIL TOP UP Rp50.000!");
        } else if (nominal.equals("100.000") || nominal.equals("100000")) {
            banyakSaldo += 100000;
            System.out.println("BERHASIL TOP UP Rp100.000!");
        } else if (nominal.equals("200.000") || nominal.equals("200000")) {
            banyakSaldo += 200000;
            System.out.println("BERHASIL TOP UP Rp200.000!");
        } else if (nominal.equals("500.000") || nominal.equals("500000")) {
            banyakSaldo += 500000;
            System.out.println("BERHASIL TOP UP Rp500.000!");
        }else {
            nominal = nominal.replace(".","");
            int convert = Integer.parseInt(nominal);
            banyakSaldo += convert;
            System.out.printf("BERHASIL TOP UP %d!", convert);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        boolean a = true;
        Scanner inp = new Scanner(System.in);
        while (a){
            System.out.println("0. Tidak Jadi");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Naik Ojek");
            System.out.println("3. Kirim Barang");
            System.out.println("4. Pesan Makanan");
            System.out.print("Masukkan nomor: ");
            int pilih = inp.nextInt();
            switch (pilih) {
                case 1:
                    saldo();
                    break;
                case 2:
                    costperjalanan();
                    break;
                case 3:
                    costbarang();
                    break;
                case 4:
                    makanan();
                    break;
                case 0:
                    System.out.println("Sampai Jumpa!");
                    return;
            }
        }
    }
    public static void costperjalanan() {
        int harga = 0;
        Scanner inp = new Scanner(System.in);
        boolean ada = true;
        String kendaraan = null;
        while (ada) {
            System.out.print("Anda ingin menggunakan apa (Mobil / Motor)? ");
            kendaraan = inp.nextLine();
            if (kendaraan.equalsIgnoreCase("mobil") || kendaraan.equalsIgnoreCase("motor")) {
                ada = false;
            } else {
                System.out.println("Masukkan kendaraan yang sesuai!");
            }
        }
        System.out.print("Berapa jarak tempuh perjalanan anda(km)? ");
        int jarak = inp.nextInt();
        if (kendaraan.equals("mobil")) {
            if (jarak > 10) {
                harga = jarak * 15000;
            } else if (jarak > 5) {
                harga = 65000;
            } else if (jarak > 2) {
                harga = 40000;
            } else {
                harga = 25000;
            }
        } else if (kendaraan.equals("motor")) {
            if (jarak > 10) {
                harga = jarak * 8000;
            } else if (jarak > 5) {
                harga = 30000;
            } else if (jarak > 2) {
                harga = 20000;
            } else {
                harga = 15000;
            }
        }
        double diskon = 0;
        String persenDiskon = null;
        String bayar = null;
        inp.nextLine();
        while (!ada) {
            System.out.print("Anda ingin membayar menggunakan apa(SamPay / OVA / Cash)? ");
            bayar = inp.nextLine().toLowerCase();
            switch (bayar) {
                case "sampay":
                    diskon = 0.1;
                    persenDiskon = "10%";
                    ada = true;
                    break;
                case "ova":
                    diskon = 0.05;
                    persenDiskon = "5%";
                    ada = true;
                    break;
                case "cash":
                    diskon = 0;
                    persenDiskon = "-";
                    ada = true;
                    break;
                default:
                    System.out.println("Masukkan metode pembayaran yang sesuai!");
            }
        }
        double hargaDiskon = harga * diskon;
        int tarif = harga - (int) hargaDiskon;
        if (tarif > 50000){
            tarif -= (int) (tarif * cashback);
        }

        System.out.println("=================================");
        System.out.printf("%22s\n", "STRUK SAMJEK");
        System.out.printf("%-15s %17s\n", "JENIS", "GO-RIDE");
        System.out.printf("%-15s %17s\n", "KENDARAAN", kendaraan.toUpperCase());
        System.out.printf("%-15s %17s\n", "BIAYA", "Rp" + harga);
        System.out.printf("%-15s %15s\n", "METODE PEMBAYARAN", bayar.toUpperCase());
        System.out.printf("%-15s %17s\n", "DISKON", persenDiskon);
        System.out.printf("%-15s %17s\n", "TOTAL BIAYA", "Rp" + tarif);
        System.out.println("---------------------------------");
        System.out.printf("%13s %14s\n", "1. KEMBALI", "2. BAYAR");
        System.out.println("---------------------------------");

        int pembayaran = inp.nextInt();
        if (pembayaran == 1) {
            return;
        } else if (pembayaran == 2) {
            if (bayar.equalsIgnoreCase("cash")){
                System.out.println("PEMBAYARAN BERHASIL!");
            }else {
                if (tarif<=banyakSaldo){
                    System.out.println("PEMBAYARAN BERHASIL!");
                    banyakSaldo -= tarif;
                }
                else {
                    System.out.println("SALDO TIDAK CUKUP!");
                    System.out.println("\nApakah anda ingin melakukan top up?");
                    System.out.println("1. Tidak");
                    System.out.println("2. Ya");
                    System.out.print("Pilih: ");
                    int pilih = inp.nextInt();
                    switch (pilih){
                        case 1:
                            return;
                        case 2:
                            topUpSaldo();
                            return;
                    }
                }
            }
        }
        System.out.println();
    }
    public static void costbarang(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan jarak: ");
        int jarak1 = inp.nextInt();
        System.out.print("Masukkan berat: ");
        int berat = inp.nextInt();
        int biaya = jarak1 * berat * 1000;

        double diskon = 0;
        String persenDiskon = null;
        String bayar = null;
        inp.nextLine();
        boolean ada= false;
        while (!ada) {
            System.out.print("Anda ingin membayar menggunakan apa(SamPay / OVA / Cash)? ");
            bayar = inp.nextLine().toLowerCase();
            switch (bayar) {
                case "sampay":
                    diskon = 0.1;
                    persenDiskon = "10%";
                    ada = true;
                    break;
                case "ova":
                    diskon = 0.05;
                    persenDiskon = "5%";
                    ada = true;
                    break;
                case "cash":
                    diskon = 0;
                    persenDiskon = "-";
                    ada = true;
                    break;
                default:
                    System.out.println("Masukkan metode pembayaran yang sesuai!");
            }
        }
        double hargaDiskon = biaya * diskon;
        int tarif = (int) biaya - (int) hargaDiskon;
        if (tarif > 50000){
            tarif -= (int) (tarif * cashback);
        }
        System.out.println("=================================");
        System.out.printf("%22s\n", "STRUK SAMJEK");
        System.out.printf("%-15s %17s\n", "JENIS", "GO-SEND");
        System.out.printf("%-15s %17s\n", "BERAT", berat+ " KG");
        System.out.printf("%-15s %17s\n", "JARAK", jarak1+ " KM");
        System.out.printf("%-15s %17s\n", "BIAYA", "Rp" + biaya);
        System.out.printf("%-15s %15s\n", "METODE PEMBAYARAN", bayar.toUpperCase());
        System.out.printf("%-15s %17s\n", "DISKON", persenDiskon);
        System.out.printf("%-15s %17s\n", "TOTAL BIAYA", "Rp" + tarif);
        System.out.println("---------------------------------");
        System.out.printf("%13s %14s\n", "1. KEMBALI", "2. BAYAR");
        System.out.println("---------------------------------");
        int pembayaran = inp.nextInt();
        if (pembayaran == 1) {
            return;
        } else if (pembayaran == 2) {
            if (bayar.equalsIgnoreCase("cash")){
                System.out.println("PEMBAYARAN BERHASIL!");
            }else {
                if (tarif<=banyakSaldo){
                    System.out.println("PEMBAYARAN BERHASIL!");
                    banyakSaldo -= tarif;
                }
                else {
                    System.out.println("SALDO TIDAK CUKUP!");
                    System.out.println("\nApakah anda ingin melakukan top up?");
                    System.out.println("1. Tidak");
                    System.out.println("2. Ya");
                    System.out.print("Pilih: ");
                    int pilih = inp.nextInt();
                    switch (pilih){
                        case 1:
                            return;
                        case 2:
                            topUpSaldo();
                            return;
                    }
                }
            }
        }
        System.out.println();
    }
    public static void makanan() {
        String jenis[] = {"Mie Gacoan", "Seblak", "Nasi Goreng", "Nasi goreng spesial", "Batagor"};
        int harga[] = {10000, 12000, 10000, 15000, 5000};
        int biaya = 0;
        boolean lanjut = true;
        Scanner inp = new Scanner(System.in);
        System.out.printf("%-20s | %10s |\n", "JENIS", "HARGA");
        System.out.println("===================================");
        System.out.printf("%-20s | %10d |\n", jenis[0], harga[0]);
        System.out.println("-----------------------------------");
        System.out.printf("%-20s | %10d |\n", jenis[1], harga[1]);
        System.out.println("-----------------------------------");
        System.out.printf("%-20s | %10d |\n", jenis[2], harga[2]);
        System.out.println("-----------------------------------");
        System.out.printf("%-20s | %10d |\n", jenis[3], harga[3]);
        System.out.println("-----------------------------------");
        System.out.printf("%-20s | %10d |\n", jenis[4], harga[4]);
        System.out.println("-----------------------------------");
        int count = 0;
        while (lanjut) {
            System.out.print("Masukkan pesanan (Ketik 'selesai' untuk mengakhiri): ");
            String pesanan = inp.nextLine();
            if (pesanan.equalsIgnoreCase("selesai")) {
                lanjut = false;
            } else {
                switch (pesanan.toLowerCase()) {
                    case "mie gacoan":
                    case "nasi goreng":
                        biaya += harga[0];
                        count += 1;
                        break;
                    case "seblak":
                        biaya += harga[1];
                        count += 1;
                        break;
                    case "nasi goreng spesial":
                        biaya += harga[3];
                        count += 1;
                        break;
                    case "batagor":
                        biaya += harga[4];
                        count += 1;
                        break;
                    default:
                        System.out.println("Masukkan menu yang valid!");
                }
                System.out.println("Biaya saat ini " + biaya);
            }
        }
        double diskon = 0;
        String persenDiskon = null;
        String bayar = null;
        boolean ada = false;
        while (!ada) {
            System.out.print("Anda ingin membayar menggunakan apa(SamPay / OVA / Cash)? ");
            bayar = inp.nextLine().toLowerCase();
            switch (bayar) {
                case "sampay":
                    diskon = 0.1;
                    persenDiskon = "10%";
                    ada = true;
                    break;
                case "ova":
                    diskon = 0.05;
                    persenDiskon = "5%";
                    ada = true;
                    break;
                case "cash":
                    diskon = 0;
                    persenDiskon = "-";
                    ada = true;
                    break;
                default:
                    System.out.println("Masukkan metode pembayaran yang sesuai!");
            }
        }
        double hargaDiskon = biaya * diskon;
        int tarif = (int) biaya - (int) hargaDiskon;
        if (tarif > 50000){
            tarif -= (int) (tarif * cashback);
        }
        System.out.println("=================================");
        System.out.printf("%22s\n", "STRUK SAMJEK");
        System.out.printf("%-15s %17s\n", "JENIS", "GO-FOOD");
        System.out.printf("%-15s %17d\n", "TOTAL MAKANAN", count);
        System.out.printf("%-15s %17s\n", "BIAYA", "Rp" + biaya);
        System.out.printf("%-15s %15s\n", "METODE PEMBAYARAN", bayar.toUpperCase());
        System.out.printf("%-15s %17s\n", "DISKON", persenDiskon);
        System.out.printf("%-15s %17s\n", "TOTAL BIAYA", "Rp" + tarif);
        System.out.println("---------------------------------");
        System.out.printf("%13s %14s\n", "1. KEMBALI", "2. BAYAR");
        System.out.println("---------------------------------");
        int pembayaran = inp.nextInt();
        if (pembayaran == 1) {
            return;
        } else if (pembayaran == 2) {
            if (bayar.equalsIgnoreCase("cash")){
                System.out.println("PEMBAYARAN BERHASIL!");
            }else {
                if (tarif<=banyakSaldo){
                    System.out.println("PEMBAYARAN BERHASIL!");
                    banyakSaldo -= tarif;
                }
                else {
                    System.out.println("SALDO TIDAK CUKUP!");
                    System.out.println("\nApakah anda ingin melakukan top up?");
                    System.out.println("1. Tidak");
                    System.out.println("2. Ya");
                    System.out.print("Pilih: ");
                    int pilih = inp.nextInt();
                    switch (pilih){
                        case 1:
                            return;
                        case 2:
                            topUpSaldo();
                            return;
                    }
                }
            }
        }
        System.out.println();
    }
    public static void saldo(){
        Scanner inp = new Scanner(System.in);
        System.out.println("====================");
        System.out.printf("%s = Rp%d\n", "SALDO", banyakSaldo);
        System.out.println("====================");
        System.out.printf("|     %-15s|      %-15s|\n", "0. KEMBALI", "1. TOP UP");
        for (int i=0; ;i++) {
            System.out.print("Pilih angka: ");
            int pilih = inp.nextInt();
            switch (pilih) {
                case 0:
                    return;
                case 1:
                    topUpSaldo();
                    return;
                default:
                    System.out.println("Masukkan angka yang sesuai!");
            }
        }
    }
}