package com.boot.es.mybootes.ytx.uml;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.CRC32;

public class Test {

    public static void main(String[] args) {
        int crc = crc32("欢迎关注：匠心零度".getBytes());
        int crc1 = crc32("欢迎关注：匠心零度".getBytes());
        int crc2 = crc32("欢迎关注：匠心零度!".getBytes());

        System.out.println(crc==crc1);
        System.out.println(crc== crc2);

        Map map= Collections.synchronizedMap(new HashMap<>());
        map.put("1","12");
    }


    public static int crc32(byte[] array) {
        if (array != null) {
            return crc32(array, 0, array.length);
        }
        return 0;
    }

    public static int crc32(byte[] array, int offset, int length) {
        CRC32 crc32 = new CRC32();
        crc32.update(array, offset, length);
        return (int) (crc32.getValue() & 0x7FFFFFFF);
    }
}
