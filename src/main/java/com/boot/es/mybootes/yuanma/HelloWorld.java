package com.boot.es.mybootes.yuanma;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class HelloWorld {
    public static void main(String[] args) {
        Collection con=new Vector();
        //((Vector) con).add(0,"23");

        List list=new ArrayList(new Vector());
        for(Object obj:list){
            System.out.println(obj);
        }

    }
}
