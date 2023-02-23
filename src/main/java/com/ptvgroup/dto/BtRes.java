package com.ptvgroup.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Giorgio Maltempi (PTV Archimedes)
 */
@Getter
@Setter
//@XmlRootElement(name = "bustime-response")
//@XmlAccessorType(XmlAccessType.FIELD)
public class BtRes  {
    
    @JsonProperty("prd")
    public List<Prd> prds;

    @JsonProperty("error")
    public List<Error> error;

    @Override
    public String toString() {
        return "BtRes{" + "prds=" + prds + ", error=" + error + '}';
    }
        
}
