package View;

import DataData.DataJabatan;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class UpdateKaryawan {

    JFrame updateKry = new JFrame();
    JLabel labelNpk, labelNama, labelPassword, labelNotelp, labelTglLahir, labelJabatan, labelNamaMenu;
    JTextField textNpk, textNama, textNotelp, textTglLahir;
    JButton Update, Back, EditNpm, EditNama, EditTglLahir, EditNotelp, EditPassword, EditJabatan;
    JPasswordField textPassword;
    JComboBox cbPilJabatan = new JComboBox(DataJabatan.jabatan);

    public UpdateKaryawan(int index_kry) {
        updateKry.setSize(1038, 737);
        updateKry.setLayout(null);
        updateKry.getContentPane().setBackground(Color.decode("#A9FC82"));
        updateKry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        updateKry.setVisible(true);
        updateKry.setLocationRelativeTo(null);

        labelNamaMenu = new JLabel("Edit Data Mahasiswa");
        labelNamaMenu.setBounds(300, 10, 600, 50);
        labelNamaMenu.setFont(new Font("ALGERIAN", Font.BOLD, 35));
        updateKry.add(labelNamaMenu);

        labelNpk = new JLabel("NPM");
        labelNpk.setBounds(400, 80, 150, 30);
        updateKry.add(labelNpk);

        textNpk = new JTextField();
        textNpk.setBounds(400, 110, 150, 30);
        updateKry.add(textNpk);

        EditNpm = new JButton("Edit");
        EditNpm.setBounds(560, 110, 55, 30);
        EditNpm.setBackground(Color.decode("#E5E5E5"));
        updateKry.add(EditNpm);

        labelNama = new JLabel("Nama");
        labelNama.setBounds(400, 140, 150, 30);
        updateKry.add(labelNama);

        textNama = new JTextField();
        textNama.setBounds(400, 170, 150, 30);
        updateKry.add(textNama);

        EditNama = new JButton("Edit");
        EditNama.setBounds(560, 170, 55, 30);
        EditNama.setBackground(Color.decode("#E5E5E5"));
        updateKry.add(EditNama);

        labelTglLahir = new JLabel("Tanggal Lahir (dd/MM/yyy)");
        labelTglLahir.setBounds(400, 200, 150, 30);
        updateKry.add(labelTglLahir);

        textTglLahir = new JTextField();
        textTglLahir.setBounds(400, 230, 150, 30);
        updateKry.add(textTglLahir);

        EditTglLahir = new JButton("Edit");
        EditTglLahir.setBounds(560, 230, 55, 30);
        EditTglLahir.setBackground(Color.decode("#E5E5E5"));
        updateKry.add(EditTglLahir);

        labelNotelp = new JLabel("No Telepon");
        labelNotelp.setBounds(400, 260, 150, 30);
        updateKry.add(labelNotelp);

        textNotelp = new JTextField();
        textNotelp.setBounds(400, 290, 150, 30);
        updateKry.add(textNotelp);

        EditNotelp = new JButton("Edit");
        EditNotelp.setBounds(560, 290, 55, 30);
        EditNotelp.setBackground(Color.decode("#E5E5E5"));
        updateKry.add(EditNotelp);

        labelPassword = new JLabel("Password");
        labelPassword.setBounds(400, 320, 150, 30);
        updateKry.add(labelPassword);

        textPassword = new JPasswordField();
        textPassword.setBounds(400, 350, 150, 30);
        updateKry.add(textPassword);

        EditPassword = new JButton("Edit");
        EditPassword.setBounds(560, 350, 55, 30);
        EditPassword.setBackground(Color.decode("#E5E5E5"));
        updateKry.add(EditPassword);

        labelJabatan = new JLabel("Jabatan");
        labelJabatan.setBounds(400, 380, 150, 30);
        updateKry.add(labelJabatan);

        cbPilJabatan.setBounds(400, 410, 150, 30);
        updateKry.add(cbPilJabatan);

        EditJabatan = new JButton("Edit");
        EditJabatan.setBounds(560, 410, 55, 30);
        EditJabatan.setBackground(Color.decode("#E5E5E5"));
        updateKry.add(EditJabatan);

        Update = new JButton("Update");
        Update.setBounds(450, 460, 100, 30);
        Update.setBackground(Color.decode("#E8F923"));
        updateKry.add(Update);
        
        Back = new JButton("Kembali");
        Back.setBounds(30, 650, 150, 30);
        Back.setBackground(Color.decode("#E8F923"));
        updateKry.add(Back);

        textNpk.setEnabled(true);
        textNama.setEnabled(true);
        textTglLahir.setEnabled(true);
        textNotelp.setEnabled(true);
        textPassword.setEnabled(true);
        cbPilJabatan.setEnabled(true);

        textNpk.setText(Allobjctrl.karyawan.getDataKaryawan(index_kry).getNpk());
        textNama.setText(Allobjctrl.karyawan.getDataKaryawan(index_kry).getNama());
        textTglLahir.setText(new SimpleDateFormat("dd/MM/yyy").format(Allobjctrl.karyawan.getDataKaryawan(index_kry).getTglLahir()));
        textNotelp.setText(Allobjctrl.karyawan.getDataKaryawan(index_kry).getNo_telp());
        textPassword.setText(Allobjctrl.karyawan.getDataKaryawan(index_kry).getPassword());
        cbPilJabatan.setSelectedIndex(Allobjctrl.karyawan.getDataKaryawan(index_kry).getIndex_jabatan());

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                updateKry.dispose();
                GUI menuUtama = new GUI();
            }
        });
        
       EditNpm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textNpk.setEnabled(true);
            }
        });

        EditNama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textNama.setEnabled(true);
            }
        });

        EditTglLahir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textTglLahir.setEnabled(true);
            }
        });
        
       EditPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textPassword.setEnabled(true);
            }
        });
        
        EditJabatan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cbPilJabatan.setEnabled(true);
            }
        });

        EditNotelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textNotelp.setEnabled(true);
            }
        });
        
        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if(textNpk.isEnabled()) {
                        Allobjctrl.karyawan.updateDataKaryawan(index_kry, textNpk.getText(), "npk", "string");
                    }
                    if(textNama.isEnabled()) {
                        Allobjctrl.karyawan.updateDataKaryawan(index_kry, textNama.getText(), "nama", "string");
                    }
                    if(textNotelp.isEnabled()) {
                        Allobjctrl.karyawan.updateDataKaryawan(index_kry, textNotelp.getText(), "notelp", "string");
                    }
                    if(textPassword.isEnabled()) {
                        Allobjctrl.karyawan.updateDataKaryawan(index_kry, textPassword.getText(), "password", "string");
                    }
                    if(textTglLahir.isEnabled()) {
                        Allobjctrl.karyawan.updateDataKaryawan(index_kry, textTglLahir.getText(), "tgllahir", "date");
                    }
                    if(cbPilJabatan.isEnabled()) {
                        Allobjctrl.karyawan.updateDataKaryawan(index_kry, String.valueOf(cbPilJabatan.getSelectedIndex()), "jabatan", "int");
                    }
                    JOptionPane.showMessageDialog(null, "Update Berhasil", "Information", JOptionPane.INFORMATION_MESSAGE);
                    updateKry.dispose();
                    GUI menuUtama = new GUI();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
