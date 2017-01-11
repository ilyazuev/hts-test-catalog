package hts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestCatalogController {

	@GetMapping("/testcatalog") // @RequestMapping("/testcatalog")
	public String mainView(
			@RequestParam(value = "name", required = false, defaultValue = "new test catalog") String name,
			Model model) {
		System.out.println("show testcatalog template.");
		model.addAttribute("name", name);
		return "testcatalog";
	}

	@GetMapping("/ext/development/TestCatalog")
	public String developmentTestCatalog(Model model) {
		return getEnvironmentIndex(model, "development");
	}

	@GetMapping("/ext/testing/TestCatalog")
	public String testingTestCatalog(Model model) {
		return getEnvironmentIndex(model, "testing");
	}

	@GetMapping("/ext/TestCatalog")
	public String productionTestCatalog(Model model) {
		return getEnvironmentIndex(model, "production");
	}
	
	private String getEnvironmentIndex(Model model, String environment) {
		model.addAttribute("environment", environment);
		return "index";
	}

}