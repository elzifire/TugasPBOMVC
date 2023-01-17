package View;
import DataData.DataJabatan;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ProfileKaryawan {

    JFrame profileKry = new JFrame();
    JTextArea areaDataKry = new JTextArea();
    JButton Back,HapusKry, EditKry;;
    JLabel labelNamaMenu;
    int index_kry;

    public ProfileKaryawan() {
        profileKry.setSize(1038, 737);
        profileKry.setLayout(null);
        profileKry.getContentPane().setBackground(Color.decode("#A4EFB5"));
        profileKry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        profileKry.setVisible(true);
        profileKry.setLocationRelativeTo(null);

        labelNamaMenu = new JLabel("Data Karyawan");
        labelNamaMenu.setBounds(370, 40, 626, 50);
        labelNamaMenu.setFont(new Font("AlGERIAN", Font.BOLD, 25));
        profileKry.add(labelNamaMenu);

        areaDataKry.setBounds(140, 124, 700, 270);
        areaDataKry.setBackground(Color.cyan);
        profileKry.add(areaDataKry);

        Back = new JButton("Kembali");
        Back.setBounds(30, 650, 150, 30);
        Back.setBackground(Color.decode("#E8F923"));
        profileKry.add(Back);
        
       Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                profileKry.dispose();
                GUI menuUtama = new GUI();
            }
        });
        
        areaDataKry.setText(dataKry());
    }

    String dataKry() {
        String text = "Npk = " + Allobjctrl.karyawan.getDataKaryawan(index_kry).getNpk() + "\n"
                + "Nama = " + Allobjctrl.karyawan.getDataKaryawan(index_kry).getNama() + "\n"
                + "No Telp = " + Allobjctrl.karyawan.getDataKaryawan(index_kry).getNo_telp() + "\n"
                + "Tanggal Lahir = " + new SimpleDateFormat("dd-MM-yyyy").format(Allobjctrl.karyawan.getDataKaryawan(index_kry).getTglLahir()) + "\n"
                + "Password = " + Allobjctrl.karyawan.getDataKaryawan(index_kry).getPassword() + "\n"
                + "Jabatan = " + DataJabatan.jabatan[Allobjctrl.karyawan.getDataKaryawan(index_kry).getIndex_jabatan()] + (" ") + DataJabatan.gaji[Allobjctrl.karyawan.getDataKaryawan(index_kry).getIndex_jabatan()] + "\n";
        return text;
    }

    public void profileKry(int index_kry) {
        index_kry = index_kry;
    }
}
