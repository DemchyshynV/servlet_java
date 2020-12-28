package logic;

import constants.DataBaseConstants;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Class.forName(DataBaseConstants.JDBC_DRIVER);

            Connection connection = DriverManager.getConnection(DataBaseConstants.DATA_BASE_URL, DataBaseConstants.USER, DataBaseConstants.PASSWORD);

            PreparedStatement preparedStatementUsersWithCars = connection.prepareStatement("select * from Cars join Users on Cars.userid = Users.id");
            ResultSet resultSetUsersWithCars = preparedStatementUsersWithCars.executeQuery();

            PreparedStatement preparedStatementUsers = connection.prepareStatement("select * from Users");
            ResultSet resultSetUsers = preparedStatementUsers.executeQuery();

            req.setAttribute("users_with_cars", getUsersWithCars(resultSetUsersWithCars));
            req.setAttribute("users", getUsers(resultSetUsers));

            connection.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        req.getRequestDispatcher("/pages/main.jsp").forward(req, resp);
    }


    public List<String> getUsersWithCars(ResultSet resultSet) throws SQLException {
        List<String> usersWithCars = new ArrayList<>();

        while (resultSet.next()) {
            int userid = resultSet.getInt("userid");
            int age = resultSet.getInt("age");
            String name = resultSet.getString("name");
            String brand = resultSet.getString("brand");

            usersWithCars.add("user id: " + userid + ", age:" + age + ", name: " + name + ", car brand: " + brand);
        }

        return usersWithCars;
    }

    public List<User> getUsers(ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int age = resultSet.getInt("age");
            String name = resultSet.getString("name");

            User user = new User(id, age, name);
            users.add(user);
        }

        return users;
    }
}
