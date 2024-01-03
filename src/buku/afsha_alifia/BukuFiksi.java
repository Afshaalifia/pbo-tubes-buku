// Package declaration
package buku.afsha_alifia;

// Import statements
import java.util.Date;

// inheritance dari buku
// BukuFiksi extends Buku, menggunakan inheritance dari kelas Buku
public class BukuFiksi extends Buku {
    private String genre;

    // Constructor untuk kelas BukuFiksi yang memanggil constructor kelas Buku menggunakan "super"
    public BukuFiksi(int idBuku, String judulBuku, String kodeBuku, String pengarang, String penerbit, String isbn, Date createAt, Date updateAt, String genre) {
        super(idBuku, judulBuku, kodeBuku, pengarang, penerbit, isbn, createAt, updateAt);
        this.genre = genre;
    }

    // Getter untuk mendapatkan genre
    public String getGenre() {
        return genre;
    }

    // Setter untuk mengatur genre
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
