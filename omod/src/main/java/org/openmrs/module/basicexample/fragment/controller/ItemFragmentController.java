/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.basicexample.fragment.controller;

import org.openmrs.module.basicexample.api.BasicexampleService;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;

/**
 *  * Controller for a fragment that shows all drugs  
 */
public class ItemFragmentController {
	
	public void controller(FragmentModel model, @SpringBean("basicexampleService") BasicexampleService service) {
		model.addAttribute("encounters", service.getAllItems());
	}
	
}
