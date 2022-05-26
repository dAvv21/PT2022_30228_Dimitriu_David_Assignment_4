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

public class DeleteProductView extends JFrame {

    private JPanel panel;
    private JButton deleteProductBtn;
    private JTextField nameTxt;
    private JLabel label;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteProductView frame = new DeleteProductView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public DeleteProductView() {
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
                    DeleteProductView.this.dispose();
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

        this.deleteProductBtn = new JButton("DELETE PRODUCT");
        deleteProductBtn.setFont(new Font("Arial", Font.PLAIN, 32));
        deleteProductBtn.setBounds(274, 433, 412, 56);
        panel.add(deleteProductBtn);

        nameTxt = new JTextField();
        nameTxt.setFont(new Font("Arial", Font.PLAIN, 15));
        nameTxt.setText("Introduce product name");
        nameTxt.setHorizontalAlignment(SwingConstants.CENTER);
        nameTxt.setBounds(603, 198, 237, 38);
        panel.add(nameTxt);
        nameTxt.setColumns(10);

        label = new JLabel("Please introduce the name of the product you want to delete :");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        label.setBounds(53, 198, 555, 38);
        panel.add(label);
        setLocationRelativeTo(null);

        this.setVisible(false);
    }

    public void deleteProductBtn(ActionListener actionListener){
        this.deleteProductBtn.addActionListener(actionListener);
    }

    public String getNameTxt() {
        return nameTxt.getText();
    }


}
