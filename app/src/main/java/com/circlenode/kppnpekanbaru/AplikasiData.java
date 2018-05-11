package com.circlenode.kppnpekanbaru;

import java.util.ArrayList;
import java.util.List;

public class AplikasiData {

    private static List<Aplikasi> aplikasiList = new ArrayList<>();
    public static List<Aplikasi> getAplikasiList(){
        aplikasiList.add(new Aplikasi("E-Rekon","http://www.google.com"));
        aplikasiList.add(new Aplikasi("Sprint","http://www.google.com"));
        aplikasiList.add(new Aplikasi("Sipandu","http://www.google.com"));
        aplikasiList.add(new Aplikasi("Wise","http://www.google.com"));
        aplikasiList.add(new Aplikasi("Omspan","http://www.google.com"));
        aplikasiList.add(new Aplikasi("Haidjpb","http://www.google.com"));
        aplikasiList.add(new Aplikasi("Simponi","http://www.google.com"));
        aplikasiList.add(new Aplikasi("Sse","http://www.google.com"));
        aplikasiList.add(new Aplikasi("Pengaduan","http://www.google.com"));
        aplikasiList.add(new Aplikasi("FAQ","http://www.google.com"));
        aplikasiList.add(new Aplikasi("Format Surat","http://www.google.com"));
        aplikasiList.add(new Aplikasi("Handbook","http://www.google.com"));
        aplikasiList.add(new Aplikasi("Sigap","http://www.google.com"));
        return aplikasiList;

    }

}
