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

    /**
     * Este metodo toma como refencia una moneda y te da su valor reflejada en otras monedas.
     *
     * @param monedaDeCambio Es la moneda a utilizar para que su valor sea convertido en otras monedas.
     * @return TazaDeCambio
     */
    public TazasDeCambio buscarTazaCambio(String monedaDeCambio) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/8771592ffe8bfc3ff9a1f914/latest/" + monedaDeCambio); // Creando una instancia de URI que contiene la Url de la api a utilizar + parametro.
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build(); // Creo una instancia de Httprequest que contiene la URI anteriormente generada.
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // Se ejecuta la solicitud Http utilizando la request generada anteriormente.
            TazaDeCambioRecord tazaDeCambioRecord = new Gson().fromJson(response.body(), TazaDeCambioRecord.class); // Utilizo una clase record para leer datos del json.
            TazasDeCambio conversion = new TazasDeCambio(tazaDeCambioRecord); // Mapeo la clase record a una clase estandar para poder ser utilizada.
            return conversion; // Devuelvo los datos mapeados a la clase requerida.
        } catch (Exception e) {
            throw new RuntimeException("No pude convertirlo !" + e.getMessage()); // En caso de algun erro levanto una exepcion mostrando el motivo del porque.
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
