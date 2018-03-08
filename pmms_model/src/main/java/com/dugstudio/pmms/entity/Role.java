package com.dugstudio.pmms.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="role")
public class Role extends BaseEntity {
    private String name;
    private Set<Resource> resource;

    @Column(name="name",length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(joinColumns = {@JoinColumn(name="role_id")},
    inverseJoinColumns = {@JoinColumn(name = "resource_id")})
    public Set<Resource> getResource() {
        return resource;
    }

    public void setResource(Set<Resource> resource) {
        this.resource = resource;
    }
}
