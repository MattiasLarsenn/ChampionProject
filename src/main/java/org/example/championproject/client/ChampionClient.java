package org.example.championproject.client;

import org.example.championproject.dto.DataDragonResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ChampionClient
{
    private final RestClient client;

    public ChampionClient(RestClient.Builder builder)
    {
        client = builder
                .baseUrl("https://ddragon.leagueoflegends.com")
                .build();
    }

    public DataDragonResponse fetch()
    {
        return client.get()
                .uri("cdn/16.21.1/data/en_US/champion.json")
                .retrieve()
                .body(DataDragonResponse.class);
    }
}
