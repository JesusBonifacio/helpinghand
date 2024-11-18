package backend.helpinghand;

import backend.helpinghand.dtos.DTOUser;
import backend.helpinghand.entities.*;
import backend.helpinghand.repositories.*;
import backend.helpinghand.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;


@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}




	@Bean
	public CommandLineRunner mappingDemo(
			CampaignRepository campaignRepository,
			CategoryRepository categoryRepository,
			CommentRepository commentRepository,
			DonationRepository donationRepository,
			OrganizationRepository organizationRepository,
			ProfileRepository profileRepository,
			UserRepository userRepository,
			UserService userService,
			AuthorityService authorityService
			) {
		return args -> {

			authorityService.addAuthority(new Authority(0L, "CONSULTA", null));
			authorityService.addAuthority(new Authority(0L, "REGISTRO", null));



			userService.addUser(new DTOUser(0L,"kyshara","password123",true,"CONSULTA;REGISTRO"));
			userService.addUser(new DTOUser(0L,"csanchez", "password456", true,"CONSULTA;REGISTRO"));
			userService.addUser(new DTOUser(0L,"avaldez", "password583",true,"REGISTRO"));
			userService.addUser(new DTOUser(0L,"hgutierrez", "password049",true,"CONSULTA"));
			userService.addUser(new DTOUser(0L,"jcasana", "password347",true,"CONSULTA"));
			userService.addUser(new DTOUser(0L,"jbonifacio", "password708",true,"REGISTRO"));



			Profile koji = new Profile(0L,"Koji Yshara","u202112901@upc.edu.pe","Lima","9923545422","2003-08-29",null,null);
			Profile carlos = new Profile(0L, "Carlos Sanchez", "u201915630@upc.edu.pe", "Lima", "9956483301","2001-03-05",null,null);
			Profile alvaro = new Profile(0L,"Alvaro Valdez","u202111486@upc.edu.pe","Lima","990872374","2003-01-07",null,null);
			Profile hernan = new Profile(0L,"Hernan Gutierrez","u20181g891@upc.edu.pe","Lima","951584307","2001-05-27",null,null);
			Profile jesus = new Profile(0L,"Jesus Casana","u20211a460@upc.edu.pe","Lima","952234542","2003-04-14",null,null);
			Profile jesus2 = new Profile(0L,"Jesus Bonifacio","u202216306@upc.edu.pe","Lima","936923786","2002-12-13",null,null);
			Profile profile1 = new Profile(0L,"Perfil1","Perfil1@upc.edu.pe","Lima","123456789","2000-01-01",null,null);

			koji = profileRepository.save(koji);
			carlos = profileRepository.save(carlos);
			alvaro = profileRepository.save(alvaro);
			hernan = profileRepository.save(hernan);
			jesus = profileRepository.save(jesus);
			jesus2 = profileRepository.save(jesus2);
			profileRepository.save(profile1);


			Organization org1 = new Organization(0L, "Red Cross", "International humanitarian organization", "contact@redcross.org", "+11234567890", null);
			Organization org2 = new Organization(0L, "UNICEF", "United Nations agency for children's rights", "info@unicef.org", "+11239876543", null);
			Organization org3 = new Organization(0L, "WWF", "World Wildlife Fund - nature conservation", "support@wwf.org", "+11098765432", null);
			Organization org4 = new Organization(0L, "Doctors Without Borders", "Medical humanitarian organization", "contact@msf.org", "+11345678901", null);


			org1 = organizationRepository.save(org1);
			org2 = organizationRepository.save(org2);
			org3 = organizationRepository.save(org3);
			org4 = organizationRepository.save(org4);

			Category category1 = new Category(0L, "Salud", null);
			Category category2 = new Category(0L, "Educación", null);
			Category category3 = new Category(0L, "Desastres Naturales", null);
			Category category4 = new Category(0L, "Pobreza y Hambre", null);
			Category category5 = new Category(0L, "Medio Ambiente", null);

			category1 = categoryRepository.save(category1);
			category2 = categoryRepository.save(category2);
			category3 = categoryRepository.save(category3);
			category4 = categoryRepository.save(category4);
			category5 = categoryRepository.save(category5);

			Campaign campaign1_org1 = new Campaign(0L, "Disaster Relief", "Helping victims of natural disasters", 1000000D, "2023-01-01", "2023-12-31", org1, null,category3,null);
			Campaign campaign2_org1 = new Campaign(0L, "Blood Donation", "Organizing blood donation drives", 500000D, "2023-02-01", "2023-11-30", org1, null,category1,null);

			Campaign campaign1_org2 = new Campaign(0L, "Education for All", "Providing education for underprivileged children",  150000D, "2023-03-01", "2024-02-28", org2, null,category2,null);
			Campaign campaign2_org2 = new Campaign(0L, "Child Nutrition", "Addressing child malnutrition globally", 1500000D,  "2023-04-01", "2024-03-31", org2, null,category4,null);

			Campaign campaign1_org3 = new Campaign(0L, "Wildlife Protection", "Protecting endangered species", 3000000D,  "2023-05-01", "2024-04-30", org3, null,category5,null);

			Campaign campaign1_org4 = new Campaign(0L, "Medical Aid", "Providing medical aid in war zones", 2500000D,  "2023-06-01", "2024-05-31", org4, null,category1,null);


			campaign1_org1 = campaignRepository.save(campaign1_org1);
			campaign2_org1 = campaignRepository.save(campaign2_org1);
			campaign1_org2 = campaignRepository.save(campaign1_org2);
			campaign2_org2 = campaignRepository.save(campaign2_org2);
			campaign1_org3 = campaignRepository.save(campaign1_org3);
			campaign1_org4 = campaignRepository.save(campaign1_org4);



			Donation donation1 = new Donation(0L, 100.0f, "2023-09-15", "Completed", koji, campaign1_org1);
			Donation donation2 = new Donation(0L, 50.5f, "2023-08-10", "Pending", carlos, campaign1_org1);
			Donation donation3 = new Donation(0L, 200.0f, "2023-07-20", "Completed", alvaro, campaign2_org1);
			Donation donation4 = new Donation(0L, 75.0f, "2023-06-05", "Failed", hernan, campaign1_org2);
			Donation donation5 = new Donation(0L, 120.0f, "2023-05-25", "Pending", jesus, campaign2_org2);
			Donation donation6 = new Donation(0L, 300.0f, "2023-04-30", "Completed", jesus2, campaign1_org4);

			donationRepository.save(donation1);
			donationRepository.save(donation2);
			donationRepository.save(donation3);
			donationRepository.save(donation4);
			donationRepository.save(donation5);
			donationRepository.save(donation6);

			Comment comment1 = new Comment(0L, "¡Gran campaña! ¡Sigan con el buen trabajo!", "2023-09-20", koji, campaign1_org1);
			Comment comment2 = new Comment(0L, "Acabo de hacer una donación, espero que ayude.", "2023-09-18", carlos, campaign1_org1);
			Comment comment3 = new Comment(0L, "¿Pueden proporcionar más información sobre los beneficiarios?", "2023-09-15", alvaro, campaign1_org2);
			Comment comment4 = new Comment(0L, "Aprecio lo que están haciendo. ¡Mis mejores deseos!", "2023-09-10", hernan, campaign2_org1);
			Comment comment5 = new Comment(0L, "¿Hay alguna forma de ser voluntario para esta campaña?", "2023-09-08", jesus, campaign2_org2);
			Comment comment6 = new Comment(0L, "Compartiré esta campaña con mis amigos.", "2023-09-05", jesus2, campaign1_org3);
			Comment comment7 = new Comment(0L, "Es inspirador ver cómo esta campaña está ayudando a tantas personas. ¡Sigan adelante!", "2024-09-28", koji, campaign1_org4);

			commentRepository.save(comment1);
			commentRepository.save(comment2);
			commentRepository.save(comment3);
			commentRepository.save(comment4);
			commentRepository.save(comment5);
			commentRepository.save(comment6);
			commentRepository.save(comment7);
		};
	}

}
