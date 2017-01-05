package hts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestCatalogController {

	//@RequestMapping("/testcatalog")
	@GetMapping("/testcatalog")
	public String greeting(@RequestParam(value="name",required=false,defaultValue="new test catalog")String name, Model model) {
		System.out.println("show testcatalog template.");
		model.addAttribute("name",name );
		return "testcatalog";
	}
	
}