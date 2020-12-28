package logic;

import constants.DataBaseConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Class.forName(DataBaseConstants.JDBC_DRIVER);

            Connection connection = DriverManager.getConnection(DataBaseConstants.DATA_BASE_URL, DataBaseConstants.USER, DataBaseConstants.PASSWORD);

            int age = Integer.parseInt(req.getParameter("age"));
            String name = req.getParameter("name");

            String insert = "insert into Users(age, name) values (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setInt(1, age);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        resp.sendRedirect("/");
    }
}
