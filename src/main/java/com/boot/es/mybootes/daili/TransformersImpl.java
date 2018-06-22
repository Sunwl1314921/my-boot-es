package com.boot.es.mybootes.daili;

/**
 * Transformers的实现类TransformersImpl，可以理解为擎天柱
 * 擎天柱实现了变形金刚接口，拥有两个功能分别是变形成人、变形成车。
 */
public class TransformersImpl implements Transformers {
    @Override
    public void transMan() {
        System.out.println("擎天柱变成了机器人");
    }

    @Override
    public void transCar() {
        System.out.println("擎天柱变成了超级车");
    }
}
