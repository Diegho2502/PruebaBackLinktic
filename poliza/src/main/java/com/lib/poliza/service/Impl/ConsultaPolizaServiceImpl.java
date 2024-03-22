package com.lib.poliza.service.Impl;

import com.lib.poliza.dto.LiquidacionDTO;
import com.lib.poliza.dto.RequestInputDTO;
import com.lib.poliza.dto.RequestOutDTO;
import com.lib.poliza.entity.Primas;
import com.lib.poliza.repository.AmparosRepository;
import com.lib.poliza.repository.AseguradosRepository;
import com.lib.poliza.repository.PrimasRepository;
import com.lib.poliza.service.IConsultaPolizaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class ConsultaPolizaServiceImpl implements IConsultaPolizaService {

    private final AseguradosRepository aseguradosRepository;
    private final PrimasRepository primasRepository;
    private final AmparosRepository amparosRepository;
    private final ModelMapper modelMapper;

    public ConsultaPolizaServiceImpl(AseguradosRepository aseguradosRepository, PrimasRepository primasRepository, AmparosRepository amparosRepository, ModelMapper modelMapper) {
        this.aseguradosRepository = aseguradosRepository;
        this.primasRepository = primasRepository;
        this.amparosRepository = amparosRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RequestOutDTO ConsultaPoliza(RequestInputDTO requestInputDTO) throws ParseException {
        var prima = 0.0;
        var asegurado = aseguradosRepository.findByNumeroIdentificacion(requestInputDTO.getNro_identificacion()).get();

       var fecha = stringToDate(asegurado.getFechaNacimiento());

       var edad = calcularEdad(fecha);

       var primas = primasRepository.consultaPrimas(edad);

       var amparos = amparosRepository.findAllByCodigos(primas.stream().map(Primas::getCodigo).toList());

       List<LiquidacionDTO> liquidacionDTOS = new ArrayList<>();
       List<Double> sum = new ArrayList<>();


        if(amparos.size() > 0){
            amparos.forEach(amparos1 -> {
                var liquidacion = new LiquidacionDTO();

                if(primas != null){
                    primas.forEach(primas1 -> {
                        liquidacion.setValor_prima(primas1.getPorcentajePrima());
                        var i = requestInputDTO.getValor_asegurado() * primas1.getPorcentajePrima();
                        sum.add(i);
                    });
                }

                liquidacion.setCodigo_amparo(Math.toIntExact(amparos1.getId()));
                liquidacion.setNombre_amparo(amparos1.getNombre());
                liquidacionDTOS.add(liquidacion);
            });
        }

        var total = sum.stream().mapToInt(Double::intValue).sum();

        var result = new RequestOutDTO();

        result.setNro_identificacion(asegurado.getNumeroIdentificacion());
        result.setTipo_identificacion(asegurado.getTipoIdentificacion());
        result.setValor_asegurado(requestInputDTO.getValor_asegurado());

        result.setLiquidacion(liquidacionDTOS);
        result.setValor_total(total);
        return result;
    }

    public Date stringToDate(String fechaNacimiento) throws ParseException {
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd-MMM-yy", new Locale("es", "ES"));
        SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy-MM-dd");


        Date fecha = formatoEntrada.parse(fechaNacimiento);
        String fechaFormateada = formatoSalida.format(fecha);
        System.out.println(fechaFormateada);

        return fecha;
    }
    public static int calcularEdad(Date fechaNacimiento) {
        // Convertir Date a LocalDate
        LocalDate fechaNacLocal = fechaNacimiento.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        // Fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Calcular período entre las fechas
        Period periodo = Period.between(fechaNacLocal, fechaActual);

        // Devolver los años
        return periodo.getYears();
    }
}
