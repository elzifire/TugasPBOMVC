package Model;

import DataData.DataJabatan;
import DataData.DataKaryawan;
import java.util.ArrayList;
import java.util.Date;


public class KaryawanModel{
    private ArrayList<DataKaryawan> karyawanEntityArrayList;
    
    public KaryawanModel() {
        karyawanEntityArrayList = new ArrayList<DataKaryawan>();
    }
    
    public DataKaryawan getProfileKaryawan(int index) {
        return karyawanEntityArrayList.get(index);
    }
    
    public ArrayList<DataKaryawan> getAllKaryawan() {
        return karyawanEntityArrayList;
    }
    
    public int cekKaryawan(String npk, String password) {
        int loop = 0;
        if (karyawanEntityArrayList.size() == 0) {
            loop = -1; // data kosong
        } else {
            for (int i = 0; i < karyawanEntityArrayList.size(); i++) {
                if (karyawanEntityArrayList.get(i).getNpk().equals(npk) &&
                        karyawanEntityArrayList.get(i).getPassword().equals(password)) {
                    loop = i;
                    break;
                } else if(!karyawanEntityArrayList.get(i).getNpk().equals(npk) &&
                            !karyawanEntityArrayList.get(i).getPassword().equals(password) &&
                                i < karyawanEntityArrayList.size()-1) {
                    continue;
                } else {
                    loop = -2;
                }
            }
        }
        return loop;
    }
    
    public void insertKaryawanModel(DataKaryawan karyawan) {
        karyawanEntityArrayList.add(karyawan);
    }
    
    public void editNpkKaryawanModel(int index, String data) {
        karyawanEntityArrayList.get(index).setNpk(data);
    }
    
    public void editNamaKaryawanModel(int index, String data) {
        karyawanEntityArrayList.get(index).setNama(data);
    }
    
    public void editNoTelpKaryawanModel(int index, String data) {
        karyawanEntityArrayList.get(index).setNo_telp(data);
    }
    
    public void editPasswordKaryawanModel(int index, String data) {
        karyawanEntityArrayList.get(index).setPassword(data);
    }
    
    public void editKaryawanModel(int index, Date data) {
        karyawanEntityArrayList.get(index).setTglLahir(data);
    }
    
    public void editKaryawanModel(int index, int data) {
        karyawanEntityArrayList.get(index).setIndex_jabatan(data);
    }
    
    public void hapusKaryawanModel(int index) {
        karyawanEntityArrayList.remove(karyawanEntityArrayList.get(index));
    }
}
