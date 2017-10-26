package main.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import domain.configurations.Configuration;
import domain.configurations.TallerFactory;
import main.app.actionApp.StartApp;
import main.app.boundaries.configuration.ConfigurationMain;
import repository.boundaries.RepositoryFactory;
import repository.configurationRepo.ConfigurationRepo;
import repository.frameworks.RepositoryManagerFactory;

public class TallerApp {

	private static final Logger LOG = Logger.getLogger(TallerApp.class.getName());
	public static StartApp start = new StartApp();
	
	public static void main(String[] args) throws Exception {
		initLog();
		Setup();
		LOG.log(Level.INFO, "Arranca la aplicación");
		start.showMessageWelcome();
		LOG.log(Level.INFO, "Fin de la aplicación.");
	}

	public static void Setup() {
		Configuration.setRepository(RepositoryFactory.getClientRepositoryService());
		Configuration.setRepository(RepositoryFactory.getVehicleRepositoryService());
		Configuration.setRepository(RepositoryFactory.getBrandRepositoryService());
		Configuration.setRepository(RepositoryFactory.getModelRepositoryService());
		ConfigurationMain.setDomain(MainFactory.getWorkOrderMainService());
		Configuration.setWorkOrderService(TallerFactory.getWorkService());
		Configuration.setRepository(RepositoryFactory.getWorkOrderRepositoryService());
		Configuration.setRepository(RepositoryFactory.getServiceRepositoryService());
		ConfigurationRepo.setRepositoryManager(RepositoryManagerFactory.getRepositoryManager());
		ConfigurationRepo.setManagerService(RepositoryManagerFactory.getManagerService());
		//main
		ConfigurationMain.setDomain(MainFactory.getManagementClientMainService());
		ConfigurationMain.setDomainBrand(MainFactory.getManagementBrandMainService());
		ConfigurationMain.setDomain(MainFactory.getServiceServiceMain());

	}

	private static void initLog() {

		try {
			LogManager.getLogManager()
					.readConfiguration(new FileInputStream("src/main/resources/config/log.properties"));
		} catch (SecurityException | IOException exception) {
			System.err.println("No se pudo cargar el fichero de configuración de Logger");
		}
	}
}
