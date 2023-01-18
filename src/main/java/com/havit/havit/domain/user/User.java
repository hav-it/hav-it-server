package com.havit.havit.domain.user;

import com.havit.havit.domain.habit.Habit;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@DynamicInsert
@Table(name = "user")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    private String slogan;

    private String token;

    private String provider;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "habit_id")
    private List<Habit> habitList = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.slogan = this.slogan == null ? "" : this.slogan;
    }

    @Builder
    public User(
            String token,
            String provider
    ) {
        this.token = token;
        this.provider = provider;
    }
}
