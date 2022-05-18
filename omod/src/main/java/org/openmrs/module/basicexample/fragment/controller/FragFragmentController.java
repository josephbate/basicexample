package org.openmrs.module.basicexample.fragment.controller;

import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;
import org.openmrs.module.basicexample.api.BasicexampleService;

public class FragFragmentController {
	
	public void controller(FragmentModel model, @SpringBean("basicexample.BasicexampleService") BasicexampleService service) {
		
		model.addAttribute("items", service.getAllItems());
	}
	
}
