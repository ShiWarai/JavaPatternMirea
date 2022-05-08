package ru.mirea.task23.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import ru.mirea.task23.tables.Address;
import ru.mirea.task23.tables.Building;
import java.io.*;

@Service
@ManagedResource(description = "Scheduler service")
@Slf4j
public class SchedulerService {
    private final String BACKUPS_DIR = "src/main/java/ru/mirea/task23/backups";

    @Autowired
    private AddressService addressService;
    @Autowired
    private BuildingService buildingService;


    @Scheduled(cron = "0 */30 * ? * *")
    @ManagedOperation(description = "Clear backups and create new files")
    public void backupFromDatabase() throws IOException {
        log.info("Sheduler task is started");

        File file_dir = ResourceUtils.getFile(BACKUPS_DIR);
        boolean a = file_dir.isDirectory();
        try {
            for (File file : file_dir.listFiles())
                if (file.isFile()) {
                    file.delete();
                }
            log.info("Files deleted");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        BufferedWriter addresses = new BufferedWriter(new FileWriter(BACKUPS_DIR + "/addresses.txt"));
        for (Address item : addressService.readAllEntity()) {
            addresses.write(item.toString());
            addresses.write('\n');
        }
        addresses.close();

        BufferedWriter buildings = new BufferedWriter(new FileWriter(BACKUPS_DIR + "/buildings.txt"));
        for (Building item : buildingService.readAllEntity()) {
            buildings.write(item.toString());
            buildings.write('\n');
        }
        buildings.close();

        log.info("Sheduler task is ended");
    }
}
