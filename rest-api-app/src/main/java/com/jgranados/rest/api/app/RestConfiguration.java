package com.jgranados.rest.api.app;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("api/v1")
public class RestConfiguration extends Application {

}
/*
@ApplicationPath("api/v1")
public class RestConfiguration extends ResourceConfig {
    
    public RestConfiguration()  {
        packages("com.jgranados.rest.api.app.restapi").register(MultiPartFeature.class);
    }
    
}*/