package br.usjt.wheatherForecast.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.DayOfWeek;

@Data
@NoArgsConstructor
@Entity
@Table(name = "my_day_of_week")
public class MyDayOfWeek implements Serializable {

    public MyDayOfWeek(DayOfWeek day) {
        this.id = day;
        this.description = day;
    }

    @Id
    @Enumerated(value = EnumType.ORDINAL)
    private DayOfWeek id;

    @Column
    @Enumerated(value = EnumType.STRING)
    private DayOfWeek description;

}
