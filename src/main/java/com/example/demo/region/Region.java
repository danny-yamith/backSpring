package com.example.demo.region;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Region implements Serializable {
    @Id
    @SequenceGenerator(
            name = "region_sequence",
            sequenceName = "region_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "region_sequence"
    )
    private Integer id;
    private String name;

    public Region() {
    }

    public Region(Integer id) {
        this.id = id;
    }

    public Region(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
