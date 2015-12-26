package com.sd.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sd_group")
public class UserGroup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min=1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    private String name;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JsonIgnore
//    private Set<UserGroup> parentGroup = new HashSet<UserGroup>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<UserGroup> getParentGroup() {
//        return parentGroup;
//    }
//
//    public void setParentGroup(Set<UserGroup> parentGroup) {
//        this.parentGroup = parentGroup;
//    }
}
