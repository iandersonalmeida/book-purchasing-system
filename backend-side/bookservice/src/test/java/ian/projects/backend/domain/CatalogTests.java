package ian.projects.backend.domain;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import ian.projects.catalogservice.domain.Catalog;
import ian.projects.catalogservice.domain.CatalogRepository;


public class CatalogTests {
	
	@Test
	void repositoryShouldReturnCatalog() {
		
		//Given
		CatalogRepository catalogRepository;
		Catalog existingCatalog = new Catalog();
		
		//When	
		Catalog catalog = catalogRepository.getCatalog();
		
		//Then
		assertSame(catalog, existingCatalog);
	}

}
