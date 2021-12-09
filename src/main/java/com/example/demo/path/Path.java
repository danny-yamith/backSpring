package com.example.demo.path;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table
public class Path implements Serializable {
    @Id
    @SequenceGenerator(
            name = "path_sequence",
            sequenceName = "path_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "path_sequence"
    )
    private Integer id;
    private Date datetime;
    private BigDecimal origin_lat;
    private BigDecimal origin_lon;
    private BigDecimal destination_lat;
    private BigDecimal destination_lon;

    public Path() {
    }

    public Path(Integer id) {
        this.id = id;
    }

    public Path(Integer id, Date datetime, BigDecimal origin_lat, BigDecimal origin_lon, BigDecimal destination_lat, BigDecimal destination_lon) {
        this.id = id;
        this.datetime = datetime;
        this.origin_lat = origin_lat;
        this.origin_lon = origin_lon;
        this.destination_lat = destination_lat;
        this.destination_lon = destination_lon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public BigDecimal getOrigin_lat() {
        return origin_lat;
    }

    public void setOrigin_lat(BigDecimal origin_lat) {
        this.origin_lat = origin_lat;
    }

    public BigDecimal getOrigin_lon() {
        return origin_lon;
    }

    public void setOrigin_lon(BigDecimal origin_lon) {
        this.origin_lon = origin_lon;
    }

    public BigDecimal getDestination_lat() {
        return destination_lat;
    }

    public void setDestination_lat(BigDecimal destination_lat) {
        this.destination_lat = destination_lat;
    }

    public BigDecimal getDestination_lon() {
        return destination_lon;
    }

    public void setDestination_lon(BigDecimal destination_lon) {
        this.destination_lon = destination_lon;
    }

    @Override
    public String toString() {
        return "Path{" +
                "id=" + id +
                ", datetime=" + datetime +
                ", origin_lat=" + origin_lat +
                ", origin_lon=" + origin_lon +
                ", destination_lat=" + destination_lat +
                ", destination_lon=" + destination_lon +
                '}';
    }
}
