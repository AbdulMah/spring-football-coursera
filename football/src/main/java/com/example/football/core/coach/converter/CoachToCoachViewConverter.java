package com.example.football.core.coach.converter;

import com.example.football.core.coach.Coach;
import com.example.football.core.coach.web.CoachView;
import com.example.football.core.team.Team;
import com.example.football.core.team.converter.TeamToTeamViewConverter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CoachToCoachViewConverter implements Converter<Coach, CoachView> {

    private final TeamToTeamViewConverter teamToTeamViewConverter;

    public CoachToCoachViewConverter(TeamToTeamViewConverter teamToTeamViewConverter) {
        this.teamToTeamViewConverter = teamToTeamViewConverter;
    }

    @Override
    public CoachView convert(@NonNull Coach coach) {
        CoachView view = new CoachView();
        view.setId(coach.getId());
        view.setName(coach.getName());
        view.setSurname(coach.getSurname());
        view.setAge(coach.getAge());
        view.setExpiriance(coach.getExperience());
        Team team = coach.getTeam();
        view.setTeam(teamToTeamViewConverter.convert(team));
        return view;
    }
}
