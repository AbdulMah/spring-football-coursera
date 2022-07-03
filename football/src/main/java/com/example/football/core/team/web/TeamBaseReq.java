package com.example.football.core.team.web;

import com.example.football.base.BaseRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TeamBaseReq extends BaseRequest {

    @NotEmpty
    private String name;

    @NotNull
    private int numPlayers;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }
}
