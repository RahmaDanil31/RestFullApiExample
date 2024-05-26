package app.Rest.RestFullApiExample;

import app.Rest.RestFullApiExample.MasterData.Filter.CategoryDtoFilter;
import app.Rest.RestFullApiExample.MasterData.Repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootTest
class RestFullApiExampleApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void contextLoads() {
	}

}
