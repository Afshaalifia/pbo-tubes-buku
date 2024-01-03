package buku.afsha_alifia;

/*
   author : Afsha alifia putri
   nim :  32602200031

   berikan penjelasan kode ini baris perbaris dengan komentar, bagian interface
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

// Interface BukuDAO
// Digunakan sebagai kerangka kerja untuk kelas yang akan mengakses dan memanipulasi data buku dalam database

public interface BukuDAO {
    // Metode untuk menambahkan buku ke database
    void addBuku(Buku buku);

    // Metode untuk memperbarui informasi buku di database
    void updateBuku(Buku buku);

    // Metode untuk mendapatkan daftar semua buku dari database
    List<Buku> getAllBuku() throws ParseException;

    // Metode untuk menghapus buku dari database berdasarkan ID
    void deleteBuku(int idBuku);
}
