package desktop.deschamps.compta.Compta;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import desktop.deschamps.compta.dao.FournisseurDAO;
import desktop.deschamps.compta.dao.IFournisseurDAO;
import desktop.deschamps.compta.dao.IStockDAO;
import desktop.deschamps.compta.dao.StockDAO;
import desktop.deschamps.compta.entities.Category;
import desktop.deschamps.compta.entities.Fournisseur;
import desktop.deschamps.compta.entities.Stock;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application
{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
		//	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		 Properties properties=new Properties();
		    properties.setProperty("log4j.rootLogger","INFO,stdout,MyFile");
		    properties.setProperty("log4j.rootCategory","INFO");

		    properties.setProperty("log4j.appender.stdout",     "org.apache.log4j.ConsoleAppender");
		    properties.setProperty("log4j.appender.stdout.layout",  "org.apache.log4j.PatternLayout");
		    properties.setProperty("log4j.appender.stdout.layout.ConversionPattern","%d{yyyy/MM/dd HH:mm:ss.SSS} [%5p] %t - %m%n");

		    properties.setProperty("log4j.appender.MyFile", "org.apache.log4j.RollingFileAppender");
		    properties.setProperty("log4j.appender.MyFile.File", "my_example.log");
		    properties.setProperty("log4j.appender.MyFile.MaxFileSize", "100KB");
		    properties.setProperty("log4j.appender.MyFile.MaxBackupIndex", "1");
		    properties.setProperty("log4j.appender.MyFile.layout",  "org.apache.log4j.PatternLayout");
		    properties.setProperty("log4j.appender.MyFile.layout.ConversionPattern","%d{yyyy/MM/dd HH:mm:ss.SSS} [%5p] %t - %m%n");

		    PropertyConfigurator.configure(properties);
		    Logger logger = Logger.getLogger(App.class);

		    
		    IFournisseurDAO fournisseurDAO = new FournisseurDAO();
		    IStockDAO stockDAO = new StockDAO();
		    
		    Fournisseur fournisseur = new Fournisseur();
		    fournisseur.setName("toto");
		    fournisseurDAO.store(fournisseur);
		    
		    Stock stock = new Stock();
		    
/*
		IUserDAO usrDAO = new UserDAO();
		IUnitDAO unitDAO = new UnitDAO();
		List<Category> list =  unitDAO.findByName("fraise");
		System.out.println("\n\n "+list.size());
		for(Category c : list){
			System.out.println("\n\n "+c.getName());
			System.out.println(c.getUser().getPassword());
		}
		//usrDAO.create(new User("branleur"));
		logger.warn("test");
		User usr = usrDAO.findById(3);

	*/
		logger.warn("coucou");
		launch(args);
	}
}
