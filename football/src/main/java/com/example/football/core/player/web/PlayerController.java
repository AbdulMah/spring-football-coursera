package com.example.football.core.player.web;

import com.example.football.core.player.Player;
import com.example.football.core.player.AuthorController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final AuthorController service;

    public PlayerController(final AuthorController service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public AuthorModel getAuthor(@PathVariable Long id) {
        return service.getPlayer(id);
    }

    
    @GetMapping
    @ResponseBody
    public Page<AuthorModel> getAllPlayer(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.findAllPlayer(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public AuthorModel create(@RequestBody @Valid PlayerBaseReq req) {
        return service.create(req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayer(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public AuthorModel updatePlayer(@PathVariable(name = "id") Long id,
                                @RequestBody @Valid PlayerBaseReq req){
        Player player = service.findPlayerOrThrow(id);
        return service.update(player, req);
    }
}
