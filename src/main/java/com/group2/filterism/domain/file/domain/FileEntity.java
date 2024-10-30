package com.group2.filterism.domain.file.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "file")
public class FileEntity {
    @Id
    private String id;

    private String fileName;

    private String extension;

    public static FileEntity create(String fileName, String extension) {
        return new FileEntity(fileName, extension);
    }

    private FileEntity(String fileName, String extension) {
        this.id = UUID.randomUUID().toString().substring(1, 6);
        this.fileName = fileName;
        this.extension = extension;
    }
}
