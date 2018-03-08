package com.dugstudio.pmms.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="academy")
public class Academy extends BaseEntity {

	private static final long serialVersionUID = 3237709687743372993L;
	private String name;
	private Set<Profession> professions;
	@Column(name="name",length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="academy_profession",
	joinColumns={@JoinColumn(name="academy_id")},
	inverseJoinColumns={@JoinColumn(name="profession_id")})
	public Set<Profession> getProfessions() {
		return professions;
	}

	public void setProfessions(Set<Profession> professions) {
		this.professions = professions;
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
