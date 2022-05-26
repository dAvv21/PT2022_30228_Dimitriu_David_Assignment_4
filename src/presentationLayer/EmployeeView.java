package presentationLayer;

import businessLayer.DeliveryService;
import businessLayer.MenuItem;
import businessLayer.Order;
import businessLayer.User;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Observable;

public class EmployeeView extends JFrame{

    private JPanel contentPanel;
    private JButton backToLoginBtn;
    private JLabel lblNewLabel;
    private JTextArea textArea;


    public EmployeeView() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 920, 570);
        contentPanel = new JPanel();
        contentPanel.setFont(new Font("Arial", Font.PLAIN, 30));
        contentPanel.setBackground(new Color(47, 79, 79));
        contentPanel.setBorder(new LineBorder(new Color(0, 0, 128), 2));
        setContentPane(contentPanel);

        JLabel lblX = new JLabel("X");
        lblX.setBounds(898, 0, 22, 38);
        lblX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?","Confirmation",JOptionPane.YES_NO_OPTION) == 0)
                    EmployeeView.this.dispose();
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
        contentPanel.setLayout(null);

        lblX.setForeground(new Color(255, 255, 255));
        lblX.setFont(new Font("Arial", Font.BOLD, 21));
        contentPanel.add(lblX);

        JPanel panelMenu = new JPanel();
        panelMenu.setBounds(0, 0, 317, 570);
        panelMenu.setBorder(null);
        panelMenu.setBackground(new Color(0, 128, 128));
        contentPanel.add(panelMenu);
        panelMenu.setLayout(null);


        JLabel titleLbl = new JLabel("Employee interface");
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
        titleLbl.setBounds(0, 25, 317, 119);
        panelMenu.add(titleLbl);

        backToLoginBtn = new JButton("<-");
        backToLoginBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        backToLoginBtn.setBounds(8, 10, 58, 22);
        panelMenu.add(backToLoginBtn);

        lblNewLabel = new JLabel("Orders ");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        lblNewLabel.setBounds(354, 39, 532, 38);
        contentPanel.add(lblNewLabel);

        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 17));
        textArea.setBounds(366, 118, 521, 383);
        contentPanel.add(textArea);
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);

        this.setVisible(false);
    }

    public void setTextArea(String textArea) {
        this.textArea.setText(textArea);
    }

    public void BackToLoginBtn(ActionListener actionListener){
        this.backToLoginBtn.addActionListener(actionListener);
    }


}
