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

package com.liferay.commerce.discount.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.discount.model.CommerceDiscountRel;
import com.liferay.commerce.discount.service.CommerceDiscountRelLocalServiceUtil;

/**
 * The extended model base implementation for the CommerceDiscountRel service. Represents a row in the &quot;CommerceDiscountRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceDiscountRelImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CommerceDiscountRelImpl
 * @see CommerceDiscountRel
 * @generated
 */
@ProviderType
public abstract class CommerceDiscountRelBaseImpl
	extends CommerceDiscountRelModelImpl implements CommerceDiscountRel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce discount rel model instance should use the {@link CommerceDiscountRel} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CommerceDiscountRelLocalServiceUtil.addCommerceDiscountRel(this);
		}
		else {
			CommerceDiscountRelLocalServiceUtil.updateCommerceDiscountRel(this);
		}
	}
}