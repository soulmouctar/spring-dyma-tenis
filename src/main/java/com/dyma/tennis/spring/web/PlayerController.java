package com.dyma.tennis.spring.web;

import com.dyma.tennis.spring.entity.Player;
import com.dyma.tennis.spring.entity.PlayerToRegister;
import com.dyma.tennis.spring.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Tenis Player API")
@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @Operation(summary = "List players", description = "Returns a list of players.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of players",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Player.class)))}
            )
    })
    @GetMapping
    public List<Player> list() {
        return playerService.getAllPlayers();
    }

    @Operation(summary = "Find player by LatsName", description = "Returns LastName of players.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of players",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Player.class))}
            )
            , @ApiResponse(responseCode = "404", description = "Player not found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))}
            )
    })
    @GetMapping("{lastName}")
    public Player getByLastName(@PathVariable(name = "lastName") String lastName) {
        return playerService.getPlayerByLastName(lastName);
    }

    @Operation(summary = "Create Player", description = "Returns Created Player.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "created player",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Player.class))}
            )
    })
    @PostMapping
    public Player createPlayer(@RequestBody @Valid PlayerToRegister playerToRegister) {
        return playerService.create(playerToRegister);
    }

    @Operation(summary = "Update Player", description = "Returns updated Player.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "update player",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Player.class))}
            )
    })
    @PutMapping
    public Player updatePlayer(@RequestBody @Valid Player player) {
        return player;
    }


    @Operation(summary = "Delete One Player", description = "Delete a Player.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "player has been deleted")
    })
    @DeleteMapping("{lastName}")
    public Player DeletePlayerByLastName(@PathVariable(name = "lastName") String lastName) {
        return null;
    }
}
