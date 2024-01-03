package buku.afsha_alifia;
/*
   author : Afsha alifia putri
   nim :  32602200031

   berikan penjelasan kode ini baris perbaris dengan komentar
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Kelas DatabaseManager
// Digunakan untuk mengelola koneksi ke database

public class DatabaseManager {
    // Metode getConnection
    // Digunakan untuk mendapatkan koneksi ke database
    public static Connection getConnection() throws SQLException {
        // Menggunakan DriverManager untuk mendapatkan koneksi dengan parameter URL, username, dan password
        // URL: "jdbc:mysql://localhost/db_buku"
        // Username: "root"
        // Password: "" (kosong)
        return DriverManager.getConnection("jdbc:mysql://localhost/db_buku", "root", "");
    }
}
