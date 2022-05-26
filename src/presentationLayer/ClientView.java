package presentationLayer;

import businessLayer.User;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import java.awt.event.*;

public class ClientView extends JFrame {

    private JPanel contentPanel;
    private JButton createOrderBtn;
    private JButton backToLoginBtn;
    private JButton viewAllProductsBtn;
    private JPanel meniuPanel;
    private JTable meniuTable;
    private JScrollPane scrollPane;
    private JButton filterBtn;
    private User client;


    public ClientView() {

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
                    ClientView.this.dispose();
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

        this.createOrderBtn = new JButton("CREATE ORDER");
        createOrderBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        createOrderBtn.setBounds(30, 216, 261, 39);
        panelMenu.add(createOrderBtn);


        JLabel titleLbl = new JLabel("Client interface.");
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
        titleLbl.setBounds(30, 25, 261, 119);
        panelMenu.add(titleLbl);

        viewAllProductsBtn = new JButton("VIEW ALL ");
        viewAllProductsBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        viewAllProductsBtn.setBounds(30, 324, 261, 39);
        panelMenu.add(viewAllProductsBtn);

        backToLoginBtn = new JButton("<-");
        backToLoginBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        backToLoginBtn.setBounds(8, 10, 58, 22);
        panelMenu.add(backToLoginBtn);

        meniuPanel = new JPanel();
        meniuPanel.setBounds(354, 76, 519, 427);
        contentPanel.add(meniuPanel);
        GridBagLayout gbl_meniuPanel = new GridBagLayout();
        gbl_meniuPanel.columnWidths = new int[]{0, 0};
        gbl_meniuPanel.rowHeights = new int[]{0, 0};
        gbl_meniuPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_meniuPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        meniuPanel.setLayout(gbl_meniuPanel);

        scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 0;
        meniuPanel.add(scrollPane, gbc_scrollPane);

        meniuTable = new JTable();
        scrollPane.setViewportView(meniuTable);

        filterBtn = new JButton("Filters");
        filterBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        filterBtn.setBounds(740, 37, 133, 29);
        contentPanel.add(filterBtn);
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);

        this.setVisible(false);
    }

    public void setClient(User user){
        client = user;
    }

    public User getClient() {
        return client;
    }

    public void showProductsTable(JTable table){
        scrollPane.setViewportView(table);
    }


    public void BackToLoginBtn(ActionListener actionListener){
        this.backToLoginBtn.addActionListener(actionListener);
    }

    public void displayMeniuBtn(ActionListener actionListener){
        this.viewAllProductsBtn.addActionListener(actionListener);
    }
    public void createOrder(ActionListener actionListener){
        this.createOrderBtn.addActionListener(actionListener);
    }

    public void filterProducts(ActionListener actionListener){
        this.filterBtn.addActionListener(actionListener);
    }

    public JTable getMeniuTable() {
        return meniuTable;
    }

    public void setMeniuTable(JTable meniuTable) {
        this.meniuTable = meniuTable;
    }
}
