package com.ptvgroup.dto;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
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
public class Error extends PanacheEntity {

    public Integer stpid;
    public String vid;
    public String msg;

    @Override
    public String toString() {
        return "Error{" + "stpid=" + stpid + ", vid=" + vid + ", msg=" + msg + '}';
    }

}
