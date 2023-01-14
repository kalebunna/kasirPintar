package com.models;

public class Barang {
    private String NamaBarang;
    private int Harga, Stok;

    public String getNamaBarang() {
        return this.NamaBarang;
    }

    public void setNamaBarang(String NamaBarang) {
        this.NamaBarang = NamaBarang;
    }

    public int getHarga() {
        return this.Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }

    public int getStok() {
        return this.Stok;
    }

    public void setStok(int Stok) {
        this.Stok = Stok;
    }

}
