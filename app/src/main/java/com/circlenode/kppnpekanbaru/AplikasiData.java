package com.circlenode.kppnpekanbaru;

import java.util.ArrayList;
import java.util.List;

public class AplikasiData {

    private static List<Aplikasi> aplikasiList = new ArrayList<>();
    public static List<Aplikasi> getAplikasiList(){
        aplikasiList.add(new Aplikasi("E-Rekon","http://e-rekon-lk.djpbn.kemenkeu.go.id/login","e_rekon"));
        aplikasiList.add(new Aplikasi("Sprint","http://sprint.kemenkeu.go.id/","sprint"));
        aplikasiList.add(new Aplikasi("Omspan","http://spanint.kemenkeu.go.id/","omspan"));
        aplikasiList.add(new Aplikasi("Haidjpb","https://hai.djpbn.kemenkeu.go.id/","hai_djpbn"));
        aplikasiList.add(new Aplikasi("Simponi","https://simponi.kemenkeu.go.id/index.php/welcome/login","simponi"));
        aplikasiList.add(new Aplikasi("Sse","https://sse3.pajak.go.id/","sse"));
        aplikasiList.add(new Aplikasi("Pengaduan","http://karir-suska.org/pengaduan/","pengaduan"));
        aplikasiList.add(new Aplikasi("FAQ","http://www.google.com","faq"));
        aplikasiList.add(new Aplikasi("Format Surat","https://www.kppn-pku008.com/session/index","format_surat"));
        aplikasiList.add(new Aplikasi("Handbook","https://www.kppn-pku008.com/session/handbook","handbook"));
        aplikasiList.add(new Aplikasi("SIKAPKU","com.circlenode.adryanekavandra.kppn","sikapku"));
        return aplikasiList;

    }

}
