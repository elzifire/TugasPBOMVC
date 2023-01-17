package DataData;

import java.util.Date;


public class Profile {
    protected String nama;
    protected Date tglLahir;

    public Profile(String nama, Date tgl_lahir) {
        this.nama = nama;
        this.tglLahir = tgl_lahir;
    }
    
    public Profile() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }
}
