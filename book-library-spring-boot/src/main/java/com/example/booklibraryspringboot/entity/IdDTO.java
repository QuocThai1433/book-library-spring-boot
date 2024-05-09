package com.example.booklibraryspringboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class IdDTO implements Serializable {

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "reader_id")
    private Long readerId;

}
