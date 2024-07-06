package ru.cotarius.oauth2.enity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "note")
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String note;
    private Long userId;
}
