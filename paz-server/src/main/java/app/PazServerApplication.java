package app;

import app.models.Cabin;
import app.models.Rental;
import app.repositories.CabinsRepository;
import app.repositories.CabinsRepositoryJpa;
import app.repositories.RentalsRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class PazServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PazServerApplication.class, args);
	}

	@Override
	@Transactional
	public void run (String... args) throws Exception{
		System.out.println();

		this.createInitialCabins();
	}

	@Qualifier("cabinsRepositoryJpa")
	@Autowired
	private CabinsRepository cabinsRepo;

	@Autowired
	private RentalsRepositoryJpa rentalsRepo;


	Rental rental1 = new Rental(
			LocalDate.of(2022, 11, 25),
			LocalDate.of(2022, 11, 30)
	);
	Rental rental2 = new Rental(
			LocalDate.of(2022, 12, 2),
			LocalDate.of(2022, 12, 8)
	);
	Rental rental3 = new Rental(
			LocalDate.of(2022, 12, 15),
			LocalDate.of(2022, 12, 29)
	);

	protected void createInitialCabins(){
		List<Cabin> cabins = this.cabinsRepo.findAll();
		if (cabins.size() > 0) return;
		System.out.println("Configuring some initial cabins");

		for (int i = 0; i < 6; i++) {
			Cabin cabin = new Cabin(0);

			for (int j = 0; j < 3; j++) {
				Rental rental = new Rental(
						LocalDate.of(2022, 11, 25),
						LocalDate.of(2022, 11, 30));
				rental.associateCabin(cabin);
				cabin.associateRental(rental);
				Rental savedRental = this.rentalsRepo.save(rental);
			}
			
			Cabin savedCabin = this.cabinsRepo.save(cabin);
		}
		
	}

}
