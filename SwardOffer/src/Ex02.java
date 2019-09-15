/*
* 实现单例模式,双检查法
* 优点是：线程安全（确保只有一个实例产生），双锁效率较高，节约资源（需要使用才加载）
* 参考资料：https://www.cnblogs.com/zhaoyan001/p/6365064.html
* */
public class Ex02 {

}

class SingleTon{
    private static volatile SingleTon uniqueInstance;
    private SingleTon(){
    };

    public static SingleTon getUniqueInstance(){
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