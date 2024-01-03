// Package declaration
package buku.afsha_alifia;
// Import statements
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/*
  author: Afsha alifia putri
  nim: 32602200031
  
  berikan penjelasan kode ini baris perbaris dengan komentar bagian polimorfisme dan inheritance di dalam kodenya
*/

// Class declaration: BukuDAOImpl implements BukuDAO
public class BukuDAOImpl implements BukuDAO {

    // Implementing the addBuku method from BukuDAO interface
    @Override
    public void addBuku(Buku buku) {
        try (Connection connection = DatabaseManager.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO t_buku (judul_buku, kode_buku, pengarang, penerbit, isbn, create_at, update_at) VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            // Setting values for the prepared statement
            preparedStatement.setString(1, buku.getJudulBuku());
            preparedStatement.setString(2, buku.getKodeBuku());
            preparedStatement.setString(3, buku.getPengarang());
            preparedStatement.setString(4, buku.getPenerbit());
            preparedStatement.setString(5, buku.getIsbn());
            preparedStatement.setString(6, DateUtils.dateToString(buku.getCreateAt()));
            preparedStatement.setString(7, DateUtils.dateToString(buku.getUpdateAt()));

            // Executing the SQL query
            preparedStatement.executeUpdate();

            // Retrieve the generated ID
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                buku.setIdBuku(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implementing the updateBuku method from BukuDAO interface
    @Override
    public void updateBuku(Buku buku) {
        try (Connection connection = DatabaseManager.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE t_buku SET judul_buku = ?, kode_buku = ?, pengarang = ?, penerbit = ?, isbn = ?, create_at = ?, update_at = ? WHERE id_buku = ?")) {

            // Setting values for the prepared statement
            preparedStatement.setString(1, buku.getJudulBuku());
            preparedStatement.setString(2, buku.getKodeBuku());
            preparedStatement.setString(3, buku.getPengarang());
            preparedStatement.setString(4, buku.getPenerbit());
            preparedStatement.setString(5, buku.getIsbn());
            preparedStatement.setString(6, DateUtils.dateToString(buku.getCreateAt()));
            preparedStatement.setString(7, DateUtils.dateToString(buku.getUpdateAt()));

            // Use setInt for id_buku
            preparedStatement.setInt(8, buku.getIdBuku());

            // Executing the SQL query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implementing the getAllBuku method from BukuDAO interface
    @Override
    public List<Buku> getAllBuku() throws ParseException {
        List<Buku> bukuList = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection(); 
             Statement statement = connection.createStatement(); 
             ResultSet resultSet = statement.executeQuery("SELECT * FROM t_buku")) {

            while (resultSet.next()) {
                // Creating a new Buku object with data from the result set
                Buku buku = new Buku(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        DateUtils.stringToDate(resultSet.getString(7)),
                        DateUtils.stringToDate(resultSet.getString(8))
                );

                // Adding the Buku object to the list
                bukuList.add(buku);
            }

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }

        // Returning the list of Buku objects
        return bukuList;
    }

    // Implementing the deleteBuku method from BukuDAO interface
    @Override
    public void deleteBuku(int idBuku) {
        try (Connection connection = DatabaseManager.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM t_buku WHERE id_buku = ?")) {

            // Setting the id_buku for the prepared statement
            preparedStatement.setInt(1, idBuku);

            // Executing the SQL query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
