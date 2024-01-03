package buku.afsha_alifia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
   author : Afsha alifia putri
   nim :  32602200031

   berikan penjelasan kode ini baris perbaris dengan komentar
*/

// Kelas DateUtils
// Digunakan untuk melakukan konversi antara objek Date dan String
public class DateUtils {

    // Konstruktor private
    // Dideklarasikan private agar kelas ini tidak dapat diinstansiasi secara langsung
    private DateUtils() {
        // Private constructor to prevent instantiation
    }

    // Metode dateToString
    // Menerima objek Date dan mengembalikan representasi String dalam format "yyyy-MM-dd HH:mm:ss"
    public static String dateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    // Metode stringToDate
    // Menerima String yang mewakili tanggal dalam format "yyyy-MM-dd HH:mm:ss"
    // dan mengembalikan objek Date
    // Melempar ParseException jika ada masalah saat parsing tanggal
    public static Date stringToDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.parse(dateString);
    }
}
