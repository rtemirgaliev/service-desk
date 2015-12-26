package com.sd.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projecttask")
public class ProjectTask implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min=1, max = 50)
    @Column(length = 50)
    private String description;

    @Size(max = 500)
    @Column(length = 500)
    private String body;

    private ZonedDateTime startDateTarget = null;

    private ZonedDateTime endDateTarget = null;

//    @ManyToMany   //(mappedBy = "projecttask")     //cascade = CascadeType.ALL, orphanRemoval = true
//    private Set<User> users = new HashSet<User>();
//
//    @ManyToOne
//    @JoinColumn(name = "project_id")
//    private Project project = new Project();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ZonedDateTime getStartDateTarget() {
        return startDateTarget;
    }

    public void setStartDateTarget(ZonedDateTime startDateTarget) {
        this.startDateTarget = startDateTarget;
    }

    public ZonedDateTime getEndDateTarget() {
        return endDateTarget;
    }

    public void setEndDateTarget(ZonedDateTime endDateTarget) {
        this.endDateTarget = endDateTarget;
    }

//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//
//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }



}
