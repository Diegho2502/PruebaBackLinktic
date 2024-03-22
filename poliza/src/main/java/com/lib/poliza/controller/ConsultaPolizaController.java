package com.lib.poliza.controller;

import com.lib.poliza.dto.RequestInputDTO;
import com.lib.poliza.dto.RequestOutDTO;
import com.lib.poliza.service.IConsultaPolizaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/poliza")
public class ConsultaPolizaController {

    private final IConsultaPolizaService iConsultaPolizaService;

    public ConsultaPolizaController(IConsultaPolizaService iConsultaPolizaService) {
        this.iConsultaPolizaService = iConsultaPolizaService;
    }

    @PostMapping
    RequestOutDTO getData(@Valid @RequestBody RequestInputDTO requestInputDTO) throws ParseException {
        return iConsultaPolizaService.ConsultaPoliza(requestInputDTO);
    }
}
