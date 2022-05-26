package presentationLayer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import java.awt.event.*;

public class FilterView extends JFrame {

    private JPanel fatMinTxt;
    private JButton backToLoginBtn;
    private JButton filterBtn;
    private JTextField keywordTxt;
    private JLabel keywordLbl;
    private JTextField ratingMinTxt;
    private JLabel lblNewLabel;
    private JTextField ratingMaxTxt;
    private JLabel lblRatingMax;
    private JTextField priceMinTxt;
    private JTextField caloriesMinTxt;
    private JTextField proteinMinTxt;
    private JTextField FattMinTxt;
    private JTextField sodiumMinTxt;
    private JTextField priceMaxTxt;
    private JTextField caloriesMaxTxt;
    private JTextField proteinMaxTxt;
    private JTextField fatMaxTxt;
    private JTextField sodiumMaxTxt;
    private JLabel lblPriceMin;
    private JLabel lblCaloriesMin;
    private JLabel lblProteinMin;
    private JLabel lblFatMin;
    private JLabel lblSodiumMin;
    private JLabel lblProceMin;
    private JLabel lblCaloriesMin_1;
    private JLabel lblProteinMin_1;
    private JLabel lblRatingMax_1;
    private JLabel lblSodiumMin_1;


    public FilterView() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 920, 570);
        fatMinTxt = new JPanel();
        fatMinTxt.setFont(new Font("Arial", Font.PLAIN, 30));
        fatMinTxt.setBackground(new Color(47, 79, 79));
        fatMinTxt.setBorder(new LineBorder(new Color(0, 0, 128), 2));
        setContentPane(fatMinTxt);

        JLabel lblX = new JLabel("X");
        lblX.setBounds(898, 0, 22, 38);
        lblX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
                    FilterView.this.dispose();
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
        fatMinTxt.setLayout(null);

        lblX.setForeground(new Color(255, 255, 255));
        lblX.setFont(new Font("Arial", Font.BOLD, 21));
        fatMinTxt.add(lblX);

        JPanel panelMenu = new JPanel();
        panelMenu.setBounds(0, 0, 317, 570);
        panelMenu.setBorder(null);
        panelMenu.setBackground(new Color(0, 128, 128));
        fatMinTxt.add(panelMenu);
        panelMenu.setLayout(null);


        JLabel titleLbl = new JLabel("Filter interface.");
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
        titleLbl.setBounds(30, 25, 261, 119);
        panelMenu.add(titleLbl);

        filterBtn = new JButton("FILTER");
        filterBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        filterBtn.setBounds(30, 324, 261, 39);
        panelMenu.add(filterBtn);

        backToLoginBtn = new JButton("<-");
        backToLoginBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        backToLoginBtn.setBounds(8, 10, 58, 22);
        panelMenu.add(backToLoginBtn);

        keywordTxt = new JTextField();
        keywordTxt.setBounds(504, 65, 387, 29);
        fatMinTxt.add(keywordTxt);
        keywordTxt.setColumns(10);

        keywordLbl = new JLabel("Keyword");
        keywordLbl.setFont(new Font("Arial", Font.PLAIN, 20));
        keywordLbl.setBounds(345, 65, 149, 29);
        fatMinTxt.add(keywordLbl);

        ratingMinTxt = new JTextField();
        ratingMinTxt.setBounds(505, 142, 82, 29);
        fatMinTxt.add(ratingMinTxt);
        ratingMinTxt.setColumns(10);

        lblNewLabel = new JLabel("Rating min");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        lblNewLabel.setBounds(345, 142, 98, 29);
        fatMinTxt.add(lblNewLabel);

        ratingMaxTxt = new JTextField();
        ratingMaxTxt.setColumns(10);
        ratingMaxTxt.setBounds(809, 142, 82, 29);
        fatMinTxt.add(ratingMaxTxt);

        lblRatingMax = new JLabel("Rating max");
        lblRatingMax.setFont(new Font("Arial", Font.PLAIN, 20));
        lblRatingMax.setBounds(659, 142, 128, 29);
        fatMinTxt.add(lblRatingMax);

        priceMinTxt = new JTextField();
        priceMinTxt.setColumns(10);
        priceMinTxt.setBounds(505, 207, 82, 29);
        fatMinTxt.add(priceMinTxt);

        caloriesMinTxt = new JTextField();
        caloriesMinTxt.setColumns(10);
        caloriesMinTxt.setBounds(505, 275, 82, 29);
        fatMinTxt.add(caloriesMinTxt);

        proteinMinTxt = new JTextField();
        proteinMinTxt.setColumns(10);
        proteinMinTxt.setBounds(504, 339, 82, 29);
        fatMinTxt.add(proteinMinTxt);

        FattMinTxt = new JTextField();
        FattMinTxt.setColumns(10);
        FattMinTxt.setBounds(504, 405, 82, 29);
        fatMinTxt.add(FattMinTxt);

        sodiumMinTxt = new JTextField();
        sodiumMinTxt.setColumns(10);
        sodiumMinTxt.setBounds(504, 470, 82, 29);
        fatMinTxt.add(sodiumMinTxt);

        priceMaxTxt = new JTextField();
        priceMaxTxt.setColumns(10);
        priceMaxTxt.setBounds(809, 207, 82, 29);
        fatMinTxt.add(priceMaxTxt);

        caloriesMaxTxt = new JTextField();
        caloriesMaxTxt.setColumns(10);
        caloriesMaxTxt.setBounds(809, 275, 82, 29);
        fatMinTxt.add(caloriesMaxTxt);

        proteinMaxTxt = new JTextField();
        proteinMaxTxt.setColumns(10);
        proteinMaxTxt.setBounds(809, 339, 82, 29);
        fatMinTxt.add(proteinMaxTxt);

        fatMaxTxt = new JTextField();
        fatMaxTxt.setColumns(10);
        fatMaxTxt.setBounds(809, 405, 82, 29);
        fatMinTxt.add(fatMaxTxt);

        sodiumMaxTxt = new JTextField();
        sodiumMaxTxt.setHorizontalAlignment(SwingConstants.TRAILING);
        sodiumMaxTxt.setColumns(10);
        sodiumMaxTxt.setBounds(809, 470, 82, 29);
        fatMinTxt.add(sodiumMaxTxt);

        lblPriceMin = new JLabel("Price min");
        lblPriceMin.setFont(new Font("Arial", Font.PLAIN, 20));
        lblPriceMin.setBounds(345, 215, 98, 29);
        fatMinTxt.add(lblPriceMin);

        lblCaloriesMin = new JLabel("Calories min");
        lblCaloriesMin.setFont(new Font("Arial", Font.PLAIN, 20));
        lblCaloriesMin.setBounds(345, 275, 120, 29);
        fatMinTxt.add(lblCaloriesMin);

        lblProteinMin = new JLabel("Protein min");
        lblProteinMin.setFont(new Font("Arial", Font.PLAIN, 20));
        lblProteinMin.setBounds(345, 339, 120, 29);
        fatMinTxt.add(lblProteinMin);

        lblFatMin = new JLabel("Fat min");
        lblFatMin.setFont(new Font("Arial", Font.PLAIN, 20));
        lblFatMin.setBounds(345, 405, 98, 29);
        fatMinTxt.add(lblFatMin);

        lblSodiumMin = new JLabel("Sodium min");
        lblSodiumMin.setFont(new Font("Arial", Font.PLAIN, 20));
        lblSodiumMin.setBounds(345, 470, 120, 29);
        fatMinTxt.add(lblSodiumMin);

        lblProceMin = new JLabel("Price max");
        lblProceMin.setFont(new Font("Arial", Font.PLAIN, 20));
        lblProceMin.setBounds(659, 207, 98, 29);
        fatMinTxt.add(lblProceMin);

        lblCaloriesMin_1 = new JLabel("Calories max");
        lblCaloriesMin_1.setFont(new Font("Arial", Font.PLAIN, 20));
        lblCaloriesMin_1.setBounds(659, 275, 128, 29);
        fatMinTxt.add(lblCaloriesMin_1);

        lblProteinMin_1 = new JLabel("Protein max");
        lblProteinMin_1.setFont(new Font("Arial", Font.PLAIN, 20));
        lblProteinMin_1.setBounds(659, 339, 128, 29);
        fatMinTxt.add(lblProteinMin_1);

        lblRatingMax_1 = new JLabel("Fat max");
        lblRatingMax_1.setFont(new Font("Arial", Font.PLAIN, 20));
        lblRatingMax_1.setBounds(659, 405, 128, 29);
        fatMinTxt.add(lblRatingMax_1);

        lblSodiumMin_1 = new JLabel("Sodium max");
        lblSodiumMin_1.setFont(new Font("Arial", Font.PLAIN, 20));
        lblSodiumMin_1.setBounds(659, 470, 128, 29);
        fatMinTxt.add(lblSodiumMin_1);
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);

        this.setVisible(false);
    }

    public String getKeywordTxt() {
        return keywordTxt.getText();
    }

    public String getRatingMinTxt() {
        return ratingMinTxt.getText();
    }

    public String getRatingMaxTxt() {
        return ratingMaxTxt.getText();
    }

    public String getPriceMinTxt() {
        return priceMinTxt.getText();
    }

    public String getCaloriesMinTxt() {
        return caloriesMinTxt.getText();
    }

    public String getProteinMinTxt() {
        return proteinMinTxt.getText();
    }

    public String getFattMinTxt() {
        return FattMinTxt.getText();
    }

    public String getSodiumMinTxt() {
        return sodiumMinTxt.getText();
    }

    public String getPriceMaxTxt() {
        return priceMaxTxt.getText();
    }

    public String getCaloriesMaxTxt() {
        return caloriesMaxTxt.getText();
    }

    public String getProteinMaxTxt() {
        return proteinMaxTxt.getText();
    }

    public String getFatMaxTxt() {
        return fatMaxTxt.getText();
    }

    public String getSodiumMaxTxt() {
        return sodiumMaxTxt.getText();
    }

    public void BackToClientCiew(ActionListener actionListener) {
        this.backToLoginBtn.addActionListener(actionListener);
    }

    public void filterBtn(ActionListener actionListener) {
        this.filterBtn.addActionListener(actionListener);
    }

}


