package com.example.bug_report.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserReq {
    @ApiModelProperty(
            example = "Sam Smith",
            notes = "Họ tên trống",
            required = true
    )
    private String fullName;

    @ApiModelProperty(
            example = "sam.smith@gmail.com",
            notes = "Email trống",
            required = true
    )
    private String email;

    @ApiModelProperty(
            example = "verysecretpassword",
            notes = "Mật khẩu trống",
            required = true
    )
    private String password;
}
