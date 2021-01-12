package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class creates the connection to the database.
 *
 * @author Mohammed Al-Ashtal, Daniel Weiser
 *
 */

public final class DbConnectionUtils {

	private static Connection connection;

	private DbConnectionUtils() {

	}

	private static void createConnectionToDatabase() {
		try {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection("jdbc:h2:./res/MoeDanHeyCar", "", "");

		} catch (ClassNotFoundException e) {
			System.err.println("The Database driver can not be found!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("The connection to the Database failed! Do you have allready an open connection to it?");
		}
	}

	public static Connection getDatabaseConnection() {

		if (connection == null) {

			createConnectionToDatabase();
		}
		return connection;
	}

}
