create table CPDefinitionVirtualSetting (
	uuid_ VARCHAR(75) null,
	CPDefinitionVirtualSettingId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	CPDefinitionId LONG,
	fileEntryId LONG,
	url VARCHAR(75) null,
	activationStatus INTEGER,
	duration LONG,
	maxUsages INTEGER,
	useSample BOOLEAN,
	sampleFileEntryId LONG,
	sampleUrl VARCHAR(75) null,
	termsOfUseRequired BOOLEAN,
	termsOfUseContent STRING null,
	termsOfUseArticleResourcePK LONG,
	lastPublishDate DATE null
);