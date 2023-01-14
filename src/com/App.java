package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.controller.BarangController;
import com.controller.LaporanTransaksiController;
import com.controller.TransaksiController;
import com.models.Barang;
import com.models.Transaksi;

public class App {
    static Scanner input = new Scanner(System.in);
    public static final Locale locale = new Locale("in", "ID");

    public static void main(String[] args) throws Exception {
        List<Barang> listBarang = new ArrayList<Barang>();
        List<Transaksi> listTransaksi = new ArrayList<Transaksi>();

        do {
            System.out.println("=== KANTIN PINTAR UNIBA ===");
            System.out.println("[1] Data Barang");
            System.out.println("[2] Transaksi");
            System.out.println("[3] Laporan Transaksi");
            System.out.println("---------------------------");
            System.out.print("Pilih menu> ");

        } while (showMenu(listBarang, listTransaksi) != 0);

    }

    public static int showMenu(List<Barang> lBarangs, List<Transaksi> lTransaksis) {
        int selectedMenu = Utility.inputInt(input.nextLine());

        switch (selectedMenu) {
            case 1:
                // 2 buat folder controller kemudian bikin nama untuk controllernya
                // 3 bikin contructor
                new BarangController(lBarangs);
                break;

            case 2:
                // tambahkan class tranksaiCOntroller di dalam package controller
                new TransaksiController(lTransaksis, lBarangs);

            case 3:
                new LaporanTransaksiController(lTransaksis);
                break;
        }
        System.out.println();
        return selectedMenu;
    }
}
