/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.product.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.product.exception.CPDefinitionMetaDescriptionException;
import com.liferay.commerce.product.exception.CPDefinitionMetaKeywordsException;
import com.liferay.commerce.product.exception.CPDefinitionMetaTitleException;
import com.liferay.commerce.product.model.CPAttachmentFileEntry;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CPDefinitionLocalization;
import com.liferay.commerce.product.model.CPDefinitionOptionRel;
import com.liferay.commerce.product.model.CPDefinitionSpecificationOptionValue;
import com.liferay.commerce.product.model.CPInstance;
import com.liferay.commerce.product.service.CPDefinitionLocalServiceUtil;
import com.liferay.commerce.product.service.CPDefinitionOptionRelLocalServiceUtil;
import com.liferay.commerce.product.service.CPDefinitionSpecificationOptionValueLocalServiceUtil;
import com.liferay.commerce.product.service.CPFriendlyURLEntryLocalServiceUtil;
import com.liferay.commerce.product.service.CPInstanceLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ModelHintsUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Marco Leo
 * @author Andrea Di Giorgi
 * @author Alessio Antonio Rendina
 */
@ProviderType
public class CPDefinitionImpl extends CPDefinitionBaseImpl {

	public static CPDefinitionMetaDescriptionException validateMetaDescription(
		String value) {

		return validateMetaDescription(value, true);
	}

	public static CPDefinitionMetaDescriptionException validateMetaDescription(
		String value, boolean checkMaxLength) {

		if (Validator.isNull(value)) {
			return null;
		}

		int maxLength = ModelHintsUtil.getMaxLength(
			CPDefinitionLocalization.class.getName(), "metaDescription");

		if (checkMaxLength && (value.length() > maxLength)) {
			return new CPDefinitionMetaDescriptionException();
		}

		return null;
	}

	public static CPDefinitionMetaKeywordsException validateMetaKeyword(
		String value) {

		return validateMetaKeyword(value, true);
	}

	public static CPDefinitionMetaKeywordsException validateMetaKeyword(
		String value, boolean checkMaxLength) {

		if (Validator.isNull(value)) {
			return null;
		}

		int maxLength = ModelHintsUtil.getMaxLength(
			CPDefinitionLocalization.class.getName(), "metaKeyword");

		if (checkMaxLength && (value.length() > maxLength)) {
			return new CPDefinitionMetaKeywordsException();
		}

		return null;
	}

	public static CPDefinitionMetaTitleException validateMetaTitle(
		String value) {

		return validateMetaTitle(value, true);
	}

	public static CPDefinitionMetaTitleException validateMetaTitle(
		String value, boolean checkMaxLength) {

		if (Validator.isNull(value)) {
			return null;
		}

		int maxLength = ModelHintsUtil.getMaxLength(
			CPDefinitionLocalization.class.getName(), "metaTitle");

		if (checkMaxLength && (value.length() > maxLength)) {
			return new CPDefinitionMetaTitleException();
		}

		return null;
	}

	public CPDefinitionImpl() {
	}

	@Override
	public Object clone() {
		CPDefinitionImpl cpDefinitionImpl = (CPDefinitionImpl)super.clone();

		cpDefinitionImpl.setDescriptionMap(getDescriptionMap());
		cpDefinitionImpl.setLayoutUuid(getLayoutUuid());
		cpDefinitionImpl.setNameMap(getNameMap());
		cpDefinitionImpl.setShortDescriptionMap(getShortDescriptionMap());
		cpDefinitionImpl.setUrlTitleMap(getUrlTitleMap());

		return cpDefinitionImpl;
	}

	@Override
	public boolean equals(Object object) {
		return super.equals(object);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<>();

		availableLanguageIds.addAll(
			CPDefinitionLocalServiceUtil.getCPDefinitionLocalizationLanguageIds(
				getCPDefinitionId()));

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public List<CPDefinitionOptionRel> getCPDefinitionOptionRels() {
		return CPDefinitionOptionRelLocalServiceUtil.getCPDefinitionOptionRels(
			getCPDefinitionId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	@Override
	public List<CPDefinitionSpecificationOptionValue>
		getCPDefinitionSpecificationOptionValues() {

		return CPDefinitionSpecificationOptionValueLocalServiceUtil.
			getCPDefinitionSpecificationOptionValues(
				getCPDefinitionId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null);
	}

	@Override
	public List<CPInstance> getCPInstances() {
		return CPInstanceLocalServiceUtil.getCPDefinitionInstances(
			getCPDefinitionId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	@Override
	public String getDefaultImageFileURL() throws PortalException {
		CPAttachmentFileEntry cpAttachmentFileEntry =
			CPDefinitionLocalServiceUtil.getDefaultImage(getCPDefinitionId());

		if (cpAttachmentFileEntry == null) {
			return null;
		}

		FileEntry fileEntry = cpAttachmentFileEntry.getFileEntry();

		return DLUtil.getDownloadURL(
			fileEntry, fileEntry.getFileVersion(), null, null);
	}

	@Override
	public String getDefaultImageThumbnailSrc(ThemeDisplay themeDisplay)
		throws Exception {

		CPAttachmentFileEntry cpAttachmentFileEntry =
			CPDefinitionLocalServiceUtil.getDefaultImage(getCPDefinitionId());

		if (cpAttachmentFileEntry == null) {
			return null;
		}

		FileEntry fileEntry = cpAttachmentFileEntry.getFileEntry();

		if (fileEntry == null) {
			return null;
		}

		return DLUtil.getThumbnailSrc(fileEntry, themeDisplay);
	}

	@Override
	public Map<Locale, String> getDescriptionMap() {
		if (_descriptionMap != null) {
			return _descriptionMap;
		}

		_descriptionMap =
			CPDefinitionLocalServiceUtil.getCPDefinitionDescriptionMap(
				getCPDefinitionId());

		return _descriptionMap;
	}

	@Override
	public String getLayoutUuid() {
		if (Validator.isNotNull(_layoutUuid)) {
			return _layoutUuid;
		}

		_layoutUuid = CPDefinitionLocalServiceUtil.getLayoutUuid(
			getCPDefinitionId());

		return _layoutUuid;
	}

	@Override
	public Map<Locale, String> getMetaDescriptionMap() {
		if (_metaDescriptionMap != null) {
			return _metaDescriptionMap;
		}

		_metaDescriptionMap =
			CPDefinitionLocalServiceUtil.getCPDefinitionMetaDescriptionMap(
				getCPDefinitionId());

		return _metaDescriptionMap;
	}

	@Override
	public Map<Locale, String> getMetaKeywordsMap() {
		if (_metaKeywordsMap != null) {
			return _metaKeywordsMap;
		}

		_metaKeywordsMap =
			CPDefinitionLocalServiceUtil.getCPDefinitionMetaKeywordsMap(
				getCPDefinitionId());

		return _metaKeywordsMap;
	}

	@Override
	public Map<Locale, String> getMetaTitleMap() {
		if (_metaTitleMap != null) {
			return _metaTitleMap;
		}

		_metaTitleMap =
			CPDefinitionLocalServiceUtil.getCPDefinitionMetaTitleMap(
				getCPDefinitionId());

		return _metaTitleMap;
	}

	@Override
	public String getNameCurrentValue() {
		Locale locale = LocaleThreadLocal.getThemeDisplayLocale();

		return getName(LocaleUtil.toLanguageId(locale), true);
	}

	@Override
	public Map<Locale, String> getNameMap() {
		if (_nameMap != null) {
			return _nameMap;
		}

		_nameMap = CPDefinitionLocalServiceUtil.getCPDefinitionNameMap(
			getCPDefinitionId());

		return _nameMap;
	}

	@Override
	public Map<Locale, String> getShortDescriptionMap() {
		if (_shortDescriptionMap != null) {
			return _shortDescriptionMap;
		}

		_shortDescriptionMap =
			CPDefinitionLocalServiceUtil.getCPDefinitionShortDescriptionMap(
				getCPDefinitionId());

		return _shortDescriptionMap;
	}

	@Override
	public String getURL(String languageId) {
		long classNameId = PortalUtil.getClassNameId(CPDefinition.class);

		Map<String, String> languageIdToUrlTitleMap =
			CPFriendlyURLEntryLocalServiceUtil.getLanguageIdToUrlTitleMap(
				getGroupId(), classNameId, getCPDefinitionId());

		return languageIdToUrlTitleMap.get(languageId);
	}

	@Override
	public Map<Locale, String> getUrlTitleMap() {
		if (_urlTitleMap != null) {
			return _urlTitleMap;
		}

		_urlTitleMap = CPDefinitionLocalServiceUtil.getUrlTitleMap(
			getCPDefinitionId());

		return _urlTitleMap;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		_descriptionMap = descriptionMap;
	}

	@Override
	public void setLayoutUuid(String layoutUuid) {
		_layoutUuid = layoutUuid;
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap) {
		_nameMap = nameMap;
	}

	@Override
	public void setShortDescriptionMap(
		Map<Locale, String> shortDescriptionMap) {

		_shortDescriptionMap = shortDescriptionMap;
	}

	@Override
	public void setUrlTitleMap(Map<Locale, String> urlTitleMap) {
		_urlTitleMap = urlTitleMap;
	}

	private Map<Locale, String> _descriptionMap;
	private String _layoutUuid;
	private Map<Locale, String> _metaDescriptionMap;
	private Map<Locale, String> _metaKeywordsMap;
	private Map<Locale, String> _metaTitleMap;
	private Map<Locale, String> _nameMap;
	private Map<Locale, String> _shortDescriptionMap;
	private Map<Locale, String> _urlTitleMap;

}