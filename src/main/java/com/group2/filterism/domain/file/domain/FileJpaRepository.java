package com.group2.filterism.domain.file.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileJpaRepository extends JpaRepository<FileEntity, String> {
}
