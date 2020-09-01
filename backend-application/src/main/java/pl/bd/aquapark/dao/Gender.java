package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "gender")
public
class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genderid")
    private Long genderId;

    @Column(name = "gendername")
    private String genderName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "genderid")
    private Set<User> users;

    public Gender() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gender gender = (Gender) o;

        if (genderId != null ? !genderId.equals(gender.genderId) : gender.genderId != null) return false;
        return genderName != null ? genderName.equals(gender.genderName) : gender.genderName == null;
    }

    @Override
    public int hashCode() {
        int result = genderId != null ? genderId.hashCode() : 0;
        result = 31 * result + (genderName != null ? genderName.hashCode() : 0);
        return result;
    }

    public Long getGenderId() {
        return this.genderId;
    }

    public String getGenderName() {
        return this.genderName;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String toString() {
        return "Gender(genderId=" + this.getGenderId() + ", genderName=" + this.getGenderName() + ", users=" + this.getUsers() + ")";
    }

    @JsonIgnore
    public Set<User> getUsers() {
        return this.users;
    }
}
