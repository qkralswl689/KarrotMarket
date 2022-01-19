package com.karrot.karrotmarket.category;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caid")
    private int caid;

    @Column(name = "caname")
    private String caname;
}
