package com.dugstudio.pmms.entity;
        import javax.persistence.Column;
        import javax.persistence.Entity;
        import javax.persistence.Table;

@Entity
@Table(name="resource")
public class Resource extends BaseEntity {

    private static final long serialVersionUID = 255615736258204053L;
    private String name;
    private String url;
    @Column(length = 20)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(length = 20)
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @Override
    public String toString() {
        return "Resource [name=" + name + ", url=" + url + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

