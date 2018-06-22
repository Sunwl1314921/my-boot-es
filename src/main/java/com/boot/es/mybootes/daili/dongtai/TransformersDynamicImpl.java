package com.boot.es.mybootes.daili.dongtai;

public class TransformersDynamicImpl implements TransformersDynamic {
    @Override
    public void transMan() {
        System.out.println("擎天柱变成机器人");
        transCar();
    }

    @Override
    public void transCar() {
        System.out.println("擎天柱变成超级车");
    }
}
