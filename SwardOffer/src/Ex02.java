/*
* 实现单例模式,双检查法
* */
public class Ex02 {

}

class SingleTon{
    private volatile SingleTon uniqueInstance;
    private SingleTon SingleTon(){
        return uniqueInstance;
    };

    public SingleTon getUniqueInstance() {
        if(null == uniqueInstance){
            synchronized (SingleTon.class){
                if(null == uniqueInstance){
                    uniqueInstance = new SingleTon();
                }
            }
        }
        return uniqueInstance;
    }
}