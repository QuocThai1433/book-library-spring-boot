package com.example.booklibraryspringboot.dto.reader;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class ReaderDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)

    private Long id;

    @Column(name = "reader_name")
    private String readerName;
}
