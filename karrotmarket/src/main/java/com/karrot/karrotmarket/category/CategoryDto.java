package com.karrot.karrotmarket.category;

import com.karrot.karrotmarket.file.entity.FileEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data

@NoArgsConstructor
public class CategoryDto {

    private int caid;
    private String caname;

    public CategoryEntity toEntity(){
        CategoryEntity build = CategoryEntity.builder()
                .caid(caid)
                .caname(caname)
                .build();
        return build;
    }

    @Builder
    public CategoryDto(int caid,String caname) {
        this.caid = caid;
        this.caname = caname;

    }
}
