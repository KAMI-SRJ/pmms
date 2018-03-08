package com.dugstudio.pmms.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class SequenceIdEntity {
    private String id;
    @Id
    @Column(length = 32, nullable = true)
    @GenericGenerator(name = "sys_uuid", strategy = "uuid")
    @GeneratedValue(generator = "sys_uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SequenceIdEntity that = (SequenceIdEntity) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}
