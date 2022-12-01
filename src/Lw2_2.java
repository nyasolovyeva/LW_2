import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password1 = "Введите пароль: ";
        System.out.println(password1);

        boolean pass_right = false;
        while (pass_right == false) {
            String password = sc.nextLine();
            if (password.length() >= 8) {
                if ((Pattern.compile("[a-z]+").matcher(password).find()) == true) { //+ - предшествующий символ входит в строку один и более раз
                    if ((Pattern.compile("[A-Z]+").matcher(password).find()) == true) {
                        if ((Pattern.compile("[а-я]+").matcher(password).find()) == false) {
                            if ((Pattern.compile("[А-Я]+").matcher(password).find()) == false) {
                                if ((Pattern.compile("[0-9]+").matcher(password).find()) == true) {
                                    if ((Pattern.compile("[`!£№$;%:^&?*()¬+=<>#.,/]+").matcher(password).find()) == false) {
                                        pass_right = true; //если всё выполнится, то меняем на true
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (pass_right == true) {
                System.out.println("Пароль надежен");
            } else {
                System.out.println("Пароль ненадежен. Повторите ввод.");
            }
        }
    }
}