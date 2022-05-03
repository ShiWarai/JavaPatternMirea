package ru.mirea.task14.Application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class BuildingController {

    private ArrayList<Building> buildings = new ArrayList<>();

    @PostMapping(value = "/add_building")
    @ResponseBody
    public String addBuilding(@RequestParam("date") String creationDate, @RequestParam("type") String typeName) {
        Building building = new Building(creationDate, typeName);
        buildings.add(building);
        return building.toString();
    }

    @GetMapping(value = "/get_buildings")
    @ResponseBody
    public String getBuildings() {
        String result = "[";

        for (Building building : buildings) {
            result += building.toString() + ',';
        }
        if(buildings.size() > 0)
            result = result.substring(0, result.length() - 1);

        result+="]";
        return result;
    }

    @DeleteMapping(value = "/delete_buildings")
    @ResponseBody
    public boolean deleteBuildings() {
        buildings.clear();
        return buildings.size() == 0;
    }
}
