package view;

import controller.Controller;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

    private Controller controller;
    private JMenu jMMetods;
    private JMenuItem jmiCuadrados, jmiCongruenciaLineal, jmiCongruenciaMultiplicativa, jmiUniforme;

    public MenuBar(Controller controller) {
        this.controller = controller;
        this.initComponents();
    }

    private void initComponents() {
        jMMetods = new JMenu("Metodos");
        jmiCuadrados = new JMenuItem("Cuadrados Medios");
        jmiCuadrados.addActionListener(controller);
        jmiCuadrados.setActionCommand("Cuadrados");
        jmiCongruenciaLineal = new JMenuItem("Congruencia Lineal");
        jmiCongruenciaLineal.addActionListener(controller);
        jmiCongruenciaLineal.setActionCommand("Lineal");
        jmiCongruenciaMultiplicativa = new JMenuItem("Congruencia Multiplicativa");
        jmiCongruenciaMultiplicativa.addActionListener(controller);
        jmiCongruenciaMultiplicativa.setActionCommand("Multilipicativa");
        jmiUniforme = new JMenuItem("Uniforme");
        jmiUniforme.addActionListener(controller);
        jmiUniforme.setActionCommand("Uniforme");

        jMMetods.add(jmiCuadrados);
        jMMetods.add(jmiCongruenciaLineal);
        jMMetods.add(jmiCongruenciaMultiplicativa);
        jMMetods.add(jmiUniforme);

        this.add(jMMetods);

    }
}
