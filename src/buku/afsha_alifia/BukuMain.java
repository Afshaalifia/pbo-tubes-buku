package buku.afsha_alifia;


/*


author : Afsha alifia putri
nim :  32602200031

berikan penjelasan kode ini baris perbaris dengan komentar
*/



import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BukuMain extends javax.swing.JFrame {

    DefaultTableModel model;
    private DatabaseManager dbHelper;
    BukuDAOImpl bukuDAOImpl;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    JButton btn_hapus;
    JButton btn_keluar1;
    JButton btn_tambah;
    JButton btn_ubah;
    JTextField id_buku;
    JTextField isbn;
    JLabel jlabelProgram;
    JLabel jLabel1;
    JLabel jLabel10;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JLabel jLabel6;
    JLabel jLabel7;
    JLabel jLabel8;
    JLabel jLabel9;
    JScrollPane jScrollPane1;
    JTextField judul_buku;
    JTextField kode_buku;
    JTextField penerbit;
    JTextField pengarang;
    JTable tabel;
    JDateChooser create_at;
    JDateChooser update_at;
    // End of variables declaration//GEN-END:variables

    private int selectedRowIndex = -1;

    public BukuMain() throws ParseException {
        initComponents();
        dbHelper = new DatabaseManager(); // Initialize DatabaseHelper
        bukuDAOImpl = new BukuDAOImpl();
        String[] judul = {"Id Buku", "Judul Buku", "Kode Buku", "Pengarang", "Penerbit", "ISBN", "Create at", "Update at"};
        model = new DefaultTableModel(judul, 0);
        tabel.setModel(model);
        tampilkan();
    }

    public void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manajemen Buku");

        // Initialize components
        id_buku = new JTextField();
        judul_buku = new JTextField();
        kode_buku = new JTextField();
        pengarang = new JTextField();
        penerbit = new JTextField();
        isbn = new JTextField();
        create_at = new JDateChooser();
        update_at = new JDateChooser();
        tabel = new JTable();
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(tabel);

        // Button components
        btn_keluar1 = new JButton("Keluar");
        btn_tambah = new JButton("Tambah");
        btn_ubah = new JButton("Ubah");
        btn_hapus = new JButton("Hapus");

        // Label components
        jlabelProgram = new JLabel("Program pencatatan buku");
        jLabel1 = new JLabel("Id Buku");
        jLabel2 = new JLabel("Judul Buku");
        jLabel3 = new JLabel("Kode Buku");
        jLabel4 = new JLabel("Pengarang");
        jLabel5 = new JLabel("Penerbit");
        jLabel6 = new JLabel("ISBN");
        jLabel7 = new JLabel("Create at");
        jLabel8 = new JLabel("Update at");

        // Panel components
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();

        GroupLayout layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jlabelProgram)
                        .addGap(20)// Add title
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(id_buku)
                        .addComponent(judul_buku)
                        .addComponent(kode_buku)
                        .addComponent(pengarang)
                        .addComponent(penerbit)
                        .addComponent(isbn)
                        .addComponent(create_at)
                        .addComponent(update_at)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(jlabelProgram) // Add title
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(id_buku))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(judul_buku))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(kode_buku))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(pengarang))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(penerbit))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(isbn))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(create_at))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(update_at)));

        layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(btn_tambah)
                .addComponent(btn_ubah)
                .addComponent(btn_hapus));

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btn_tambah)
                .addComponent(btn_ubah)
                .addComponent(btn_hapus));

        GroupLayout mainLayout = new GroupLayout(jPanel3);
        jPanel3.setLayout(mainLayout);
        mainLayout.setAutoCreateGaps(true);
        mainLayout.setAutoCreateContainerGaps(true);

        mainLayout.setHorizontalGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1)
                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        mainLayout.setVerticalGroup(mainLayout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(jScrollPane1)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));

        // Set the layout for the frame
        GroupLayout frameLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(frameLayout);

        frameLayout.setHorizontalGroup(frameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        frameLayout.setVerticalGroup(frameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();

        // Add action listeners to buttons
        btn_tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btn_tambahActionPerformed(e);
                } catch (ParseException ex) {
                    Logger.getLogger(BukuMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btn_ubah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btn_ubahActionPerformed(e);
                } catch (ParseException ex) {
                    Logger.getLogger(BukuMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btn_hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btn_hapusActionPerformed(e);
                } catch (ParseException ex) {
                    Logger.getLogger(BukuMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btn_keluar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_keluarActionPerformed(e);
            }
        });

        // Add list selection listener to the table
        tabel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    selectedRowIndex = tabel.getSelectedRow();
                    if (selectedRowIndex >= 0) {
                        fillFormWithSelectedData();
                    }
                }
            }
        });
    }

    private void tampilkan() throws ParseException {
        // Bersihkan tabel
        model.setRowCount(0);

        // Ambil data dari database dan tampilkan di tabel
        List<Buku> listBuku = bukuDAOImpl.getAllBuku();
        for (Buku buku : listBuku) {
            Object[] row = {
                buku.getIdBuku(),
                buku.getJudulBuku(),
                buku.getKodeBuku(),
                buku.getPengarang(),
                buku.getPenerbit(),
                buku.getIsbn(),
                DateUtils.dateToString(buku.getCreateAt()),
                DateUtils.dateToString(buku.getUpdateAt())
            };
            model.addRow(row);
        }
    }

    private void btn_tambahActionPerformed(ActionEvent evt) throws ParseException {
        // Mendapatkan data dari inputan user
        String judul = judul_buku.getText();
        String kode = kode_buku.getText();
        String pengarangBuku = pengarang.getText();
        String penerbitBuku = penerbit.getText();
        String isbnBuku = isbn.getText();

        // Mendapatkan tanggal saat ini
        Date createDate = new Date();

        // Membuat objek buku tanpa menyertakan ID
        Buku buku = new Buku(0, judul, kode, pengarangBuku, penerbitBuku, isbnBuku, createDate, createDate);

        // Menambahkan buku ke database
        bukuDAOImpl.addBuku(buku);

        // Menampilkan ulang data pada tabel
        tampilkan();

        // Mengosongkan inputan
        judul_buku.setText("");
        kode_buku.setText("");
        pengarang.setText("");
        penerbit.setText("");
        isbn.setText("");
    }

    private void btn_ubahActionPerformed(ActionEvent evt) throws ParseException {
        // Memastikan bahwa baris telah dipilih
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Pilih buku yang akan diubah!");
            return;
        }

        // Mendapatkan ID buku dari baris yang dipilih
        int id = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());

        // Mendapatkan data dari inputan user
        String judul = judul_buku.getText();
        String kode = kode_buku.getText();
        String pengarangBuku = pengarang.getText();
        String penerbitBuku = penerbit.getText();
        String isbnBuku = isbn.getText();

        // Mendapatkan tanggal saat ini
        Date updateDate = new Date();

        // Membuat objek buku
        Buku buku = new Buku(id, judul, kode, pengarangBuku, penerbitBuku, isbnBuku, updateDate, updateDate);

        // Mengubah buku di database
        bukuDAOImpl.updateBuku(buku);

        // Menampilkan ulang data pada tabel
        tampilkan();

        // Mengosongkan inputan
        id_buku.setText("");
        judul_buku.setText("");
        kode_buku.setText("");
        pengarang.setText("");
        penerbit.setText("");
        isbn.setText("");
        selectedRowIndex = -1;
    }

    private void btn_hapusActionPerformed(ActionEvent evt) throws ParseException {
        // Memastikan bahwa baris telah dipilih
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Pilih buku yang akan dihapus!");
            return;
        }

        // Mendapatkan ID buku dari baris yang dipilih
        int id = Integer.parseInt(id_buku.getText());

        // Menghapus buku dari database
        bukuDAOImpl.deleteBuku(id);

        // Menampilkan ulang data pada tabel
        tampilkan();

        // Mengosongkan inputan
        id_buku.setText("");
        judul_buku.setText("");
        kode_buku.setText("");
        pengarang.setText("");
        penerbit.setText("");
        isbn.setText("");
        selectedRowIndex = -1;
    }

    private void btn_keluarActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void fillFormWithSelectedData() {
        id_buku.setText(model.getValueAt(selectedRowIndex, 0).toString());
        judul_buku.setText(model.getValueAt(selectedRowIndex, 1).toString());
        kode_buku.setText(model.getValueAt(selectedRowIndex, 2).toString());
        pengarang.setText(model.getValueAt(selectedRowIndex, 3).toString());
        penerbit.setText(model.getValueAt(selectedRowIndex, 4).toString());
        isbn.setText(model.getValueAt(selectedRowIndex, 5).toString());

        // Menetapkan tanggal ke JDateChooser
        try {
            Date createDate = DateUtils.stringToDate(model.getValueAt(selectedRowIndex, 6).toString());
            create_at.setDate(createDate);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        try {
            Date updateDate = DateUtils.stringToDate(model.getValueAt(selectedRowIndex, 7).toString());
            update_at.setDate(updateDate);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BukuMain().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(BukuMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
