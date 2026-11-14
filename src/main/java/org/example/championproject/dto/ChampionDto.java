package org.example.championproject.dto;

public record ChampionDto(
        String name,
        String id,
        String title,
        String imageUrl,
        String resource,
        StatsDto stats)
{
    private static final String BASE_URL = "https://ddragon.leagueoflegends.com/cdn/16.21.1/img/champion/";

    public static ChampionDto from(Champion champion)
    {
        return new ChampionDto(
                champion.id(),
                champion.key(),
                champion.title(),
                 BASE_URL + champion.image().full(),
                champion.partype(),
                StatsDto.from(champion.stats()));
    }

}

