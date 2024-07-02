package com.conversorMonedas.ConversorMonedas.conversion;

public class Conversion {
    private float conversionRate;
    private float conversionResult;

    public float getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(float conversionRate) {
        this.conversionRate = conversionRate;
    }

    public float getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(float conversionResult) {
        this.conversionResult = conversionResult;
    }

    public Conversion(float conversionRate, float conversionResult) {
        this.conversionRate = conversionRate;
        this.conversionResult = conversionResult;
    }


    public String toString(double valorConvertir, String monedaUno, String monedaDos ) {
        return "Usted eligio convertir " + valorConvertir + " " + monedaUno +
                " que equivalen a " + conversionRate + " " + monedaDos +
                ", por lo que obtiene un total de " + conversionResult + " " + monedaDos + ".";
    }
}
