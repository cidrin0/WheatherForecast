package br.usjt.wheatherForecast.model.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "wheather_forecast")
public class WheatherForecast implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private DayOfWeek dayOfWeek;

    @Column(name = "min_temperature")
    @NotNull
    @Min(Long.MIN_VALUE)
    @Max(Long.MAX_VALUE)
    private Double minTemperature;

    @Column(name = "max_temperature")
    @NotNull
    @Min(Long.MIN_VALUE)
    @Max(Long.MAX_VALUE)
    private Double maxTemperature;

    @NotNull
    @Min(Long.MIN_VALUE)
    @Max(Long.MAX_VALUE)
    private Double moisture;

    @NotNull
    @Min(Long.MIN_VALUE)
    @Max(Long.MAX_VALUE)
    private Long latitude;

    @NotNull
    @Min(Long.MIN_VALUE)
    @Max(Long.MAX_VALUE)
    private Long longitude;

    @NotNull
    @Column(name = "time")
    private LocalTime time;

    @NotBlank
    private String description;
}