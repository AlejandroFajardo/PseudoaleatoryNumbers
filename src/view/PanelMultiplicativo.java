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

public class PanelMultiplicativo extends JPanel {

    private Controller controller;
    private DefaultTableModel defaultTableModel;
    private JScrollPane jScrollPane;
    private JTable jtTable;
    private JTextField fieldIterations, fieldSeed, fieldT, fieldD, fieldA, fieldB, fieldChi, fieldVariance, fieldAverage;
    private JButton btnStart, btnChi, btnAverage, fieldVar;
    private JPanel jpNorth, jpSouth;

    public PanelMultiplicativo(Controller controller) {
        this.controller = controller;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#00000"));
        this.initNorth();
        this.table();
    }

    private void table() {
        defaultTableModel = new DefaultTableModel();
        Font fontHeader = new Font("Leelawadee UI", Font.PLAIN, 18);
        jtTable = new JTable();
        jtTable.setModel(defaultTableModel);
        jtTable.getTableHeader().setReorderingAllowed(false);
        jtTable.getTableHeader().setBackground(Color.decode("#FFFFFF"));
        jtTable.getTableHeader().setForeground(Color.BLACK);
        jtTable.getTableHeader().setFont(fontHeader);
        jtTable.setBackground(Color.white);
        jtTable.setBorder(null);
        jScrollPane = new JScrollPane(jtTable);
        jScrollPane.setForeground(Color.white);
        jScrollPane.setBorder(null);
        jScrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(jScrollPane, BorderLayout.CENTER);

        this.setBorder(null);
        String[] headers = {"Iteracion", "Xi", "Ri", "Ni", "Ri2", "Ni2"};
        defaultTableModel.setColumnIdentifiers(headers);
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jtTable.getColumnCount(); i++) {
            jtTable.getColumnModel().getColumn(i).setCellRenderer(Alinear);
        }
    }

    public void addToList(String[] list) {
        defaultTableModel.addRow(list);
    }

    private void initNorth() {
        this.jpNorth = new JPanel();
        jpNorth.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.jpNorth.setLayout(new GridLayout(2, 4, 5, 5));
        this.jpNorth.setBackground(Color.WHITE);
        this.fieldIterations = new JTextField();
        this.fieldIterations.setBorder(BorderFactory.createTitledBorder(null, "Iteraciones", TitledBorder.LEFT,
                TitledBorder.CENTER, new Font("Leelawadee UI", Font.PLAIN, 18)));
        this.fieldIterations.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (fieldIterations.getText().length() == 10) {
                    e.consume();
                }
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    e.consume();
                }
            }
        });
        this.fieldSeed = new JTextField();
        this.fieldSeed.setBorder(BorderFactory.createTitledBorder(null, "Semilla", TitledBorder.LEFT,
                TitledBorder.CENTER, new Font("Leelawadee UI", Font.PLAIN, 18)));
        this.fieldSeed.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (fieldSeed.getText().length() == 10) {
                    e.consume();
                }
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    e.consume();
                }
            }
        });

        this.fieldA = new JTextField();
        this.fieldA.setBorder(BorderFactory.createTitledBorder(null, "Minimo para Ni", TitledBorder.LEFT,
                TitledBorder.CENTER, new Font("Leelawadee UI", Font.PLAIN, 18)));
        this.fieldSeed.addKeyListener(new KeyAdapter() {
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
        this.fieldB.setBorder(BorderFactory.createTitledBorder(null, "Maximo para Ni", TitledBorder.LEFT,
                TitledBorder.CENTER, new Font("Leelawadee UI", Font.PLAIN, 18)));
        this.fieldSeed.addKeyListener(new KeyAdapter() {
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

        this.fieldT = new JTextField();
        this.fieldT.setBorder(BorderFactory.createTitledBorder(null, "T", TitledBorder.LEFT,
                TitledBorder.CENTER, new Font("Leelawadee UI", Font.PLAIN, 18)));
        this.fieldT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (fieldT.getText().length() == 10) {
                    e.consume();
                }
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    e.consume();
                }
            }
        });

        this.fieldD = new JTextField();
        this.fieldD.setBorder(BorderFactory.createTitledBorder(null, "D", TitledBorder.LEFT,
                TitledBorder.CENTER, new Font("Leelawadee UI", Font.PLAIN, 18)));
        this.fieldD.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (fieldD.getText().length() == 10) {
                    e.consume();
                }
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    e.consume();
                }
            }
        });

        this.btnStart = new JButton("Generar");
        this.btnStart.setForeground(Color.WHITE);
        this.btnStart.setBorder(BorderFactory.createRaisedBevelBorder());
        this.btnStart.setBackground(Color.decode("#000000"));
        this.btnStart.addActionListener(controller);
        this.btnStart.setActionCommand("GMultipli");
        this.btnStart.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));
        this.btnStart.setFocusable(false);
        this.btnStart.setForeground(Color.WHITE);

        this.jpNorth.add(this.fieldSeed);
        this.jpNorth.add(this.fieldT);
        this.jpNorth.add(this.fieldD);
        this.jpNorth.add(this.fieldIterations);
        this.jpNorth.add(this.fieldA);
        this.jpNorth.add(this.fieldB);
        this.jpNorth.add(this.btnStart);

        this.jpSouth = new JPanel();
        this.jpSouth.setLayout(new GridLayout(3, 2));
        this.btnAverage = new JButton("Medias");
        this.btnAverage.setActionCommand("MediaMulti");
        this.btnAverage.addActionListener(controller);
        this.fieldVar = new JButton("Varianza");
        this.fieldVar.setActionCommand("VarMulti");
        this.fieldVar.addActionListener(controller);
        this.btnChi = new JButton("Chi2");
        this.btnChi.setActionCommand("ChiMulti");
        this.btnChi.addActionListener(controller);
        this.fieldAverage = new JTextField();
        this.fieldVariance = new JTextField();
        this.fieldChi = new JTextField();

        btnAverage.setFocusPainted(false);
        btnAverage.setContentAreaFilled(false);
        btnAverage.setBorder(new LineBorder(Color.decode("#FFFFFF")));
        btnAverage.setBackground(Color.decode("#000000"));
        btnAverage.setForeground(Color.WHITE);
        btnAverage.setOpaque(true);
        btnAverage.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));

        fieldVar.setFocusPainted(false);
        fieldVar.setContentAreaFilled(false);
        fieldVar.setBorder(new LineBorder(Color.decode("#FFFFFF")));
        fieldVar.setBackground(Color.decode("#000000"));
        fieldVar.setOpaque(true);
        fieldVar.setForeground(Color.WHITE);
        fieldVar.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));

        btnChi.setFocusPainted(false);
        btnChi.setContentAreaFilled(false);
        btnChi.setForeground(Color.WHITE);
        btnChi.setBorder(new LineBorder(Color.decode("#FFFFFF")));
        btnChi.setBackground(Color.decode("#000000"));
        btnChi.setOpaque(true);
        btnChi.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));

        this.fieldAverage = new JTextField();
        this.fieldVariance = new JTextField();
        this.fieldChi = new JTextField();

        this.jpSouth.add(this.btnAverage);
        this.jpSouth.add(this.fieldAverage);

        this.jpSouth.add(this.fieldVar);
        this.jpSouth.add(this.fieldVariance);

        this.jpSouth.add(this.btnChi);
        this.jpSouth.add(this.fieldChi);

        this.add(this.jpNorth, BorderLayout.NORTH);
        this.add(this.jpSouth, BorderLayout.SOUTH);
    }

    public String getSeed() {
        return this.fieldSeed.getText();
    }

    public String getIterations() {
        return this.fieldIterations.getText();
    }

    public void clean() {
        this.fieldIterations.setText("");
        this.fieldSeed.setText("");
        this.fieldA.setText("");
        this.fieldB.setText("");
        this.fieldD.setText("");
        this.fieldT.setText("");
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

    public int getT() {
        return Integer.parseInt(this.fieldT.getText());
    }

    public int getD() {
        return Integer.parseInt(this.fieldD.getText());
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
