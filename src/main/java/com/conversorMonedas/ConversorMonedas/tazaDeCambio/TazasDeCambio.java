package com.conversorMonedas.ConversorMonedas.tazaDeCambio;

import com.conversorMonedas.ConversorMonedas.moneda.Moneda;

public class TazasDeCambio {

    private Moneda conversionRate;

    public Moneda getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Moneda conversionRate) {
        this.conversionRate = conversionRate;
    }

    public TazasDeCambio(TazaDeCambioRecord convertidor) {
        this.conversionRate = new Moneda(convertidor.conversion_rates());
    }

    @Override
    public String toString() {
        return "Conversion{" +
                "conversionRate=" + conversionRate +
                '}';
    }
}
