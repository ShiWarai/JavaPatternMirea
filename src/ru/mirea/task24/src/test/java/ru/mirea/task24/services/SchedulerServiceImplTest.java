package ru.mirea.task24.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class SchedulerServiceImplTest {
    private final String BACKUPS_DIR = "src/main/java/ru/mirea/task24/backups";
    private SchedulerService underTest;

    @Mock
    private AddressService addressService;
    @Mock
    private BuildingService buildingService;

    @BeforeEach
    public void setUp() {
        underTest = new SchedulerService();
    }

    @Test
    @Disabled
    void backupFromDatabase() throws IOException {
    }
}