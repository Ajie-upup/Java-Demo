package demo02_文件IO拷贝;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author ajie
 * @date 2023/6/26
 * @description:
 */
public class Test01 {
    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream("E:\\test.txt");
                BufferedInputStream bis = new BufferedInputStream(fis);
                FileOutputStream fos = new FileOutputStream("E:\\copy.txt");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ) {
            int size = 0;
            byte[] buf = new byte[1024];
            while ((size = bis.read(buf)) != -1) {
                bos.write(buf, 0, size);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
