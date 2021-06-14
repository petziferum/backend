package com.petziferum.backend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@Getter
@Setter
@Document(collection = "entities")
public class TheEntity  extends BaseEntity {

    //private static final long serialVersionUID = 1L;

    private String textAttribute;

    public TheEntity (String textAttribute){
        this.textAttribute = textAttribute;
    }
}
