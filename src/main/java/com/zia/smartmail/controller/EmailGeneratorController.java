package com.zia.smartmail.controller;

import com.zia.smartmail.dto.EmailRequest;
import com.zia.smartmail.service.EmailGeneratorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
public class EmailGeneratorController {

    private final EmailGeneratorService emailGeneratorService;

    @PostMapping("/generate")
    @Operation(summary = "Generate email reply", description = "Generates a professional email reply using Gemini API")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest) {
        String response = emailGeneratorService.generateEmailReply(emailRequest);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/hello")
    public ResponseEntity<String> checkHello() {
        return ResponseEntity.ok("Hello");
    }
}
