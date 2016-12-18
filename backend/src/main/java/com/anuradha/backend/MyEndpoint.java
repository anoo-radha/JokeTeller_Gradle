/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.anuradha.backend;

import com.anuradha.JokeFactory;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.anuradha.com",
                ownerName = "backend.anuradha.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A Google Cloud endpoint method that returns a joke form jokefactory-java library
     */

    @ApiMethod(name = "getAJoke")
    public MyBean getAJoke() {
        MyBean response = new MyBean();
        String joke = new JokeFactory().JokeTeller();
        response.setData(joke);
        return response;
    }

}
