package View;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class LoginKaryawan {

    JFrame loginKry = new JFrame();
    JButton LoginKry, Back;
    JLabel labelNamaMenu, labelNpk, labelPassword;
    JTextField textNpk, textPassword;

    public LoginKaryawan() {
        loginKry.setSize(1038, 737);
        loginKry.setLayout(null);
        loginKry.getContentPane().setBackground(Color.decode("#99FFAF"));
        loginKry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginKry.setVisible(true);
        loginKry.setLocationRelativeTo(null);

        labelNamaMenu = new JLabel("Login");
        labelNamaMenu.setBounds(480, 80, 100, 100);
        labelNamaMenu.setFont(new Font("AlGERIAN", Font.BOLD, 28));
        loginKry.add(labelNamaMenu);

        labelNpk = new JLabel("NPM");
        labelNpk.setBounds(430,180,50,30);
        loginKry.add(labelNpk);

        textNpk = new JTextField();
        textNpk.setBounds(430, 210, 200, 30);
        loginKry.add(textNpk);

        labelPassword = new JLabel("Password");
        labelPassword.setBounds(430, 236, 150, 30);
        loginKry.add(labelPassword);

        textPassword = new JTextField();
        textPassword.setBounds(430, 266, 200, 30);
        loginKry.add(textPassword);

        LoginKry = new JButton("Sig in");
        LoginKry.setBounds(430, 300, 150, 30);
        LoginKry.setBackground(Color.decode("#E8F923"));
        loginKry.add(LoginKry);

        Back = new JButton("Kembali");
        Back.setBounds(30, 660, 150, 30);
        Back.setBackground(Color.decode("#E8F923"));
        loginKry.add(Back);

       LoginKry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int index_kry = Allobjctrl.karyawan.login(textNpk.getText(), textPassword.getText());
                if (index_kry == -1) {
                    JOptionPane.showMessageDialog(null, "NPK atau Password salah", "information", JOptionPane.INFORMATION_MESSAGE);
                    LoginKaryawan loginMahasiswa = new LoginKaryawan();
                } else if (index_kry == -2) {
                    JOptionPane.showMessageDialog(null, "NPK atau Password salah", "information", JOptionPane.INFORMATION_MESSAGE);
                    LoginKaryawan loginMahasiswa = new LoginKaryawan();
                } else {
                    loginKry.dispose();
                    ProfileKaryawan profileKry = new ProfileKaryawan();
                    profileKry.profileKry(index_kry);
                }
            }
        });

       Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                loginKry.dispose();
                GUI menuUtama = new GUI();
            }
        });
    }
}
