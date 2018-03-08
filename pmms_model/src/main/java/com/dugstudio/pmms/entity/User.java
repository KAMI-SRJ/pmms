package com.dugstudio.pmms.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {
    private String username;
    private String password;
    private String sno;
    private String icon;//头像
    private String email;
    private String phone;
    private Integer isAdmin;
    private int status;
    private String nation;
    private String addrress;
    private String gender;
    private Date birthday;
    private String identify;//身份证号
    private String profession;
    private String clazz;//201506
    private Set<Document> docs;
    private Set<Topic> topic;
    private Role role;
    @Column(length = 15)
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
    @Column(length = 100)
    public String getAddrress() {
        return addrress;
    }

    public void setAddrress(String addrress) {
        this.addrress = addrress;
    }

    @ManyToOne()
    @JoinColumn(name="role" )
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    @OneToMany
    @JoinTable(name="user_document",
    joinColumns = {@JoinColumn(name = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "doc_id")})
    public Set<Document> getDocs() {
        return docs;
    }

    public void setDocs(Set<Document> docs) {
        this.docs = docs;
    }
    @Column(length = 18)
    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    @Column(name="username" ,nullable=false,length=20)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name="password",nullable=false,columnDefinition="varchar(32) default '1234560'")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name="sno" ,nullable=false,length = 10)//学号最长10位
    public String getSno() {
        return sno;
    }
    public void setSno(String sno) {
        this.sno = sno;
    }
    //头像
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getEmail() { return email; }
    @OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinTable(name = "user_topic",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "topic_id")})
    public Set<Topic> getTopic() {
        return topic;
    }
    public void setTopic(Set<Topic> topic) {
        this.topic = topic;
    }
    @Column(length = 20)
    public void setEmail(String email) {
        this.email = email;
    }
    @Column(length=11)
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    //1管理员
    @Column(name="isAdmin",columnDefinition="INT default 0")
    public Integer getIsAdmin() {
        return isAdmin;
    }
    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }
    //未激活0,激活1
    @Column(name="status",columnDefinition="INT default 0")
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    @Column(name="gender",length = 2)
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Column(name="birthday")
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    @Column(length=20)
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Column(length = 6)
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }



    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", sno=" + sno + ", icon=" + icon + ", email="
                + email + ", phone=" + phone + ", isAdmin=" + isAdmin + ", status=" + status + ", gender=" + gender
                + ", birthday=" + birthday + /*", roles=" + roles + */", profession=" + profession + ", clazz="
                + clazz + "]";
    }
}
