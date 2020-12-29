package database;

import java.sql.SQLException;
import java.sql.Statement;

public class DbDDLStatements {

	public static void createHeyCarDb() {

		try (Statement createHeyCarTable = DbConnectionUtils.getDatabaseConnection().createStatement()) {
			createHeyCarTable.execute("CREATE TABLE IF NOT EXISTS Car (id INTEGER AUTO_INCREMENT PRIMARY KEY,"
					+ " brandid INTEGER, modelid INTEGER, "
					+ " dateOfRelease DATE, mileage INTEGER, transmission VARCHAR(50), power INTEGER, "
					+ " fuel VARCHAR(50), color VARCHAR(50), status VARCHAR(50), price DOUBLE, "
					+ " FOREIGN KEY(brandid) REFERENCES Brand(id),"
					+ " FOREIGN KEY(modelid) REFERENCES Model(id));");
			System.out.println("Car-Table is created");

		} catch (SQLException e) {
			System.out.println("HeyCar table is not created !");
			e.printStackTrace();
		}

	}

	public static void createBrandTable() {

		try (Statement createBrandStatement = DbConnectionUtils.getDatabaseConnection().createStatement()) {

			createBrandStatement.execute(
					"CREATE TABLE IF NOT EXISTS Brand(id INTEGER AUTO_INCREMENT PRIMARY KEY, brand VARCHAR(50));");
			System.out.println("Brand table is created.");
		} catch (SQLException e) {
			System.out.println("Brand table is not created !");
			e.printStackTrace();
		}

	}

	public static void createModelTable() {

		try (Statement createModelStatement = DbConnectionUtils.getDatabaseConnection().createStatement()) {

			createModelStatement.execute(
					"CREATE TABLE IF NOT EXISTS Model(id INTEGER AUTO_INCREMENT PRIMARY KEY, model VARCHAR(50), brandid INTEGER,"
							+ "FOREIGN KEY(brandid) REFERENCES brand(id));");
			System.out.println("Model table is created.");
		} catch (SQLException e) {
			System.out.println("Model table is not created !");
			e.printStackTrace();
		}

	}

}
