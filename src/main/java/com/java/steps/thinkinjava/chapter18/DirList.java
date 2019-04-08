package com.java.steps.thinkinjava.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

//查看目录列表，或满足条件的目录列表
public class DirList {
    //传给匿名函数的参数必须是final类型，以共享
    public static void main(final String[] args) {
        File file = new File(".");
        String[] strings;
        if (args.length == 0) {
            strings = file.list();
        } else {
            //匿名内部类
            strings = file.list(new FilenameFilter() {
                //正则表达式的使用
                private Pattern pattern = Pattern.compile(args[0]);

                //接收文件所在目录的File对象以及文件名
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        //按字母顺序
        Arrays.sort(strings, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : strings
        ) {
            System.out.println(dirItem);
        }
    }
}
/**
 * File类：既能代表一个特定文件的名称，又能代表一个目录下的一组文件的名称。
 * 表示文件集时，可以调用list()方法，返回一个字符数组。
 * 相关类：FilenameFilter接口
 * <p>
 * DirFilter类实现了FilenameFilter接口，提供accept()方法给list()方法调用，以决定哪些文件包含在列表中。这种结构称为回调，
 * 具体来说，这是一个“策略模式”的例子：在list()中实现了基本的功能，按照FilenameFilter的形式提供策略，以完善list()在提供服务时所需的算法。
 * 因为list()接受FilenameFilter对象作为参数，意味着我们可以传递实现了FilenameFilter接口的任何类的对象，用以选择list()方法的行为方式。
 * 策略的目的就是提供了代码行为的灵活性。
 */
