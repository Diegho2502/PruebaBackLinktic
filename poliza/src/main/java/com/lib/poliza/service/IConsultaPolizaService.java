package com.lib.poliza.service;

import com.lib.poliza.dto.RequestInputDTO;
import com.lib.poliza.dto.RequestOutDTO;

import java.text.ParseException;

public interface IConsultaPolizaService {
    RequestOutDTO ConsultaPoliza(RequestInputDTO requestInputDTO) throws ParseException;
}
