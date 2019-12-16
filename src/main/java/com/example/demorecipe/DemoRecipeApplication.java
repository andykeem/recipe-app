package com.example.demorecipe;

import com.example.demorecipe.entity.Category;
import com.example.demorecipe.repository.CategoryRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@SpringBootApplication
public class DemoRecipeApplication implements CommandLineRunner {

//	@Autowired
//	private CategoryRepository catRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoRecipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*String catName = "Italian";
		Optional<Category> cat = catRepo.findByName(catName).map(new Function<Category, Category>() {
			@Override
			public Category apply(Category category) {
				return category;
			}
		});
		if (cat.isPresent()) {
			log.info("category: " + cat.get().getName());
		} else {
			throw new EntityNotFoundException("category name: " + catName + " not found");
		}*/
	}
}
