package database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Car;
import entities.CarBuilder;
import enums.CarColor;
import enums.Transmission;

/**
 * This class inserts the cars into the database and loads them.
 *
 * @author Mohammed Al-Ashtal, Daniel Weiser
 *
 */

public class DbDMLStatements {

	/*
	 * This method gets the id of the brand from the brand-table.
	 */

	private static Integer getBrandIdFromBrand(String brand) {

		String query = "SELECT id FROM Brand WHERE brand = ?;";
		PreparedStatement preparedStatement;
		Integer brandId = null;

		try {
			preparedStatement = DbConnectionUtils.getDatabaseConnection().prepareStatement(query);
			preparedStatement.setString(1, brand);
			ResultSet brandIdResult = preparedStatement.executeQuery();
			while(brandIdResult.next()) {
				brandId = brandIdResult.getInt("Id");
			}
		} catch (SQLException e) {
			System.err.print("Brand is not prepared !");
			e.printStackTrace();
		}
		return brandId;
	}

	/*
	 * This method gets the id of the model from the model-table.
	 */

	private static Integer getModelIdFromModel(String model) {

		String query = "SELECT id FROM Model WHERE model = ?;";
		PreparedStatement preparedStatement;
		Integer modelId = null;

		try {
			preparedStatement = DbConnectionUtils.getDatabaseConnection().prepareStatement(query);
			preparedStatement.setString(1, model);
			ResultSet modelIdResult = preparedStatement.executeQuery();
			while(modelIdResult.next()) {
				modelId = modelIdResult.getInt("Id");
			}
		} catch (SQLException e) {
			System.err.print("Model is not prepared !");
			e.printStackTrace();
		}
		return modelId;
	}

	/*
	 * This method adds a brand into the brand-table.
	 */

	private static void insertBrandIntoDb(String brand) {
		String insertStatement = "INSERT INTO Brand (brand) VALUES (?);";

		try {
			PreparedStatement statement= DbConnectionUtils.getDatabaseConnection().prepareStatement(insertStatement);
			statement.setString(1, brand);
			statement.execute();
		} catch (SQLException e) {
			System.err.print("Brand is not inserted !");
			e.printStackTrace();
		}

	}

	/*
	 * This method adds a model into the model-table.
	 */

	private static void insertModelIntoDb(String model, String brand) {
		String insertStatement = "INSERT INTO Model (model, brandid) VALUES (?, ?);";

		try {
			Integer brandId = getBrandIdFromBrand(brand);
			if(brandId == null) {
				insertBrandIntoDb(brand);
				brandId = getBrandIdFromBrand(brand);
			}
			PreparedStatement statement = DbConnectionUtils.getDatabaseConnection().prepareStatement(insertStatement);
			statement.setString(1, model);
			statement.setInt(2, brandId);
			statement.execute();
		} catch (SQLException e) {
			System.err.print("Model is not inserted !");
			e.printStackTrace();
		}

	}

	/*
	 * This method adds a car into the car-table. If the brand or model are not in
	 * the table yet, it will be added.
	 */

	public static void insertCarIntoDb(Car car) {

		Integer brandId = getBrandIdFromBrand(car.getBrandName());
		if (brandId == null) {
			insertBrandIntoDb(car.getBrandName());
			brandId = getBrandIdFromBrand(car.getBrandName());
		}

		Integer modelId = getModelIdFromModel(car.getModel());

		if(modelId == null) {
			insertModelIntoDb(car.getModel(), car.getBrandName());
			modelId =  getModelIdFromModel(car.getModel());
		}

		String insertStatement = "INSERT INTO Car (brandid, modelid, dateOfRelease, mileage,"
				+ " transmission, power, fuel, color, status, price) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try {
			PreparedStatement statement = DbConnectionUtils.getDatabaseConnection().prepareStatement(insertStatement);
			statement.setInt(1, brandId);
			statement.setInt(2, modelId);
			statement.setDate(3, Date.valueOf(car.getDateOfRelease()));
			statement.setDouble(4, car.getMileage());
			statement.setString(5, car.getTransmission().toString());
			statement.setInt(6, car.getPower());
			statement.setString(7, car.getFuel().toString());
			statement.setString(8, car.getColor().toString());
			statement.setString(9, car.getStatus().toString());
			statement.setDouble(10, car.getPrice());
			statement.execute();

			System.out.println("Car inserted");
		} catch (SQLException e) {
			System.err.print("Car is not inserted into DB !");
			e.printStackTrace();
		}

	}

	/*
	 * This method gets all cars from the database.
	 */

	public static List<Car> getAllCarsFromDb() {

		String query = "SELECT * FROM Car JOIN Model ON Model.id=Car.modelid JOIN Brand ON Brand.id=Car.brandid";

		List<Car> carList = new ArrayList();

		Statement statement;

		try {
			statement = DbConnectionUtils.getDatabaseConnection().createStatement();
			ResultSet allCars = statement.executeQuery(query);
			while (allCars.next()) {
				carList.add(new CarBuilder().withCarId(allCars.getInt("id")).withBrandName(allCars.getString("brand"))
						.withModel(allCars.getString("model"))
						.withDateOfRelease(allCars.getDate("dateOfRelease").toLocalDate())
						.withMileage(allCars.getInt("mileage"))
						.withTransmission(Transmission.getTransmissionOf(allCars.getString("transmission")))
						.withPower(allCars.getInt("power"))
						.withFuel(allCars.getString("fuel"))
						.withColor(CarColor.getCarColorOf(allCars.getString("color")))
						.withStatus(allCars.getString("status"))
						.withPrice(allCars.getDouble("price"))
						.create());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return carList;

	}

	public static List<String> getAllBrandsFromDb() {

		String query = "SELECT * FROM Brand";

		List<String> brandList = new ArrayList();

		Statement statement;

		try {
			statement = DbConnectionUtils.getDatabaseConnection().createStatement();
			ResultSet allBrands = statement.executeQuery(query);

			while(allBrands.next()) {

				brandList.add(allBrands.getString("brand"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return brandList;

	}

}
