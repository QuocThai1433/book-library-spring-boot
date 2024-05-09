package com.example.booklibraryspringboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "publisher")
@Getter
@Setter
@Entity
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class PublisherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;

    @Column(name = "publisher_name")
    private String publisherName;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<BookEntity> bookEntities = new ArrayList<>();

}
