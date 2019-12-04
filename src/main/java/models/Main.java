package models;

import daos.BookDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
         /* Test Connection */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        java.sql.Connection connection = ConnectionFactory.getConnection();
        BookDAO bookDAO = new BookDAO();
        Books myBook = bookDAO.findById(2);

        System.out.println("Starting Connection");

        try{
            List<Books> book = bookDAO.findAll();
            for(Books each : book){
                System.out.println(each.toString());
            }

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Connection failed");
        }
    }
}
