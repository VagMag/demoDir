package com.example.demodir;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Attribute {
    private String name;
    private Object value;

    public Attribute(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
