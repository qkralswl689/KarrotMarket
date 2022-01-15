package com.karrot.karrotmarket.category;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class CategoryDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caid")
    private int caid;

    @Column(name = "caname")
    private String caname;
}
