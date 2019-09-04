package Datastruct;
/*
* 单例模式
* 双检查法的优点：线程安全；延迟加载；效率较高。
* */
public class SingleTon {
    private volatile SingleTon uniqueInstance;
    private SingleTon(){
    }

    public SingleTon getUniqueInstance(){
        if (null == uniqueInstance){
            synchronized (SingleTon.class){
                if(null == uniqueInstance){
                    uniqueInstance = new SingleTon();
                }
            }
        }
        return uniqueInstance;
    }
}
