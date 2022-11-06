import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Converter converter = new Converter();
        String[] act = {"+", "-", "/", "*"};
        String[] regexAct = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение, состоящее из двух натуральных чисел, в арабской или римской системе счисления" +
                " от 1 до 10 включительно и знака операции (+,-,*,/) между ними.\n" +
                "Пример: 2+2.\n" +
                "Пример: II-I.\n" +
                "Нельзя использовать арабские и римские цифры вместе!\n");
        String exp = scn.nextLine();
        int actIndex=-1;
        for (int i = 0; i < act.length; i++) {
            if(exp.contains(act[i])){
                actIndex = i;
                break;
            }
        }
        if(actIndex==-1){
            System.out.println("Ошибка! Некорректное выражение");
            return;
        }

        String[] data = exp.split(regexAct[actIndex]);

        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
            int a,b;

            boolean isRoman = converter.isRoman(data[0]);
            if(isRoman){

                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            }else{

                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }

            int result;
            switch (act[actIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }

            if ((a > 10 || a < 1) || (b > 10 || b < 1)) {System.out.println("ошибка! Числа должны быть больше 0 и меньше 11");System.exit(0);}

            if(isRoman){

                System.out.println(converter.intToRoman(result));
            }
            else{

                System.out.println(result);
            }
        }else{
            System.out.println("Ошибка! Числа должны быть в одном формате");
        }


    }
}