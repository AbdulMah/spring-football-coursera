package com.example.football.core.player.web;

import com.example.football.core.team.web.TeamView;

import java.util.HashSet;
import java.util.Set;

public class AuthorModel {

    private long id;

    private String surname;

    private String name;

    private int height;

    private int weight;

    private int age;

    private Set<TeamView> teams = new HashSet<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<TeamView> getTeams() {
        return teams;
    }

    public void setTeams(Set<TeamView> teams) {
        this.teams = teams;
    }
}
