package com.circlenode.kppnpekanbaru;

import java.util.ArrayList;
import java.util.List;

public class Aplikasi {

    public Aplikasi(String namaAplikasi, String urlAplikasi, String gambarAplikasi) {
        this.namaAplikasi = namaAplikasi;
        this.urlAplikasi = urlAplikasi;
        this.gambarAplikasi = gambarAplikasi;


    }
    private String namaAplikasi;
    private String urlAplikasi;
    private String gambarAplikasi;

    public String getNamaAplikasi() {
        return namaAplikasi;
    }

    public void setNamaAplikasi(String namaAplikasi) {
        this.namaAplikasi = namaAplikasi;
    }

    public String getUrlAplikasi() {
        return urlAplikasi;
    }

    public void setUrlAplikasi(String urlAplikasi) {
        this.urlAplikasi = urlAplikasi;
    }

    public String getGambarAplikasi() {
        return gambarAplikasi;
    }

    public void setGambarAplikasi(String gambarAplikasi) {
        this.gambarAplikasi = gambarAplikasi;
    }



}
