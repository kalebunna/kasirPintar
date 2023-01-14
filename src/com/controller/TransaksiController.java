package com.controller;

import java.util.List;
import java.util.Scanner;

import com.Utility;
import com.models.Barang;
import com.models.Transaksi;

public class TransaksiController {
    private List<Transaksi> listTransaksi;
    private List<Barang> listBarang;
    Scanner input = new Scanner(System.in);

    public TransaksiController(List<Transaksi> listTransaksi, List<Barang> listBarang) {
        this.listTransaksi = listTransaksi;
        this.listBarang = listBarang;
        showBarang();
        store();
    }

    void showBarang() {
        System.out.println(
                "______________________________________________________________________________");
        System.out.println(
                "| NO |     Nama Barang     |          Harga          |          Stok         |");
        System.out.println(
                "===============================================================================");
        int i = 1;
        for (Barang barang : listBarang) {
            System.out.printf("|%-4s|%-21s|%-25s|%-23s| %n", i++, barang.getNamaBarang(),
                    Utility.toRupiah(barang.getHarga()),
                    barang.getStok());
        }
    }

    void store() {
        String inputan = "Y";
        do {

            System.out.println("\n~Ketik 0 kembali ke menu utama-");
            System.out.print("Input No :");
            int lokasiBarang = Utility.inputInt(input.nextLine());
            if (lokasiBarang > 0 && --lokasiBarang < listBarang.size()) {

                System.out.print("Jumlah : ");
                int jumlah = Utility.inputInt(input.nextLine());
                int stok = listBarang.get(lokasiBarang).getStok();
                System.out.println("Metode Pembayaran yang Tersedia");
                System.out.println("[1] Visa/Master");
                System.out.println("[2] Debit");
                System.out.println("[3] Cash");
                System.out.println("-------------------------------");
                System.out.print("Pilihan> ");
                int pilihan = Utility.inputInt(input.nextLine());

                if (jumlah <= stok) {

                    listBarang.get(lokasiBarang).setStok(stok -= jumlah);

                    String namaBarang = listBarang.get(lokasiBarang).getNamaBarang();
                    int Harga = listBarang.get(lokasiBarang).getHarga();

                    System.out
                            .println("-------------------------------------------------------------------------------");
                    System.out.printf("Nama Barang |%-21s|Harga  |%-25s|Stok|%-23s| %n",
                            namaBarang,
                            Utility.toRupiah(Harga),
                            listBarang.get(lokasiBarang).getStok());
                    System.out
                            .println("-------------------------------------------------------------------------------");
                    int total = jumlah * Harga;
                    System.out.println("total : " + Utility.toRupiah(jumlah * Harga));

                    switch (pilihan) {
                        case 1:
                            int visa = total * 15 / 100;
                            System.out.println(
                                    "Metode Pembayaran Visa/Master \nBiaya Transaksi : " + Utility.toRupiah(visa));
                            System.out.println("Total Pembayaran : " + Utility.toRupiah(visa + total));
                            break;
                        case 2:
                            int debit = total * 3 / 100;
                            System.out.println(
                                    "Metode Pembayaran Debit \nBiaya Transaksi : " + Utility.toRupiah(debit));
                            System.out.println("Total Pembayaran : " + Utility.toRupiah(debit + total));
                            break;
                        case 3:
                            System.out.println("Metode Pembayaran Cash" + total);
                            break;
                        default:
                            break;
                    }
                    Transaksi transaksi = new Transaksi();
                    transaksi.setNamaBarang(namaBarang);
                    transaksi.setQty(jumlah);
                    transaksi.setHarga(Harga);
                    listTransaksi.add(transaksi);

                    System.out.println("Pembelian Berhasil");
                } else {
                    System.out.println("Jumlah Pembelian Melebihi Stok");
                }
            }

            System.out.println("apakah ingin melanjutkan transaksi (Y/N) ? ");
            inputan = input.nextLine();

        } while (inputan.equalsIgnoreCase("y"));
    }

}
