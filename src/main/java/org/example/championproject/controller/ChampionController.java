package org.example.championproject.controller;

import org.example.championproject.dto.ChampionDto;
import org.example.championproject.service.ChampionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class ChampionController
{
    private final ChampionService service;

    public ChampionController(ChampionService service)
    {
        this.service = service;
    }

    @GetMapping("api/champions")
    public List<ChampionDto> getChampions()
    {
        return service.getChampions();
    }
}
