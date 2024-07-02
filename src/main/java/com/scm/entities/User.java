package com.scm.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User {

    @Id
    @Column(name="User_Id")
    private String user_id;

    @Column(name="Name", nullable = false)
    @NotNull
    private String user_name;

    @Column(name="Email", unique = true, nullable = false)
    @NotNull
    private String user_email;
    
    @Column(name="Password", nullable = false)
    @NotNull
    private String user_password;

    @Column(name="About")
    private String about;

    @Column(name="Contact")
    private String phoneNumber;

    @Column(name="Profile_Url")
    private String profilePic;

    @Column(name="Is_enabled")
    private boolean enabled=false;

    @Column(name="Is_emailVerified")
    private boolean emailVerified=false;

    @Column(name="Is_phoneNumberVerified")
    private boolean phoneNumberVerified=false;

    @Column(name="Provider")
    private Providers provider=Providers.SELF;

    @Column(name="Provider_User_Id")
    private String providerUserID;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contacts> contacts;

    @Column(nullable = false, updatable = false, name = "Created_At")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false, name = "Updated_At")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;



}
