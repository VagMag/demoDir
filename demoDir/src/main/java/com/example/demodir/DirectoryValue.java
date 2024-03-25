package com.example.demodir;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
@Entity
@Data
@NoArgsConstructor

public class DirectoryValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "\"key\"")
    private String key;

    private String name;

    @ManyToOne
    @JoinColumn(name = "directory_id")
    private Directory directory;

    @ElementCollection
    @CollectionTable(name = "attribute")
    private Map<String, String> attributes = new HashMap<>();

    public DirectoryValue(String key, String name, Directory directory) {
        this.key = key;
        this.name = name;
        this.directory = directory;
    }

    public void addAttribute(String attributeName, String value) {
        attributes.put(attributeName, value);
    }
}
