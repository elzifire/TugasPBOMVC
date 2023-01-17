package Controller;

import DataData.DataKaryawan;
import DataData.DataJabatan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class KaryawanController {
    int indexLogin;
    public DataKaryawan getDataKaryawan(int index) {
        return AllObjectModel.karyawan.getProfileKaryawan(index);
    }
    
    public int login(String npk, String password) {
        return AllObjectModel.karyawan.cekKaryawan(npk, password);
    }
    
    public DataKaryawan karyawanEntity(int index) {
        return AllObjectModel.karyawan.getProfileKaryawan(index);
    }
    
    public void insertDataKaryawan(String npk, String nama, Date tanggal_lahir, int index_jabatan, String no_telp, String password) {
        DataKaryawan karyawan = new DataKaryawan();
        karyawan.setNpk(npk);
        karyawan.setNama(nama);
        karyawan.setTglLahir(tanggal_lahir);
        karyawan.setIndex_jabatan(index_jabatan);
        karyawan.setNo_telp(no_telp);
        karyawan.setPassword(password);
        AllObjectModel.karyawan.insertKaryawanModel(karyawan);
    }
    
    public void deleteDataKaryawan(int index) {
        AllObjectModel.karyawan.hapusKaryawanModel(index);
    }
    
    public ArrayList<DataKaryawan> getDataKaryawan() {
        return AllObjectModel.karyawan.getAllKaryawan();
    }
    
    public void updateDataKaryawan(int index, String data, String ubah, String tipe) throws ParseException {
        switch(tipe) {
            case "string" :
                switch(ubah) {
                    case "Npk":
                        AllObjectModel.karyawan.editNpkKaryawanModel(index, data);
                        break;
                    case "Nama":
                        AllObjectModel.karyawan.editNamaKaryawanModel(index, data);
                        break;
                    case "NoTelp":
                        AllObjectModel.karyawan.editNoTelpKaryawanModel(index, data);
                        break;
                    case "Password":
                        AllObjectModel.karyawan.editPasswordKaryawanModel(index, data);
                        break;
                }
                break;
            case "date" :
                AllObjectModel.karyawan.editKaryawanModel(index, new SimpleDateFormat("dd/MM/yyyy").parse(data));
                break;
            case "int":
                AllObjectModel.karyawan.editKaryawanModel(index, Integer.parseInt(data));
                break;
        }
    }
    
    public DefaultTableModel dataTabelKry(){
        DefaultTableModel dtmKry = new DefaultTableModel();
        Object[] kolom = {"index", "NPK", "Nama", "Jabatan"};
        dtmKry.setColumnIdentifiers(kolom);
        int size = AllObjectModel.karyawan.getAllKaryawan().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[4];
            data[0] = String.valueOf(i);
            data[1] = AllObjectModel.karyawan.getAllKaryawan().get(i).getNpk();
            data[2] = AllObjectModel.karyawan.getAllKaryawan().get(i).getNama();
            data[3] = DataJabatan.jabatan[AllObjectModel.karyawan.getAllKaryawan().get(i).getIndex_jabatan()] + (". ") + DataJabatan.gaji[AllObjectModel.karyawan.getAllKaryawan().get(i).getIndex_jabatan()] ;
            dtmKry.addRow(data);
        }
        return dtmKry;
    }
}
