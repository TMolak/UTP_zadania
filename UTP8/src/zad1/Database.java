package zad1;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private String url;
    private TravelData travelData;
    public Database(String url, TravelData travelData){
        this.url = url;
        this.travelData = travelData;
    }

    public void create() {
//        try{
//            Connection connection = DriverManager.getConnection(url+";create=true");
//            Statement statement = connection.createStatement();
//
//
//        }catch (SQLException e){
//            System.out.println(e);
//        }
    }

    public void showGui() {

    }
}
