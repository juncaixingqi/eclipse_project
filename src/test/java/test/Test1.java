package test;
/*
 * 接口不能创建对象，所以用框架创建的对象，是实现类，重写看对象。
 */
public class Test1 {
     public static void main(String[] args) {
        CostDao cd1=new CostDaoImpl();
        cd1.update("mm");
        
    }
}
