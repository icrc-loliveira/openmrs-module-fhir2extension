/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.fhir2extension.api;

import javax.annotation.Nonnull;

import java.util.Collection;
import java.util.List;

import ca.uhn.fhir.rest.api.server.IBundleProvider;
import ca.uhn.fhir.rest.param.TokenParam;
import org.hl7.fhir.r4.model.Questionnaire;
import org.openmrs.module.fhir2.api.FhirService;
import org.openmrs.module.fhir2extension.api.search.param.QuestionnaireSearchParams;

public interface FhirQuestionnaireService extends FhirService<Questionnaire> {
	
	List<Questionnaire> getQuestionnairesByIds(@Nonnull Collection<Integer> ids);
	
	Questionnaire getById(@Nonnull Integer id);
	
	IBundleProvider searchForQuestionnaires(QuestionnaireSearchParams questionnaireSearchParams);
	
	IBundleProvider getQuestionnaireEverything(TokenParam identifier);
	
	IBundleProvider getQuestionnaireEverything();
}
