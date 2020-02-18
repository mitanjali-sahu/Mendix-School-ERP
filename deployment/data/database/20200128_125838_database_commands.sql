DROP INDEX "idx_eventapplication$result_id_system$changedby";
DROP INDEX "idx_eventapplication$result_id_system$owner";
ALTER TABLE "eventapplication$result_id" RENAME TO "f091495f3d0c4a42b257a9f3e94437b2";
DELETE FROM "mendixsystem$entity" 
 WHERE "id" = '5d274f37-bc54-484e-9aee-662e25221343';
DELETE FROM "mendixsystem$entityidentifier" 
 WHERE "id" = '5d274f37-bc54-484e-9aee-662e25221343';
DELETE FROM "mendixsystem$sequence" 
 WHERE "attribute_id" IN (SELECT "id"
 FROM "mendixsystem$attribute"
 WHERE "entity_id" = '5d274f37-bc54-484e-9aee-662e25221343');
DELETE FROM "mendixsystem$attribute" 
 WHERE "entity_id" = '5d274f37-bc54-484e-9aee-662e25221343';
DELETE FROM "mendixsystem$index" 
 WHERE "table_id" = '5d274f37-bc54-484e-9aee-662e25221343';
DELETE FROM "mendixsystem$index_column" 
 WHERE "index_id" IN ('969678f5-9850-33ab-b9cd-671ef5842364', 'b2dba094-ae9c-39e9-8c50-2c800e16d047');
DELETE FROM "mendixsystem$association" 
 WHERE "id" = '047428fb-74c9-3538-b052-4413236ba258';
DELETE FROM "mendixsystem$association" 
 WHERE "id" = 'e6c1a29f-3725-323b-9022-dffe77a88a5a';
CREATE TABLE "eventapplication$holiday" (
	"id" BIGINT NOT NULL,
	"changeddate" TIMESTAMP NULL,
	"createddate" TIMESTAMP NULL,
	"occasion" VARCHAR_IGNORECASE(2147483647) NULL,
	"day" VARCHAR_IGNORECASE(2147483647) NULL,
	"date" TIMESTAMP NULL,
	"system$owner" BIGINT NULL,
	"system$changedby" BIGINT NULL,
	PRIMARY KEY("id"));
CREATE INDEX "idx_eventapplication$holiday_system$owner" ON "eventapplication$holiday" ("system$owner" ASC,"id" ASC);
CREATE INDEX "idx_eventapplication$holiday_system$changedby" ON "eventapplication$holiday" ("system$changedby" ASC,"id" ASC);
INSERT INTO "mendixsystem$entity" ("id", 
"entity_name", 
"table_name")
 VALUES ('58affdc8-e065-4bbb-b844-54a22f26bbc4', 
'EventApplication.Holiday', 
'eventapplication$holiday');
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('d3a795c4-61f0-37b6-b648-c5cd06dde384', 
'58affdc8-e065-4bbb-b844-54a22f26bbc4', 
'changedDate', 
'changeddate', 
20, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('f6eb41b7-979e-3499-849f-256ab91c0414', 
'58affdc8-e065-4bbb-b844-54a22f26bbc4', 
'createdDate', 
'createddate', 
20, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('31cf4a13-ffcc-4c1e-9f01-7da29e1cf006', 
'58affdc8-e065-4bbb-b844-54a22f26bbc4', 
'Occasion', 
'occasion', 
30, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('e91cbbc9-e84b-4ddf-9386-0178491f1722', 
'58affdc8-e065-4bbb-b844-54a22f26bbc4', 
'Day', 
'day', 
30, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('f79c3eb8-62b2-488f-8f51-8ae13a99da37', 
'58affdc8-e065-4bbb-b844-54a22f26bbc4', 
'Date', 
'date', 
20, 
0, 
'', 
false);
INSERT INTO "mendixsystem$index" ("id", 
"table_id", 
"index_name")
 VALUES ('ac4a7ae6-2f80-34f1-acb5-b1bdb8b5b474', 
'58affdc8-e065-4bbb-b844-54a22f26bbc4', 
'idx_eventapplication$holiday_system$owner');
INSERT INTO "mendixsystem$index_column" ("index_id", 
"column_id", 
"sort_order", 
"ordinal")
 VALUES ('ac4a7ae6-2f80-34f1-acb5-b1bdb8b5b474', 
'e8693f43-f35a-37a0-b815-e1c5021eb8bc', 
false, 
0);
INSERT INTO "mendixsystem$index" ("id", 
"table_id", 
"index_name")
 VALUES ('ca5d5859-f640-3c24-a1b6-8fb5df6f8946', 
'58affdc8-e065-4bbb-b844-54a22f26bbc4', 
'idx_eventapplication$holiday_system$changedby');
INSERT INTO "mendixsystem$index_column" ("index_id", 
"column_id", 
"sort_order", 
"ordinal")
 VALUES ('ca5d5859-f640-3c24-a1b6-8fb5df6f8946', 
'4e835db2-a15e-3979-9ad9-97f39f908e78', 
false, 
0);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name")
 VALUES ('e8693f43-f35a-37a0-b815-e1c5021eb8bc', 
'System.owner', 
'system$owner', 
'58affdc8-e065-4bbb-b844-54a22f26bbc4', 
'282e2e60-88a5-469d-84a5-ba8d9151644f', 
'id', 
'system$owner');
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name")
 VALUES ('4e835db2-a15e-3979-9ad9-97f39f908e78', 
'System.changedBy', 
'system$changedby', 
'58affdc8-e065-4bbb-b844-54a22f26bbc4', 
'282e2e60-88a5-469d-84a5-ba8d9151644f', 
'id', 
'system$changedby');
CREATE TABLE "eventapplication$staff" (
	"id" BIGINT NOT NULL,
	"full_name" VARCHAR_IGNORECASE(2147483647) NULL,
	"changeddate" TIMESTAMP NULL,
	"description" VARCHAR_IGNORECASE(2147483647) NULL,
	"email" VARCHAR_IGNORECASE(2147483647) NULL,
	"createddate" TIMESTAMP NULL,
	"phone" BIGINT NULL,
	"subject" VARCHAR_IGNORECASE(2147483647) NULL,
	"system$owner" BIGINT NULL,
	"system$changedby" BIGINT NULL,
	PRIMARY KEY("id"));
CREATE INDEX "idx_eventapplication$staff_system$owner" ON "eventapplication$staff" ("system$owner" ASC,"id" ASC);
CREATE INDEX "idx_eventapplication$staff_system$changedby" ON "eventapplication$staff" ("system$changedby" ASC,"id" ASC);
INSERT INTO "mendixsystem$entity" ("id", 
"entity_name", 
"table_name")
 VALUES ('a6c3cecd-a9ba-43ae-a34d-8ba35a961683', 
'EventApplication.Staff', 
'eventapplication$staff');
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('33868e81-8da3-4356-83f8-f57f3d3db56b', 
'a6c3cecd-a9ba-43ae-a34d-8ba35a961683', 
'Full_Name', 
'full_name', 
30, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('5c9b9380-7530-37ad-a6f8-4a2a4a3908c1', 
'a6c3cecd-a9ba-43ae-a34d-8ba35a961683', 
'changedDate', 
'changeddate', 
20, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('053dfdc2-4572-4f2c-aff7-6fb3b201f944', 
'a6c3cecd-a9ba-43ae-a34d-8ba35a961683', 
'Description', 
'description', 
30, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('9ceedab0-ff7b-471c-8d51-2dc7d77b1c49', 
'a6c3cecd-a9ba-43ae-a34d-8ba35a961683', 
'Email', 
'email', 
30, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('d900b9f4-fc0c-371e-bbea-e37325601b81', 
'a6c3cecd-a9ba-43ae-a34d-8ba35a961683', 
'createdDate', 
'createddate', 
20, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('3e9c337f-47f3-440b-8dc9-02eaa4426f6e', 
'a6c3cecd-a9ba-43ae-a34d-8ba35a961683', 
'Phone', 
'phone', 
4, 
0, 
'0', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('3de80729-81c9-4578-a3e4-1ed64fc90138', 
'a6c3cecd-a9ba-43ae-a34d-8ba35a961683', 
'Subject', 
'subject', 
30, 
0, 
'', 
false);
INSERT INTO "mendixsystem$index" ("id", 
"table_id", 
"index_name")
 VALUES ('ff50c656-2d00-3f3d-8a55-cad9a2f48855', 
'a6c3cecd-a9ba-43ae-a34d-8ba35a961683', 
'idx_eventapplication$staff_system$owner');
INSERT INTO "mendixsystem$index_column" ("index_id", 
"column_id", 
"sort_order", 
"ordinal")
 VALUES ('ff50c656-2d00-3f3d-8a55-cad9a2f48855', 
'9a8bea83-18b5-3635-97f3-6b54150c6795', 
false, 
0);
INSERT INTO "mendixsystem$index" ("id", 
"table_id", 
"index_name")
 VALUES ('713c4426-d866-3c6f-8e7b-3e0add5516f4', 
'a6c3cecd-a9ba-43ae-a34d-8ba35a961683', 
'idx_eventapplication$staff_system$changedby');
INSERT INTO "mendixsystem$index_column" ("index_id", 
"column_id", 
"sort_order", 
"ordinal")
 VALUES ('713c4426-d866-3c6f-8e7b-3e0add5516f4', 
'9728abcf-b0b8-34bd-8fee-9994c287ccc0', 
false, 
0);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name")
 VALUES ('9a8bea83-18b5-3635-97f3-6b54150c6795', 
'System.owner', 
'system$owner', 
'a6c3cecd-a9ba-43ae-a34d-8ba35a961683', 
'282e2e60-88a5-469d-84a5-ba8d9151644f', 
'id', 
'system$owner');
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name")
 VALUES ('9728abcf-b0b8-34bd-8fee-9994c287ccc0', 
'System.changedBy', 
'system$changedby', 
'a6c3cecd-a9ba-43ae-a34d-8ba35a961683', 
'282e2e60-88a5-469d-84a5-ba8d9151644f', 
'id', 
'system$changedby');
CREATE TABLE "eventapplication$staff_result" (
	"eventapplication$staffid" BIGINT NOT NULL,
	"eventapplication$resultid" BIGINT NOT NULL,
	PRIMARY KEY("eventapplication$staffid","eventapplication$resultid"),
	CONSTRAINT "uniq_eventapplication$staff_result_eventapplication$staffid" UNIQUE ("eventapplication$staffid"));
CREATE INDEX "idx_eventapplication$staff_result_eventapplication$result_eventapplication$staff" ON "eventapplication$staff_result" ("eventapplication$resultid" ASC,"eventapplication$staffid" ASC);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name", 
"index_name")
 VALUES ('0b3336f7-5a99-49ff-9db1-df5f6e46b502', 
'EventApplication.Staff_Result', 
'eventapplication$staff_result', 
'a6c3cecd-a9ba-43ae-a34d-8ba35a961683', 
'cbd5f28c-099f-4314-80e6-68c5823864a5', 
'eventapplication$staffid', 
'eventapplication$resultid', 
'idx_eventapplication$staff_result_eventapplication$result_eventapplication$staff');
INSERT INTO "mendixsystem$unique_constraint" ("name", 
"table_id", 
"column_id")
 VALUES ('uniq_eventapplication$staff_result_eventapplication$staffid', 
'0b3336f7-5a99-49ff-9db1-df5f6e46b502', 
'e7037fb1-a755-361f-af93-f18ff4cf939e');
CREATE TABLE "eventapplication$homework" (
	"id" BIGINT NOT NULL,
	"submission_date" TIMESTAMP NULL,
	"subjects" VARCHAR_IGNORECASE(200) NULL,
	"date" TIMESTAMP NULL,
	"homework" VARCHAR_IGNORECASE(200) NULL,
	PRIMARY KEY("id"));
INSERT INTO "mendixsystem$entity" ("id", 
"entity_name", 
"table_name")
 VALUES ('aa32e45c-0af2-4c94-91b7-b5d81e51d42d', 
'EventApplication.Homework', 
'eventapplication$homework');
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('68c0f43d-c6a2-484d-9c3f-a17892e15bfb', 
'aa32e45c-0af2-4c94-91b7-b5d81e51d42d', 
'Submission_Date', 
'submission_date', 
20, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('141d8bce-6a73-4fb3-bc58-1edcb664677b', 
'aa32e45c-0af2-4c94-91b7-b5d81e51d42d', 
'Subjects', 
'subjects', 
30, 
200, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('106af97c-577c-48d7-880d-22a5768f1a11', 
'aa32e45c-0af2-4c94-91b7-b5d81e51d42d', 
'Date', 
'date', 
20, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('10f4f26f-21f3-4733-a74a-5d0ce3cff219', 
'aa32e45c-0af2-4c94-91b7-b5d81e51d42d', 
'Homework', 
'homework', 
30, 
200, 
'', 
false);
CREATE TABLE "eventapplication$homework_staff" (
	"eventapplication$homeworkid" BIGINT NOT NULL,
	"eventapplication$staffid" BIGINT NOT NULL,
	PRIMARY KEY("eventapplication$homeworkid","eventapplication$staffid"),
	CONSTRAINT "uniq_eventapplication$homework_staff_eventapplication$homeworkid" UNIQUE ("eventapplication$homeworkid"));
CREATE INDEX "idx_eventapplication$homework_staff_eventapplication$staff_eventapplication$homework" ON "eventapplication$homework_staff" ("eventapplication$staffid" ASC,"eventapplication$homeworkid" ASC);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name", 
"index_name")
 VALUES ('16e0544a-1598-45fb-881e-728c233f33e0', 
'EventApplication.Homework_Staff', 
'eventapplication$homework_staff', 
'aa32e45c-0af2-4c94-91b7-b5d81e51d42d', 
'a6c3cecd-a9ba-43ae-a34d-8ba35a961683', 
'eventapplication$homeworkid', 
'eventapplication$staffid', 
'idx_eventapplication$homework_staff_eventapplication$staff_eventapplication$homework');
INSERT INTO "mendixsystem$unique_constraint" ("name", 
"table_id", 
"column_id")
 VALUES ('uniq_eventapplication$homework_staff_eventapplication$homeworkid', 
'16e0544a-1598-45fb-881e-728c233f33e0', 
'de546656-2a35-3e6e-85b0-30bd191aed40');
CREATE TABLE "eventapplication$fees" (
	"id" BIGINT NOT NULL,
	"changeddate" TIMESTAMP NULL,
	"createddate" TIMESTAMP NULL,
	"paid_amount" VARCHAR_IGNORECASE(2147483647) NULL,
	"account_name" VARCHAR_IGNORECASE(2147483647) NULL,
	"due_amount" VARCHAR_IGNORECASE(2147483647) NULL,
	"system$owner" BIGINT NULL,
	"system$changedby" BIGINT NULL,
	PRIMARY KEY("id"));
CREATE INDEX "idx_eventapplication$fees_system$owner" ON "eventapplication$fees" ("system$owner" ASC,"id" ASC);
CREATE INDEX "idx_eventapplication$fees_system$changedby" ON "eventapplication$fees" ("system$changedby" ASC,"id" ASC);
INSERT INTO "mendixsystem$entity" ("id", 
"entity_name", 
"table_name")
 VALUES ('2a545202-d3c3-430f-9710-f9b6e1470f8e', 
'EventApplication.Fees', 
'eventapplication$fees');
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('d4c1838f-bbca-3c23-8519-aaa17aa9ec4c', 
'2a545202-d3c3-430f-9710-f9b6e1470f8e', 
'changedDate', 
'changeddate', 
20, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('de721b89-8cef-37c8-98a3-d473460edd15', 
'2a545202-d3c3-430f-9710-f9b6e1470f8e', 
'createdDate', 
'createddate', 
20, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('7b510b70-7d43-4898-b719-d6abdfa93d2b', 
'2a545202-d3c3-430f-9710-f9b6e1470f8e', 
'Paid_Amount', 
'paid_amount', 
30, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('34dc915d-f96a-4749-baa8-a8382a67a040', 
'2a545202-d3c3-430f-9710-f9b6e1470f8e', 
'Account_Name', 
'account_name', 
30, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('97d8a2b1-e3c9-4072-ba7d-3fada658c313', 
'2a545202-d3c3-430f-9710-f9b6e1470f8e', 
'Due_Amount', 
'due_amount', 
30, 
0, 
'', 
false);
INSERT INTO "mendixsystem$index" ("id", 
"table_id", 
"index_name")
 VALUES ('46d7cefe-9533-36cc-9333-fe5359d115c2', 
'2a545202-d3c3-430f-9710-f9b6e1470f8e', 
'idx_eventapplication$fees_system$owner');
INSERT INTO "mendixsystem$index_column" ("index_id", 
"column_id", 
"sort_order", 
"ordinal")
 VALUES ('46d7cefe-9533-36cc-9333-fe5359d115c2', 
'3b7a8de6-c560-35fe-8022-389f50c2a75a', 
false, 
0);
INSERT INTO "mendixsystem$index" ("id", 
"table_id", 
"index_name")
 VALUES ('c0fdc8a1-6d6a-34e3-bea2-f45207b1deb1', 
'2a545202-d3c3-430f-9710-f9b6e1470f8e', 
'idx_eventapplication$fees_system$changedby');
INSERT INTO "mendixsystem$index_column" ("index_id", 
"column_id", 
"sort_order", 
"ordinal")
 VALUES ('c0fdc8a1-6d6a-34e3-bea2-f45207b1deb1', 
'ffeed3b9-52d9-3bda-a1e6-60052b5406bc', 
false, 
0);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name")
 VALUES ('3b7a8de6-c560-35fe-8022-389f50c2a75a', 
'System.owner', 
'system$owner', 
'2a545202-d3c3-430f-9710-f9b6e1470f8e', 
'282e2e60-88a5-469d-84a5-ba8d9151644f', 
'id', 
'system$owner');
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name")
 VALUES ('ffeed3b9-52d9-3bda-a1e6-60052b5406bc', 
'System.changedBy', 
'system$changedby', 
'2a545202-d3c3-430f-9710-f9b6e1470f8e', 
'282e2e60-88a5-469d-84a5-ba8d9151644f', 
'id', 
'system$changedby');
DROP TABLE "f091495f3d0c4a42b257a9f3e94437b2";
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20200128 12:58:38';
