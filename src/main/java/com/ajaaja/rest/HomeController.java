package com.ajaaja.rest;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ajaaja.rest.domain.Category;
import com.ajaaja.rest.domain.Product;
import com.ajaaja.rest.repository.CategoryRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	CategoryRepository categoryRepository;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		if (categoryRepository == null) {
			System.out.println("... null");
		} else {
			System.out.println(categoryRepository.count());
		}
		return "home";
	}

	/**
	 * insert with keyword, productCode, company if exist add product
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@RequestParam String keyword,
			@RequestParam final String productCode,
			@RequestParam final String company, Model model) {
		if (categoryRepository == null) {
			System.out.println("... null");
		} else {
			Category exist = categoryRepository.findByKeyword(keyword);
			if (exist == null) {
				List<Product> products = new ArrayList<Product>() {
					{
						add(new Product(productCode, company));
					}
				};
				Category insertCategory = new Category(keyword, null);
				categoryRepository.save(insertCategory);
				exist = insertCategory;
			} else {
				exist.getResult().add(new Product(productCode, company));
				categoryRepository.save(exist);
			}
			model.addAttribute("message", "save ok : " + exist.toString());
		}
		return "home";
	}

	/**
	 * 
	 * @param keyword
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String select(@RequestParam(required = false) String keyword,
			Model model) {
		String messages = "";
		if (categoryRepository == null) {
			System.out.println("... null");
		} else {
			// TODO parameter null check... else method
			if (keyword == null) {
				List<Category> categories = categoryRepository.findAll();
				messages = categories.toString();
			} else {
				Category category = categoryRepository.findByKeyword(keyword);
				messages = category.toString();
			}
			logger.info("select : "+messages);
		}
		model.addAttribute("message", messages);
		return "select";
	}

}
