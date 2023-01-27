package com.havit.havit.domain.habitlog;

import com.havit.havit.domain.habit.Habit;
import com.havit.havit.domain.user.User;
import java.time.LocalDate;
import javax.persistence.ManyToOne;
import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.DynamicInsert;


@Entity
@Getter
@DynamicInsert
public class HabitLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habitlog_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "habit_id")
    private Habit habit;

    private int year;
    private int month;
    private int weekNo;
    private int day;
    @Column
    private boolean isAccomplished = false;


}
