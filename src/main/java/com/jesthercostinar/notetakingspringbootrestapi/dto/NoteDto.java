package com.jesthercostinar.notetakingspringbootrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto {

    private Long id;
    private String title;
    private String body;
    private boolean hidden;
    private LocalDateTime dateCreate;
    private LocalDateTime lastDateUpdate;
}
