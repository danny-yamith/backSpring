package com.example.demo.trip;

import com.example.demo.utils.TripRegionDto;

import javax.persistence.*;

//@NamedNativeQueries(
 //       @NamedNativeQuery(name = "Trip.getPromTrips", query = "SELECT r.\"name\" as name, count(*) as countTotal FROM trip t INNER JOIN region r on r.id = t.id_region GROUP BY r.\"name\"", resultSetMapping = TripRegionDto.class)
//)
@Entity
@Table
public class Trip {
    @Id
    @SequenceGenerator(
            name = "trip_sequence",
            sequenceName = "trip_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "trip_sequence"
    )
    private Integer id;
    private Integer id_region;
    private Integer id_path;
    private Integer id_datasource;

    public Trip() {
    }

    public Trip(Integer id, Integer id_region, Integer id_path, Integer id_datasource) {
        this.id = id;
        this.id_region = id_region;
        this.id_path = id_path;
        this.id_datasource = id_datasource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_region() {
        return id_region;
    }

    public void setId_region(Integer id_region) {
        this.id_region = id_region;
    }

    public Integer getId_path() {
        return id_path;
    }

    public void setId_path(Integer id_path) {
        this.id_path = id_path;
    }

    public Integer getId_datasource() {
        return id_datasource;
    }

    public void setId_datasource(Integer id_datasource) {
        this.id_datasource = id_datasource;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", id_region=" + id_region +
                ", id_path=" + id_path +
                ", id_datasource=" + id_datasource +
                '}';
    }
}
