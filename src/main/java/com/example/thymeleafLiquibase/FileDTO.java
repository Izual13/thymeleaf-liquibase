package com.example.thymeleafLiquibase;


public class FileDTO {

    private String name;

    private byte[] bytes;

    public FileDTO() {
    }

    public FileDTO(String name, byte[] bytes) {
        this.name = name;
        this.bytes = bytes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
