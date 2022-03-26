package com.hit.btvn_b4.Model;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.security.Timestamp;


@Table(name = "account_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    private String password;

    @Nationalized
    private String fullName;

//    @CreationTimestamp//time tao
//    private Timestamp created;
//
//    @UpdateTimestamp//time update
//    private Timestamp updated;

    @Override
    public boolean equals(Object o) {
       if(this == o) return true;
       if(o.getClass() != this.getClass() || o == null) return false;
       User user = (User) o;
       if(!username.equals(user.getUsername()))return false;
       return password.equals(user.getPassword());
    }

    public User() {
    }

    public User(Long id, String username, String password, String fullName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

//    public Timestamp getCreated() {
//        return created;
//    }
//
//    public void setCreated(Timestamp created) {
//        this.created = created;
//    }
//
//    public Timestamp getUpdated() {
//        return updated;
//    }
//
//    public void setUpdated(Timestamp updated) {
//        this.updated = updated;
//    }
}