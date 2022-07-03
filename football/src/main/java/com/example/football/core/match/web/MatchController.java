package com.example.football.core.match.web;

import com.example.football.core.match.Match;
import com.example.football.core.match.MatchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @GetMapping("/last")
    @ResponseBody
    public List<MatchView> getLast(@RequestBody @Valid MatchLastReq req){
        return service.findLastMatch(req);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public MatchView getMatch(@PathVariable Long id) {
        return service.getMatch(id);
    }

    @GetMapping({"", "/"})
    @ResponseBody
    public Page<MatchView> getAllMatch(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.findAllMatch(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MatchView create(@RequestBody @Valid MatchBaseReq req) {
        return service.create(req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMatch(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public MatchView updateTournament(@PathVariable(name = "id") Long id,
                                      @RequestBody @Valid MatchBaseReq req) {
        Match match = service.findMatchOrThrow(id);
        return service.update(match, req);
    }
}
