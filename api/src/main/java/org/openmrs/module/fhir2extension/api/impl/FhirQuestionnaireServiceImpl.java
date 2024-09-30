/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.fhir2extension.api.impl;

import javax.annotation.Nonnull;

import ca.uhn.fhir.rest.api.PatchTypeEnum;
import ca.uhn.fhir.rest.api.server.IBundleProvider;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.param.TokenAndListParam;
import ca.uhn.fhir.rest.param.TokenParam;
import ca.uhn.fhir.rest.server.SimpleBundleProvider;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hl7.fhir.r4.model.Questionnaire;
import org.openmrs.module.fhir2.api.search.SearchQueryInclude;
import org.openmrs.module.fhir2extension.api.FhirQuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.openmrs.api.AdministrationService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PACKAGE)
public class FhirQuestionnaireServiceImpl implements FhirQuestionnaireService {

	@Autowired
	private SearchQueryInclude<Questionnaire> searchQueryInclude;

	@Autowired
	@Qualifier("adminService")
	private AdministrationService administrationService;

	private String questionnairesFolder = administrationService.getGlobalProperty("fhir2extension.questionnaires.folder");

	@Override
	public Questionnaire get(@Nonnull String uuid) {
		return QuestionnaireFileUtils.getQuestionnaire(questionnairesFolder, uuid);
	}

	@Override
	public List<Questionnaire> get(@Nonnull Collection<String> collection) {
		return collection.stream().map(uuid -> QuestionnaireFileUtils.getQuestionnaire(questionnairesFolder, uuid)).collect(Collectors.toList());
	}

	@Override
	public IBundleProvider getQuestionnaireEverything() {
		return new SimpleBundleProvider(QuestionnaireFileUtils.getAllQuestionnaires(questionnairesFolder));
	}

	@Override
	public Questionnaire create(@Nonnull Questionnaire questionnaire) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Questionnaire update(@Nonnull String s, @Nonnull Questionnaire questionnaire) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Questionnaire patch(@Nonnull String s, @Nonnull PatchTypeEnum patchTypeEnum, @Nonnull String s1,
							   RequestDetails requestDetails) {

		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(@Nonnull String s) {
		throw new UnsupportedOperationException();
	}

}
