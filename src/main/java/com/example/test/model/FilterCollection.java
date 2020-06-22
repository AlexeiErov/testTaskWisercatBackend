package com.example.test.model;

import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "filter_collection")
@Setter
@Getter
@EqualsAndHashCode
public class FilterCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "filters")
    private String filters;

}
