package be.sertifikasi.isb.user.model;


import lombok.Data;


@Data
public class UserResponse {

    private Integer id;

    private String userName;

    private String userEmail;
}
