package com.isai.demo_system_management_trailers.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovie;

    @NotEmpty
    private String title;

    @NotEmpty
    private String synopsis;

    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate datePremiere;

    @NotBlank
    private String idYotubeTrailer;

    private String routeCover;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movies_genres", joinColumns = @JoinColumn(name = "id_movie"), inverseJoinColumns = @JoinColumn(name = "id_gender"))
    private List<Gender> genres;

    //dato temporal
    @Transient
    private MultipartFile fileCover;

}
