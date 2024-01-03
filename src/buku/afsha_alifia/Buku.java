package buku.afsha_alifia;


/*
author : Afsha alifia putri
nim :  32602200031

berikan penjelasan kode ini baris perbaris dengan komentar, bagian polimorfisme, getter setter, constructor, inheritance
*/

import java.util.Date;

public class Buku {
    // Atribut private untuk menyimpan informasi buku
    private int idBuku;
    private String judulBuku;
    private String kodeBuku;
    private String pengarang;
    private String penerbit;
    private String isbn;
    private Date createAt;
    private Date updateAt;

    // Constructor untuk membuat objek Buku dengan memberikan nilai awal pada atribut
    public Buku(int idBuku, String judulBuku, String kodeBuku, String pengarang, String penerbit, String isbn, Date createAt, Date updateAt) {
        this.idBuku = idBuku;
        this.judulBuku = judulBuku;
        this.kodeBuku = kodeBuku;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.isbn = isbn;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    // Getter dan setter untuk mengakses dan mengubah nilai atribut private
    public int getIdBuku() {
        return idBuku;
    }
// Getter dan setter untuk mengakses dan mengubah nilai atribut private
    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }
// Getter dan setter untuk mengakses dan mengubah nilai atribut private
    public String getJudulBuku() {
        return judulBuku;
    }
// Getter dan setter untuk mengakses dan mengubah nilai atribut private
    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }
// Getter dan setter untuk mengakses dan mengubah nilai atribut private
    public String getKodeBuku() {
        return kodeBuku;
    }
// Getter dan setter untuk mengakses dan mengubah nilai atribut private
    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }
// Getter dan setter untuk mengakses dan mengubah nilai atribut private
    public String getPengarang() {
        return pengarang;
    }
// Getter dan setter untuk mengakses dan mengubah nilai atribut private
    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }
// Getter dan setter untuk mengakses dan mengubah nilai atribut private
    public String getPenerbit() {
        return penerbit;
    }
// Getter dan setter untuk mengakses dan mengubah nilai atribut private
    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
// Getter dan setter untuk mengakses dan mengubah nilai atribut private
    public String getIsbn() {
        return isbn;
    }
// Getter dan setter untuk mengakses dan mengubah nilai atribut private
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
// Getter dan setter untuk mengakses dan mengubah nilai atribut private
    public Date getCreateAt() {
        return createAt;
    }
// Getter dan setter untuk mengakses dan mengubah nilai atribut private
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
// Getter dan setter untuk mengakses dan mengubah nilai atribut private
    public Date getUpdateAt() {
        return updateAt;
    }
// Getter dan setter untuk mengakses dan mengubah nilai atribut private
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
