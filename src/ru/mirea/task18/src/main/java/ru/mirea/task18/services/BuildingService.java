package ru.mirea.task18.services;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.mirea.task18.repositories.BuildingRepository;
import ru.mirea.task18.tables.Building;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class BuildingService implements TableService<Building>{

    private BuildingRepository buildingRepository;

    @Autowired
    BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public BuildingService() {
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
