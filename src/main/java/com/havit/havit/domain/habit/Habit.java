package com.havit.havit.domain.habit;

import com.havit.havit.domain.user.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@DynamicInsert
@NoArgsConstructor
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habit_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 기본값은 빈 스트링
    private String emoji;

    // 기본값은 빈 스트링
    private String name;

    @Min(value = 1, message = "목표 횟수는 1과 같거나 1보다 커야 합니다.")
    @Max(value = 7, message = "목표 횟수는 7과 같거나 7보다 작아야 합니다.")
    @Column(name = "target_cnt")
    // 기본값은 1
    private int targetCnt;

    // 기본값은 ACTIVE
    @Enumerated(EnumType.STRING)
    private Status status;

    @PrePersist
    public void prePersist() {
        this.emoji = this.emoji == null ? "" : this.emoji;
        this.name = this.name == null ? "" : this.name;
        this.status = this.status == null ? Status.ACTIVE : this.status;
    }

    @Builder
    public Habit(
            User user,
            String emoji,
            String name,
            int targetCnt,
            String status
    ) {
        this.user = user;
        this.emoji = emoji;
        this.name = name;
        this.targetCnt = targetCnt;
        this.status = Status.getStatus(status);
    }
}
