package com.boot.es.mybootes.shejimoshi.mingling.ml;

/**
 * 具体命令类
 */
public class ConcreteCommand implements Command{
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        super();
        this.receiver = receiver;
    }

    public void execute() {
        //可进行执行命令前相关操作

        receiver.action();//执行命令

        //可进行执行命令后相关操作
    }

    public void cancel() {
        receiver.unAction();
    }
}