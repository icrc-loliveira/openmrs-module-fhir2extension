/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.fhir2extension.api.dao.impl;

import static org.hibernate.criterion.Restrictions.*;

import javax.annotation.Nonnull;

import java.util.Collection;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.FormResource;
import org.openmrs.module.fhir2.api.dao.impl.BaseFhirDao;
import org.openmrs.module.fhir2extension.FhirConstants;
import org.openmrs.module.fhir2extension.api.dao.FhirQuestionnaireDao;
import org.openmrs.module.fhir2.api.search.param.SearchParameterMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Setter(AccessLevel.PACKAGE)
public class FhirQuestionnaireDaoImpl extends BaseFhirDao<FormResource> implements FhirQuestionnaireDao {
	
	@Autowired
	@Getter(AccessLevel.PUBLIC)
	@Setter(AccessLevel.PUBLIC)
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public FormResource getQuestionnaireById(@Nonnull Integer id) {
		return (FormResource) getSessionFactory().getCurrentSession().createCriteria(FormResource.class).add(eq("id", id))
		        .uniqueResult();
	}
	
	@Override
	public FormResource get(@Nonnull String uuid) {
		return (FormResource) getSessionFactory().getCurrentSession().createCriteria(FormResource.class)
		        .add(eq("uuid", uuid)).uniqueResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<FormResource> getQuestionnairesByIds(@Nonnull Collection<Integer> ids) {
		return getSessionFactory().getCurrentSession().createCriteria(FormResource.class).add(in("id", ids)).list();
	}
	
	@Override
	protected void setupSearchParams(Criteria criteria, SearchParameterMap theParams) {
		criteria.add(eq("name", FhirConstants.FHIR_QUESTIONNAIRE_TYPE));
	}
	
	@Override
	protected void handleRetireable(Criteria criteria) {
		criteria.createAlias("form", "f");
		criteria.add(Restrictions.eq("f.retired", false));
	}
	
}
