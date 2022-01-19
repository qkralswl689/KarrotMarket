package com.karrot.karrotmarket.category;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class CategoryDto {

    private int caid;
    private String caname;
}
