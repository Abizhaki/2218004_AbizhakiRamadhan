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
import Praktikum5.SKS;
/**
 *
 * @author LENOVO
 */
public class DataMatkul extends Matkul implements SKS_interface {
    @Override
    public String sks(String matkul) {
        String cetak = null;
        switch (matkul){
            case "IF1101" : cetak = "3"; break;
            case "IF1102" : cetak = "3"; break;
            case "IF1103" : cetak = "3"; break;
            case "IF1104" : cetak = "4"; break;
            case "IF2101" : cetak = "4"; break;
            case "IF2102" : cetak = "3"; break;
            case "IF2103" : cetak = "4"; break;
            case "IF2104" : cetak = "3"; break;
            case "IF3101" : cetak = "3"; break;
            case "IF3102" : cetak = "3"; break;
            case "IF3103" : cetak = "4"; break;
            case "IF3104" : cetak = "4"; break;
            case "IF4101" : cetak = "2"; break;
            case "IF4102" : cetak = "4"; break;
            case "IF4103" : cetak = "4"; break;
            case "IF4104" : cetak = "3"; break;
            case "IF5101" : cetak = "2"; break;
            case "IF5102" : cetak = "3"; break;
            case "IF5103" : cetak = "4"; break;
            case "IF5104" : cetak = "3"; break;
                     
        }
         
         return cetak;
     
    }
      
    @Override
    String dataMatkul( String mk) {
        String a = null;
        switch (mk) {
            case "IF1101" : a = "Pendidikan Agama Islam\t";break;
            case "IF1102" : a = "Pendidikan Agama Kristen\t";break;
            case "IF1103" : a = "Pendidikan Agama Katolik\t";break;
            case "IF1104" : a = "Algoritma dan Pemograman\t";break; 
            case "IF2101" : a = "Struktur Data\t";break;
            case "IF2102" : a = "Arsitektur Komputer\t";break;
            case "IF2103" : a = "Basis Data\t\t";break;    
            case "IF2104" : a = "Bahasa Indonesia\t";break;
            case "IF3101" : a = "Matematika Diskrit\t";break;
            case "IF3102" : a = "Riset Operasi\t\t";break;
            case "IF3103" : a = "Object Oriented Programming\t";break;
            case "IF3104" : a = "Pengolahan Citra Digital\t";break; 
            case "IF4101" : a = "Metode Numerik\t";break;
            case "IF4102" : a = "Pemrograman Visual\t";break;
            case "IF4103" : a = "Pemrograman Web\t";break;
            case "IF4104" : a = "Kecerdasan Buatan\t";break;  
            case "IF5101" : a = "Pendidikan Pancasila\t";break;
            case "IF5102" : a = "Pemodelan dan Simulasi\t";break;
            case "IF5103" : a = "Mobile Programming\t";break;
            case "IF5104" : a = "Grafika Komputer\t";break; 
        }
        return a ;
    }

    
}
