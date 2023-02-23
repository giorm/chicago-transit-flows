package com.ptvgroup.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.util.Date;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Giorgio Maltempi (PTV Archimedes)
 */
@Setter
@Getter
@Entity
public class Prd extends PanacheEntity  {
    
    public Integer stpid; // Unique identifier representing the stop
    public String rt; // Alphanumeric designator of the route 
    public Integer vid; // Unique ID of the vehicle for which this prediction was generated
    
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm")
    public Date tmstmp; // Date and time (local) the prediction was generated
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm")
    public Date prdtm; // Predicted date and time (local) 
    public String prdctdn; // This is the time left, in minutes, until the bus arrives at this stop. DUE stay for "in time"
    public Integer dstp; // Linear distance (feet) left to be traveled by the vehicle before it reaches the stop associated with this prediction
    
    public String typ; // Type of prediction.  A or D
    public String des; // Final destination of the vehicle associated with this prediction
    
    public String stpnm; // Display name of the stop

    public String rtdir; // Direction of travel of the route
    
    public Boolean dly; // “true” if the vehicle is delayed
    public String tablockid;
    public String tatripid;
    public String zone;

    @Override
    public String toString() {
        return "Prd{" + "tmstmp=" + tmstmp + ", prdtm=" + prdtm + ", prdctdn=" + prdctdn + ", typ=" + typ + ", vid=" + vid + ", dstp=" + dstp + ", des=" + des + ", stpnm=" + stpnm + ", stpid=" + stpid + ", rt=" + rt + ", rtdir=" + rtdir + ", dly=" + dly + ", tablockid=" + tablockid + ", tatripid=" + tatripid + ", zone=" + zone + '}';
    }
        
}
