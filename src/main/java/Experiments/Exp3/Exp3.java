package Experiments.Exp3;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Exp3 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String s1 = "0123456789'-.,";
        byte[] buffer1 = s1.getBytes();

        for (int i = 0; i < buffer1.length; i++) {
            if (buffer1[i] > 55) {
                System.out.println("да");
            }
        }

        System.out.println(Arrays.toString(buffer1));

        String s2 = "0123456789";
        Charset koi8 = Charset.forName("KOI8-R");
        byte[] buffer2 = s2.getBytes(koi8);

        System.out.println(Arrays.toString(buffer2));

        String s3 = "0123456789";
        byte[] buffer3 = s3.getBytes("Windows-1251");

        System.out.println(Arrays.toString(buffer3));

    }

}
