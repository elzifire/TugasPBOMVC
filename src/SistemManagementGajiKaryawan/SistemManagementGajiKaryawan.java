package SistemManagementGajiKaryawan;

import DataData.DataJabatan;
import DataData.DataKaryawan;
import Controller.KaryawanController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



import View.*;

public class SistemManagementGajiKaryawan {

    public KaryawanController karyawan = new KaryawanController();
    public Scanner input = new Scanner(System.in);
    public String npk, nama, no_telp, password, jawab;
    public Date tgl_lahir;
    public int pil, index_jabatan, index_kry;
    
    public static void main(String[] args) {
        GUI menuUtama = new GUI();
    }
}