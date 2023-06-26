package demo04_String相关;

/**
 * @author ajie
 * @date 2023/6/26
 * @description:
 */
public class Test01 {
    public static void main(String[] args) {
        // 1. new String 创建了几个对象
        String str1 = new String("ajie");
        /*
            常量池存在，则直接new⼀个对象；
            常量池不存在，则在常量池创建⼀个对象，也在堆⾥⾯创建⼀个对象
         */
        String str2 = "ajie";
        String str3 = "ajie";
        System.out.println(str1 == str2); // false
        System.out.println(str2 == str3); // true
        /*
            第⼀个是false： new 创建新的对象会开辟新的空间，所以地址不⼀样
            第⼆个是true：都是从常量池⾥⾯获取，"ajie" 存在于常量池中
         */
        String s1 = "a";
        // 构建了⼀个新的string对象，并将对象引⽤赋予s2变量，常量池中的地址不⼀样，但是值⼀样
        String s2 = s1 + "jie"; // 变量 + 常量 -> 来自堆
        // javac编译可以对[字符串常量]直接相加的表达式进⾏优化，不⽤等到运⾏期再去进⾏加法运算处理，⽽是直接将其编译成⼀个这些常量相连的结果
        String s3 = "a" + "jie"; // 常量 + 常量 -> 来自常量池
        System.out.println(s2 == "ajie"); // false
        System.out.println(s3 == "ajie"); // true
    }
}
