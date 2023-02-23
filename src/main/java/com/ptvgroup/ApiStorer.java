package com.ptvgroup;

import com.ptvgroup.dto.Dto;
import io.quarkus.scheduler.Scheduled;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author Giorgio Maltempi (PTV Archimedes)
 */
@Slf4j
public class ApiStorer {
    private static final String FORMAT_JSON = "json";

    @Inject
    @RestClient
    MyRemoteService myRemoteService;
    
    @ConfigProperty(name = "api.key", defaultValue = "xxx") 
    String apiKey;
    @ConfigProperty(name = "stpid", defaultValue = "14555") 
    Integer stpid;
    @ConfigProperty(name = "rt", defaultValue = "X49") 
    String rt;
    @ConfigProperty(name = "vid", defaultValue = "8201") 
    Integer vid;

    @Transactional
    @Scheduled(cron = "${myJob.cronExpression:*/30 * * * * ?}")
    public void doSomething() {
        log.info("GET api calling...");
        Dto dto = myRemoteService.call(apiKey, FORMAT_JSON, 
                stpid, //comma-delimited list of stop IDs (not available with vid parameter)
                null, //comma-delimited list of route designators (optional, available with stpid parameter)
                null); //comma-delimited list of vehicle IDs (not available with stpid parameter)

        log.info("...Prediction DTO parsed: " + dto.toString());
        if (dto.bustimeResponse.prds != null) {
            dto.bustimeResponse.prds.forEach(p -> p.persist());
            log.info("Prediction DTO persisted");
        }
        if (dto.bustimeResponse.error != null) {
            dto.bustimeResponse.error.forEach(e -> e.persist());
            log.error("Error DTO persisted");
        }
    }
}
