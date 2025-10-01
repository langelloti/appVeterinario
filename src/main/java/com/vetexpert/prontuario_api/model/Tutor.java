package com.vetexpert.prontuario_api.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tutores")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int idade;
    private String contato;
}
