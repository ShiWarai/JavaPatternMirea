package ru.mirea.task17.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task17.services.BuildingService;
import ru.mirea.task17.services.TableService;
import ru.mirea.task17.tables.Building;

import java.util.List;

@RestController
public class BuildingController {

    private final TableService<Building> serviceTableService;

    @Autowired
    public BuildingController(TableService<Building> serviceTableService) {
        this.serviceTableService = serviceTableService;
    }

    @PostMapping(value = "/add_building", consumes = {"application/json"})
    public ResponseEntity<?> createBuilding(@RequestBody Building building) {
        serviceTableService.createEntity(building);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/get_buildings")
    public ResponseEntity<List<Building>> readBuildings() {
        final List<Building> buildings = serviceTableService.readAllEntity();
        return buildings != null && !buildings.isEmpty()
                ? new ResponseEntity<>(buildings, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/get_buildings/by")
    public ResponseEntity<List<Building>> getBuildingBy(@RequestParam(value = "date", required = false) String date,
                                                        @RequestParam(value = "type", required = false) String type) {
        List<Building> buildings = null;

        if(date != null && type != null) {
            buildings = ((BuildingService) serviceTableService).filterByDate(date);
            for (Building building : buildings) {
                if (building.getType() != type)
                    buildings.remove(building);
            }
        }
        else if(date != null)
            buildings = ((BuildingService)serviceTableService).filterByDate(date);
        else if (type != null)
            buildings = ((BuildingService)serviceTableService).filterByType(type);

        return buildings != null && !buildings.isEmpty()
                ? new ResponseEntity<>(buildings, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value="/delete_buildings")
    public ResponseEntity<?> deleteBuildings() {
        final boolean isDeleted = serviceTableService.deleteAllEntity();
        return isDeleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
