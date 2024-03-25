package com.example.demodir;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
@Entity
@Data
@NoArgsConstructor
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "directory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<String, DirectoryValue> values = new HashMap<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addValue(String key, String name) {
        values.put(key, new DirectoryValue(key, name, this));
    }

    public void deleteValue(String key) {
        values.remove(key);
    }

}
