package ru.mirea.task24.services;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.task24.repositories.BuildingRepository;
import ru.mirea.task24.tables.Building;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class BuildingServiceTest {
    
    @Mock
    private BuildingRepository buildingsRepository;
    private BuildingService underTest;

    @BeforeEach
    void setUp() {
        underTest = new BuildingService(buildingsRepository);
    }

    @Test
    void createEntity() {
        Building building = new Building();
        building.setDate("14.11.2002");
        building.setType("Simple");

        underTest.createEntity(building);


        //ArgumentCaptor хранит и предоставляет все значения соответствующего параметра,
        // с которыми метод был вызван до того, как данный
        ArgumentCaptor<Building> buildingsArgumentCaptor =
                ArgumentCaptor.forClass(Building.class);

        //С помощью Mockito разработчик создает имитатор — мок, указывает библиотеке,
        // что делать при вызове определенных методов, а затем использует экземпляр имитатора в своем тесте
        // вместо реального объекта.
        Mockito.verify(buildingsRepository).save(buildingsArgumentCaptor.capture());

        Building buildingsArgumentCaptorValue = buildingsArgumentCaptor.getValue();
        Assertions.assertThat(buildingsArgumentCaptorValue).isEqualTo(building);
    }

    @Test
    void readAllEntity() {
        Building building1 = new Building();
        building1.setDate("11.11.2005");
        building1.setType("Complex");

        Building building2 = new Building();
        building2.setDate("04.01.1958");
        building2.setType("Simple");

        Mockito.when(buildingsRepository.findAll()).thenReturn(List.of(building1, building2));

        List<Building> expected = underTest.readAllEntity();

        Mockito.verify(buildingsRepository).findAll();
        assertThat(expected).isNotNull();
        assertThat(expected.size()).isEqualTo(2);
        assertThat(expected.get(0).getDate()).isEqualTo("11.11.2005");
        assertThat(expected.get(1).getDate()).isEqualTo("04.01.1958");
    }

    @Test
    void deleteEntities() {
        Building building = new Building();
        building.setDate("12.01.2005");
        building.setType("Big");

        underTest.deleteAllEntity();

        Mockito.verify(buildingsRepository).deleteAll();
    }

    @Test
    void filterBuildingByType() {
        Building building1 = new Building();
        building1.setDate("02.01.2005");
        building1.setType("Big");

        Building building2 = new Building();
        building2.setDate("12.09.2002");
        building2.setType("Simple");

        Mockito.when(buildingsRepository.findAllByType(building2.getType())).thenReturn(List.of(building2));

        //when
        List<Building> expected = underTest.filterBy(null, building2.getType());

        //then
        Mockito.verify(buildingsRepository). findAllByType(building2.getType());
        assertThat(expected).isNotNull();
        assertThat(expected.size()).isEqualTo(1);
        assertThat(expected.get(0).getType()).isEqualTo("Simple");
    }
}