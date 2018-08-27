package com.eprakash.learn.microservices.filtering;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	// get resource to return a object
	@GetMapping(path = "/Filter/StaticFiltertedbean")
	public List<StaticFilteredBean> staticFilteredbean() {
		List<StaticFilteredBean> filteredBeanList = new ArrayList<>();
		filteredBeanList.add(new StaticFilteredBean("prakash", "prakash", "kuna.jprakash@gmail.com", "los angeles"));
		filteredBeanList.add(new StaticFilteredBean("sandhya", "sandhya", "sandhya.25gmail.com", "los angeles"));
		filteredBeanList.add(new StaticFilteredBean("hitika", "hitika", "hitika.gmail.com", "los angeles"));

		return filteredBeanList;
	}
	
	@GetMapping(path = "/Filter/DynamicFiltertedbean")
	public MappingJacksonValue dynamicFilteredbean() {
		List<DynamicFilteredBean> filteredBeanList = new ArrayList<>();
		filteredBeanList.add(new DynamicFilteredBean("prakash", "prakash", "kuna.jprakash@gmail.com", "los angeles"));
		filteredBeanList.add(new DynamicFilteredBean("sandhya", "sandhya", "sandhya.25gmail.com", "los angeles"));
		filteredBeanList.add(new DynamicFilteredBean("hitika", "hitika", "hitika.gmail.com", "los angeles"));
		
		MappingJacksonValue mapping=new MappingJacksonValue(filteredBeanList);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("userName","email");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilter", filter);
		mapping.setFilters(filters);

		return mapping;
	}

}
