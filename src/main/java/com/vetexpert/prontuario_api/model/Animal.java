package com.vetexpert.prontuario_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "animais")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String raca;
    private Double peso;
    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;
}
