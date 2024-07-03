package com.conversorMonedas.ConversorMonedas.moneda;

import com.conversorMonedas.ConversorMonedas.conversion.Conversion;
import com.conversorMonedas.ConversorMonedas.conversion.ConversionRecord;
import com.conversorMonedas.ConversorMonedas.tazaDeCambio.TazaDeCambioRecord;
import com.conversorMonedas.ConversorMonedas.tazaDeCambio.TazasDeCambio;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AdministradorDeMonedas {

    private HttpClient client = HttpClient.newHttpClient();

    public TazasDeCambio buscarTazaCambio(String monedaDeCambio) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/8771592ffe8bfc3ff9a1f914/latest/" + monedaDeCambio);
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            TazaDeCambioRecord tazaDeCambioRecord = new Gson().fromJson(response.body(), TazaDeCambioRecord.class);
            TazasDeCambio conversion = new TazasDeCambio(tazaDeCambioRecord);
            return conversion;
        } catch (Exception e) {
            throw new RuntimeException("No pude convertirlo !" + e.getMessage());
        }
    }

    /**
     * Con este metodo convertimos el valor de una moneda a otra dandole como parametro la cantidad.
     *
     * @param monedaDeCambioUno  Moneda base
     * @param monedaDeCambioDos  Monedad a convertir
     * @param cantidadAconvertir Cantidad a convertir
     * @return conversion.
     */
    public Conversion convertirMoneda(String monedaDeCambioUno, String monedaDeCambioDos, double cantidadAconvertir) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/8771592ffe8bfc3ff9a1f914/pair/" + monedaDeCambioUno + "/" + monedaDeCambioDos + "/" + cantidadAconvertir);
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ConversionRecord conversionRecord = new Gson().fromJson(response.body(), ConversionRecord.class);
            Conversion conversion = new Conversion(conversionRecord.conversion_rate(), conversionRecord.conversion_result());
            return conversion;
        } catch (Exception e) {
            throw new RuntimeException("No pude convertirlo !" + e.getMessage());
        }
    }
}
