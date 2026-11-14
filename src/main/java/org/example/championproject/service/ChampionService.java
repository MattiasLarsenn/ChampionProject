package org.example.championproject.service;

import org.example.championproject.client.ChampionClient;
import org.example.championproject.dto.ChampionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionService
{
    private final ChampionClient client;

    public ChampionService(ChampionClient client)
    {
        this.client = client;
    }

    public List<ChampionDto> getChampions()
    {
        return client.fetch()
                .data()
                .values()
                .stream()
                .map(ChampionDto::from)
                .toList();
    }
}
