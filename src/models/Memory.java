package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Memory {

    private static final Memory inst = new Memory();

    private String actualText = "";

    private List<MemoryObserver> observers = new ArrayList<>();

    private double sum = 0;
    private double minus = 0;
    private double x = 0;
    private double div = 0;
    private int cont = 0;

    private Memory() {
    }

    public static Memory getInst() {
        return inst;
    }

    public void addObserver(MemoryObserver o) {
        observers.add(o);
    }

    public String getText() {
        return actualText.isEmpty() ? "0" : actualText;
    }

    public void commandProcess(String value) {
        try{
            Integer.parseInt(value);
            actualText += value;
        }catch (NumberFormatException e){
            actualText = verifyOperation(value);
        }
        observers.forEach(o -> o.setActualText(getText()));
    }

    public String verifyOperation(String newText) {
        switch (newText) {
            case "AC" -> {
                newText = "";
                cont = 0;
                return newText;
            }

            case "-" -> {
                minus += Double.parseDouble(getText());
                newText = "";
                cont = 0;
                return newText;
            }
            case "+" -> {
                sum += Double.parseDouble(getText());
                newText = "";
                cont = 0;
                return newText;
            }
            case "X" -> {
                x += Double.parseDouble(getText());
                newText = "";
                cont = 0;
                return newText;
            }
            case "÷" -> {
                div += Double.parseDouble(getText());
                newText = "";
                cont = 0;
                return newText;
            }
            case "." -> {
                if(cont == 0){
                    newText = getText();
                    cont = 1;
                    return newText += ".";
                }else {
                    newText = "";
                    cont = 0;
                    return newText;
                }
            }
            case "=" -> {
                if(sum != 0){
                    sum += Double.parseDouble(getText());
                    double aux = sum;
                    sum = 0;
                    return String.valueOf(aux);
                }
                else if(x != 0){
                    x *= Double.parseDouble(getText());
                    double aux = x;
                    x = 0;
                    return String.valueOf(aux);
                }
                else if(minus != 0){
                    minus -= Double.parseDouble(getText());
                    double aux = minus;
                    minus = 0;
                    return String.valueOf(aux);
                }
                else if(div != 0){
                    div /= Double.parseDouble(getText());
                    double aux = div;
                    div = 0;
                    return String.valueOf(aux);
                }
                return newText = "";
            }
            default -> {
                cont = 0;
                return newText;
            }
        }
    }
}
