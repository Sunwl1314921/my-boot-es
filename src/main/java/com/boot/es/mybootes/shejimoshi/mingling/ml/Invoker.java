package com.boot.es.mybootes.shejimoshi.mingling.ml;

public class Invoker {
    private Command command;

    public Invoker(Command command) {
        super();
        this.command = command;
    }

    //执行命令
    public void runCommand() {
        command.execute();
    }

    //取消命令
    public void cancelCommand() {
        command.cancel();
    }
}
