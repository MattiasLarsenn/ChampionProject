package org.example.championproject.dto;

public record StatsDto(
        int health,
        int movementSpeed,
        int armor,
        int magicResist,
        int attackRange,
        int attackDamage,
        double attackSpeed)
{
    public static StatsDto from(Stats stats)
    {
        return new StatsDto(
                stats.hp(),
                stats.movespeed(),
                stats.armor(),
                stats.spellblock(),
                stats.attackrange(),
                stats.attackdamage(),
                stats.attackspeed());
    }
}
