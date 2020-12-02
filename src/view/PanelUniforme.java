package view;

import controller.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PanelUniforme extends JPanel {

    private Controller controller;
    private DefaultTableModel defaultTableModel, defaultTableModel2;
    private JScrollPane jScrollPane1, jScrollPane2;
    private JTable jTable1, jTable2;
    private JTextField fieldIteration, fieldA, fieldB, fieldChi, fieldAverage, fieldVariance;
    private JButton btnStart, btnChi, btnAverage, btnVariance;
    private JPanel jpNorth, jpCenter, jpSouth;

    public PanelUniforme(Controller controller) {
        this.controller = controller;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#00000"));
        this.initNorth();
        this.table();
    }

    private void table() {
        defaultTableModel = new DefaultTableModel();
        Font fontHeader = new Font("Leelawadee UI", Font.PLAIN, 18);
        jTable1 = new JTable();
        jTable1.setModel(defaultTableModel);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setBackground(Color.decode("#FFFFFF"));
        jTable1.getTableHeader().setForeground(Color.BLACK);
        jTable1.getTableHeader().setFont(fontHeader);
        jTable1.setBackground(Color.white);
        jTable1.setBorder(null);
        jScrollPane1 = new JScrollPane(jTable1);
        jScrollPane1.setForeground(Color.WHITE);
        jScrollPane1.setBorder(null);
        jScrollPane1.setAlignmentX(Component.CENTER_ALIGNMENT);

        defaultTableModel2 = new DefaultTableModel();
        jTable2 = new JTable();
        jTable2.setModel(defaultTableModel2);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.getTableHeader().setBackground(Color.decode("#FFFFFF"));
        jTable2.getTableHeader().setForeground(Color.BLACK);
        jTable2.getTableHeader().setFont(fontHeader);
        jTable2.setBackground(Color.white);
        jTable2.setBorder(null);
        jScrollPane2 = new JScrollPane(jTable2);
        jScrollPane2.setForeground(Color.white);
        jScrollPane2.setBorder(null);
        jScrollPane2.setAlignmentX(Component.CENTER_ALIGNMENT);

        jpCenter = new JPanel();
        jpCenter.setLayout(new GridLayout(1, 2, 5, 5));
        jpCenter.setBorder(new EmptyBorder(10, 10, 10, 10));
        jpCenter.add(jScrollPane2);
        jpCenter.add(jScrollPane1);

        add(jpCenter, BorderLayout.CENTER);

        this.setBorder(null);
        String[] headers1 = {"Ri", "Ni"};
        defaultTableModel.setColumnIdentifiers(headers1);

        String[] headers2 = {"No", "Inicial", "Final", "Fr Obtenida", "Fr Esperada", "Chi2"};
        defaultTableModel2.setColumnIdentifiers(headers2);

        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(Alinear);
        }

    }

    public void addToList1(String[] list) {
        defaultTableModel.addRow(list);
    }

    public void addToList2(String[] list) {
        defaultTableModel2.addRow(list);
    }

    private void initNorth() {
        this.jpNorth = new JPanel();
        this.jpNorth.setLayout(new GridLayout(2, 3));

        this.fieldIteration = new JTextField();
        this.fieldIteration.setBorder(BorderFactory.createTitledBorder(null, "Iteraciones", TitledBorder.LEFT,
                TitledBorder.CENTER, new Font("Leelawadee UI", Font.PLAIN, 18)));
        this.fieldIteration.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (fieldIteration.getText().length() == 10) {
                    e.consume();
                }
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    e.consume();
                }
            }
        });

        this.fieldA = new JTextField();
        this.fieldA.setBorder(BorderFactory.createTitledBorder(null, "Ni Minimo", TitledBorder.LEFT,
                TitledBorder.CENTER, new Font("Leelawadee UI", Font.PLAIN, 18)));
        this.fieldA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (fieldA.getText().length() == 10) {
                    e.consume();
                }
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    e.consume();
                }
            }
        });

        this.fieldB = new JTextField();
        this.fieldB.setBorder(BorderFactory.createTitledBorder(null, "Ni Maximo", TitledBorder.LEFT,
                TitledBorder.CENTER, new Font("Leelawadee UI", Font.PLAIN, 18)));
        this.fieldB.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (fieldB.getText().length() == 10) {
                    e.consume();
                }
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    e.consume();
                }
            }
        });

        this.btnStart = new JButton("Generar numeros");
        this.btnStart.setForeground(Color.WHITE);
        this.btnStart.setBorder(BorderFactory.createRaisedBevelBorder());
        this.btnStart.setBackground(Color.BLACK);
        this.btnStart.addActionListener(controller);
        this.btnStart.setActionCommand("GUniforme");
        this.btnStart.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));
        this.btnStart.setFocusable(false);

        this.jpNorth.add(this.fieldIteration);
        this.jpNorth.add(this.fieldA);
        this.jpNorth.add(this.fieldB);
        this.jpNorth.add(this.btnStart);

        this.jpSouth = new JPanel();
        this.jpSouth.setLayout(new GridLayout(3, 2));
        this.btnAverage = new JButton("Media");
        this.btnAverage.setActionCommand("MediaUniforme");
        this.btnAverage.addActionListener(controller);
        this.btnVariance = new JButton("Varianza");
        this.btnVariance.setActionCommand("VarUniforme");
        this.btnVariance.addActionListener(controller);
        this.btnChi = new JButton("Chi2");
        this.btnChi.setActionCommand("ChiUniforme");
        this.btnChi.addActionListener(controller);
        this.fieldAverage = new JTextField();
        this.fieldVariance = new JTextField();
        this.fieldChi = new JTextField();

        btnAverage.setFocusPainted(false);
        btnAverage.setBorder(new LineBorder(Color.decode("#FFFFFF")));
        btnAverage.setBackground(Color.decode("#000000"));
        btnAverage.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));
        btnAverage.setForeground(Color.WHITE);
        
        btnVariance.setFocusPainted(false);
        btnVariance.setBorder(new LineBorder(Color.decode("#FFFFFF")));
        btnVariance.setBackground(Color.decode("#000000"));
        btnVariance.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));
        btnVariance.setForeground(Color.WHITE);

        btnChi.setFocusPainted(false);
        btnChi.setBorder(new LineBorder(Color.decode("#FFFFFF")));
        btnChi.setBackground(Color.decode("#000000"));
        btnChi.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));
        btnChi.setForeground(Color.WHITE);

        this.fieldAverage = new JTextField();
        this.fieldVariance = new JTextField();
        this.fieldChi = new JTextField();

        this.jpSouth.add(this.btnAverage);
        this.jpSouth.add(this.fieldAverage);

        this.jpSouth.add(this.btnVariance);
        this.jpSouth.add(this.fieldVariance);

        this.jpSouth.add(this.btnChi);
        this.jpSouth.add(this.fieldChi);

        this.add(this.jpNorth, BorderLayout.NORTH);
        this.add(this.jpSouth, BorderLayout.SOUTH);
    }

    public String getIterations() {
        return this.fieldIteration.getText();
    }

    public void clean() {
        this.fieldIteration.setText("");
        this.fieldA.setText("");
        this.fieldB.setText("");
    }

    public void cleanTable() {
        defaultTableModel.setRowCount(0);
    }

    public int getA() {
        return Integer.parseInt(this.fieldA.getText());
    }

    public int getB() {
        return Integer.parseInt(this.fieldB.getText());
    }

    public String getItera() {
        return this.fieldIteration.getText();
    }

    public void setTextMed(String text) {
        this.fieldAverage.setText(text);
    }

    public void setTextVar(String text) {
        this.fieldVariance.setText(text);
    }

    public void setTextChi(String text) {
        this.fieldChi.setText(text);
    }
}
