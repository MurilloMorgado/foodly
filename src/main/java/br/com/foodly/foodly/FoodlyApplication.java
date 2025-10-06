package br.com.foodly.foodly;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.foodly.foodly.framework.models.Cardapio;
import br.com.foodly.foodly.framework.models.Ingrediente;
import br.com.foodly.foodly.framework.repositories.CardapioRepository;
import br.com.foodly.foodly.framework.repositories.IngredienteRespository;

@SpringBootApplication
public class FoodlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodlyApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataInitializer(IngredienteRespository ingredienteRepository, CardapioRepository cardapioRepository) {
		Cardapio cardapio = new Cardapio();
		cardapio.setCategoria("Cardápio Principal");
		cardapioRepository.save(cardapio);

		return args -> {
			if (ingredienteRepository.count() == 0) {
				Ingrediente tomate = new Ingrediente();
				tomate.setNome("Tomate");
				tomate.setStatus(true);
				ingredienteRepository.save(tomate);
			}
		};
	}
}
