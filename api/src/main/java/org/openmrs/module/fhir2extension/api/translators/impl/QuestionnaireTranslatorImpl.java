/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.fhir2extension.api.translators.impl;

import static org.apache.commons.lang3.Validate.notNull;

import javax.annotation.Nonnull;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import lombok.AccessLevel;
import lombok.Setter;
import org.hl7.fhir.r4.model.*;
import org.openmrs.FormResource;
import org.openmrs.api.FormService;
import org.openmrs.module.fhir2extension.api.translators.QuestionnaireTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Setter(AccessLevel.PACKAGE)
public class QuestionnaireTranslatorImpl implements QuestionnaireTranslator {
	
	@Autowired
	FormService formService;
	
	@Override
	public Questionnaire toFhirResource(@Nonnull FormResource formResource) {
		notNull(formResource, "The Openmrs FormResource object should not be null");
		FhirContext ctx = FhirContext.forR4();
		IParser p = ctx.newJsonParser();
		return p.parseResource(Questionnaire.class, formResource.getValue().toString());
	}
	
	@Override
	public FormResource toOpenmrsType(@Nonnull Questionnaire resource) {
		return (FormResource) formService.getFormResourceByUuid(resource.getId());
	}
}
