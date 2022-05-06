package ru.mirea.task20.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.task20.repositories.BuildingRepository;
import ru.mirea.task20.tables.Building;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BuildingService implements TableService<Building>{

    private BuildingRepository buildingRepository;

    @Autowired
    BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public void createEntity(Building building) {
        buildingRepository.save(building);
    }


    public List<Building> readAllEntity() {
        return buildingRepository.findAll();
    }

    public boolean deleteAllEntity() {
        buildingRepository.deleteAll();
        return true;
    }

    public List<Building> filterBy(String date, String type) {
        if(date != null && type != null)
            return buildingRepository.findAllByDateAndType(date, type);
        else if (date != null) {
            return buildingRepository.findAllByDate(date);
        } else if (type != null) {
            return buildingRepository.findAllByType(type);
        }

        return null;
    }
}
