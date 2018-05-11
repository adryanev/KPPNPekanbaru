package com.circlenode.kppnpekanbaru;

import java.util.ArrayList;
import java.util.List;

public class Aplikasi {
    public Aplikasi(String namaAplikasi, String urlAplikasi) {
        this.namaAplikasi = namaAplikasi;
        this.urlAplikasi = urlAplikasi;

    }
    private String namaAplikasi;
    private String urlAplikasi;

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




}
