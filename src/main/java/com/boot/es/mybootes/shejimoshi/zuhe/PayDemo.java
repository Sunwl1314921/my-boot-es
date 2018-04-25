package com.boot.es.mybootes.shejimoshi.zuhe;

import java.util.ArrayList;
import java.util.List;

public class PayDemo {

    /**
     *  总店
     */
    public abstract class Makert{
        String name;

        public abstract  void add(Makert makert);

        public abstract  void remove(Makert makert);

        public abstract  void payMakert();

    }

    /**
     * 分店
     * 下面有加盟店
     */
    public class MarketBranch extends Makert{

        private String name;

        private List<Makert> makerts= new ArrayList<>();

        public MarketBranch(String name){
            this.name=name;
        }

        @Override
        public void add(Makert makert) {
            makerts.add(makert);
        }

        @Override
        public void remove(Makert makert) {
            makerts.remove(makert);
        }

        @Override
        public void payMakert() {
            System.out.println(name+"分店消费开始-----");
            for (Makert makerts:makerts){
                makerts.payMakert();
            }
        }
    }


    /**
     * 加盟店下面没有最低级门店
     */
    public class  MarketJoin extends Makert{

        private String name;
        public MarketJoin(String name){
            this.name=name;
        }
        @Override
        public void add(Makert makert) {
            System.out.println("无");
        }

        @Override
        public void remove(Makert makert) {
            System.out.println("无");
        }

        @Override
        public void payMakert() {
            System.out.println(name+"加盟店消费开始");
        }
    }

    public static void main(String[] args) {
        PayDemo pd=new PayDemo();

        MarketBranch makert=pd.new MarketBranch("总店");

        MarketBranch fendian=pd.new MarketBranch("分店");

        MarketJoin jiamengdian1=pd.new MarketJoin("一分店");
        MarketJoin jiamengdian2=pd.new MarketJoin("二分店");

        fendian.add(jiamengdian1);
        fendian.add(jiamengdian2);
        makert.add(fendian);

        makert.payMakert();
    }

}
