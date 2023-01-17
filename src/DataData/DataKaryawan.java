package DataData;

import java.util.Date;


public class DataKaryawan extends Profile{
    private String npk, password, no_telp;
    private int index_jabatan;

   
    public DataKaryawan() {
        
    }
    
    @Override
    public Date getTglLahir() {
        return tglLahir;
    }
    
    @Override
    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getNpk() {
        return npk;
    }

    public void setNpk(String npk) {
        this.npk = npk;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIndex_jabatan() {
        return index_jabatan;
    }

    public void setIndex_jabatan(int index_jabatan) {
        this.index_jabatan = index_jabatan;
    }
}
