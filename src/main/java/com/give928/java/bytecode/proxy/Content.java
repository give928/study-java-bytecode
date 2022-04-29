package com.give928.java.bytecode.proxy;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String title;

    @Builder
    public Content(Integer id, String title) {
        this.id = id;
        this.title = title;
    }
}
