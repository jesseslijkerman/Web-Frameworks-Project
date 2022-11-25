package app;

import app.models.Cabin;
import app.models.Rental;
import app.models.Status;
import app.repositories.CabinsRepository;
import app.repositories.CabinsRepositoryJpa;
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
	Rental rental1 = new Rental(
			LocalDate.of(2022, 11, 25),
			LocalDate.of(2022, 11, 30),
			Status.APPROVED
	);

	protected void createInitialCabins(){
		List<Cabin> cabins = this.cabinsRepo.findAll();
		if (cabins.size() > 0) return;
		System.out.println("Configuring some initial cabins");

		for (int i = 0; i < 6; i++) {
			Cabin cabin = new Cabin(0);
			Cabin savedCabin = this.cabinsRepo.save(cabin);
		}
	}

}
