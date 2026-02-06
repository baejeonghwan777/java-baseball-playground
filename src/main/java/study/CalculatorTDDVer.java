package study;

public class CalculatorTDDVer {
    final static int FIRST_NUM = 0;

    public String[] split(String string) {
        if (string == null) {
            return new String[]{};
        }
        return string.split(" ");
    }

    public Integer toInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException | NullPointerException e) {
            return null;
        }
    }

    Integer add(int i, int j) {
        if ((i >= 0 || j >= 0) && i > Integer.MAX_VALUE - j) {
            return Integer.MAX_VALUE;
        } else if ((i < 0 || j < 0) && i < Integer.MIN_VALUE - j) {
            return Integer.MIN_VALUE;
        }
        return i + j;
    }

    Integer subtract(int i, int j) {
        if ((i >= 0 || j < 0) && i > Integer.MAX_VALUE + j) {
            return Integer.MAX_VALUE;
        } else if ((i < 0 || j >= 0) && i < Integer.MIN_VALUE + j) {
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
        if (j == 0) return null;
        else if (i == Integer.MIN_VALUE && j == -1) {
            return Integer.MAX_VALUE;
        }
        return i / j;
    }

    public Integer selectCal(String[] values) {
        Integer result = toInt(values[FIRST_NUM]); // 첫번째 값 초기화

        for (int i = 2; i < values.length; i += 2) {
            Integer cal = toInt(values[i]);
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

        return result;
    }

}
