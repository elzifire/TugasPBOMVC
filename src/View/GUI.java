package View;

import Controller.KaryawanController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.*;

public class GUI {

    KaryawanController karyawan = new KaryawanController();
    JFrame menuUtama = new JFrame();
    JButton DaftarKry, LoginKry, HapusKry, EditKry;
    JTextField textUbahData;
    JLabel labelNamaAplikasi, labelUbahData;
    JTable tabelKry = new JTable();
    JScrollPane scrollTabelKry = new JScrollPane(tabelKry);

    public GUI() {
        menuUtama.setSize(800, 380);
        menuUtama.setLayout(null);
        menuUtama.getContentPane().setBackground(Color.decode("#ABC175"));
        menuUtama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuUtama.setVisible(true);
        menuUtama.setLocationRelativeTo(null);

        labelNamaAplikasi = new JLabel("Aplikasi Gaji Karyawan");
        labelNamaAplikasi.setBounds(40, 30, 1000, 50);
        labelNamaAplikasi.setFont(new Font("AlGERIAN", Font.BOLD, 36));
        menuUtama.add(labelNamaAplikasi);

        LoginKry = new JButton("Masuk");
        LoginKry.setBounds(30, 70, 140, 30);
        LoginKry.setBackground(Color.decode("#3ebce6"));
        menuUtama.add(LoginKry);
        
        DaftarKry = new JButton("Daftar");
        DaftarKry.setBounds(180, 70, 140, 30);
        DaftarKry.setBackground(Color.decode("#0a6685"));
        menuUtama.add(DaftarKry);

        scrollTabelKry.setBounds(30, 110, 570, 200);
        tabelKry.setModel(karyawan.dataTabelKry());
        menuUtama.add(scrollTabelKry);

        labelUbahData = new JLabel("Ubah Data Karyawan");
        labelUbahData.setBounds(620, 105, 130, 30);
        menuUtama.add(labelUbahData);

        textUbahData = new JTextField("Index");
        textUbahData.setBounds(620, 135, 60, 30);
        menuUtama.add(textUbahData);

        EditKry = new JButton("Edit");
        EditKry.setBounds(620, 175, 70, 30);
        EditKry.setBackground(Color.decode("#E8F923"));
        menuUtama.add(EditKry);

        HapusKry = new JButton("Hapus");
        HapusKry.setBounds(685, 175, 70, 30);
        HapusKry.setBackground(Color.decode("#c4302b"));
        menuUtama.add(HapusKry);

        LoginKry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuUtama.dispose();
                LoginKaryawan loginKaryawan = new LoginKaryawan();
            }
        });
        
        DaftarKry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuUtama.dispose();
                DaftarKaryawan daftarMahasiswa = new DaftarKaryawan();
            }
        });

        textUbahData.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textUbahData.setText(null);
            }

            @Override
            public void focusLost(FocusEvent fe) {
            }
        });

        EditKry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (Allobjctrl.karyawan.getDataKaryawan().size() == 0) {
                    JOptionPane.showMessageDialog(null, "Data Masih Kosong", "Information", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    menuUtama.dispose();
                    int index_kry = Integer.parseInt(textUbahData.getText());
                    UpdateKaryawan updateKaryawan = new UpdateKaryawan(index_kry);
                }

            }
        });

        HapusKry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (Allobjctrl.karyawan.getDataKaryawan().size() == 0) {
                    JOptionPane.showMessageDialog(null, "Data Masih Kosong", "Information", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int index_kry = Integer.parseInt(textUbahData.getText());
                    int result = JOptionPane.showConfirmDialog(menuUtama, "apakah anda yakin untuk menghapus ?", "Swing Tester",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (result == JOptionPane.YES_OPTION) {
                        Allobjctrl.karyawan.deleteDataKaryawan(index_kry);
                        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus", "Information", JOptionPane.INFORMATION_MESSAGE);
                        tabelKry.setModel(karyawan.dataTabelKry());
                        textUbahData.setText(null);
                    }
                }

            }
        });

        tabelKry.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelKry.getSelectedRow();
                textUbahData.setText(Allobjctrl.karyawan.dataTabelKry().getValueAt(i, 0).toString());
            }
        });
    }
}
