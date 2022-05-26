package presentationLayer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class LoginView extends JFrame {
    private Image img_logo = (new ImageIcon("C:\\Users\\Giussepe\\Desktop\\foodDeliveryManagementSystem\\src\\res\\logo.jpg")).getImage().getScaledInstance(170,170,Image.SCALE_SMOOTH);
    private Image img_lock = (new ImageIcon("C:\\Users\\Giussepe\\Desktop\\foodDeliveryManagementSystem\\src\\res\\key.png")).getImage().getScaledInstance(120,90,Image.SCALE_SMOOTH);
    private Image img_client = (new ImageIcon("C:\\Users\\Giussepe\\Desktop\\foodDeliveryManagementSystem\\src\\res\\pict-employee-male.png")).getImage().getScaledInstance(60,64,Image.SCALE_SMOOTH);

    private JPanel contentPanel;
    private JTextField usernameField;
    private JPasswordField pwdPassword;
    private JLabel loginMessage = new JLabel("");
    private JButton loginButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginView frame = new LoginView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public LoginView() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 920, 570);
        contentPanel = new JPanel();
        contentPanel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPanel.setBackground(new Color(0, 139, 139));
        contentPanel.setBorder(new LineBorder(new Color(0, 0, 128), 2));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        JPanel usernamePanel = new JPanel();
        usernamePanel.setBounds(274, 233, 412, 64);
        usernamePanel.setBackground(new Color(240, 240, 240));
        contentPanel.add(usernamePanel);
        usernamePanel.setLayout(null);

        usernameField = new JTextField();
        usernameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(usernameField.getText().equals("Username")) {
                    usernameField.setText("");
                }
                else
                    usernameField.selectAll();
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(usernameField.getText().equals(""))
                    usernameField.setText("Username");
            }
        });
        usernameField.setBorder(null);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameField.setText("Username");
        usernameField.setBounds(10, 10, 287, 44);
        usernamePanel.add(usernameField);
        usernameField.setColumns(10);

        JLabel lblUserName = new JLabel("");
        lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
        lblUserName.setBounds(307, 0, 105, 64);
        usernamePanel.add(lblUserName);
        lblUserName.setIcon(new ImageIcon(img_client));

        JPanel passPanel = new JPanel();
        passPanel.setBounds(274, 323, 412, 64);
        passPanel.setBackground(SystemColor.menu);
        contentPanel.add(passPanel);
        passPanel.setLayout(null);

        pwdPassword = new JPasswordField();
        pwdPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(pwdPassword.getText().equals("Password")) {
                    pwdPassword.setEchoChar('●');
                    pwdPassword.setText("");
                }
                else
                    pwdPassword.selectAll();

            }
            @Override
            public void focusLost(FocusEvent e) {
                if(pwdPassword.getText().equals("")) {
                    pwdPassword.setText("Password");
                    pwdPassword.setEchoChar((char)0);

                }
            }
        });
        pwdPassword.setBorder(null);
        pwdPassword.setEchoChar((char)0);
        pwdPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        pwdPassword.setText("Password");
        pwdPassword.setBounds(10, 10, 287, 44);
        passPanel.add(pwdPassword);

        JLabel lblPassWord = new JLabel("");
        lblPassWord.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassWord.setBounds(327, 0, 62, 64);
        lblPassWord.setIcon(new ImageIcon(img_lock));
        passPanel.add(lblPassWord);

        JLabel lblX = new JLabel("X");
        lblX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?","Confirmation",JOptionPane.YES_NO_OPTION) == 0)
                    LoginView.this.dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lblX.setForeground(Color.RED);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblX.setForeground(Color.WHITE);
            }
        });

        lblX.setForeground(new Color(255, 255, 255));
        lblX.setBounds(898, 0, 22, 38);
        lblX.setFont(new Font("Arial", Font.BOLD, 21));
        contentPanel.add(lblX);

        JLabel logoPic = new JLabel("");
        logoPic.setHorizontalAlignment(SwingConstants.CENTER);
        logoPic.setBounds(274, 59, 412, 153);
        contentPanel.add(logoPic);
        logoPic.setIcon(new ImageIcon(img_logo));

        loginMessage.setForeground(new Color(255, 0, 0));
        loginMessage.setFont(new Font("Arial", Font.PLAIN, 15));
        loginMessage.setBounds(274, 397, 412, 39);
        contentPanel.add(loginMessage);

        this.loginButton = new JButton("LOGIN");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 32));
        loginButton.setBounds(274, 433, 412, 56);
        contentPanel.add(loginButton);

        JLabel lblTe = new JLabel("Technical University of Cluj-Napoca");
        lblTe.setFont(new Font("Arial", Font.PLAIN, 11));
        lblTe.setBounds(10, 16, 183, 13);
        contentPanel.add(lblTe);
        setLocationRelativeTo(null);

        this.setVisible(true);
    }

    public String getUsernameField() {
        return usernameField.getText();
    }

    public void setUsernameField(String usernameField) {
        this.usernameField.setText("");
    }

    public String getPwdPassword() {
        return pwdPassword.getText();
    }


    public void setPwdPassword(String pwdPassword) {
        this.pwdPassword.setText("");
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public void loginBtn(ActionListener action){
        loginButton.addActionListener(action);
    }
}
