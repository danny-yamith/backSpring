package com.example.demo.datasource;

import javax.persistence.*;

@Entity
@Table
public class Datasource {
    @Id
    @SequenceGenerator(
            name = "datasource_sequence",
            sequenceName = "datasource_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "datasource_sequence"
    )
    private Integer id;
    private String name;

    public Datasource() {
    }

    public Datasource(Integer id, String name) {
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
        return "Datasource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
