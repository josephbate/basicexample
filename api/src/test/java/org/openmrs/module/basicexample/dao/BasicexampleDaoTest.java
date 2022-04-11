/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.basicexample.dao;

import org.junit.Test;
import org.junit.Ignore;
import org.openmrs.api.UserService;
import org.openmrs.api.context.Context;
import org.openmrs.module.basicexample.Item;
import org.openmrs.module.basicexample.api.dao.BasicexampleDao;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * It is an integration test (extends BaseModuleContextSensitiveTest), which verifies DAO methods
 * against the in-memory H2 database. The database is initially loaded with data from
 * standardTestDataset.xml in openmrs-api. All test methods are executed in transactions, which are
 * rolled back by the end of each test method.
 */
public class BasicexampleDaoTest extends BaseModuleContextSensitiveTest {
	
	@Autowired
	BasicexampleDao dao;
	
	@Autowired
	UserService userService;
	
	@Test
	public void saveItem_shouldSaveAllPropertiesInDb() {
		//Given
		Item item = new Item();
		item.setDrugName("drugitem");
		item.setDescription("some description");
		item.setPrescription("some prescription");
		item.setQuantity(10);
		item.setPurchases(null);
		
		//When
		dao.saveItem(item);
		
		//Let's clean up the cache to be sure getItemByUuid fetches from DB and not from cache
		Context.flushSession();
		Context.clearSession();
		
		//Then
		//Item savedItem = dao.getItemByUuid(item.getUuid());
		
		Item savedItem = dao.getItem(1);
		assertThat(savedItem, hasProperty("uuid", is(item.getUuid())));
		assertThat(savedItem, hasProperty("drugName", is(item.getDrugName())));
		assertThat(savedItem, hasProperty("description", is(item.getDescription())));
		assertThat(savedItem, hasProperty("prescription", is(item.getPrescription())));
		assertThat(savedItem, hasProperty("quantity", is(item.getQuantity())));
		assertThat(savedItem, hasProperty("purchases", is(item.getPurchases())));
	}
	
}
