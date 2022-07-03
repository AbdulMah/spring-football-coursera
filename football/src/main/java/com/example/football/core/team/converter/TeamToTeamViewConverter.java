package com.example.football.core.team.converter;

import com.example.football.core.team.Team;
import com.example.football.core.team.web.TeamView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class TeamToTeamViewConverter implements Converter<Team, TeamView> {

    @Override
    public TeamView convert(@NonNull Team team) {
        TeamView view = new TeamView();
        view.setId(team.getId());
        view.setName(team.getName());
        view.setNumPlayers(team.getNumPlayers());
        return view;
    }
}
