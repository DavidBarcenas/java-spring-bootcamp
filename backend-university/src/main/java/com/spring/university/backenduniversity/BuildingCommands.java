package com.spring.university.backenduniversity;

import com.spring.university.backenduniversity.dao.BuildingDAO;
import com.spring.university.backenduniversity.persistence.entity.Address;
import com.spring.university.backenduniversity.persistence.entity.Building;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BuildingCommands implements CommandLineRunner {
    private final BuildingDAO buildingService;

    public BuildingCommands(BuildingDAO buildingService) {
        this.buildingService = buildingService;
    }

    @Override
    public void run(String... args) throws Exception {
        /*Building building1 = new Building(null, 100.0, "Building 1",
                new Address("Zocalo", "276", "98765", null, "2", "Ciudad de México")
        );
        Building building2 = new Building(null, 150.0, "Building 2",
                new Address("Piedras Negras", "342", "23432", null, "21", "Jalisco")
        );
        Building building3 = new Building(null, 200.0, "Building 3",
                new Address("Zapaata", "455", "34564", null, "21", "Puebla")
        );
        Building building4 = new Building(null, 80.0, "Building 4",
                new Address("Arteaga", "678", "56566", null, "2", "Monterrey")
        );
        Building building5 = new Building(null, 125.0, "Building 5",
                new Address("Xochitla", "564", "78655", null, "5", "San Luis")
        );

        this.buildingService.save(building1);
        this.buildingService.save(building2);
        this.buildingService.save(building3);
        this.buildingService.save(building4);
        this.buildingService.save(building5);
     */
        Iterable<Building> buildings = this.buildingService.findByName("Building");
        buildings.forEach(System.out::println);
    }
}
