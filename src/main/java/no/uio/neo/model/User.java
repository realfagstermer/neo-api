package no.uio.neo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.sql.Timestamp;

/**
 * The persistent class for the users database table.
 *
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Id
    @SequenceGenerator(name = "USERS_USERID_GENERATOR", sequenceName = "USERS_USER_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_USERID_GENERATOR")
    @Column(name = "user_id")
    private Integer userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Timestamp created;

    @Column(name = "created_by")
    private Integer createdBy;

    // private String domain;

    private String name;

    private String username;

    public User() {
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getCreated() {
        return this.created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Integer getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    // public String getDomain() {
    // return this.domain;
    // }
    //
    // public void setDomain(String domain) {
    // this.domain = domain;
    // }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}