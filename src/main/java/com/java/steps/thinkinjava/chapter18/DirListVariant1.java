package com.java.steps.thinkinjava.chapter18;


import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

//查看目录，返回包含指定内容的文件列表
public class DirListVariant1 {
    public static void main(final String[] args) {
        File file = new File("D:\\chenb\\下载\\tmp\\testdata");
        String[] list = file.list(new FilenameFilter() {
            Pattern pattern = Pattern.compile(args[0]);

            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        for (String dirItem : list
        ) {
            System.out.println(dirItem);
        }

    }
}
