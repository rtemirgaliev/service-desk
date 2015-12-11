package com.sd.repository;


import com.sd.domain.ProjectMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectMessageRepository extends JpaRepository<ProjectMessage, Long> {

}
