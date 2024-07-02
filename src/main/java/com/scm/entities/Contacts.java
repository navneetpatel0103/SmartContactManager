package com.scm.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Contacts")
public class Contacts {

    @Id
    @Column(name="Contact_Id")
    private String contact_id;

    @Column(name="Name", nullable = false)
    @NotNull
    private String contact_name;

    @Column(name="Email", unique=true, nullable = false)
    @NotNull
    private String contact_email;

    @Column(name="Contact")
    private String contact_phoneNumber;

    @Column(name="Address")
    private String address;

    @Column(name="ProfilePic_Url")
    private String profilePicture;

    @Column(name="Description")
    private String description;

    @Column(name="Is_Favorite")
    private boolean favorite=false;

    @Column(name="WebSite_Link")
    private String webSiteLink;

    @Column(name="LinkedIn_Link")
    private String linkedInLink;

    @JsonBackReference
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
    private List<SocialLink> socialLinks;

    @Column(nullable = false, updatable = false, name = "Created_At")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false, name = "Updated_At")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;



}
