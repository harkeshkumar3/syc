package com.syc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_images")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private String name;
    @Column(name = "hashcode")
    private String hashcode;
    @Column(name = "deleteHashcode")
    private String deleteHashcode;

}
