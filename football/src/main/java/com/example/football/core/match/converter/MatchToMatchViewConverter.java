package com.example.football.core.match.converter;

import com.example.football.core.match.Match;
import com.example.football.core.match.web.MatchView;
import com.example.football.core.team.Team;
import com.example.football.core.team.converter.TeamToTeamViewConverter;
import com.example.football.core.tournament.Tournament;
import com.example.football.core.tournament.converter.TournamentToTournamentViewConverter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class MatchToMatchViewConverter implements Converter<Match, MatchView> {

    private final TeamToTeamViewConverter teamToTeamViewConverter;
    private final TournamentToTournamentViewConverter tournamentToTournamentViewConverter;

    public MatchToMatchViewConverter(TeamToTeamViewConverter teamToTeamViewConverter,
                                     TournamentToTournamentViewConverter tournamentToTournamentViewConverter) {
        this.teamToTeamViewConverter = teamToTeamViewConverter;
        this.tournamentToTournamentViewConverter = tournamentToTournamentViewConverter;
    }

    @Override
    public MatchView convert(@NonNull Match match) {
        MatchView view = new MatchView();
        view.setId(match.getId());
        view.setMatchDate(match.getMatchDate());
        view.setScoreOwners(match.getScoreOwners());
        view.setScoreGuests(match.getScoreGuests());
        Team guest = match.getGuest();
        view.setTeamGuest(teamToTeamViewConverter.convert(guest));
        Team owner = match.getOwner();
        view.setTeamOwner(teamToTeamViewConverter.convert(owner));
        Tournament tournament = match.getTournament();
        view.setTournament(tournamentToTournamentViewConverter.convert(tournament));
        return view;
    }
}
