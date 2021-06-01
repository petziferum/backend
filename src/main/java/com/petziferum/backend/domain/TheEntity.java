package com.petziferum.backend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class TheEntity  extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String textAttribute;
}
