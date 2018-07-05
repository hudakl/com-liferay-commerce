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

import com.liferay.commerce.product.model.CPDefinitionLocalization;
import com.liferay.commerce.product.model.CPDefinitionLocalizationModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the CPDefinitionLocalization service. Represents a row in the &quot;CPDefinitionLocalization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CPDefinitionLocalizationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CPDefinitionLocalizationImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CPDefinitionLocalizationImpl
 * @see CPDefinitionLocalization
 * @see CPDefinitionLocalizationModel
 * @generated
 */
@ProviderType
public class CPDefinitionLocalizationModelImpl extends BaseModelImpl<CPDefinitionLocalization>
	implements CPDefinitionLocalizationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cp definition localization model instance should use the {@link CPDefinitionLocalization} interface instead.
	 */
	public static final String TABLE_NAME = "CPDefinitionLocalization";
	public static final Object[][] TABLE_COLUMNS = {
			{ "mvccVersion", Types.BIGINT },
			{ "cpDefinitionLocalizationId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "CPDefinitionId", Types.BIGINT },
			{ "languageId", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "shortDescription", Types.VARCHAR },
			{ "description", Types.CLOB },
			{ "metaTitle", Types.VARCHAR },
			{ "metaDescription", Types.VARCHAR },
			{ "metaKeywords", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("cpDefinitionLocalizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CPDefinitionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("languageId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("shortDescription", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.CLOB);
		TABLE_COLUMNS_MAP.put("metaTitle", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("metaDescription", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("metaKeywords", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table CPDefinitionLocalization (mvccVersion LONG default 0 not null,cpDefinitionLocalizationId LONG not null primary key,companyId LONG,CPDefinitionId LONG,languageId VARCHAR(75) null,name STRING null,shortDescription STRING null,description TEXT null,metaTitle VARCHAR(255) null,metaDescription VARCHAR(255) null,metaKeywords VARCHAR(255) null)";
	public static final String TABLE_SQL_DROP = "drop table CPDefinitionLocalization";
	public static final String ORDER_BY_JPQL = " ORDER BY cpDefinitionLocalization.cpDefinitionLocalizationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CPDefinitionLocalization.cpDefinitionLocalizationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.product.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.commerce.product.model.CPDefinitionLocalization"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.product.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.commerce.product.model.CPDefinitionLocalization"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.product.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.commerce.product.model.CPDefinitionLocalization"),
			true);
	public static final long CPDEFINITIONID_COLUMN_BITMASK = 1L;
	public static final long LANGUAGEID_COLUMN_BITMASK = 2L;
	public static final long CPDEFINITIONLOCALIZATIONID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.commerce.product.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.commerce.product.model.CPDefinitionLocalization"));

	public CPDefinitionLocalizationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _cpDefinitionLocalizationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCpDefinitionLocalizationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cpDefinitionLocalizationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CPDefinitionLocalization.class;
	}

	@Override
	public String getModelClassName() {
		return CPDefinitionLocalization.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("cpDefinitionLocalizationId",
			getCpDefinitionLocalizationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("CPDefinitionId", getCPDefinitionId());
		attributes.put("languageId", getLanguageId());
		attributes.put("name", getName());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("description", getDescription());
		attributes.put("metaTitle", getMetaTitle());
		attributes.put("metaDescription", getMetaDescription());
		attributes.put("metaKeywords", getMetaKeywords());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long cpDefinitionLocalizationId = (Long)attributes.get(
				"cpDefinitionLocalizationId");

		if (cpDefinitionLocalizationId != null) {
			setCpDefinitionLocalizationId(cpDefinitionLocalizationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long CPDefinitionId = (Long)attributes.get("CPDefinitionId");

		if (CPDefinitionId != null) {
			setCPDefinitionId(CPDefinitionId);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String shortDescription = (String)attributes.get("shortDescription");

		if (shortDescription != null) {
			setShortDescription(shortDescription);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String metaTitle = (String)attributes.get("metaTitle");

		if (metaTitle != null) {
			setMetaTitle(metaTitle);
		}

		String metaDescription = (String)attributes.get("metaDescription");

		if (metaDescription != null) {
			setMetaDescription(metaDescription);
		}

		String metaKeywords = (String)attributes.get("metaKeywords");

		if (metaKeywords != null) {
			setMetaKeywords(metaKeywords);
		}
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@Override
	public long getCpDefinitionLocalizationId() {
		return _cpDefinitionLocalizationId;
	}

	@Override
	public void setCpDefinitionLocalizationId(long cpDefinitionLocalizationId) {
		_cpDefinitionLocalizationId = cpDefinitionLocalizationId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getCPDefinitionId() {
		return _CPDefinitionId;
	}

	@Override
	public void setCPDefinitionId(long CPDefinitionId) {
		_columnBitmask |= CPDEFINITIONID_COLUMN_BITMASK;

		if (!_setOriginalCPDefinitionId) {
			_setOriginalCPDefinitionId = true;

			_originalCPDefinitionId = _CPDefinitionId;
		}

		_CPDefinitionId = CPDefinitionId;
	}

	public long getOriginalCPDefinitionId() {
		return _originalCPDefinitionId;
	}

	@Override
	public String getLanguageId() {
		if (_languageId == null) {
			return "";
		}
		else {
			return _languageId;
		}
	}

	@Override
	public void setLanguageId(String languageId) {
		_columnBitmask |= LANGUAGEID_COLUMN_BITMASK;

		if (_originalLanguageId == null) {
			_originalLanguageId = _languageId;
		}

		_languageId = languageId;
	}

	public String getOriginalLanguageId() {
		return GetterUtil.getString(_originalLanguageId);
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public String getShortDescription() {
		if (_shortDescription == null) {
			return "";
		}
		else {
			return _shortDescription;
		}
	}

	@Override
	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public String getMetaTitle() {
		if (_metaTitle == null) {
			return "";
		}
		else {
			return _metaTitle;
		}
	}

	@Override
	public void setMetaTitle(String metaTitle) {
		_metaTitle = metaTitle;
	}

	@Override
	public String getMetaDescription() {
		if (_metaDescription == null) {
			return "";
		}
		else {
			return _metaDescription;
		}
	}

	@Override
	public void setMetaDescription(String metaDescription) {
		_metaDescription = metaDescription;
	}

	@Override
	public String getMetaKeywords() {
		if (_metaKeywords == null) {
			return "";
		}
		else {
			return _metaKeywords;
		}
	}

	@Override
	public void setMetaKeywords(String metaKeywords) {
		_metaKeywords = metaKeywords;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CPDefinitionLocalization.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CPDefinitionLocalization toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CPDefinitionLocalization)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CPDefinitionLocalizationImpl cpDefinitionLocalizationImpl = new CPDefinitionLocalizationImpl();

		cpDefinitionLocalizationImpl.setMvccVersion(getMvccVersion());
		cpDefinitionLocalizationImpl.setCpDefinitionLocalizationId(getCpDefinitionLocalizationId());
		cpDefinitionLocalizationImpl.setCompanyId(getCompanyId());
		cpDefinitionLocalizationImpl.setCPDefinitionId(getCPDefinitionId());
		cpDefinitionLocalizationImpl.setLanguageId(getLanguageId());
		cpDefinitionLocalizationImpl.setName(getName());
		cpDefinitionLocalizationImpl.setShortDescription(getShortDescription());
		cpDefinitionLocalizationImpl.setDescription(getDescription());
		cpDefinitionLocalizationImpl.setMetaTitle(getMetaTitle());
		cpDefinitionLocalizationImpl.setMetaDescription(getMetaDescription());
		cpDefinitionLocalizationImpl.setMetaKeywords(getMetaKeywords());

		cpDefinitionLocalizationImpl.resetOriginalValues();

		return cpDefinitionLocalizationImpl;
	}

	@Override
	public int compareTo(CPDefinitionLocalization cpDefinitionLocalization) {
		long primaryKey = cpDefinitionLocalization.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CPDefinitionLocalization)) {
			return false;
		}

		CPDefinitionLocalization cpDefinitionLocalization = (CPDefinitionLocalization)obj;

		long primaryKey = cpDefinitionLocalization.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CPDefinitionLocalizationModelImpl cpDefinitionLocalizationModelImpl = this;

		cpDefinitionLocalizationModelImpl._originalCPDefinitionId = cpDefinitionLocalizationModelImpl._CPDefinitionId;

		cpDefinitionLocalizationModelImpl._setOriginalCPDefinitionId = false;

		cpDefinitionLocalizationModelImpl._originalLanguageId = cpDefinitionLocalizationModelImpl._languageId;

		cpDefinitionLocalizationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CPDefinitionLocalization> toCacheModel() {
		CPDefinitionLocalizationCacheModel cpDefinitionLocalizationCacheModel = new CPDefinitionLocalizationCacheModel();

		cpDefinitionLocalizationCacheModel.mvccVersion = getMvccVersion();

		cpDefinitionLocalizationCacheModel.cpDefinitionLocalizationId = getCpDefinitionLocalizationId();

		cpDefinitionLocalizationCacheModel.companyId = getCompanyId();

		cpDefinitionLocalizationCacheModel.CPDefinitionId = getCPDefinitionId();

		cpDefinitionLocalizationCacheModel.languageId = getLanguageId();

		String languageId = cpDefinitionLocalizationCacheModel.languageId;

		if ((languageId != null) && (languageId.length() == 0)) {
			cpDefinitionLocalizationCacheModel.languageId = null;
		}

		cpDefinitionLocalizationCacheModel.name = getName();

		String name = cpDefinitionLocalizationCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			cpDefinitionLocalizationCacheModel.name = null;
		}

		cpDefinitionLocalizationCacheModel.shortDescription = getShortDescription();

		String shortDescription = cpDefinitionLocalizationCacheModel.shortDescription;

		if ((shortDescription != null) && (shortDescription.length() == 0)) {
			cpDefinitionLocalizationCacheModel.shortDescription = null;
		}

		cpDefinitionLocalizationCacheModel.description = getDescription();

		String description = cpDefinitionLocalizationCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			cpDefinitionLocalizationCacheModel.description = null;
		}

		cpDefinitionLocalizationCacheModel.metaTitle = getMetaTitle();

		String metaTitle = cpDefinitionLocalizationCacheModel.metaTitle;

		if ((metaTitle != null) && (metaTitle.length() == 0)) {
			cpDefinitionLocalizationCacheModel.metaTitle = null;
		}

		cpDefinitionLocalizationCacheModel.metaDescription = getMetaDescription();

		String metaDescription = cpDefinitionLocalizationCacheModel.metaDescription;

		if ((metaDescription != null) && (metaDescription.length() == 0)) {
			cpDefinitionLocalizationCacheModel.metaDescription = null;
		}

		cpDefinitionLocalizationCacheModel.metaKeywords = getMetaKeywords();

		String metaKeywords = cpDefinitionLocalizationCacheModel.metaKeywords;

		if ((metaKeywords != null) && (metaKeywords.length() == 0)) {
			cpDefinitionLocalizationCacheModel.metaKeywords = null;
		}

		return cpDefinitionLocalizationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{mvccVersion=");
		sb.append(getMvccVersion());
		sb.append(", cpDefinitionLocalizationId=");
		sb.append(getCpDefinitionLocalizationId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", CPDefinitionId=");
		sb.append(getCPDefinitionId());
		sb.append(", languageId=");
		sb.append(getLanguageId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", shortDescription=");
		sb.append(getShortDescription());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", metaTitle=");
		sb.append(getMetaTitle());
		sb.append(", metaDescription=");
		sb.append(getMetaDescription());
		sb.append(", metaKeywords=");
		sb.append(getMetaKeywords());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.liferay.commerce.product.model.CPDefinitionLocalization");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mvccVersion</column-name><column-value><![CDATA[");
		sb.append(getMvccVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cpDefinitionLocalizationId</column-name><column-value><![CDATA[");
		sb.append(getCpDefinitionLocalizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CPDefinitionId</column-name><column-value><![CDATA[");
		sb.append(getCPDefinitionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageId</column-name><column-value><![CDATA[");
		sb.append(getLanguageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortDescription</column-name><column-value><![CDATA[");
		sb.append(getShortDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metaTitle</column-name><column-value><![CDATA[");
		sb.append(getMetaTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metaDescription</column-name><column-value><![CDATA[");
		sb.append(getMetaDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metaKeywords</column-name><column-value><![CDATA[");
		sb.append(getMetaKeywords());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CPDefinitionLocalization.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CPDefinitionLocalization.class, ModelWrapper.class
		};
	private long _mvccVersion;
	private long _cpDefinitionLocalizationId;
	private long _companyId;
	private long _CPDefinitionId;
	private long _originalCPDefinitionId;
	private boolean _setOriginalCPDefinitionId;
	private String _languageId;
	private String _originalLanguageId;
	private String _name;
	private String _shortDescription;
	private String _description;
	private String _metaTitle;
	private String _metaDescription;
	private String _metaKeywords;
	private long _columnBitmask;
	private CPDefinitionLocalization _escapedModel;
}