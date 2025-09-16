package com.marlon.parking.Dto;

public class UserRequestDto {
    private String name;

    private String documentId;

    private String phone;

    private String email;

    public UserRequestDto(String name, String documentId, String phone, String email) {
        this.name = name;
        this.documentId = documentId;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
