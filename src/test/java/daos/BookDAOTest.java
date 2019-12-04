package daos;

import models.Books;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOTest {
    Books book = new Books();
    BookDAO dao = new BookDAO();

    @Before
    public void setUp(){
        book.setId(11);
        book.setTitle("Between the World and Me");
        book.setIsbn("9788875787585");
        book.setGender("Male");
        book.setPublisher("Spiegel & Grau");

    }

    @Test
    public void findByIdTest() throws SQLException, ClassNotFoundException {
        Books book = dao.findById(8);
        Assert.assertEquals("Wendi Inde", book.getTitle());

    }

    @Test
    public void findAllTest() throws SQLException, ClassNotFoundException {
        List<Books> book = dao.findAll();
        Assert.assertEquals("Winona Calken", book.get(8).getTitle());
    }

    @Test
    public void updateTest() throws ClassNotFoundException, SQLException {
        Books test = new Books(0,"Green Eggs and Ham", "743829749831724", "Male", "A Who in Whoville");
        dao.create(test);

        List<Books> book = dao.findAll();
        test.setGender("Female");
        dao.update(test);

        Assert.assertEquals("Female",book.get(book.size()-1).getGender());
    }

    @Test
    public void createTest() throws ClassNotFoundException, SQLException {
        Books test = new Books(0,"Down A Dark Hall", "73482974892", "Female", "HorrorHouse");
        dao.create(test);
        List<Books> book = dao.findAll();

        Assert.assertEquals("Down A Dark Hall",book.get(book.size()-1).getTitle());

    }

    @Test
    public void deleteTest() throws ClassNotFoundException, SQLException {
        Assert.assertTrue(dao.delete(11));
    }
}
