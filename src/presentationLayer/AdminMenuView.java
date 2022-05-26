package presentationLayer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;

public class AdminMenuView extends JFrame {

    private JPanel contentPanel;
    private JButton selectAddBtn;
    private JButton backToLoginBtn;
    private JButton viewAllProductsBtn;
    private JButton selectCreateMenuBtn;
    private JButton selectEditBtn;
    private JButton selectDeleteBtn;
    private JButton selectReportView;
    private JButton importBtn;
    private JPanel prodTablePane;
    private JScrollPane scrollPane;
    private JTable productsTable;
    private JTextField menuNameTxt;


    public AdminMenuView() {
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
                    AdminMenuView.this.dispose();
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

        this.selectAddBtn = new JButton("ADD PRODUCT");
        selectAddBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        selectAddBtn.setBounds(30, 138, 261, 39);
        panelMenu.add(selectAddBtn);


        JLabel titleLbl = new JLabel("Manage the products.");
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
        titleLbl.setBounds(30, 25, 261, 119);
        panelMenu.add(titleLbl);

        selectDeleteBtn = new JButton("DELETE PRODUCT");
        selectDeleteBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        selectDeleteBtn.setBounds(30, 212, 261, 39);
        panelMenu.add(selectDeleteBtn);

        selectEditBtn = new JButton("EDIT PRODUCT");
        selectEditBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        selectEditBtn.setBounds(30, 291, 261, 39);
        panelMenu.add(selectEditBtn);

        selectCreateMenuBtn = new JButton("CREATE MENU");
        selectCreateMenuBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        selectCreateMenuBtn.setBounds(30, 369, 160, 39);
        panelMenu.add(selectCreateMenuBtn);

        viewAllProductsBtn = new JButton("VIEW ALL ");
        viewAllProductsBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        viewAllProductsBtn.setBounds(30, 443, 261, 39);
        panelMenu.add(viewAllProductsBtn);

        backToLoginBtn = new JButton("<-");
        backToLoginBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        backToLoginBtn.setBounds(8, 10, 58, 22);
        panelMenu.add(backToLoginBtn);

        menuNameTxt = new JTextField();
        menuNameTxt.setBounds(201, 369, 106, 39);
        panelMenu.add(menuNameTxt);
        menuNameTxt.setColumns(10);

        JLabel lblNewLabel = new JLabel("Menu Name");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        lblNewLabel.setBounds(191, 340, 116, 27);
        panelMenu.add(lblNewLabel);

        prodTablePane = new JPanel();
        prodTablePane.setBounds(342, 90, 554, 335);
        contentPanel.add(prodTablePane);
        GridBagLayout gbl_prodTablePane = new GridBagLayout();
        gbl_prodTablePane.columnWidths = new int[]{0, 0};
        gbl_prodTablePane.rowHeights = new int[]{0, 0};
        gbl_prodTablePane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_prodTablePane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        prodTablePane.setLayout(gbl_prodTablePane);

        scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 0;
        prodTablePane.add(scrollPane, gbc_scrollPane);

        productsTable = new JTable();
        scrollPane.setViewportView(productsTable);

        importBtn = new JButton("IMPORT CSV");
        importBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        importBtn.setBounds(635, 442, 261, 39);
        contentPanel.add(importBtn);

        selectReportView = new JButton("GENERATE REPORTS");
        selectReportView.setFont(new Font("Arial", Font.PLAIN, 17));
        selectReportView.setBounds(342, 442, 261, 39);
        contentPanel.add(selectReportView);

        JLabel lblProductsMeniu = new JLabel("Products Meniu");
        lblProductsMeniu.setHorizontalAlignment(SwingConstants.CENTER);
        lblProductsMeniu.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 23));
        lblProductsMeniu.setBounds(342, 13, 554, 67);
        contentPanel.add(lblProductsMeniu);
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);

        this.setVisible(false);
    }


    public JTable getProductsTable() {
        return productsTable;
    }

    public void setProductsTable(JTable productsTable) {
        this.productsTable = productsTable;
    }

    public void showProductsTable(JTable table){
        scrollPane.setViewportView(table);
    }

    public String getMenuNameTxt() {
        return menuNameTxt.getText();
    }

    public void selectAddBtn(ActionListener actionListener){
        this.selectAddBtn.addActionListener(actionListener);
    }
    public void selectDeleteBtn(ActionListener actionListener){
        this.selectDeleteBtn.addActionListener(actionListener);
    }
    public void selectEditBtn(ActionListener actionListener){
        this.selectEditBtn.addActionListener(actionListener);
    }
    public void createMenuBtn(ActionListener actionListener){
        this.selectCreateMenuBtn.addActionListener(actionListener);
    }
    public void viewAllProductBtn(ActionListener actionListener){
        this.viewAllProductsBtn.addActionListener(actionListener);
    }
    public void BackToLoginBtn(ActionListener actionListener){
        this.backToLoginBtn.addActionListener(actionListener);
    }
    public void selectReportsView(ActionListener actionListener){
        this.selectReportView.addActionListener(actionListener);
    }
    public void importBtn(ActionListener actionListener){
        this.importBtn.addActionListener(actionListener);
    }
}
