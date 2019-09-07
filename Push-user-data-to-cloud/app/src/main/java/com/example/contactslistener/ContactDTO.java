package com.example.contactslistener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry on 1/26/2018.
 */

public class ContactDTO {

    // Contact belong group fields.
    private long groupId;

    // Contacts id.
    private long contactId;

    // Raw contacts id. Has same value of contact id.
    private long rawContactId;

    // Contact structured name fields.
    private String displayName;
    private String givenName;
    private String familyName;

    // Contact nickname fields.
    private String nickName;

    // Contact organization fields.
    private String company;
    private String department;
    private String title;
    private String jobDescription;
    private String officeLocation;

    // Contact phone list.

    // Contact note.
    private String note;

    // Contact im list.


    // Contact postal fields.
    private String country;
    private String city;
    private String postCode;
    private String street;
    private String region;
    private long postType;

    // Contact identity fields.
    // Identity value
    private String identity;
    // Identity card, passport etc.
    private String namespace;

    // Contact photo fields.
    private String photo;
    private String photoFieldId;

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public long getRawContactId() {
        return rawContactId;
    }

    public void setRawContactId(long rawContactId) {
        this.rawContactId = rawContactId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhotoFieldId() {
        return photoFieldId;
    }

    public void setPhotoFieldId(String photoFieldId) {
        this.photoFieldId = photoFieldId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public long getPostType() {
        return postType;
    }

    public void setPostType(long postType) {
        this.postType = postType;
    }
}