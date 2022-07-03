package com.example.football.core.tournament.converter;

import com.example.football.core.team.Team;
import com.example.football.core.team.converter.TeamToTeamViewConverter;
import com.example.football.core.team.web.TeamView;
import com.example.football.core.tournament.Tournament;
import com.example.football.core.tournament.web.TournamentView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class TournamentToTournamentViewConverter implements Converter<Tournament, TournamentView> {

    private final TeamToTeamViewConverter teamToTeamViewConverter;

    public TournamentToTournamentViewConverter(TeamToTeamViewConverter teamToTeamViewConverter) {
        this.teamToTeamViewConverter = teamToTeamViewConverter;
    }

    @Override
    public TournamentView convert(@NonNull Tournament tournament) {
        TournamentView view = new TournamentView();
        view.setId(tournament.getId());
        view.setName(tournament.getName());
        view.setCountry(tournament.getCountry());
        Set<TeamView> views = new HashSet<>();
        Set<Team> teams= tournament.getTeams();
        teams.forEach(team -> views.add(teamToTeamViewConverter.convert(team)));
        view.setTeams(views);
        return view;
    }
}
