package view;

import controller.Controller;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {

    private MenuBar jBMenu;
    private Controller controller;
    public MainWindow(Controller controller) {
        this.controller = controller;
        jBMenu = new MenuBar(controller);
        this.initComponents();
    }

    private void initComponents() {
        this.setTitle("Generador de Numeros Pseudoaleatorios");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Icon.png"));
        System.out.println(getClass().getResource(""));
        this.setIconImage(icono);
        this.setJMenuBar(jBMenu);
    }

    public void initPanel(JPanel panel) {
        this.add(panel, BorderLayout.CENTER);
        this.revalidate();
    }

}
