package View;
import DataData.DataJabatan;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class DaftarKaryawan {
    JFrame daftarKry = new JFrame();
    JLabel labelNpk, labelNama, labelPassword, labelNotelp, labelTglLahir, labelJabatan, labelNamaMenu;
    JTextField textNpk, textNama, textNotelp, textTglLahir;
    JButton Daftar, Back;
    JPasswordField textPassword;
    JComboBox cbPilJabatan = new JComboBox(DataJabatan.jabatan);
    public DaftarKaryawan() {
        daftarKry.setSize(1038, 737);
        daftarKry.setLayout(null);
        daftarKry.getContentPane().setBackground(Color.decode("#99FFAF"));
        daftarKry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        daftarKry.setVisible(true);
        daftarKry.setLocationRelativeTo(null);
        
        labelNamaMenu = new JLabel("Pendaftaran Karyawan");
        labelNamaMenu.setBounds(300, 10, 600, 50);
        labelNamaMenu.setFont(new Font("AlGERIAN", Font.BOLD, 35));
        daftarKry.add(labelNamaMenu);
        
        labelNpk = new JLabel("NPK");
        labelNpk.setBounds(450, 80, 150, 30);
        daftarKry.add(labelNpk);
        
        textNpk = new JTextField();
        textNpk.setBounds(450, 110, 150, 30);
        daftarKry.add(textNpk);
        
        labelNama = new JLabel("Nama");
        labelNama.setBounds(450, 140, 150, 30);
        daftarKry.add(labelNama);
        
        textNama = new JTextField();
        textNama.setBounds(450, 170, 150, 30);
        daftarKry.add(textNama);
        
        labelTglLahir = new JLabel("Tanggal Lahir (dd/MM/yyyy)");
        labelTglLahir.setBounds(450, 200, 160, 30);
        daftarKry.add(labelTglLahir);
        
        textTglLahir = new JTextField();
        textTglLahir.setBounds(450, 230, 150, 30);
        daftarKry.add(textTglLahir);
        
        labelNotelp = new JLabel("No Telepon");
        labelNotelp.setBounds(450, 260, 150, 30);
        daftarKry.add(labelNotelp);
        
        textNotelp = new JTextField();
        textNotelp.setBounds(450, 290, 150, 30);
        daftarKry.add(textNotelp);
        
        labelPassword = new JLabel("Password");
        labelPassword.setBounds(450, 320, 150, 30);
        daftarKry.add(labelPassword);
        
        textPassword = new JPasswordField();
        textPassword.setBounds(450, 350, 150, 30);
        daftarKry.add(textPassword);
        
        labelJabatan = new JLabel("Jabatan");
        labelJabatan.setBounds(450, 380, 150, 30);
        daftarKry.add(labelJabatan);
        
        cbPilJabatan.setBounds(450, 410, 150, 30);
        daftarKry.add(cbPilJabatan);
        
        Daftar = new JButton("Daftar");
        Daftar.setBounds(450, 460, 150, 30);
        Daftar.setBackground(Color.decode("#E8F923"));
        daftarKry.add(Daftar);
        
        Back = new JButton("Kembali");
        Back.setBounds(30, 650, 150, 30);
        Back.setBackground(Color.decode("#E8F923"));
        daftarKry.add(Back);
        
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                daftarKry.dispose();
                GUI menuUtama = new GUI();
            }
        });
        
        Daftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String npk = textNpk.getText();
                    String nama = textNama.getText();
                    Date tgllahir = new Date(textTglLahir.getText());
                    String notelp = textNotelp.getText();
                    String pass = textPassword.getText();
                    int indexJabatan = cbPilJabatan.getSelectedIndex();
                    Allobjctrl.karyawan.insertDataKaryawan(npk, nama, tgllahir, indexJabatan, notelp, pass);
                    JOptionPane.showMessageDialog(null, "Registrasi Berhasil", "Information", JOptionPane.INFORMATION_MESSAGE);
                    daftarKry.dispose();
                    GUI menuUtama = new GUI();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }
            }
        });
    }
    
    void kosong() {
        textNpk.setText(null);
        textNama.setText(null);
        textNotelp.setText(null);
        textTglLahir.setText(null);
        textPassword.setText(null);
        cbPilJabatan.setSelectedIndex(0);
    }
}