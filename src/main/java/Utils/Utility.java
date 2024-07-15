package Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utility {

    public static LocalDateTime sqlDateTimeToLocalDateTime(String dateTime) {
        // Definisci il formato della stringa di data e ora da convertire
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Converte la stringa in un oggetto LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);

        return localDateTime;
    }

    public static boolean checkIfStringContainsOnlySpaces(String s) {

        //restituisce true se la stringa s contiene soltanto spazi vuoti

        boolean flag = true;

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) != ' ') {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
