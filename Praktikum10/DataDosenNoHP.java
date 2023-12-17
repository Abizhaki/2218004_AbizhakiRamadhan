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
public class DataDosenNoHP extends Data_Dosen2{
    @Override
    String DataDosen(String b) {
            String c = null;
        switch (b){
            case "IF1101" : c = "Pak Sentot "; break;
            case "IF1102" : c = "Pak Rudi "; break;
            case "IF1103" : c = "Pak Deddy "; break;
            case "IF1104" : c = "Pak Achmad ";break;
            case "IF2101" : c = "Pak Yoseph Agung ";break;
            case "IF2102" : c = "Bu Nurlaily ";break;
            case "IF2103" : c = "Pak Joseph ";break;
            case "IF2104" : c = "Pak Sujianto ";break;
            case "IF3101" : c = "Pak Ali ";break;
            case "IF3102" : c = "Pak Achmad ";break;
            case "IF3103" : c = "Pak Faisol ";break;
            case "IF3104" : c = "Pak Yoa ";break;
            case "IF4101" : c = "Pak Sentot ";break;
            case "IF4102" : c = "Bu Karina ";break;
            case "IF4103" : c = "Pak Renaldi";break;
            case "IF4104" : c = "Pak Deddy";break;
            case "IF5101" : c = "Pak Sentot ";break;
            case "IF5102" : c = "Pak Faisol ";break;
            case "IF5103" : c = "Pak Aldi ";break;
            case "IF5104" : c = "Bu Karina ";
            break;
        }
        return c;
    } 
    String DataNoHP(String a){
        String c = null;
        switch(a){
            case "IF1101" : c = "0831733435"; break;
            case "IF1102" : c = "0845247134"; break;
            case "IF1103" : c = "0845323123"; break;
            case "IF1104" : c = "0831234241";break;
            case "IF2101" : c = "0853424234";break;
            case "IF2102" : c = "0843123517";break;
            case "IF2103" : c = "0812351352";break;
            case "IF2104" : c = "0831243458";break;
            case "IF3101" : c = "0834135694";break;
            case "IF3102" : c = "0831234241";break;
            case "IF3103" : c = "0831243853";break;
            case "IF3104" : c = "0874567312";break;
            case "IF4101" : c = "0831733435";break;
            case "IF4102" : c = "083234274258";break;
            case "IF4103" : c = "084231423548";break;
            case "IF4104" : c = "0845323123";break;
            case "IF5101" : c = "0831733435";break;
            case "IF5102" : c = "0864534623";break;
            case "IF5103" : c = "0823413934";break;
            case "IF5104" : c = "083234274258";
            break;
        }
        return c;
    }
}
