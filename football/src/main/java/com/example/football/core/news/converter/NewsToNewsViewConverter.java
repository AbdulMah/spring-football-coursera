package com.example.football.core.news.converter;

import com.example.football.core.news.News;
import com.example.football.core.news.web.NewsView;
import com.example.football.core.team.Team;
import com.example.football.core.team.converter.TeamToTeamViewConverter;
import com.example.football.core.team.web.TeamView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class NewsToNewsViewConverter implements Converter<News, NewsView> {

    private final TeamToTeamViewConverter teamToTeamViewConverter;

    public NewsToNewsViewConverter(TeamToTeamViewConverter teamToTeamViewConverter) {
        this.teamToTeamViewConverter = teamToTeamViewConverter;
    }

    @Override
    public NewsView convert(@NonNull News news) {
        NewsView view = new NewsView();
        view.setId(news.getId());
        view.setName(news.getName());
        view.setContent(news.getContent());
        Set<TeamView> views = new HashSet<>();
        Set<Team> teams= news.getTeams();
        teams.forEach(team -> {
            TeamView teamView = teamToTeamViewConverter.convert(team);
            views.add(teamView);
        });
        view.setTeams(views);
        return view;
    }
}
