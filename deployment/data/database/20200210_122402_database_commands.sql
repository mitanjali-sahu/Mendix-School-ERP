ALTER TABLE "eventapplication$login" ALTER COLUMN "password" RENAME TO "login_password";
UPDATE "mendixsystem$attribute"
 SET "entity_id" = 'c9dcda51-c64f-43c9-a450-1b3d237d86a6', 
"attribute_name" = 'Login_Password', 
"column_name" = 'login_password', 
"type" = 30, 
"length" = 200, 
"default_value" = '', 
"is_auto_number" = false
 WHERE "id" = '57de0ae2-e599-41c3-a1b3-2bb06ef8c5b1';
ALTER TABLE "eventapplication$registrant" ADD "password" VARCHAR_IGNORECASE(200) NULL;
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('0e9e0b0a-cc21-4120-9d50-689692307c9f', 
'45b57eda-40c5-493b-9ddb-dc494b038731', 
'Password', 
'password', 
30, 
200, 
'', 
false);
CREATE TABLE "system$scheduledeventinformation_xasinstance" (
	"system$scheduledeventinformationid" BIGINT NOT NULL,
	"system$xasinstanceid" BIGINT NOT NULL,
	PRIMARY KEY("system$scheduledeventinformationid","system$xasinstanceid"),
	CONSTRAINT "uniq_system$scheduledeventinformation_xasinstance_system$scheduledeventinformationid" UNIQUE ("system$scheduledeventinformationid"));
CREATE INDEX "idx_system$scheduledeventinformation_xasinstance_system$xasinstance_system$scheduledeventinformation" ON "system$scheduledeventinformation_xasinstance" ("system$xasinstanceid" ASC,"system$scheduledeventinformationid" ASC);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name", 
"index_name")
 VALUES ('7b8a18de-fe6d-4735-9841-0d9d4760697e', 
'System.ScheduledEventInformation_XASInstance', 
'system$scheduledeventinformation_xasinstance', 
'685df5a6-1e02-49bb-a0b5-5a55c5e8313d', 
'd4154981-8dac-4150-aec5-efa3ef62a7a2', 
'system$scheduledeventinformationid', 
'system$xasinstanceid', 
'idx_system$scheduledeventinformation_xasinstance_system$xasinstance_system$scheduledeventinformation');
INSERT INTO "mendixsystem$unique_constraint" ("name", 
"table_id", 
"column_id")
 VALUES ('uniq_system$scheduledeventinformation_xasinstance_system$scheduledeventinformationid', 
'7b8a18de-fe6d-4735-9841-0d9d4760697e', 
'b1eb1dd4-9f4c-3dae-9cde-9a7df66af36c');
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20200210 12:24:02';
