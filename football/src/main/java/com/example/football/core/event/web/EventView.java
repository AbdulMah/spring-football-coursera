package com.example.football.core.event.web;

import com.example.football.core.player.web.AuthorModel;

import java.util.HashSet;
import java.util.Set;

public class EventView {
    private long id;

    private String name;

    private String content;

    private Set<AuthorModel> players = new HashSet<>();

    public long getId(){return id;}

    public void setId(Long id){this.id = id;}

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public String getContent(){return content;}

    public void setContent(String content){this.content = content;}

    public Set<AuthorModel> getPlayers(){return players;}

    public void setPlayers(Set<AuthorModel> players) {this.players = players;}
}
