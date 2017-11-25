package com.bala;
 
import com.bala.model.Employee;
import com.bala.model.User;
import com.bala.dao.EmployeeDAO;
 
import com.bala.resources.EmployeesResource;
 
 
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import javax.ws.rs.client.Client;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
/**
 * A application class.
 * 
 * @author bala
 **/
 
public class MyDropApp   
        extends Application<AppConfiguration> {

    /**
     * Hibernate bundle.
     */
    private final HibernateBundle<AppConfiguration> hibernateBundle
            = new HibernateBundle<AppConfiguration>(
                    Employee.class
            ) {

        public DataSourceFactory getDataSourceFactory(
        		AppConfiguration configuration
        ) {
            return configuration.getDataSourceFactory();
        }

    };

    /**
     * The main method of the application.
     *
     * @param args command-line arguments
     * @throws Exception any exception while executing the main() method.
     */
    public static void main(final String[] args) throws Exception {
        new MyDropApp().run(args);
    }

    @Override
    public String getName() {
        return "DropAppGettingStarted";
    }

    @Override
    public void initialize(
            final Bootstrap<AppConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final AppConfiguration configuration,
            final Environment environment) {
        //Create Employee DAO.
        final EmployeeDAO employeeDAO
                = new EmployeeDAO(hibernateBundle.getSessionFactory());
        //Create Jersey client.
        final Client client = new JerseyClientBuilder(environment)
                .using(configuration.getJerseyClientConfiguration())
                .build(getName());
       
        
        environment.jersey().register(new EmployeesResource(employeeDAO));
        //Register a resource using Jersey client.
        
    }

}