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

public class ReportsView extends JFrame {

    private JPanel contentPanel;
    private  JButton generatePopularProductsBtn;
    private JButton generateClientsReportBtn;
    private JButton generateProdOrderedSpecificDayBtn;
    private JButton generateTimeIntervalReport;
    private JButton backBtn;
    private JTextField startTxt;
    private JTextField endTxt;
    private JTextField numOfOrdersTxt;
    private JTextField xTimesTxt;
    private JTextField orderValueGreaterTxt;
    private JTextField specificDayTxt;



    public ReportsView() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 920, 570);
        contentPanel = new JPanel();
        contentPanel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPanel.setBackground(new Color(0, 139, 139));
        contentPanel.setBorder(new LineBorder(new Color(0, 0, 128), 2));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        JLabel lblX = new JLabel("X");
        lblX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?","Confirmation",JOptionPane.YES_NO_OPTION) == 0)
                    ReportsView.this.dispose();
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

        generateTimeIntervalReport = new JButton("GENERATE");
        generateTimeIntervalReport.setFont(new Font("Arial", Font.PLAIN, 15));
        generateTimeIntervalReport.setBounds(634, 194, 239, 29);
        contentPanel.add(generateTimeIntervalReport);

        JLabel lblNewLabel = new JLabel("Select report you want to generate !");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 29));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 39, 920, 52);
        contentPanel.add(lblNewLabel);

        JLabel lblTimeIntervalOf = new JLabel("Time interval of the orders  : ");
        lblTimeIntervalOf.setHorizontalAlignment(SwingConstants.LEFT);
        lblTimeIntervalOf.setFont(new Font("Arial", Font.PLAIN, 24));
        lblTimeIntervalOf.setBounds(21, 195, 325, 28);
        contentPanel.add(lblTimeIntervalOf);

        JLabel lblPop = new JLabel("The products ordered more then a specific number :");
        lblPop.setHorizontalAlignment(SwingConstants.LEFT);
        lblPop.setFont(new Font("Arial", Font.PLAIN, 24));
        lblPop.setBounds(21, 280, 568, 28);
        contentPanel.add(lblPop);

        JLabel lblTheClientsThat = new JLabel("The clients that have ordered more and higher value :");
        lblTheClientsThat.setHorizontalAlignment(SwingConstants.LEFT);
        lblTheClientsThat.setFont(new Font("Arial", Font.PLAIN, 24));
        lblTheClientsThat.setBounds(38, 359, 586, 28);
        contentPanel.add(lblTheClientsThat);

        JLabel specificDayTxtd = new JLabel("The products ordered within a specified day  :");
        specificDayTxtd.setHorizontalAlignment(SwingConstants.LEFT);
        specificDayTxtd.setFont(new Font("Arial", Font.PLAIN, 24));
        specificDayTxtd.setBounds(38, 430, 489, 28);
        contentPanel.add(specificDayTxtd);

        generatePopularProductsBtn = new JButton("GENERATE");
        generatePopularProductsBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        generatePopularProductsBtn.setBounds(634, 279, 239, 29);
        contentPanel.add(generatePopularProductsBtn);

        generateClientsReportBtn = new JButton("GENERATE");
        generateClientsReportBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        generateClientsReportBtn.setBounds(634, 362, 239, 29);
        contentPanel.add(generateClientsReportBtn);

        generateProdOrderedSpecificDayBtn = new JButton("GENERATE");
        generateProdOrderedSpecificDayBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        generateProdOrderedSpecificDayBtn.setBounds(634, 429, 239, 29);
        contentPanel.add(generateProdOrderedSpecificDayBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Arial", Font.PLAIN, 10));
        backBtn.setBounds(10, 10, 64, 31);
        contentPanel.add(backBtn);

        startTxt = new JTextField();
        startTxt.setBounds(375, 197, 71, 25);
        contentPanel.add(startTxt);
        startTxt.setColumns(10);

        endTxt = new JTextField();
        endTxt.setColumns(10);
        endTxt.setBounds(499, 197, 71, 25);
        contentPanel.add(endTxt);

        JLabel lblNewLabel_1 = new JLabel("START");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(367, 171, 90, 29);
        contentPanel.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("END");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(490, 171, 90, 29);
        contentPanel.add(lblNewLabel_1_1);

        numOfOrdersTxt = new JTextField();
        numOfOrdersTxt.setColumns(10);
        numOfOrdersTxt.setBounds(583, 283, 39, 25);
        contentPanel.add(numOfOrdersTxt);

        xTimesTxt = new JTextField();
        xTimesTxt.setColumns(10);
        xTimesTxt.setBounds(130, 397, 71, 25);
        contentPanel.add(xTimesTxt);

        orderValueGreaterTxt = new JTextField();
        orderValueGreaterTxt.setColumns(10);
        orderValueGreaterTxt.setBounds(375, 397, 71, 25);
        contentPanel.add(orderValueGreaterTxt);

        specificDayTxt = new JTextField();
        specificDayTxt.setColumns(10);
        specificDayTxt.setBounds(537, 433, 87, 25);
        contentPanel.add(specificDayTxt);

        JLabel lblXTimes = new JLabel("x times");
        lblXTimes.setHorizontalAlignment(SwingConstants.CENTER);
        lblXTimes.setFont(new Font("Arial", Font.PLAIN, 17));
        lblXTimes.setBounds(62, 393, 71, 29);
        contentPanel.add(lblXTimes);

        JLabel lblOrdersValue = new JLabel("orders value > y");
        lblOrdersValue.setHorizontalAlignment(SwingConstants.CENTER);
        lblOrdersValue.setFont(new Font("Arial", Font.PLAIN, 17));
        lblOrdersValue.setBounds(244, 395, 121, 25);
        contentPanel.add(lblOrdersValue);
        setLocationRelativeTo(null);

        this.setVisible(false);
    }


    public void selectGenerateTimeIntervalReport(ActionListener actionListener){
        this.generateTimeIntervalReport.addActionListener(actionListener);
    }

    public void generatePopularProductsBtn(ActionListener actionListener){
        this.generatePopularProductsBtn.addActionListener(actionListener);
    }

    public void generateClientsReportBtn(ActionListener actionListener){
        this.generateClientsReportBtn.addActionListener(actionListener);
    }

    public void generateProdOrderedSpecificDayBtn(ActionListener actionListener){
        this.generateProdOrderedSpecificDayBtn.addActionListener(actionListener);
    }

    public void getBackToAdminMeniuView(ActionListener actionListener){
        this.backBtn.addActionListener(actionListener);
    }

    public String getStartTxt() {
        return startTxt.getText();
    }

    public String getEndTxt() {
        return endTxt.getText();
    }

    public String getNumOfOrdersTxt() {
        return numOfOrdersTxt.getText();
    }



    public String getXTimesTxt() {
        return xTimesTxt.getText();
    }


    public String getOrderValueGreaterTxt() {
        return orderValueGreaterTxt.getText();
    }



    public String getSpecificDayTxt() {
        return specificDayTxt.getText();
    }

}
