package logic;

import models.Car;

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

        System.out.println("main servlet do get");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars?serverTimezone=UTC", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from vip_cars");

            req.setAttribute("cars", getCars(resultSet));
            req.setAttribute("currentPath", req.getContextPath());

            connection.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        req.getRequestDispatcher("/pages/main.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars?serverTimezone=UTC", "root", "password");

            String model = req.getParameter("model");
            String color = req.getParameter("color");
            String producer = req.getParameter("producer");
            String ownerNickname = req.getParameter("ownerNickname");
            int ownerAge = Integer.parseInt(req.getParameter("ownerAge"));

            String insert = "insert into vip_cars(model, color, producer, ownerNickname, ownerAge) values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setString(1, model);
            preparedStatement.setString(2, color);
            preparedStatement.setString(3, producer);
            preparedStatement.setString(4, ownerNickname);
            preparedStatement.setInt(5, ownerAge);

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.executeQuery("select * from vip_cars");

            req.setAttribute("cars", getCars(resultSet));
            req.setAttribute("currentPath", req.getContextPath());

            connection.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        req.getRequestDispatcher("/pages/main.jsp").forward(req, resp);
    }


    public List<Car> getCars(ResultSet resultSet) throws SQLException {
        List<Car> cars = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String model = resultSet.getString(2);
            String color = resultSet.getString(3);
            String producer = resultSet.getString(4);
            String ownerNickname = resultSet.getString(5);
            int ownerAge = resultSet.getInt(6);

            Car car = new Car(id, model, color, producer, ownerNickname, ownerAge);
            cars.add(car);
        }

        return cars;
    }
}
