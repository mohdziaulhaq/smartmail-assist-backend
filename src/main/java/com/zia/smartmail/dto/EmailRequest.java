package com.zia.smartmail.dto;

import lombok.Data;

@Data
public class EmailRequest {
    String emailContent;
    String tone;
}
