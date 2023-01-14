package com.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.Utility;
import com.models.Transaksi;

public class LaporanTransaksiController {
    private List<Transaksi> listTransaksi;

    public LaporanTransaksiController(List<Transaksi> listTransaksi) {
        this.listTransaksi = listTransaksi;
        showData();
    }

    void showData() {
        System.out.println(
                "__________________________________________________________________________________________");
        System.out.println(
                "| NO |     Nama Barang     |   QTY    |          Harga          |          Total         |");
        System.out.println(
                "==========================================================================================");
        int i = 1;
        for (Transaksi transaksi : listTransaksi) {
            System.out.printf("|%-4s|%-21s|%-10s|%-25s|%-24s| %n",
                    i++,
                    transaksi.getNamaBarang(),
                    transaksi.getQty(),
                    Utility.toRupiah(transaksi.getHarga()),
                    Utility.toRupiah(transaksi.getHarga() * transaksi.getQty()));
        }
        System.out.println(
                "__________________________________________________________________________________________");
    }
}
