<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
CommerceCartContentMiniDisplayContext commerceCartContentMiniDisplayContext = (CommerceCartContentMiniDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

Map<String, Object> contextObjects = new HashMap<>();

contextObjects.put("commerceCartContentMiniDisplayContext", commerceCartContentMiniDisplayContext);

CommerceOrderPrice commerceOrderPrice = commerceCartContentMiniDisplayContext.getCommerceOrderPrice();

CommerceMoney subtotal = commerceOrderPrice.getSubtotal();
CommerceDiscountValue subtotalDiscountValue = commerceOrderPrice.getSubtotalDiscountValue();
CommerceMoney taxValue = commerceOrderPrice.getTaxValue();
CommerceDiscountValue totalDiscountValue = commerceOrderPrice.getTotalDiscountValue();
CommerceMoney totalOrder = commerceOrderPrice.getTotal();

SearchContainer<CommerceOrderItem> commerceOrderItemSearchContainer = commerceCartContentMiniDisplayContext.getSearchContainer();

PortletURL portletURL = commerceCartContentMiniDisplayContext.getPortletURL();

portletURL.setParameter("searchContainerId", "commerceOrderItems");

request.setAttribute("view.jsp-portletURL", portletURL);
%>

<liferay-ddm:template-renderer
	className="<%= CommerceCartContentMiniPortlet.class.getName() %>"
	contextObjects="<%= contextObjects %>"
	displayStyle="<%= commerceCartContentMiniDisplayContext.getDisplayStyle() %>"
	displayStyleGroupId="<%= commerceCartContentMiniDisplayContext.getDisplayStyleGroupId() %>"
	entries="<%= commerceOrderItemSearchContainer.getResults() %>"
>
	<ul class="commerce-order-items-header">
		<li class="autofit-row">
			<div class="autofit-col autofit-col-expand">
				<h4 class="commerce-title">
					<liferay-ui:message arguments="<%= commerceCartContentMiniDisplayContext.getCommerceOrderItemsQuantity() %>" key="items-x" translateArguments="<%= false %>" />
				</h4>
			</div>

			<div class="autofit-col">
				<liferay-commerce:order-transitions
					commerceOrderId="<%= commerceCartContentMiniDisplayContext.getCommerceOrderId() %>"
					cssClass="btn commerce-btn"
				/>
			</div>

			<div class="autofit-col">
				<div><a class="btn commerce-btn" href="<%= commerceCartContentMiniDisplayContext.getCommerceCartPortletURL() %>"><liferay-ui:message key="edit-cart" /></a></div>
			</div>
		</li>
	</ul>

	<div class="commerce-order-items-body" id="<portlet:namespace />entriesContainer">
		<liferay-ui:search-container
			cssClass="list-group-flush"
			id="commerceOrderItems"
			iteratorURL="<%= portletURL %>"
			searchContainer="<%= commerceOrderItemSearchContainer %>"
		>
			<liferay-ui:search-container-row
				className="com.liferay.commerce.model.CommerceOrderItem"
				cssClass="entry-display-style"
				keyProperty="CommerceOrderItemId"
				modelVar="commerceOrderItem"
			>

				<%
				CPDefinition cpDefinition = commerceOrderItem.getCPDefinition();

				String thumbnailSrc = commerceCartContentMiniDisplayContext.getCommerceOrderItemThumbnailSrc(commerceOrderItem, themeDisplay);
				%>

				<liferay-ui:search-container-column-image
					cssClass="thumbnail-section"
					src="<%= thumbnailSrc %>"
				/>

				<liferay-ui:search-container-column-text
					cssClass="autofit-col-expand"
				>
					<div class="description-section">
						<div class="list-group-text">Brand</div>

						<div class="list-group-title">
							<a href="<%= commerceCartContentMiniDisplayContext.getCPDefinitionURL(cpDefinition.getCPDefinitionId(), themeDisplay) %>">
								<%= HtmlUtil.escape(cpDefinition.getName(languageId)) %>
							</a>
						</div>

						<%
						List<KeyValuePair> keyValuePairs = commerceCartContentMiniDisplayContext.getKeyValuePairs(commerceOrderItem.getJson(), locale);

						StringJoiner stringJoiner = new StringJoiner(StringPool.COMMA);

						for (KeyValuePair keyValuePair : keyValuePairs) {
							stringJoiner.add(keyValuePair.getValue());
						}
						%>

						<div class="list-group-subtitle">SKU: <%= HtmlUtil.escape(commerceOrderItem.getSku()) %></div>
						<div class="list-group-subtitle"><%= HtmlUtil.escape(stringJoiner.toString()) %></div>
					</div>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text>
					<div class="quantity-section">
						<span class="commerce-quantity"><%= commerceOrderItem.getQuantity() %></span><span class="inline-item-after">x</span>
					</div>
				</liferay-ui:search-container-column-text>

				<%
				CommerceMoney finalPriceMoney = commerceOrderItem.getFinalPriceMoney();
				%>

				<liferay-ui:search-container-column-text
					value="<%= finalPriceMoney.format(locale) %>"
				/>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator
				displayStyle="descriptive"
				markupView="lexicon"
				paginate="<%= false %>"
				searchContainer="<%= commerceOrderItemSearchContainer %>"
			/>
		</liferay-ui:search-container>
	</div>

	<ul class="commerce-order-items-footer">
		<li class="autofit-row commerce-tax">
			<div class="autofit-col autofit-col-expand">
				<div class="commerce-description"><liferay-ui:message key="subtotal" /></div>
			</div>

			<div class="autofit-col">
				<div class="commerce-value"><%= HtmlUtil.escape(subtotal.format(locale)) %></div>
			</div>

			<c:if test="<%= subtotalDiscountValue != null %>">

				<%
				CommerceMoney subtotalDiscountAmount = subtotalDiscountValue.getDiscountAmount();
				%>

				<div class="autofit-col autofit-col-expand">
					<div class="commerce-description"><liferay-ui:message key="subtotal-discount" /></div>
				</div>

				<div class="commerce-value">
					<%= HtmlUtil.escape(subtotalDiscountAmount.format(locale)) %>
				</div>

				<div class="commerce-value">
					<%= HtmlUtil.escape(commerceCartContentMiniDisplayContext.getFormattedPercentage(subtotalDiscountValue.getDiscountPercentage())) %>
				</div>
			</c:if>
		</li>
		<li class="autofit-row commerce-tax">
			<div class="autofit-col autofit-col-expand">
				<div class="commerce-description"><liferay-ui:message key="tax" /></div>
			</div>

			<div class="autofit-col">
				<div class="commerce-value"><%= HtmlUtil.escape(taxValue.format(locale)) %></div>
			</div>
		</li>
		<li class="autofit-row commerce-total">
			<c:if test="<%= totalDiscountValue != null %>">

				<%
				CommerceMoney totalDiscountAmount = totalDiscountValue.getDiscountAmount();
				%>

				<div class="autofit-col autofit-col-expand">
					<div class="commerce-description"><liferay-ui:message key="total-discount" /></div>
				</div>

				<div class="commerce-value">
					<%= HtmlUtil.escape(totalDiscountAmount.format(locale)) %>
				</div>

				<div class="commerce-value">
					<%= HtmlUtil.escape(commerceCartContentMiniDisplayContext.getFormattedPercentage(totalDiscountValue.getDiscountPercentage())) %>
				</div>
			</c:if>

			<div class="autofit-col autofit-col-expand">
				<div class="commerce-description"><liferay-ui:message key="total" /></div>
			</div>

			<div class="autofit-col">
				<div class="commerce-value"><%= HtmlUtil.escape(totalOrder.format(locale)) %></div>
			</div>
		</li>
	</ul>

	<%@ include file="/cart_mini/transition.jspf" %>

	<aui:script use="aui-base">
		var orderTransition = A.one('#<portlet:namespace />orderTransition');

		if (orderTransition) {
			orderTransition.delegate(
				'click',
				function(event) {
					<portlet:namespace />transition(event);
				},
				'.transition-link'
			);
		}
	</aui:script>
</liferay-ddm:template-renderer>