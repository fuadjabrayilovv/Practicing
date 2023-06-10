package com.example.practicing.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PracticeResponseDto {
    String roles;

    String name;
    String mail;
    String password;
}
