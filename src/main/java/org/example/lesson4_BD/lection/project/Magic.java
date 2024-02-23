package org.example.lesson4_BD.lection.project;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "test.magic")
public class Magic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "damage")
    private int damage;
    @Column(name = "armor")
    private int armor;


    public Magic(String name, int damage, int armor) {
        this.name = name;
        this.damage = damage;
        this.armor = armor;
    }

    public Magic() {}

    @Override
    public String toString() {
        return "Magic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", damage=" + damage +
                ", armor=" + armor +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
