/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.fhir2extension.api.translators;

import javax.annotation.Nonnull;

import org.hl7.fhir.r4.model.Questionnaire;
import org.openmrs.Form;
import org.openmrs.module.fhir2.api.translators.OpenmrsFhirTranslator;

public interface QuestionnaireTranslator extends OpenmrsFhirTranslator<Form, Questionnaire> {
	
	/**
	 * Maps an {@link Form} to a {@link Questionnaire}
	 * 
	 * @param form the form to translate
	 * @return the corresponding FHIR questionnaire resource
	 */
	@Override
	Questionnaire toFhirResource(@Nonnull Form form);
	
}
