/**
 * Project name(项目名称)：析构方法 destructuring-method
 * Package(包名): PACKAGE_NAME
 * Class(类名): Student
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/10/7
 * Time(创建时间)： 13:19
 * Version(版本): 1.0
 * Description(描述)： 析构方法与构造方法相反，当对象脱离其作用域时（例如对象所在的方法已调用完毕），系统自动执行析构方法。
 * 析构方法往往用来做清理垃圾碎片的工作，例如在建立对象时用 new 开辟了一片内存空间，应退出前在析构方法中将其释放。
 * 在 Java 的 Object 类中还提供了一个 protected 类型的 finalize() 方法，因此任何 Java 类都可以覆盖这个方法，
 * 在这个方法中进行释放对象所占有的相关资源的操作。
 * 对象的 finalize() 方法具有如下特点：
 * 垃圾回收器是否会执行该方法以及何时执行该方法，都是不确定的。
 * finalize() 方法有可能使用对象复活，使对象恢复到可触及状态。
 * 垃圾回收器在执行 finalize() 方法时，如果出现异常，垃圾回收器不会报告异常，程序继续正常运行。
 */

public class Student
{
    private static int count = 0;

    public Student()
    {
        count++;
        System.out.println("调用构造函数," + "数量：" + count);
    }

    public static int getCount()
    {
        return count;
    }

    protected void finalize()
    {
        count--;
        System.out.println("调用析构函数," + "数量：" + count);
    }
}

class test
{
    public static void main(String[] args)
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        s1 = null;
        s2 = null;
        try
        {
            System.gc();    // 清理内存
            Thread.sleep(1000);    // 延时1000毫秒
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        //------------------------------------------------------
    }
}
