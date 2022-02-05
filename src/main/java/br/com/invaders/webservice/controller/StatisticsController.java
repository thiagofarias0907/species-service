package br.com.invaders.webservice.controller;

import br.com.invaders.webservice.entities.Statistics;
import br.com.invaders.webservice.repositories.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    StatisticsRepository statisticsRepository;


    @GetMapping("/specie/{specieId}")
    protected Statistics getSpecieStatistics(@PathVariable Long specieId) {
        return statisticsRepository.getSpecieStatistics(specieId);
    }
}
