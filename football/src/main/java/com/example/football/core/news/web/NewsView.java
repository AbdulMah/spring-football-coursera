package com.example.football.core.news.web;

import com.example.football.core.team.web.TeamView;

import java.util.HashSet;
import java.util.Set;

public class NewsView {

    private long id;

    private String name;

    private String content;

    private Set<TeamView> teams = new HashSet<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<TeamView> getTeams() {
        return teams;
    }

    public void setTeams(Set<TeamView> teams) {
        this.teams = teams;
    }
}
