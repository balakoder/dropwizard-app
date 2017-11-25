package com.bala;

 
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.client.JerseyClientConfiguration;
import io.dropwizard.db.DataSourceFactory;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.NotEmpty;

 /**
 * A Configuration class
 * 
 * @author bala
 **/
public class AppConfiguration extends Configuration {

   
    @NotNull
    @Valid
    private final DataSourceFactory dataSourceFactory
            = new DataSourceFactory();

    /**
     * Jersey client default configuration.
     */
    @Valid
    @NotNull
    private final JerseyClientConfiguration jerseyClientConfiguration
            = new JerseyClientConfiguration();

    /**
     *
     * @return Jersey Client
     */
    @JsonProperty("jerseyClient")
    public JerseyClientConfiguration getJerseyClientConfiguration() {
        return jerseyClientConfiguration;
    }

     
    /**
     * A getter for the database factory.
     *
     * @return An instance of database factory deserialized from the
     * configuration file passed as a command-line argument to the application.
     */
    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }

    /**
     * A getter for the URL of currency rates the API.
     *
     * @return the URL of currency rates the API.
     */
   

}