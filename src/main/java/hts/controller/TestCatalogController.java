package hts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestCatalogController {

	@GetMapping("/testcatalog") // @RequestMapping("/testcatalog")
	public String greeting(
			@RequestParam(value = "name", required = false, defaultValue = "new test catalog") String name,
			Model model) {
		System.out.println("show testcatalog template.");
		model.addAttribute("name", name);
		return "testcatalog";
	}

	@GetMapping("/ext/development/TestCatalog")
	public String developmentTestCatalog(Model model) {
		model.addAttribute("environment", "development");
		return "index";
	}

	@GetMapping("/ext/testing/TestCatalog")
	public String testingTestCatalog(Model model) {
		model.addAttribute("environment", "testing");
		return "index";
	}

	@GetMapping("/ext/TestCatalog")
	public String productionTestCatalog(Model model) {
		model.addAttribute("environment", "production");
		return "index";
	}

}