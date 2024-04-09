package com.romm.twtodos.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity 
@AllArgsConstructor @Setter @Getter @EqualsAndHashCode @ToString
public class Todo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false) @Size(min = 3, max = 100) @NotBlank
    private String title;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @DateTimeFormat(iso = ISO.DATE) @FutureOrPresent @Column(nullable = true)
    private LocalDate deadline;
    
    @Column(nullable = true)
    private LocalDate finishedAt;

    public Todo() {
        this.createdAt = LocalDateTime.now();
    }

    public void finish() {
        this.finishedAt = LocalDate.now();
    }
}
