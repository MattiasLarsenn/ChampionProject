package org.example.championproject.dto;

public record Champion(
        String id,
        String key,
        String title,
        Image image,
        String partype,
        Stats stats){}
