package ua.lviv.iot.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.work.business.StadiumService;
import ua.lviv.iot.work.model.Stadium;

import java.util.*;

@RequestMapping("/stadiums")
@RestController
public class StadiumsController {
    @Autowired
    private StadiumService stadiumService;

    @GetMapping
    public List<Stadium> getStadiums() {
        return new LinkedList<Stadium>(stadiumService.allStadiums());
    }

    @GetMapping(path = "/{id}")
    public Object getStadium(final @PathVariable("id") Integer stadiumId) {
        if (stadiumService.stadiumId(stadiumId) != null) {
            return stadiumService.stadiumId(stadiumId);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Stadium createStadium(final @RequestBody Stadium stadium) {
        return stadiumService.createStadium(stadium);
    }

    @PutMapping(path = "/id")
    public Object createStadium(final @PathVariable("id") Integer stadiumId, final @RequestBody Stadium stadium) {
        if (stadiumService.stadiumId(stadiumId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        stadiumService.replaceStadium(stadium, stadiumId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Stadium> deleteStadium(final @PathVariable("id") Integer stadiumId) {
        if (stadiumService.destroyStadium(stadiumId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
