package com.boot.es.mybootes.shejimoshi.mingling.ml;

public class Client {
    public static void main(String[] args) {
        //创建接收者
        Receiver receiver=new Receiver();
        //创建命令对象，并设置接收者
        Command command=new ConcreteCommand(receiver);

        //创建调用者，设置命令
        Invoker invoker=new Invoker(command);

        invoker.runCommand();
        invoker.cancelCommand();
    }
}
