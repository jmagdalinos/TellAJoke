/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.tellajoke.backend;

import com.example.JokeFactory;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myJokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.tellajoke.example.com",
                ownerName = "backend.tellajoke.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that gets a joke from the jokefactory java library and returns it
     */
    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke() {
        MyBean response = new MyBean();
        response.setData(JokeFactory.getJoke());

        return response;
    }

}
