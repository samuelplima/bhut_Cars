package br.com.bhut.cars.controller;


import br.com.bhut.cars.dto.LogsDTO;
import br.com.bhut.cars.service.LogsService;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Transactional
@RestController
@RequestMapping("/logs")
public class LogsController {

    private LogsService logsService;

    @Autowired
    public LogsController(LogsService logsService) {
        this.logsService = logsService;
    }

    @GetMapping("/list")
    public List<LogsDTO> listLogs(){
        return logsService.findAll();
    }

}
