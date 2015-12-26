package com.sd.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50)
    @Column(length = 50)
    private String description;

    @Size(max = 1000)
    @Column(length = 50)
    private String body;

    @OneToOne
    private Request request = new Request();

//    @JsonIgnore
//    @OneToMany(mappedBy = "project")
//    private Set<ProjectTask> tasks = new HashSet<ProjectTask>();
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "project")
//    private Set<ProjectMessage> messages = new HashSet<ProjectMessage>();

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

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

//    public Set<ProjectTask> getTasks() {
//        return tasks;
//    }
//
//    public void setTasks(Set<ProjectTask> tasks) {
//        this.tasks = tasks;
//    }
//
//    public Set<ProjectMessage> getMessages() {
//        return messages;
//    }
//
//    public void setMessages(Set<ProjectMessage> messages) {
//        this.messages = messages;
//    }


}
