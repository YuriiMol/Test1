import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] agrs) {
        String number1;
        String number2;
        int number1_int;
        int number2_int;
        int answer;
        String operation;


        Scanner input = new Scanner(System.in);
        System.out.println("Введите пример");

        number1 = input.next();
        number1_int = ROMAN.ToInt(number1);
        CHECKER.limit(number1_int);

        operation = input.next();

        number2 = input.next();
        number2_int = ROMAN.ToInt(number2);
        CHECKER.limit(number2_int);

        CHECKER.roman();


        answer = (CHECKER.opearation(number1_int, number2_int, operation));
        System.out.println(ROMAN.ToRoman(answer));
    }


    public static class ROMAN {
        static int roman_checker = 0;
        static String[] romans = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        static String[] arabics = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"};

        public static int ToInt(String number) {

            number = number.toUpperCase();
            int num_int = 0;
            for (int i = 0; i < 10; i++) {
                if (romans[i].equals(number)) {
                    roman_checker++;
                    num_int = i + 1;
                }
            }
            for (int i = 0; i < 10; i++) {
                if (arabics[i].equals(number)) {
                    num_int = i + 1;
                }
            }
            return (num_int);
        }

        public static String ToRoman(int answer) {
            String str_answer = String.valueOf(answer);
            if (roman_checker == 2) {
                for (int i = 0; i < 100; i++) {
                    if (str_answer.equals(arabics[i])) {
                        roman_checker++;
                        str_answer = romans[i];
                    }
                }
            }
            return str_answer;
        }
    }

    public static class CHECKER {

        public static void limit(int check_number) {
            if (check_number == 0) {
                System.exit(0);
            }
        }

        public static void roman() {
            if (ROMAN.roman_checker == 1) {
                System.exit(0);
            }
        }

        public static int opearation(int number1_int, int number2_int, String operation) {
            int answer = 0;
            if (operation.equals("+")) {
                answer = CALCULATION.plus(number1_int, number2_int);
            } else if (operation.equals("-")) {
                answer = CALCULATION.minus(number1_int, number2_int);
            } else if (operation.equals("*")) {
                answer = CALCULATION.multiply(number1_int, number2_int);
            } else if (operation.equals("/")) {
                answer = CALCULATION.divide(number1_int, number2_int);
            }
            return answer;
        }

    }

    public static class CALCULATION {
        public static int plus(int number1_int, int number2_int) {
            return (number1_int + number2_int);
        }

        public static int minus(int number1_int, int number2_int) {
            return (number1_int - number2_int);
        }

        public static int multiply(int number1_int, int number2_int) {
            return (number1_int * number2_int);
        }

        public static int divide(int number1_int, int number2_int) {
            return (number1_int / number2_int);
        }
    }
}

