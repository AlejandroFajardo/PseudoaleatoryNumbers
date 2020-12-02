package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private List<Double> chi;
    private List<Double> inferiorInterval;
    private List<Double> superiorInterval;

    public Utils() {
        chi = new ArrayList<>();
        inferiorInterval = new ArrayList<>();
        superiorInterval = new ArrayList<>();
        try {
            muestraContenido(String.valueOf("B:\\2020\\simulacion\\NumerosPseudoaleatorios\\src\\test\\chi.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        String[] splitString;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            splitString = cadena.split("	");
            this.chi.add(Double.parseDouble(splitString[0]));
            this.superiorInterval.add(Double.parseDouble(splitString[1]));
            this.inferiorInterval.add(Double.parseDouble(splitString[2]));
        }
        b.close();
    }

    public List<Double> getChi() {
        return chi;
    }

    public List<Double> getInferiorInterval() {
        return inferiorInterval;
    }

    public List<Double> getSuperiorInterval() {
        return superiorInterval;
    }
}
