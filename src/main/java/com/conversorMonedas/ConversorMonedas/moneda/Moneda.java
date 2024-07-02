package com.conversorMonedas.ConversorMonedas.moneda;

public class Moneda {
    private float usd;
    private float ars;
    private float bob;
    private float brl;
    private float clp;
    private float cop;

    public float getUSD() {
        return usd;
    }

    public void setUSD(float USD) {
        this.usd = USD;
    }

    public float getArs() {
        return ars;
    }

    public void setArs(float ars) {
        this.ars = ars;
    }

    public float getBob() {
        return bob;
    }

    public void setBob(float bob) {
        this.bob = bob;
    }

    public float getBrl() {
        return brl;
    }

    public void setBrl(float brl) {
        this.brl = brl;
    }

    public float getClp() {
        return clp;
    }

    public void setClp(float clp) {
        this.clp = clp;
    }

    public float getCop() {
        return cop;
    }

    public void setCop(float cop) {
        this.cop = cop;
    }

    public Moneda(MonedaRecord parametro) {
        this.usd = parametro.USD();
        this.ars = parametro.ARS();
        this.bob = parametro.BOB();
        this.brl = parametro.BRL();
        this.clp = parametro.CLP();
        this.cop = parametro.COP();
    }

    @Override
    public String toString() {
        return "dominio.Moneda{" +
                "USD=" + usd +
                ", ARS=" + ars +
                ", BOB=" + bob +
                ", BRL=" + brl +
                ", CLP=" + clp +
                ", COP=" + cop +
                '}';
    }
}
