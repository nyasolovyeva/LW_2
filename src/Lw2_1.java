import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String date1 = "Введите дату в формате дд/мм/гггг: ";
        System.out.println(date1);

        String date = sc.nextLine();
        //далее проверяем, что на определённых индексах стоят "/"; если 4 случая: 1/1/2000;1/01/2000; 01/1/2000; 01/01/2000 (смотря, как введёт пользователь):
        if ((date.charAt(2) == '/' && date.charAt(5) == '/') || (date.charAt(2) == '/' && date.charAt(4) == '/') || (date.charAt(1) == '/' && date.charAt(4) == '/') || (date.charAt(1) == '/' && date.charAt(3) == '/')) {

            String[] arr_date = date.split("/"); //мы освобождаем от строки с /, чтобы потом строчки из чисел нам уже перевести в int и поставить ограничения

            //преобразовываем String в int:
            int dd = Integer.parseInt(arr_date[0]);

            int mm = Integer.parseInt(arr_date[1]);

            int yyyy = Integer.parseInt(arr_date[2]);

            if (yyyy < 1900 || yyyy > 9999 || mm > 12 || dd > 31) {
                System.out.println("Введённое выражение не является датой.");
            }
            else {
                if (mm == 2 && dd > 28 ) //проверка на корректрость даты февраля:
                {
                    if (yyyy % 4 == 0 & yyyy % 100 != 0 & dd < 30) { //год является високосным, если он кратен 4 и при этом не кратен 100
                        System.out.println("Введённое выражение является датой.");
                    } else {
                        System.out.println("В феврале всего 28 дней.");
                    }
                } else {
                    System.out.println("Введённое выражение является датой.");
                }
            }
        }
        else{
            System.out.println("Введённое выражение не соответствует заданному формату даты dd/mm/yyyy.");
        }
    }
}
