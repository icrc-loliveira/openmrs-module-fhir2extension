/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.fhir2extension.api.dao;

import javax.annotation.Nonnull;

import java.util.Collection;
import java.util.List;

import org.openmrs.FormResource;
import org.openmrs.annotation.Authorized;
import org.openmrs.module.fhir2.api.dao.FhirDao;
import org.openmrs.util.PrivilegeConstants;

public interface FhirQuestionnaireDao extends FhirDao<FormResource> {
	
	@Authorized(PrivilegeConstants.GET_FORMS)
	FormResource getQuestionnaireById(@Nonnull Integer id);
	
	@Authorized(PrivilegeConstants.GET_FORMS)
	List<FormResource> getQuestionnairesByIds(@Nonnull Collection<Integer> ids);
	
	@Override
	@Authorized(PrivilegeConstants.GET_FORMS)
	FormResource get(@Nonnull String uuid);
	
}
