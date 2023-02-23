package com.ptvgroup.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Giorgio Maltempi (PTV Archimedes)
 */
@Getter
@Setter
public class Dto {

    @JsonProperty("bustime-response")
    public BtRes bustimeResponse;

    @Override
    public String toString() {
        return "Dto{" + "bustimeResponse=" + bustimeResponse + '}';
    }
    
    
}
