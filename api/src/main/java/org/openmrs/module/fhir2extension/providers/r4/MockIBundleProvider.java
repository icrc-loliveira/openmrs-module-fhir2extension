/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.fhir2extension.providers.r4;

import javax.annotation.Nonnull;

import java.util.Date;
import java.util.List;

import ca.uhn.fhir.rest.api.server.IBundleProvider;
import lombok.Getter;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.instance.model.api.IPrimitiveType;
import org.hl7.fhir.r4.model.InstantType;
import org.openmrs.module.fhir2.api.util.FhirUtils;

public class MockIBundleProvider<U extends IBaseResource> implements IBundleProvider {
	
	private final Date datePublished;
	
	private final List<U> mockResultList;
	
	@Getter
	private final String uuid;
	
	private final Integer size;
	
	private final Integer preferredPageSize;
	
	public MockIBundleProvider(List<U> mockResultList, Integer preferredPageSize, Integer count) {
		this.size = count;
		this.uuid = FhirUtils.newUuid();
		this.datePublished = new Date();
		this.mockResultList = mockResultList;
		this.preferredPageSize = preferredPageSize;
	}
	
	@Override
	public IPrimitiveType<Date> getPublished() {
		return new InstantType(datePublished);
	}
	
	@Nonnull
	@Override
	@SuppressWarnings("unchecked")
	public List<IBaseResource> getResources(int i, int i1) {
		return (List<IBaseResource>) this.mockResultList;
	}
	
	public Integer preferredPageSize() {
		return preferredPageSize;
	}
	
	public Integer size() {
		return size;
	}
}
