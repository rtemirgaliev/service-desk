package com.sd.repository;

import com.sd.domain.Project;
import com.sd.domain.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long>{

}
