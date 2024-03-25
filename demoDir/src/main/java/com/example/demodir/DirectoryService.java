package com.example.demodir;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryService {
    private final DirectoryRepository directoryRepository;

    public DirectoryService(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    public Directory createDirectory(String name) {
        return directoryRepository.save(new Directory(name));
    }

    public void deleteDirectory(Long id) {
        directoryRepository.deleteById(id);
    }

    public void addValueToDirectory(Long directoryId, String key, String valueName) {
        Directory directory = directoryRepository.findById(directoryId).orElseThrow();
        directory.addValue(key, valueName);
        directoryRepository.save(directory);
    }

    public void deleteValueFromDirectory(Long directoryId, String key) {
        Directory directory = directoryRepository.findById(directoryId).orElseThrow();
        directory.deleteValue(key);
        directoryRepository.save(directory);
    }

    public Directory getDirectory(Long id) {
        return directoryRepository.findById(id).orElseThrow();
    }
    public List<Directory> getAllDirectories() {
        return directoryRepository.findAll();
    }
}
