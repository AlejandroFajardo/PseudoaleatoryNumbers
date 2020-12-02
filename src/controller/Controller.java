package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import javax.swing.JOptionPane;
import model.CongruenciaLineal;
import model.CongruenciaMultiplicativa;
import model.CuadradosMedios;
import model.Uniforme;
import test.TestChi2;
import test.TestAverage;
import test.TestVariance;
import view.MainWindow;
import view.PanelCuadrados;
import view.PanelLineal;
import view.PanelMultiplicativo;
import view.PanelUniforme;


public class Controller implements ActionListener {

    private MainWindow jFMainWindow;
    private CuadradosMedios cuadradosMedios;
    private CongruenciaLineal congruenciaLineal;
    private CongruenciaMultiplicativa congruenciaMultiplicativa;
    private Uniforme uniforme;
    private PanelCuadrados panelCuadrados;
    private PanelLineal panelLineal;
    private PanelMultiplicativo panelMultiplicativo;
    private PanelUniforme panelUniforme;
    private TestChi2 chiTest;
    private TestAverage averageTest;
    private TestVariance varianceTest;
    
  public Controller () {
        this.chiTest = new TestChi2();
        this.averageTest = new TestAverage();
        this.varianceTest = new TestVariance();
        this.panelCuadrados = new PanelCuadrados(this);
        this.panelLineal = new PanelLineal(this);
        this.panelMultiplicativo = new PanelMultiplicativo(this);
        this.panelUniforme = new PanelUniforme(this);
        this.cuadradosMedios = new CuadradosMedios();
        this.congruenciaLineal = new CongruenciaLineal();
        this.congruenciaMultiplicativa = new CongruenciaMultiplicativa();
        this.uniforme = new Uniforme();
        this.jFMainWindow = new MainWindow(this);
        this.jFMainWindow.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch(ae.getActionCommand()) {
            case "Salir":
                System.exit(0);
                break;
            case "Cuadrados":
                this.panelLineal.setVisible(false);                
                this.panelMultiplicativo.setVisible(false);
                this.panelUniforme.setVisible(false);
                this.panelCuadrados.setVisible(true);
                this.panelCuadrados.cleanTable();
                this.panelCuadrados.clean();
                this.jFMainWindow.initPanel(this.panelCuadrados);
                break;
            case "GCuadrados":
                this.GCuadrados();
                break;
            case "Lineal":
                this.panelCuadrados.setVisible(false);                       
                this.panelMultiplicativo.setVisible(false);                
                this.panelUniforme.setVisible(false);
                this.panelLineal.setVisible(true);
                this.panelLineal.cleanTable();
                this.panelLineal.clean();
                this.jFMainWindow.initPanel(this.panelLineal);
                break;
            case "GLineal":
                this.GLineal();
                break;
            case "Multilipicativa":
                this.panelCuadrados.setVisible(false);       
                this.panelLineal.setVisible(false);     
                this.panelUniforme.setVisible(false);           
                this.panelMultiplicativo.setVisible(true);
                this.panelMultiplicativo.cleanTable();
                this.panelMultiplicativo.clean();
                this.jFMainWindow.initPanel(this.panelMultiplicativo);
                break;
            case "GMultipli":
                this.GMultiplicativo();
                break;
            case "Uniforme":
                this.panelCuadrados.setVisible(false);
                this.panelLineal.setVisible(false);
                this.panelMultiplicativo.setVisible(false);
                this.panelUniforme.setVisible(true);
                this.panelUniforme.clean();
                this.panelUniforme.cleanTable();
                this.jFMainWindow.initPanel(panelUniforme);
                break;
            case "GUniforme":
                this.GUniforme();
                break;
            case "MediaUniforme":
                if(this.averageTest.isMeetsCondition(this.uniforme.getRi())) {
                    this.panelUniforme.setTextMed(" Numeros validos ");
                }else {
                    this.panelUniforme.setTextMed(" Numeros no validos ");
                }
                break;
            case "VarUniforme":
                if(this.varianceTest.isSatisfactory(this.uniforme.getRi())) {
                    this.panelUniforme.setTextVar(" Numeros validos ");
                }else {
                    this.panelUniforme.setTextVar(" Numeros no validos ");
                }
                break;
            case "ChiUniforme":
                TestChi2 chi = new TestChi2(this.uniforme.getNi());
                if(chi.isSatisfactory()) {
                    this.panelUniforme.setTextChi(" Numeros validos ");
                }else {
                    this.panelUniforme.setTextChi(" Numeros no validos ");
                }
                break;
            case "MediaMulti":
                if(this.averageTest.isMeetsCondition(this.congruenciaMultiplicativa.getRi())) {
                    this.panelMultiplicativo.setTextMed(" Numeros validos ");
                }else {
                    this.panelMultiplicativo.setTextMed(" Numeros no validos ");
                }
                break;
            case "VarMulti":
                if(this.varianceTest.isSatisfactory(this.congruenciaMultiplicativa.getRi())) {
                    this.panelMultiplicativo.setTextVar(" Numeros validos ");
                }else {
                    this.panelMultiplicativo.setTextVar(" Numeros no validos ");
                }
                break;
            case "ChiMulti":
                TestChi2 chi2 = new TestChi2(this.congruenciaMultiplicativa.getNi());
                if(chi2.isSatisfactory()) {
                    this.panelMultiplicativo.setTextChi(" Numeros validos ");
                }else {
                    this.panelMultiplicativo.setTextChi(" Numeros no validos ");
                }
                break;
            case "MediaLineal":
                if(this.averageTest.isMeetsCondition(this.congruenciaLineal.getRi())) {
                    this.panelLineal.setTextMed(" Numeros validos ");
                }else {
                    this.panelLineal.setTextMed(" Numeros no validos ");
                }
                break;
            case "VarLineal":
                if(this.varianceTest.isSatisfactory(this.congruenciaLineal.getRi())) {
                    this.panelLineal.setTextVar(" Numeros validos ");
                }else {
                    this.panelLineal.setTextVar(" Numeros no validos ");
                }
                break;
            case "ChiLineal":
                TestChi2 chi3 = new TestChi2(this.congruenciaLineal.getNi());
                if(chi3.isSatisfactory()) {
                    this.panelLineal.setTextChi(" Numeros validos ");
                }else {
                    this.panelLineal.setTextChi(" Numeros no validos ");
                }
                break;
            case "MediaCuadrados":
                if(this.averageTest.isMeetsCondition(this.cuadradosMedios.getRi())) {
                    this.panelCuadrados.setTextMed(" Numeros validos ");
                }else {
                    this.panelCuadrados.setTextMed(" Numeros no validos ");
                }
                break;
            case "VarCuadrados":
                if(this.varianceTest.isSatisfactory(this.cuadradosMedios.getRi())) {
                    this.panelCuadrados.setTextVar(" Numeros validos ");
                }else {
                    this.panelCuadrados.setTextVar(" Numeros no validos ");
                }
                break;
            case "ChiCuadrados":
                TestChi2 chi4 = new TestChi2(this.cuadradosMedios.getNi());
                if(chi4.isSatisfactory()) {
                    this.panelCuadrados.setTextChi(" Numeros validos ");
                }else {
                    this.panelCuadrados.setTextChi(" Numeros no validos ");
                }
                break;
            default:
                break;
        }
            
    }
    
    private void GCuadrados(){
        this.panelCuadrados.cleanTable();
        this.cuadradosMedios.getList().removeAll(cuadradosMedios.getList());
        String[] rowData = {};
        if(this.panelCuadrados.getSeed().equals("")){
            JOptionPane.showMessageDialog(null, "Valor de la semilla incorrecto");
        }else if(this.panelCuadrados.getIterations().equals("") || 
                Integer.valueOf(this.panelCuadrados.getIterations()) <= 0){            
            JOptionPane.showMessageDialog(null, "Se harán 100 iteraciones");
            if(this.panelCuadrados.getB() <= this.panelCuadrados.getA()){
                JOptionPane.showMessageDialog(null, "El valor minimo de Ni, debe ser menor que el valor maximo de Ni");
            }else {
                this.cuadradosMedios.setXi(BigInteger.valueOf(Long.valueOf(this.panelCuadrados.getSeed())));
                this.cuadradosMedios.metodo(100, this.panelCuadrados.getA(), this.panelCuadrados.getB()); 
                for (int i = 0; i < this.cuadradosMedios.getList().size(); i++) {
                    rowData = String.valueOf(this.cuadradosMedios.getList().get(i)).split("-");
                    panelCuadrados.addToList(rowData);
                }
            }
        } else {
            if(this.panelCuadrados.getB() <= this.panelCuadrados.getA()){
                JOptionPane.showMessageDialog(null, "El valor minimo de Ni, debe ser menor que el valor maximo de Ni");
            }else {
                this.cuadradosMedios.setXi(BigInteger.valueOf(Long.valueOf(this.panelCuadrados.getSeed())));
                this.cuadradosMedios.metodo(Integer.parseInt(this.panelCuadrados.getIterations()),
                        this.panelCuadrados.getA(), this.panelCuadrados.getB()); 
                for (int i = 0; i < this.cuadradosMedios.getList().size(); i++) {
                    rowData = String.valueOf(this.cuadradosMedios.getList().get(i)).split("-");
                    panelCuadrados.addToList(rowData);
                }
            }
        }
   }
    
    private void GLineal() {
        this.panelLineal.cleanTable();
        String[] rowData = {};
        if(this.panelLineal.getSeed().equals("")){
            JOptionPane.showMessageDialog(null, "Valor de la semilla incorrecto");
        }else if(this.panelLineal.getIterations().equals("") || 
                Integer.valueOf(this.panelLineal.getIterations()) <= 0){            
            JOptionPane.showMessageDialog(null, "Se harán 100 iteraciones");
            if(this.panelLineal.getB() <= this.panelLineal.getA()){
                JOptionPane.showMessageDialog(null, "El valor minimo de Ni, debe ser menor que el valor maximo de Ni");
            }else {
                this.congruenciaLineal.metodo(100, Integer.parseInt(this.panelLineal.getSeed()), this.panelLineal.getA(), this.panelLineal.getB(), this.panelLineal.getC(),
                        this.panelLineal.getG(), this.panelLineal.getK());
                for (int i = 0; i < this.congruenciaLineal.getList().size(); i++) {
                    rowData = String.valueOf(this.congruenciaLineal.getList().get(i)).split("-");
                    panelLineal.addToList(rowData);
                }
            }
        } else {
            if(this.panelLineal.getB() <= this.panelLineal.getA()){
                JOptionPane.showMessageDialog(null, "El valor minimo de Ni, debe ser menor que el valor maximo de Ni");
            }else {
                this.congruenciaLineal.metodo(Integer.parseInt(this.panelLineal.getIterations()), Integer.parseInt(this.panelLineal.getSeed()), this.panelLineal.getA(), this.panelLineal.getB(), this.panelLineal.getC(),
                        this.panelLineal.getG(), this.panelLineal.getK());for (int i = 0; i < this.congruenciaLineal.getList().size(); i++) {
                    rowData = String.valueOf(this.congruenciaLineal.getList().get(i)).split("-");
                    panelLineal.addToList(rowData);
                }
            }
        }
    }
    
    private void GMultiplicativo() {
        this.panelMultiplicativo.cleanTable();
        String[] rowData = {};
        if(this.panelMultiplicativo.getSeed().equals("")){
            JOptionPane.showMessageDialog(null, "Valor de la semilla incorrecto");
        }else if(this.panelMultiplicativo.getIterations().equals("") || 
                Integer.valueOf(this.panelMultiplicativo.getIterations()) <= 0){            
            JOptionPane.showMessageDialog(null, "Se harán 100 iteraciones");
            if(this.panelMultiplicativo.getB() <= this.panelMultiplicativo.getA()){
                JOptionPane.showMessageDialog(null, "El valor minimo de Ni, debe ser menor que el valor maximo de Ni");
            }else {
                this.congruenciaMultiplicativa.setXi(Integer.parseInt(this.panelMultiplicativo.getSeed()));
                this.congruenciaMultiplicativa.metodo(100, this.panelMultiplicativo.getA(), this.panelMultiplicativo.getB(),
                        this.panelMultiplicativo.getT(), this.panelMultiplicativo.getD());
                for (int i = 0; i < this.congruenciaMultiplicativa.getList().size(); i++) {
                    rowData = String.valueOf(this.congruenciaMultiplicativa.getList().get(i)).split("-");
                    panelMultiplicativo.addToList(rowData);
                }
            }
        } else {
            if(this.panelMultiplicativo.getB() <= this.panelMultiplicativo.getA()){
                JOptionPane.showMessageDialog(null, "El valor minimo de Ni, debe ser menor que el valor maximo de Ni");
            }else {
                this.congruenciaMultiplicativa.setXi(Integer.parseInt(this.panelMultiplicativo.getSeed()));
                this.congruenciaMultiplicativa.metodo(Integer.parseInt(this.panelMultiplicativo.getIterations()),
                        this.panelMultiplicativo.getA(), this.panelMultiplicativo.getB(),
                        this.panelMultiplicativo.getT(), this.panelMultiplicativo.getD());
                for (int i = 0; i < this.congruenciaMultiplicativa.getList().size(); i++) {
                    rowData = String.valueOf(this.congruenciaMultiplicativa.getList().get(i)).split("-");
                    panelMultiplicativo.addToList(rowData);
                }
            }
        }
    }
    
    public void GUniforme() {
        String[] rowData1 = {};
        String[] rowData2 = {};
        if(this.panelUniforme.getItera().equals("")){
            JOptionPane.showMessageDialog(null, "Se haran 20 iteraciones");
            this.uniforme.generar(20, this.panelUniforme.getA(), this.panelUniforme.getB()); 
            for (int i = 0; i < this.uniforme.getList().size(); i++) {
                rowData1 = String.valueOf(this.uniforme.getList().get(i)).split("-");
                panelUniforme.addToList1(rowData1);
            }
            this.uniforme.chi2();
            for (int i = 0; i < this.uniforme.getList3().size(); i++) {
                rowData2 = String.valueOf(this.uniforme.getList3().get(i)).split("-");
                panelUniforme.addToList2(rowData2);
            }
            this.panelUniforme.repaint();
        } else {
            this.uniforme.generar(Integer.parseInt(this.panelUniforme.getItera()), this.panelUniforme.getA(), this.panelUniforme.getB());
            for (int i = 0; i < this.uniforme.getList().size(); i++) {
                rowData1 = String.valueOf(this.uniforme.getList().get(i)).split("-");
                panelUniforme.addToList1(rowData1);
            }
            this.uniforme.chi2();
            for (int i = 0; i < this.uniforme.getList3().size(); i++) {
                rowData2 = String.valueOf(this.uniforme.getList3().get(i)).split("-");
                panelUniforme.addToList2(rowData2);
            }            
            this.panelUniforme.repaint();
        }
    }
}
