package com.boot.es.mybootes.shejimoshi.mingling.ml
/**
 * 抽象命令接口
 */
interface Command {
    fun  execute();//执行命令
    fun  cancel();//取消命令
}