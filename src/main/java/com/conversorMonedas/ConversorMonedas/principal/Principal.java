package com.conversorMonedas.ConversorMonedas.principal;

import com.conversorMonedas.ConversorMonedas.conversion.Conversion;
import com.conversorMonedas.ConversorMonedas.moneda.AdministradorDeMonedas;
import com.conversorMonedas.ConversorMonedas.tazaDeCambio.TazasDeCambio;

import java.util.Scanner;

public class Principal {

    Scanner scanner = new Scanner(System.in);

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
                case 0:
                    System.out.println("Cerrando la aplicación...");
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
        Conversion conversion = consultaDeCambio.convertirMoneda(monedaDeCambioUno, monedaDeCambioDos, cantidadConvertir);
        System.out.println(conversion.toString(cantidadConvertir,monedaDeCambioUno,monedaDeCambioDos));

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

}