package com.example.demodir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directories")
public class DirectoryController {

    private final DirectoryService directoryService;

    @Autowired
    public DirectoryController(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @PostMapping
    public ResponseEntity<Directory> createDirectory(@RequestBody Directory directory) {
        return ResponseEntity.ok(directoryService.createDirectory(directory.getName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirectory(@PathVariable Long id) {
        directoryService.deleteDirectory(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{directoryId}/values")
    public ResponseEntity<Void> addValueToDirectory(@PathVariable Long directoryId,
                                                    @RequestParam String key,
                                                    @RequestParam String valueName) {
        directoryService.addValueToDirectory(directoryId, key, valueName);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{directoryId}/values/{key}")
    public ResponseEntity<Void> deleteValueFromDirectory(@PathVariable Long directoryId,
                                                         @PathVariable String key) {
        directoryService.deleteValueFromDirectory(directoryId, key);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Directory> getDirectory(@PathVariable Long id) {
        return ResponseEntity.ok(directoryService.getDirectory(id));
    }
    @GetMapping
    public ResponseEntity<List<Directory>> getAllDirectories() {
        List<Directory> directories = directoryService.getAllDirectories();
        return new ResponseEntity<>(directories, HttpStatus.OK);
    }
}
