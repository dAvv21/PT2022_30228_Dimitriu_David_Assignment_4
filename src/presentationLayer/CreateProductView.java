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

public class CreateProductView extends JFrame {

    private JPanel panel;
    private JButton createProductBtn;
    private JTextField nameTxt;
    private JTextField ratingTxt;
    private JTextField caloriesTxt;
    private JTextField priceTxt;
    private JTextField sodiumTxt;
    private JTextField fatTxt;
    private JTextField proteinTxt;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreateProductView frame = new CreateProductView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public CreateProductView() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 920, 570);
        panel = new JPanel();
        panel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.setBackground(new Color(0, 139, 139));
        panel.setBorder(new LineBorder(new Color(0, 0, 128), 2));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel lblX = new JLabel("X");
        lblX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?","Confirmation",JOptionPane.YES_NO_OPTION) == 0)
                    CreateProductView.this.dispose();
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
        panel.add(lblX);

        this.createProductBtn = new JButton("CREATE PRODUCT");
        createProductBtn.setFont(new Font("Arial", Font.PLAIN, 32));
        createProductBtn.setBounds(274, 433, 412, 56);
        panel.add(createProductBtn);

        nameTxt = new JTextField();
        nameTxt.setFont(new Font("Arial", Font.PLAIN, 15));
        nameTxt.setText("Introduce product name");
        nameTxt.setHorizontalAlignment(SwingConstants.CENTER);
        nameTxt.setBounds(96, 99, 208, 38);
        panel.add(nameTxt);
        nameTxt.setColumns(10);

        ratingTxt = new JTextField();
        ratingTxt.setText("Introduce product rating");
        ratingTxt.setHorizontalAlignment(SwingConstants.CENTER);
        ratingTxt.setFont(new Font("Arial", Font.PLAIN, 15));
        ratingTxt.setColumns(10);
        ratingTxt.setBounds(96, 220, 208, 38);
        panel.add(ratingTxt);

        caloriesTxt = new JTextField();
        caloriesTxt.setText("Introduce product calories");
        caloriesTxt.setHorizontalAlignment(SwingConstants.CENTER);
        caloriesTxt.setFont(new Font("Arial", Font.PLAIN, 15));
        caloriesTxt.setColumns(10);
        caloriesTxt.setBounds(96, 345, 208, 38);
        panel.add(caloriesTxt);

        priceTxt = new JTextField();
        priceTxt.setText("Introduce product price");
        priceTxt.setHorizontalAlignment(SwingConstants.CENTER);
        priceTxt.setFont(new Font("Arial", Font.PLAIN, 15));
        priceTxt.setColumns(10);
        priceTxt.setBounds(368, 385, 208, 38);
        panel.add(priceTxt);

        sodiumTxt = new JTextField();
        sodiumTxt.setText("Introduce product sodium");
        sodiumTxt.setHorizontalAlignment(SwingConstants.CENTER);
        sodiumTxt.setFont(new Font("Arial", Font.PLAIN, 15));
        sodiumTxt.setColumns(10);
        sodiumTxt.setBounds(628, 345, 208, 38);
        panel.add(sodiumTxt);

        fatTxt = new JTextField();
        fatTxt.setText("Introduce product fat");
        fatTxt.setHorizontalAlignment(SwingConstants.CENTER);
        fatTxt.setFont(new Font("Arial", Font.PLAIN, 15));
        fatTxt.setColumns(10);
        fatTxt.setBounds(628, 220, 208, 38);
        panel.add(fatTxt);

        proteinTxt = new JTextField();
        proteinTxt.setText("Introduce product protein");
        proteinTxt.setHorizontalAlignment(SwingConstants.CENTER);
        proteinTxt.setFont(new Font("Arial", Font.PLAIN, 15));
        proteinTxt.setColumns(10);
        proteinTxt.setBounds(628, 99, 208, 38);
        panel.add(proteinTxt);
        setLocationRelativeTo(null);

        this.setVisible(false);
    }

    public void createProductBtn(ActionListener actionListener){
        this.createProductBtn.addActionListener(actionListener);
    }

    public String getNameTxt() {
        return nameTxt.getText();
    }

    public String getRatingTxt() {
        return ratingTxt.getText();
    }

    public String getCaloriesTxt() {
        return caloriesTxt.getText();
    }

    public String getPriceTxt() {
        return priceTxt.getText();
    }

    public String getSodiumTxt() {
        return sodiumTxt.getText();
    }

    public String getFatTxt() {
        return fatTxt.getText();
    }

    public String getProteinTxt() {
        return proteinTxt.getText();
    }
}
