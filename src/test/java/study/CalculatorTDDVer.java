package study;

import org.junit.jupiter.api.AfterEach;

public class CalculatorTDDVer {

    public String[] split(String s) {
        if (s == null) {
            return new String[]{};
        }
        return s.split(" ");
    }

//    public int[] toInt(String[] values) {
//        if (values == null) {
//            return new int[]{};
//        }
//        int[] numbers = new int[values.length];
//        for(int i=0;i<values.length;i++) {
//            numbers[i] = Integer.parseInt(values[i]);
//        }
//        return numbers;
//    }

    public Integer toInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException | NullPointerException e) {
            return null;
        }
    }

    Integer add(int i, int j) {
        if((i >= 0 || j >= 0) && i > Integer.MAX_VALUE - j) {
            return Integer.MAX_VALUE;
        } else if((i < 0 || j < 0) && i < Integer.MIN_VALUE - j) {
            return Integer.MIN_VALUE;
        }
        return i + j;
    }

    Integer subtract(int i, int j) {
        if((i >= 0 || j < 0) && i > Integer.MAX_VALUE + j) {
            return Integer.MAX_VALUE;
        } else if((i < 0 || j >= 0) && i < Integer.MIN_VALUE + j) {
            return Integer.MIN_VALUE;
        }
        return i - j;
    }

    Integer multiply(int i, int j) {
        if (i == 0 || j == 0) return 0;
        int res = i * j;
        if (res / j != i) {
            if ((i > 0 && j > 0) || (i < 0 && j < 0)) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        return res;
    }

    Integer divide(int i, int j) {
        if(j == 0) return null;
        else if (i == Integer.MIN_VALUE && j == -1) {
            return Integer.MAX_VALUE;
        }
        return i / j;
    }

    public Integer selectCal(String[] values) {
        Integer result = 0;

        for(int i=0;i < values.length;i+=2) {
            if(i == 0) {
                result = toInt(values[0]);
            } else if(i != 0) {
                int cal = toInt(values[i]);
                switch (values[i - 1]) {
                    case "+":
                        result = add(result, cal);
                        break;
                    case "-":
                        result = subtract(result, cal);
                        break;
                    case "*":
                        result = multiply(result, cal);
                        break;
                    case "/":
                        result = divide(result, cal);
                        break;
                    default:
                        result = null;
                }
            }
        }

        return result;
    }

}
