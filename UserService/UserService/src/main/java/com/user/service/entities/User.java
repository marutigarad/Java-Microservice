package com.user.service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "mirco_users")
public class User {

    @Id
    @Column(name="id")
    private String userId;
    @Column(name="name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "about")
    private String about;

    @Transient
    private List<Rating> ratings= new ArrayList<>();
}
