package com.basic.BasicSpringBootApplication;

import com.basic.BasicSpringBootApplication.dto.OwnerDTO;
import com.basic.BasicSpringBootApplication.dto.PetDTO;
import com.basic.BasicSpringBootApplication.service.OwnerService;
import com.basic.BasicSpringBootApplication.util.InputUtil;
import com.basic.BasicSpringBootApplication.service.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Scanner;

@PropertySource("classpath:messages.properties")
@SpringBootApplication
public class BasicSpringBootApplication implements CommandLineRunner {
    private final OwnerService ownerService;
    private final PetService petService;
    private static final Logger LOGGER = LoggerFactory.getLogger(BasicSpringBootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BasicSpringBootApplication.class, args);
    }

    // by making the variables private we have declared that they should be constructor injected using autowiring
    // so we don't need to use @Autowired annotation here
    public BasicSpringBootApplication(OwnerService ownerService, PetService petService) {
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("Welcome to Petistaan");
                int menuOption = InputUtil.acceptMenuOption(scanner);
                switch (menuOption) {
                    case 1:
                        OwnerDTO ownerDTO = InputUtil.acceptOwnerDetailsToSave(scanner);
                        PetDTO petDTO = InputUtil.acceptPetDetailsToSave(scanner);
                        ownerDTO.setPetDTO(petDTO);
                        ownerService.saveOwner(ownerDTO);
                        System.out.println("Owner has been saved successfully.");
                        break;
                    case 2:
                        int ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
                        ownerDTO = ownerService.findOwner(ownerId);
                        System.out.println("Owner has been fetched successfully.");
                        System.out.println(ownerDTO);
                        break;
                    case 3:
                        ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
                        String petName = InputUtil.acceptPetDetailsToUpdate(scanner);
                        ownerService.updatePetDetails(ownerId, petName);
                        System.out.println("Het details of owner have been updated successfully.");
                        break;
                    case 4:
                        ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
                        ownerService.deleteOwner(ownerId);
                        System.out.println("Owner has been deleted successfully.");
                        break;
                    case 5:
                        List<OwnerDTO> ownerDTOList = ownerService.findAllOwners();
                        System.out.println("There are + ownerDTOList.size()" + "owners.");
                        ownerDTOList.forEach(System.out::println);
                        break;
                    case 6:
                        int petId = InputUtil.acceptPetIdToOperate(scanner);
                        petDTO = petService.findPet(petId);
                        System.out.println("Pet has been fetched successfully.");
                        System.out.println(petDTO);
                        break;
                    default:
                        System.out.println("Invalid option entered.");
                }
            } while (InputUtil.wantToContinue(scanner));
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
    }
}