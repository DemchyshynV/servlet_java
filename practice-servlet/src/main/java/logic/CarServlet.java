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

public class CarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Class.forName(DataBaseConstants.JDBC_DRIVER);

            Connection connection = DriverManager.getConnection(DataBaseConstants.DATA_BASE_URL, DataBaseConstants.USER, DataBaseConstants.PASSWORD);

            String brand = req.getParameter("brand");
            int userid = Integer.parseInt(req.getParameter("userid"));

            String insert = "insert into Cars(brand, userid) values (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setString(1, brand);
            preparedStatement.setInt(2, userid);

            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        resp.sendRedirect("/");
    }
}
