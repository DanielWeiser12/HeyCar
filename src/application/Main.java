package application;

import controller.Controller;
import database.DbConnectionUtils;
import database.DbDDLStatements;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {


		new Controller(primaryStage);

		DbConnectionUtils.getDatabaseConnection();
		DbDDLStatements.createBrandTable();
		DbDDLStatements.createModelTable();
		DbDDLStatements.createHeyCarDb();

		//		DbDDLStatements.dropAllTables();

		//		try {
		//			DbConnectionUtils.getDatabaseConnection().close();
		//		} catch (SQLException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}



	}

	public static void main(String[] args) {
		launch(args);
	}
}