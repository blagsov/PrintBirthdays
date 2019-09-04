import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Calendar.YEAR;
/*
code written
by Zoya Klocheva
 */

public class Main {
    /*
   очень простая программа на работу с датами
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
//----------------------------------------------------
        System.out.println("Введите дату рождения в формате \"" + inputFormat.toPattern() + "\":");
        String input = scanner.nextLine().trim();
//----------------------------------------------------
        Pattern pattern = Pattern.compile("(\\d{2})\\.(\\d{2})\\.(\\d{4})");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            System.out.println("Ошибка ввода!");
//----------------------------------------------------
        } else {
            Date date = inputFormat.parse(input, new ParsePosition(0));
//----------------------------------------------------
            Calendar birthday = new GregorianCalendar();
            Calendar now = new GregorianCalendar();
//----------------------------------------------------
            birthday.setTime(date);
//----------------------------------------------------
            DateFormat outputFormat = new SimpleDateFormat("dd.MM.yyyy - EEEE");
            /*если просто день недели,
              то убрать dd.MM.yyyy, а если нужно сокращенный день недели ставить,
               то  EEE
             */
            for (int x = 0; !birthday.after(now); x++) {
                System.out.println(x + " - " + outputFormat.format(birthday.getTime()));
                birthday.add(YEAR, 1);
            }
        }
    }
}
