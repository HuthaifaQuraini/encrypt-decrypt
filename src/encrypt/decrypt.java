package encrypt;

import static java.lang.Math.pow;

/**
 *
 * @author Huthaifa A Quraini
 */
public class decrypt {

    private String txt;

    public decrypt(String txt) {
        this.txt = txt;
    }

    private String split() {
        String result = "", n;

        for (int i = 0; i < txt.length(); i++) {
            n = toBinary((int) (txt.charAt(i) )-5) + "";
            n = format(n);
            n = Decrypt(n);
            
            n = (char) toDec(n) + "";
            result += n;
        }

        return result;

    }
 private String format(String binary) {
        String x = "";
        if (binary.length() < 16) {
            for (int i = 0; i < 16 - binary.length(); i++) {
                x += "0";
            }
        }
        x += binary;
        return x;

    }
    private String Decrypt(String n) {
        String result = "";
        for (int i = 0; i < n.length() / 2; i++) {
            if (n.charAt(i) == '0') {
                result += "1";
            } else {
                result += "0";
            }
        }
        result += n.charAt(n.length() - 1);
        for (int i = (n.length() / 2) + 1; i < n.length() - 1; i++) {
            result += n.charAt(i);
        }
        result += n.charAt(n.length() / 2);
        return result;

    }

    private String toBinary(int dec) {
        String result = "";
        while (dec != 0) {
            result += (dec % 2);
            dec /= 2;
        }

        String result_inverse = "";
        for (int i = result.length() - 1; i >= 0; i--) {
            result_inverse += result.charAt(i);
        }

        return result_inverse;
    }

    private int toDec(String t) {
        Long num = new Long(t);
        int sum = 0;
        int e = 0;
        while (num != 0) {
            sum += (num % 10) * pow(2, e++);
            num /= 10;
        }

        return sum;
    }

    @Override
    public String toString() {
        return split();
    }
}
