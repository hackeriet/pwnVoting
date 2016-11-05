package no.hackeriet;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.*;

public class TopKek {
    public static String readFile(InputStream is) throws FileNotFoundException {
        return new Scanner(is).useDelimiter("\\Z").next();
    }

    public static void parse(String input) {
        String[] parts = input.split(" |\n");



        for(Map<String, Integer> translation : translationTables()) {
            StringBuilder sb = new StringBuilder();

            for(String p : parts) {
                sb.append(Integer.toString(translation.get(p)));
            }

            BigInteger bi = new BigInteger(sb.toString(), 10);
            System.out.println("bi.toString(256) = " + toStringFromInt(bi));
        }
    }

    public static String toStringFromInt(BigInteger bi) {
        StringBuilder append = new StringBuilder();
        for(String b : bi.toString(2).split("(?<=\\G........)")) {
            BigInteger bi2 = new BigInteger(b, 8);

            append.append((char) bi2.intValue());
        }
        return append.toString();
    }

    public static List<Map<String, Integer>> translationTables() {
        List<Map<String, Integer>> toRet = new ArrayList<>();

        Map<String, Integer> m = new HashMap<>();

        m.put("KEK!", 0);
        m.put("KEK!!", 1);
        m.put("KEK!!!", 2);
        m.put("KEK!!!!", 3);
        m.put("KEK!!!!!", 4);
        m.put("TOP!", 5);
        m.put("TOP!!", 6);
        m.put("TOP!!!", 7);
        m.put("TOP!!!!", 8);
        m.put("TOP!!!!!", 9);

        toRet.add(m);

        return toRet;
    }
}
