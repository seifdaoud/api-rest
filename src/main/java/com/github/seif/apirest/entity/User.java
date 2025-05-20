package com.github.seif.apirest.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)          private String name;
    @Column(nullable = false, unique = true) private String email;

    @CreationTimestamp @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp                   private Instant updatedAt;

    /* getters & setters */
    public Long getId()                 { return id; }
    public void setId(Long id)          { this.id = id; }

    public String getName()             { return name; }
    public void setName(String name)    { this.name = name; }

    public String getEmail()            { return email; }
    public void setEmail(String email)  { this.email = email; }

    public Instant getCreatedAt()       { return createdAt; }
    public Instant getUpdatedAt()       { return updatedAt; }
}
