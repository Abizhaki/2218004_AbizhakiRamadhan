/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum10;

import Praktikum9.*;
import Praktikum8.*;
import Praktikum7.*;
import Praktikum6.*;
import Praktikum5.*;
import Praktikum4.*;

/**
 *
 * @author LENOVO
 */
public class DataMahasiswa {

    protected String nim, nama, fakultas, prodi, judul;
    
    private String setJudul(){
        judul = "DATA MAHASISWA";
        return judul;
    }
    public String getJudul(){
        return setJudul();
    }
    void setDataNim(String NIM) {
        this.nim = NIM;
    }

    void setDataNama(String NAMA) {
        this.nama = NAMA;
    }

    void setDataFakultas(String FAKULTAS) {
        this.fakultas = FAKULTAS;
    }

    void setDataProdi(String PRODI) {
        this.prodi = PRODI;
    }

    String getCetakNIM() {
        return nim;
    }

    String getCetakNama() {
        return nama;
    }

    String getCetakFakultas() {
        return fakultas;
    }

    String getCetakProdi() {
        return prodi;
    }
}
