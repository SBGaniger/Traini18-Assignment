package com.train18.model;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String centerName;
   
    @Column(length = 12, unique = true, nullable = false)
    private String centerCode;

    @Embedded
    private Address address;

    private Integer studentCapacity;

    @ElementCollection
    @CollectionTable(name = "courses_offered", joinColumns = @JoinColumn(name = "training_center_id"))
    @Column(name = "course_name")
    private List<String> coursesOffered;
   
    @Temporal(TemporalType.TIMESTAMP)
    private Instant createdOn;

    @Column(nullable = false)
    private String contactEmail;

    @Column(nullable = false)
    private String contactPhone;

    // Default Constructor
    public TrainingCenter() {
        this.createdOn = Instant.now(); // Automatically set the creation time
    }

    // Parameterized Constructor
    public TrainingCenter(String centerName, String centerCode, Address address, Integer studentCapacity,
                          List<String> coursesOffered, String contactEmail, String contactPhone) {
        this.centerName = centerName;
        this.centerCode = centerCode;
        this.address = address;
        this.studentCapacity = studentCapacity;
        this.coursesOffered = coursesOffered;
        this.createdOn = Instant.now(); // Automatically set timestamp
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getStudentCapacity() {
        return studentCapacity;
    }

    public void setStudentCapacity(Integer studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    public List<String> getCoursesOffered() {
        return coursesOffered;
    }

    public void setCoursesOffered(List<String> coursesOffered) {
        this.coursesOffered = coursesOffered;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
