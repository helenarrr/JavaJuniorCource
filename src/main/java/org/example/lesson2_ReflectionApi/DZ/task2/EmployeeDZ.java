package org.example.lesson2_ReflectionApi.DZ.task2;

import java.util.UUID;

@Table(name = "users")
public class EmployeeDZ {

    public EmployeeDZ(String username, String email) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.email = email;
    }

    @Column(name = "id", primaryKey = true)
    private UUID id;

    @Column(name = "name")
    private String username;

    @Column(name = "mail")
    private String email;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
