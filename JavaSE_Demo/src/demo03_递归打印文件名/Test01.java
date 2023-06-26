package demo03_递归打印文件名;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ajie
 * @date 2023/6/26
 * @description:
 */
public class Test01 {
    public static void main(String[] args) {
        // 找出某⽬录下的所有⼦⽬录以及⼦⽂件并打印到控制台上
        List<String> paths = new ArrayList<>();
        File filePath = new File("D:\\project");
        getAllFilePaths(filePath, paths);
        for (String path : paths) {
            System.out.println(path);
        }
    }

    private static void getAllFilePaths(File filePath, List<String> paths) {
        File[] files = filePath.listFiles();
        if (files == null) {
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                paths.add(f.getPath());
                getAllFilePaths(f, paths);
            } else {
                paths.add(f.getPath());
            }
        }
    }
}
