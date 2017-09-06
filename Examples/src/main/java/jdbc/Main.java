package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC
 * Devcolibri
 *
 * https://www.youtube.com/playlist?list=PLIU76b8Cjem5qdMQLXiIwGLTLyUHkTqi2
 */

public class Main {

    //private final static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final static String URLFIXED =
            "jdbc:mysql://localhost:3306/mydbtest" +
                    //"?verifyServerCertificate=false" +
                    "?useUnicode=true" +
                    "&useSSL=true" +
                    //"&requireSSL=false"+
                    "&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false" +
                    "&serverTimezone=UTC";

    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    public static void main(String[] args) {

        lesson4();
        System.out.println("\n---\n");

        try (Connection connection = DriverManager.getConnection(URLFIXED, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()){
            //boolean resultB     = statement.execute("INSERT INTO animals(name, descr) VALUES ('nameQQ2', 'descQQ2');");
            //int result          = statement.executeUpdate("UPDATE animals SET name='new_val' WHERE id=1;");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM animals");
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.println(resultSet.getString("descr") + " ");
            }
            resultSet.close();


//            statement.addBatch("INSERT INTO animals(name, descr) VALUES ('name1', 'desc1');");
//            statement.addBatch("INSERT INTO animals(name, descr) VALUES ('name2', 'desc2');");
//            statement.addBatch("INSERT INTO animals(name, descr) VALUES ('name3', 'desc3');");
//            statement.executeBatch();
//            //statement.clearBatch();

            //System.out.println(statement.isClosed());


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }


    /**
     * https://pastebin.com/rwgPsfgW
     * https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue
     * https://ru.stackoverflow.com/questions/551454/jdbc-Не-создается-driver-new-fabricmysqldriver-java-se
     */
    public static void lesson4() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URLFIXED, USERNAME, PASSWORD);

            if (!connection.isClosed()) {
                System.out.println("Соединение с БД Установлено!");
            }
            connection.close();
            if (connection.isClosed()) {
                System.out.println("Соединение с БД Закрыто!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
