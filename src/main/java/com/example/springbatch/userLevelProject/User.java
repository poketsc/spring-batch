package com.example.springbatch.userLevelProject;

import com.example.springbatch.userOrders.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "member")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    @Enumerated(EnumType.STRING)
    private Level level = Level.NORMAL;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private List<Orders> orders;

    private LocalDate updatedDate;

    @Builder
    private User(String userName, List<Orders> orders) {
        this.userName = userName;
        this.orders = orders;
    }

    public Level levelUp() {
        Level nextLevel = Level.getNextLevel(this.getTotalAmount());

        this.level = nextLevel;
        this.updatedDate = LocalDate.now();

        return nextLevel;
    }

    private int getTotalAmount() {
        return this.orders.stream()
                .mapToInt(Orders::getAmount)
                .sum();
    }

    public boolean availableLevelUp() {
        return Level.availableLevelUp(this.getLevel(), this.getTotalAmount());
    }
}
