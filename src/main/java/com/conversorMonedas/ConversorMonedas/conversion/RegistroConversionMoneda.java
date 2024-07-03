package com.conversorMonedas.ConversorMonedas.conversion;

import java.time.LocalDateTime;

public class RegistroConversionMoneda {

    private String monedaUno;
    private String monedaDos;
    private double cantidadConvertida;
    private LocalDateTime fechaHora;

    public RegistroConversionMoneda(String monedaUno, String monedaDos, double cantidadConvertida, LocalDateTime fechaHora) {
            this.monedaUno = monedaUno;
            this.monedaDos = monedaDos;
            this.cantidadConvertida = cantidadConvertida;
            this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "RegistroConversion{" +
                    "monedaOrigen='" + monedaUno + '\'' +
                    ", monedaDestino='" + monedaDos + '\'' +
                    ", cantidadConvertida=" + cantidadConvertida +
                    ", fechaHora=" + fechaHora +
                    '}';
    }
}
