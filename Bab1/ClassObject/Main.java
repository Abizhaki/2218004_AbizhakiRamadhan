/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab1.ClassObject;

/**
 *
 * @author Passwordnya Susah
 */
public class Main {
    public static void main(String[] args){
        Kendaraan mobil = new Kendaraan();
        mobil.nama = "Mobil";
        mobil.warna = "Merah";
        mobil.merk = "Toyota";
        System.out.println("Nama Kendaraan : "+mobil.nama);
        System.out.println("Warna Kendaraan : "+mobil.warna);
        System.out.println("Merk Kendaraan : "+mobil.merk);
        System.out.println("Jumlah Roda : "+mobil.jmlRoda(4)+"\n");
        System.out.println("Cara Kendaraan Bergerak: ");
        System.out.print("Saat Maju: ");
        mobil.kendaraanMaju();
        System.out.print("Saat Mundur : ");
        mobil.kendaraanMundur();
        System.out.print("Saat berhenti : "+mobil.nama);
        mobil.kendaraanBerhenti();     
    }
}
