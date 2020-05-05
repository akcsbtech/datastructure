package education.io.multithreading;
class CustomThread1 extends Thread{
    Shared s;
    public CustomThread1(Shared s,String str){
        super(str);
        this.s=s;
        start();
    }
    public void run(){
    	Shared.show1(Thread.currentThread().getName(),20);
    }
}