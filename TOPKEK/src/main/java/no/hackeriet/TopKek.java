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

        String[] tokKek = new String[] {"KEK!", "KEK!!", "KEK!!!", "KEK!!!!", "KEK!!!!!", "TOP!", "TOP!!", "TOP!!!", "TOP!!!!", "TOP!!!!!"};

        Permutations<String> per = new Permutations<>(tokKek);

        for (String[] m = tokKek; per.hasNext(); m = per.next()) {
            Map<String, Integer> translation = new HashMap<>();

            translation.put(m[0], 0);
            translation.put(m[1], 1);
            translation.put(m[2], 2);
            translation.put(m[3], 3);
            translation.put(m[4], 4);
            translation.put(m[5], 5);
            translation.put(m[6], 6);
            translation.put(m[7], 7);
            translation.put(m[8], 8);
            translation.put(m[9], 9);

            StringBuilder sb = new StringBuilder();

            for (String p : parts) {
                sb.append(Integer.toString(translation.get(p)));
            }

            BigInteger bi = new BigInteger(sb.toString(), 10);

            String maybeFlag = toStringFromInt(bi);
            if(maybeFlag.startsWith("flag{"))
                System.out.println("bi.toString(256) = " + maybeFlag);
        }
    }

    public static String toStringFromInt(BigInteger bi) {
        StringBuilder append = new StringBuilder();
        for (String b : bi.toString(2).split("(?<=\\G........)")) {
            BigInteger bi2 = new BigInteger(b, 2);

            append.append((char) bi2.intValue());
        }
        return append.toString();
    }

    public static List<Map<String, Integer>> translationTables() {
        List<Map<String, Integer>> toRet = new ArrayList<>();

        List<String> tokens = new ArrayList<>();
        tokens.add("KEK!");
        tokens.add("KEK!!");
        tokens.add("KEK!!!");
        tokens.add("KEK!!!!");
        tokens.add("KEK!!!!!");
        tokens.add("TOP!");
        tokens.add("TOP!!");
        tokens.add("TOP!!!");
        tokens.add("TOP!!!!");
        tokens.add("TOP!!!!!");

        permute(tokens, 0, toRet);

        return toRet;
    }

    static void permute(List<String> arr, int k, List<Map<String, Integer>> result) {
        for (int i = k; i < arr.size(); i++) {
            java.util.Collections.swap(arr, i, k);
            permute(arr, k + 1, result);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
            Map<String, Integer> m = new HashMap<>();

            m.put(arr.get(0), 0);
            m.put(arr.get(1), 1);
            m.put(arr.get(2), 2);
            m.put(arr.get(3), 3);
            m.put(arr.get(4), 4);
            m.put(arr.get(5), 5);
            m.put(arr.get(6), 6);
            m.put(arr.get(7), 7);
            m.put(arr.get(8), 8);
            m.put(arr.get(9), 9);

            result.add(m);
        }
    }
}
