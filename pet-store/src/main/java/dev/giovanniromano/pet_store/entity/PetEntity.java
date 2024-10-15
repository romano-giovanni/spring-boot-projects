package dev.giovanniromano.pet_store.entity;

import jakarta.persistence.*;

@Entity
@Table(name="pet_entity")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String tag;

    public PetEntity() {
    }

    public PetEntity(Long id, String name, String tag) {
        this.id = id;
        this.name = name;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
