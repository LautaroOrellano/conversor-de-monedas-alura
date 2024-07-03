package com.conversorMonedas.ConversorMonedas.principal;

import com.conversorMonedas.ConversorMonedas.conversion.Conversion;
import com.conversorMonedas.ConversorMonedas.conversion.RegistroConversionMoneda;
import com.conversorMonedas.ConversorMonedas.moneda.AdministradorDeMonedas;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    Scanner scanner = new Scanner(System.in);
    private List<RegistroConversionMoneda> registroConversionMonedas;

    public Principal() {
        this.registroConversionMonedas = new ArrayList<>();
    }

    public void muestraMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    
                    **********************************************
                    * Bienvenido a el conversor de monedas ALURA *
                    **********************************************
                    
                    Elija una opcion de conversion del 1 al 6 por favor
                    ___________________________________________________
                    
                    
                    1 - Dólar =>> Peso argentino
                    2 - Peso argentino =>> Dólar
                    3 - Dólar =>> Real brasileño
                    4 - Real brasileño =>> Dólar
                    5 - Dólar =>> Peso colombiano
                    6 - Peso colombiano =>> Dólar
                    7 - Dólar =>> Dólar Canadiense
                    8 - Dólar Canadiense =>> Dólar
                    9 - Dólar =>> Euro
                    10- Euro =>> Dólar
                    11- Dólar =>> Libra Egipcia
                    12- Libra Egipcia =>> Dólar
                    13- Ver Historial de conversiones         
                    0 - Salir
                    
                    Elija una opcion válida:
                    """;
            System.out.println(menu);
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    conversionDolarAPesoArgen();
                    break;
                case 2:
                    conversionPesoArgenADolar();
                    break;
                case 3:
                    conversionDolaraReal();
                    break;
                case 4:
                    conversionRealaDolar();
                    break;
                case 5:
                    conversionDolarAPesoColom();
                    break;
                case 6:
                    conversionPesoColomADolar();
                    break;
                case 7:
                    conversionDolarADolarCanadiense();
                    break;
                case 8:
                    conversionDolarCanadienseADolar();
                    break;
                case 9:
                    conversionDolarAEuro();
                    break;
                case 10:
                    conversionEuroADolar();
                    break;
                case 11:
                    conversionDolarALibraEgipcia();
                    break;
                case 12:
                    conversionLibraEgipciaADolar();
                    break;
                case 13:
                    verHistorialDeConversiones();
                    break;
                case 0:
                    System.out.println("");
                    System.out.println("******************************");
                    System.out.println("* Cerrando la aplicación.... *");
                    System.out.println("******************************");
                    System.out.println("");
                    mostrarHistorial();
                    break;
                default:
                    System.out.println("Opción inválida");

            }
        }
    }

    private void conversora(String monedaDeCambioUno, String monedaDeCambioDos) {
        double cantidadConvertir;
        AdministradorDeMonedas consultaDeCambio = new AdministradorDeMonedas();
        System.out.println("Que cantidad de dinero desea convertir?");
        cantidadConvertir = scanner.nextDouble();
        System.out.println("");
        Conversion conversion = consultaDeCambio.convertirMoneda(monedaDeCambioUno, monedaDeCambioDos, cantidadConvertir);
        System.out.println(conversion.toString(cantidadConvertir,monedaDeCambioUno,monedaDeCambioDos));
        RegistroConversionMoneda registro = new RegistroConversionMoneda(
                monedaDeCambioUno,
                monedaDeCambioDos,
                cantidadConvertir,
                LocalDateTime.now()
        );
        registroConversionMonedas.add(registro);
    }



    private void conversionDolarAPesoArgen() {
        conversora("USD","ARS");
    }

    private void conversionPesoArgenADolar() {
        conversora("ARS","USD");
    }

    private void conversionDolaraReal() {
        conversora("USD","BRL");
    }

    private void conversionRealaDolar() {
        conversora("BRL","USD");
    }

    private void conversionDolarAPesoColom() {
        conversora("USD","COP");
    }

    private void conversionPesoColomADolar() {
        conversora("COP","USD");
    }

    private void conversionDolarADolarCanadiense() {
        conversora("USD","CAD");
    }

    private void conversionDolarCanadienseADolar() {
        conversora("CAD","USD");
    }

    private void conversionDolarAEuro() {
        conversora("USD","EUR");
    }

    private void conversionEuroADolar() {
        conversora("EUR","USD");
    }

    private void conversionDolarALibraEgipcia() {
        conversora("USD","EGP");
    }

    private void conversionLibraEgipciaADolar() {
        conversora("EGP","USD");
    }

    private void verHistorialDeConversiones(){
        mostrarHistorial();
    }

    private void mostrarHistorial() {
        System.out.println("Historial de conversiones:");
        for (RegistroConversionMoneda registro : registroConversionMonedas) {
            System.out.println(registro);
        }
    }

}