package com.sd.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.*;

@Entity
@Table(name = "projectmessage")
public class ProjectMessage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User author;

    @Size(min=1, max = 50)
    @Column(length = 50)
    private String description;

    @Size(min=1, max = 500)
    @Column(length = 50)
    private String body;

    private ZonedDateTime creationTime = null;

//    @ManyToMany
//    private Set<User> toUsers = new HashSet<User>();
//
//    @ManyToOne
//    @JoinColumn(name = "project_id")
//    private Project project;


//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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

    public ZonedDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(ZonedDateTime creationTime) {
        this.creationTime = creationTime;
    }

//    public Set<User> getToUsers() {
//        return toUsers;
//    }
//
//    public void setToUsers(Set<User> toUsers) {
//        this.toUsers = toUsers;
//    }


}
