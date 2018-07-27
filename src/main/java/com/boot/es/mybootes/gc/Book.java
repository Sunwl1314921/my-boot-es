package com.boot.es.mybootes.gc;

import java.util.ArrayList;
import java.util.List;
public class Book {
    boolean checkedOut = false;

    Book(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    //重写finalize方法 \
    @Override
    protected void finalize() throws Throwable {
        //校验checkedOut
        if (checkedOut) {
            System.out.println("校验出现了一次错误: Checked out ");
        }
        super.finalize();
    }

    public static void main(String[] args) {

        Book novel = new Book(true);
        System.out.println(novel.toString());
        novel.checkIn();

        //对checked进行了一次误操作,未进行签入
        new Book(true);
        System.out.println(novel.toString());
        //调用Gc 强制执行终结操作(finalize)
        System.gc();
        System.out.println(novel.toString());


    }
}
