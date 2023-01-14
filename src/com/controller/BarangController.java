package com.controller;

import java.util.List;
import java.util.Scanner;

import com.Utility;
import com.models.Barang;

public class BarangController {
    private List<Barang> listbarang;
    static Scanner input = new Scanner(System.in);

    public BarangController(List<Barang> listbarang) {
        this.listbarang = listbarang;
        menuBarang();
    }

    void menuBarang() {
        int pilih = 0;
        do {
            show();
            System.out.println("[1] Input Barang");
            System.out.println("[2] Update Barang");
            System.out.println("[3] Hapus Barang");
            System.out.println("[0] Halaman Utama");
            System.out.println("------------------");
            System.out.print("Pilih Menu> ");
            pilih = Utility.inputInt(input.nextLine());

            switch (pilih) {
                case 0:
                    System.out.println("");
                    break;
                case 1:
                    store();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    destroy();
                    break;
                default:
                    break;
            }
        } while (pilih != 0);
    }

    void show() {
        System.out.println(
                "______________________________________________________________________________");
        System.out.println(
                "| NO |     Nama Barang     |          Harga          |          Stok         |");
        System.out.println(
                "===============================================================================");
        int i = 1;
        for (Barang barang : listbarang) {
            System.out.printf("|%-4s|%-21s|%-25s|%-23s| %n", i++, barang.getNamaBarang(),
                    Utility.toRupiah(barang.getHarga()),
                    barang.getStok());
        }
    }

    void store() {
        show();
        Barang b = new Barang();
        System.out.print("Masukkan Nama Barang : ");
        b.setNamaBarang(input.nextLine());
        System.out.print("Masukkan Harga : ");
        b.setHarga(Utility.inputInt(input.nextLine()));
        System.out.print("Masukkan Stok Barang : ");
        b.setStok(Utility.inputInt(input.nextLine()));
        listbarang.add(b);
    }

    void update() {
        show();
        System.out.println("======Ubah Data Barang======");
        System.out.println("~Kosongkan Data Jika Tidak Ingin Dirubah~");
        System.out.println("~Ketik 0 kembali ke menu utama-");
        System.out.print("Pilih NO : ");
        int inputan = Utility.inputInt(input.nextLine());
        if (inputan > 0 && --inputan < listbarang.size()) {
            System.out.print("Masukkan nama : ");
            String nama = input.nextLine();

            if (!nama.equals("")) {
                listbarang.get(inputan).setNamaBarang(nama);
            }

            System.out.print("Masukkan Harga : ");
            int harga = Utility.inputInt(input.nextLine());

            if (harga >= 0) {
                listbarang.get(inputan).setHarga(harga);
            }

            System.out.print("Masukkan Stok : ");
            int stok = Utility.inputInt(input.nextLine());
            if (stok >= 0) {
                listbarang.get(inputan).setStok(stok);
            }
        }
    }

    void destroy() {
        show();
        System.out.print("Masukkan No> ");
        int inputan = Utility.inputInt(input.nextLine());

        if (inputan > 0 && --inputan < listbarang.size()) {
            listbarang.remove(inputan);
            System.out.println("\n Data Berhasil Dihapus \n");
        }
    }

}
