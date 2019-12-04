package daos;

import models.Books;
import models.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookDAO implements DAO<Books> {

    public Books findById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionFactory.getConnection();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM books WHERE id = " + id);

            if(rs.next()){
                return extractBookFromResultSet(rs);
            }
        }catch(SQLException e){
            System.out.println("Find book by id failed ");
            e.printStackTrace();
            connection.close();
        }
        return null;
    }

    public List<Books> findAll() throws ClassNotFoundException, SQLException {
        List<Books> books = new ArrayList<Books>();
        Connection connection = ConnectionFactory.getConnection();

        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM books");

            while(rs.next()){
                Books book = extractBookFromResultSet(rs);
                books.add(book);
            }
            return books;

        }catch(SQLException e){
            System.out.println("Find all books, Failed");
            e.printStackTrace();
            connection.close();
        }

        return null;
    }


    public boolean update(Books book) throws ClassNotFoundException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE books SET title=?, isbn=?, gender=?, publisher=? WHERE id=?");
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getIsbn());
            ps.setString(3, book.getGender());
            ps.setString(4, book.getPublisher());
            ps.setInt(5, book.getId());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    public boolean create(Books book) throws ClassNotFoundException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO books (title, isbn, gender, publisher) VALUES (?, ?, ?, ?)");
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getIsbn());
            ps.setString(3, book.getGender());
            ps.setString(4, book.getPublisher());

            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) throws ClassNotFoundException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM books WHERE id=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    private Books extractBookFromResultSet(ResultSet rs) throws SQLException {
        Books book = new Books();
        book.setId( rs.getInt("id") );
        book.setTitle( rs.getString("title") );
        book.setIsbn( rs.getString("isbn") );
        book.setGender( rs.getString("gender") );
        book.setPublisher( rs.getString("publisher") );

        return book;
    }
}
