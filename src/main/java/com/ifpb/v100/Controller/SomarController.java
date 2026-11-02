package com.ifpb.v100.Controller;

import com.ifpb.v100.dto.SomarRequestDTO;
import com.ifpb.v100.dto.SomarResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/somar")
public class SomarController {

    @PostMapping
    public ResponseEntity<SomarResponseDTO> somar(@Valid @RequestBody SomarRequestDTO request) {
        Double resultado = request.a() + request.b();
        return ResponseEntity.ok(new SomarResponseDTO(resultado));
    }
}