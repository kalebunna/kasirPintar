package com.models;

public class Transaksi {
    private String NamaBarang;
    private int qty, Harga, Pembayaran;

    public String getNamaBarang() {
        return this.NamaBarang;
    }

    public void setNamaBarang(String NamaBarang) {
        this.NamaBarang = NamaBarang;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getHarga() {
        return this.Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }

    public int getPembayaran() {
        return this.Pembayaran;
    }

    public void setPembayaran(int Pembayaran) {
        this.Pembayaran = Pembayaran;
    }

}
