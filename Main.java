
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner string = new Scanner(System.in);
        String info = string.nextLine();
        //String info = "LXXX + VII";
        String result = calc(info);
        System.out.println(result);
    }

    public static String calc(String input) throws Exception{
        String[] vars = input.split(" ");
        if (vars.length != 3){
            throw new Exception("Требуется два операнда и один оператор (+, -, /, *)");
        }
        Integer[] arabic = {0, 0, 0};
        String result = "";
        try {
            for (int i = 0; i < 3; i += 2) {
                if (Integer.parseInt(vars[i]) < 1 || Integer.parseInt(vars[i]) > 10) {
                    throw new Exception();
                }
                arabic[i] = Integer.parseInt(vars[i]);
            }
            return String.valueOf(count(arabic, vars));
        }
        catch (Exception e){
            String[] array = new String[] {
                    "C,100", "XC,90", "L,50", "XL,40", "X,10", "IX,9", "V,5", "IV,4", "I,1"
            };
            for (int i = 0; i < 3; i += 2) {
                switch (vars[i]) {
                    case "I" -> arabic[i] = 1;
                    case "II" -> arabic[i] = 2;
                    case "III" -> arabic[i] = 3;
                    case "IV" -> arabic[i] = 4;
                    case "V" -> arabic[i] = 5;
                    case "VI" -> arabic[i] = 6;
                    case "VII" -> arabic[i] = 7;
                    case "VIII" -> arabic[i] = 8;
                    case "IX" -> arabic[i] = 9;
                    case "X" -> arabic[i] = 10;
                    default -> throw new Exception("Ожидается либо два римских либо два целых арабских числа в пределах от 1 до 10");
                }
                }
            int countnum = count(arabic, vars);

            if (countnum < 1){
                throw new Exception("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
            }

            while (countnum > 0) {
                for (int i = 0; i < 9; i ++){
                    int arraynum = Integer.parseInt(array[i].split(",")[1]);
                    if(countnum >= arraynum){
                        countnum -= arraynum;
                        result += array[i].split(",")[0];
                        break;
                    }
                }
            }
            return result;
            }
    }

    public static Integer count(Integer [] arabicnum, String [] numbers) throws Exception {
        switch (numbers[1]) {
            case "+" -> {
                return arabicnum[0] + arabicnum[2];
            }
            case "-" -> {
                return arabicnum[0] - arabicnum[2];
            }
            case "*" -> {
                return arabicnum[0] * arabicnum[2];
            }
            case "/" -> {
                return arabicnum[0] / arabicnum[2];
            }
            default -> throw new Exception("Требуется оператор (+, -, /, *)");
        }
    }
    }

