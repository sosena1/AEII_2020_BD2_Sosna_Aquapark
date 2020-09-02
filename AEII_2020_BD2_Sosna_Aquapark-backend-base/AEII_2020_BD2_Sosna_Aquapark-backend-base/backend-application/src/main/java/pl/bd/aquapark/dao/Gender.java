package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "gender")
public @Data
class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genderid")
    private Long genderId;

    @Column(name = "gendername")
    private String genderName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "genderid")
    @Getter(onMethod = @__( @JsonIgnore))
    private Set<User> users;

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
}
