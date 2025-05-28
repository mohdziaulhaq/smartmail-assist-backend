package com.zia.smartmail.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EmailRequest {

    @Schema(description = "Content of the original email",example = "Hi, I wanted to check on our meeting schedule.")
    String emailContent;

    @Schema(description = "Tone of the generated reply",example = "Formal")
    String tone;
}
