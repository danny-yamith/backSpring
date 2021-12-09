package com.example.demo.trip;

import com.example.demo.datasource.Datasource;
import com.example.demo.path.Path;
import com.example.demo.region.Region;
import com.example.demo.utils.TripWeeklyDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedNativeQuery(
        name = "find_weekly_dto",
        query = "select l.name_region, avg(count_trip) as count_week from ( " +
                "select r.name as name_region, extract(week from p.datetime) as weekDate, count(*) as count_trip " +
                "from trip t " +
                "inner join path p on p.id = t.id_path " +
                "inner join region r on r.id = t.id_region " +
                "where extract(year from p.datetime) = :year " +
                "group by r.name, weekDate) as l " +
                "group by l.name_region",
        resultSetMapping = "weekly_dto"
)
@SqlResultSetMapping(
        name = "weekly_dto",
        classes = @ConstructorResult(
                targetClass = TripWeeklyDto.class,
                columns = {
                        @ColumnResult(name = "name_region", type = String.class),
                        @ColumnResult(name = "count_week", type = Long.class)
                }
        )
)
@Table
public class Trip implements Serializable {
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

    @OneToOne
    @JoinColumn(name = "id_region")
    private Region region;

    @OneToOne
    @JoinColumn(name = "id_path")
    private Path path;

    @OneToOne
    @JoinColumn(name = "id_datasource")
    private Datasource datasource;

    public Trip() {
    }

    public Trip(Integer id, Region region, Path path, Datasource datasource) {
        this.id = id;
        this.region = region;
        this.path = path;
        this.datasource = datasource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Datasource getDatasource() {
        return datasource;
    }

    public void setDatasource(Datasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", region=" + region +
                ", path=" + path +
                ", datasource=" + datasource +
                '}';
    }
}
