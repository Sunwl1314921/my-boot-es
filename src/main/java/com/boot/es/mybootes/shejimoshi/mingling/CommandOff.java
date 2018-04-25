package com.boot.es.mybootes.shejimoshi.mingling;

//关机命令ConcreteCommand
public class CommandOff implements Command {
    private Tv myTv;

    public CommandOff(Tv tv) {
        myTv = tv;
    }

    public void execute() {
        myTv.turnOff();
    }
}
