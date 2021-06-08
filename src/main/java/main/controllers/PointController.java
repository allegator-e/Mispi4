package main.controllers;

import main.models.Point;
import main.models.PointDto;
import main.service.PointService;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class PointController {
    @Autowired
    private PointService pointService;
    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/points")
    PointDto addPoint(@RequestBody PointDto pointDto, @RequestHeader String login){
        System.out.println("Request for adding the point");
        Point point = pointDto.toPoint();
        point.setUser(userService.findByLogin(login));
        pointService.save(point);
        pointService.countPoints(point);
        pointService.setArea(point);
        System.out.println("Point " + point + " added!");
        return pointDto;
    }

    @CrossOrigin
    @GetMapping("/")
    Collection<PointDto> getPoints(@RequestHeader String login){
        System.out.println("Request for points of user " + login);
        Collection<Point> collection = pointService.findByUser(userService.findByLogin(login));
        Collection<PointDto> newCol = new ArrayList<>();
        for (Point p:collection){
            newCol.add(p.toPointDto());
        }
        System.out.println(newCol);
        return newCol;
    }
}
