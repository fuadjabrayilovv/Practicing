package com.example.practicing.Entity;

import com.example.practicing.enums.Status;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Data
public class PracticeDao {
    @Enumerated(EnumType.STRING)
    @Column(name = "card_status")
    Status status;

    private String roles;
    private String name;
    private String mail;
    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
