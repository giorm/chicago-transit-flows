package com.ptvgroup;

import com.ptvgroup.dto.Dto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * To use it via injection.
 *
 * {@code
     @Inject
     @RestClient
     MyRemoteService myRemoteService;

     public void doSomething() {
         Set<MyRemoteService.Dto> restClientExtensions = myRemoteService.call("io.quarkus:quarkus-rest-client");
     }
 }
 */
@RegisterRestClient(baseUri = "https://www.ctabustracker.com/bustime/api/v2")
public interface MyRemoteService {

    @GET
    @Path("/getpredictions")
    @Produces({"text/plain", "application/json", "text/json"})
    Dto call(@QueryParam("key") String key, @QueryParam("format") String format, 
            @QueryParam("stpid") Integer stpid, //comma-delimited list of stop IDs (not available with vid parameter)
            @QueryParam("rt") String rt, //comma-delimited list of route designators (optional, available with stpid parameter)
            @QueryParam("vid") Integer vid); //comma-delimited list of vehicle IDs (not available with stpid parameter)

    //TODO wrtite the Response DTO
    @GET
    @Path("/getroutes")
    @Produces({"text/plain", "application/json", "text/json"})
    Dto callGetRoutes(@QueryParam("key") String key, @QueryParam("format") String format);

    //TODO wrtite the Response DTO
    @GET
    @Path("/getstops")
    @Produces({"text/plain", "application/json", "text/json"})
    Dto callGetStops(@QueryParam("key") String key, @QueryParam("format") String format,
            @QueryParam("rt") String rt,
            @QueryParam("dir") String dir);

}
