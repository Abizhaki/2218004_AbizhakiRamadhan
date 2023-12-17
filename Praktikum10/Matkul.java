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

/**
 *
 * @author LENOVO
 */
public abstract class Matkul {
    abstract String dataMatkul( String mk);
    String dataMatkul (int sks){
         String matkul = null;
         if (sks == 2){
             matkul="Pendidikan Bahasa Inggris \n"+
                     "Pendidikan Pancasila \n"+
                     "Kalkulus \n"+
                     "Aljabar \n"+
                     "Probabilitas dan Statistik \n"+
                     "Rekayasa Perangkat Lunak";
         }else if(sks == 3){
             matkul="Pendidikan Agama \n"+
                    "Pendidikan Bahasa Indonesia \n"+
                    "Matematika Diskrit \n"+
                    "Teknik Pemograman \n"+
                    "Sistem Digital";
         }else if(sks == 4){
             matkul="Algoritma dan Pemograman \n"+
                    "Database \n"+
                    "Struktur Data \n"+
                    "Jaringan Komputer \n"+
                    "Pemograman Visual\n"+
                    "Pemograman Web";
         }
         return matkul;
     }
}
