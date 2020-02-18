CREATE TABLE "eventapplication$parent" (
	"id" BIGINT NOT NULL,
	"parent_email" VARCHAR_IGNORECASE(200) NULL,
	"phone_number" BIGINT NULL,
	"parent_name" VARCHAR_IGNORECASE(200) NULL,
	PRIMARY KEY("id"));
INSERT INTO "mendixsystem$entity" ("id", 
"entity_name", 
"table_name")
 VALUES ('d8eaa48a-47ff-46b5-8eb5-f17dbbff75bc', 
'EventApplication.Parent', 
'eventapplication$parent');
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('66fa6ddc-a9d7-44d8-9610-8c1c11efe9fc', 
'd8eaa48a-47ff-46b5-8eb5-f17dbbff75bc', 
'Parent_email', 
'parent_email', 
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
 VALUES ('4b8bca15-a6d2-4cd5-ab31-2f5bd7f2d7ef', 
'd8eaa48a-47ff-46b5-8eb5-f17dbbff75bc', 
'phone_number', 
'phone_number', 
4, 
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
 VALUES ('00f4eb18-87ab-48fb-a963-3ea65f1a5e3d', 
'd8eaa48a-47ff-46b5-8eb5-f17dbbff75bc', 
'Parent_Name', 
'parent_name', 
30, 
200, 
'', 
false);
CREATE TABLE "eventapplication$parent_registrant" (
	"eventapplication$parentid" BIGINT NOT NULL,
	"eventapplication$registrantid" BIGINT NOT NULL,
	PRIMARY KEY("eventapplication$parentid","eventapplication$registrantid"),
	CONSTRAINT "uniq_eventapplication$parent_registrant_eventapplication$parentid" UNIQUE ("eventapplication$parentid"));
CREATE INDEX "idx_eventapplication$parent_registrant_eventapplication$registrant_eventapplication$parent" ON "eventapplication$parent_registrant" ("eventapplication$registrantid" ASC,"eventapplication$parentid" ASC);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name", 
"index_name")
 VALUES ('4fe232e8-6658-4e70-92c2-6174cc6f2b49', 
'EventApplication.Parent_Registrant', 
'eventapplication$parent_registrant', 
'd8eaa48a-47ff-46b5-8eb5-f17dbbff75bc', 
'45b57eda-40c5-493b-9ddb-dc494b038731', 
'eventapplication$parentid', 
'eventapplication$registrantid', 
'idx_eventapplication$parent_registrant_eventapplication$registrant_eventapplication$parent');
INSERT INTO "mendixsystem$unique_constraint" ("name", 
"table_id", 
"column_id")
 VALUES ('uniq_eventapplication$parent_registrant_eventapplication$parentid', 
'4fe232e8-6658-4e70-92c2-6174cc6f2b49', 
'092d2577-e894-3e53-8566-8160fb42ba6a');
CREATE TABLE "eventapplication$studentdetails" (
	"id" BIGINT NOT NULL,
	"student_mail" VARCHAR_IGNORECASE(200) NULL,
	"student_name" VARCHAR_IGNORECASE(200) NULL,
	"student_class" VARCHAR_IGNORECASE(200) NULL,
	PRIMARY KEY("id"));
INSERT INTO "mendixsystem$entity" ("id", 
"entity_name", 
"table_name")
 VALUES ('5ff5609c-8019-499d-8ccf-16d3b6ddcff1', 
'EventApplication.StudentDetails', 
'eventapplication$studentdetails');
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('d39494cb-ae81-44d5-8c76-2747a163da62', 
'5ff5609c-8019-499d-8ccf-16d3b6ddcff1', 
'Student_mail', 
'student_mail', 
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
 VALUES ('e1df2913-49fc-4ebd-9ff5-196c1ca95646', 
'5ff5609c-8019-499d-8ccf-16d3b6ddcff1', 
'Student_Name', 
'student_name', 
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
 VALUES ('a484d606-cb2a-4975-90c9-c3fb3001bf59', 
'5ff5609c-8019-499d-8ccf-16d3b6ddcff1', 
'Student_Class', 
'student_class', 
30, 
200, 
'', 
false);
CREATE TABLE "eventapplication$studentdetails_registrant" (
	"eventapplication$studentdetailsid" BIGINT NOT NULL,
	"eventapplication$registrantid" BIGINT NOT NULL,
	PRIMARY KEY("eventapplication$studentdetailsid","eventapplication$registrantid"),
	CONSTRAINT "uniq_eventapplication$studentdetails_registrant_eventapplication$studentdetailsid" UNIQUE ("eventapplication$studentdetailsid"));
CREATE INDEX "idx_eventapplication$studentdetails_registrant_eventapplication$registrant_eventapplication$studentdetails" ON "eventapplication$studentdetails_registrant" ("eventapplication$registrantid" ASC,"eventapplication$studentdetailsid" ASC);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name", 
"index_name")
 VALUES ('589b51a1-feef-433a-b9a0-4ff6965723ae', 
'EventApplication.StudentDetails_Registrant', 
'eventapplication$studentdetails_registrant', 
'5ff5609c-8019-499d-8ccf-16d3b6ddcff1', 
'45b57eda-40c5-493b-9ddb-dc494b038731', 
'eventapplication$studentdetailsid', 
'eventapplication$registrantid', 
'idx_eventapplication$studentdetails_registrant_eventapplication$registrant_eventapplication$studentdetails');
INSERT INTO "mendixsystem$unique_constraint" ("name", 
"table_id", 
"column_id")
 VALUES ('uniq_eventapplication$studentdetails_registrant_eventapplication$studentdetailsid', 
'589b51a1-feef-433a-b9a0-4ff6965723ae', 
'bf4ce471-a1d5-34ed-9356-9a1a91baea8e');
CREATE TABLE "eventapplication$login_staff" (
	"eventapplication$loginid" BIGINT NOT NULL,
	"eventapplication$staffid" BIGINT NOT NULL,
	PRIMARY KEY("eventapplication$loginid","eventapplication$staffid"),
	CONSTRAINT "uniq_eventapplication$login_staff_eventapplication$loginid" UNIQUE ("eventapplication$loginid"));
CREATE INDEX "idx_eventapplication$login_staff_eventapplication$staff_eventapplication$login" ON "eventapplication$login_staff" ("eventapplication$staffid" ASC,"eventapplication$loginid" ASC);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name", 
"index_name")
 VALUES ('83b33aa6-0e22-42b4-ba19-5ddd703d7e52', 
'EventApplication.Login_Staff', 
'eventapplication$login_staff', 
'c9dcda51-c64f-43c9-a450-1b3d237d86a6', 
'a6c3cecd-a9ba-43ae-a34d-8ba35a961683', 
'eventapplication$loginid', 
'eventapplication$staffid', 
'idx_eventapplication$login_staff_eventapplication$staff_eventapplication$login');
INSERT INTO "mendixsystem$unique_constraint" ("name", 
"table_id", 
"column_id")
 VALUES ('uniq_eventapplication$login_staff_eventapplication$loginid', 
'83b33aa6-0e22-42b4-ba19-5ddd703d7e52', 
'e1d6e651-7b5d-3cc7-9396-cb6beb7496f3');
CREATE TABLE "eventapplication$login_parent" (
	"eventapplication$loginid" BIGINT NOT NULL,
	"eventapplication$parentid" BIGINT NOT NULL,
	PRIMARY KEY("eventapplication$loginid","eventapplication$parentid"),
	CONSTRAINT "uniq_eventapplication$login_parent_eventapplication$loginid" UNIQUE ("eventapplication$loginid"));
CREATE INDEX "idx_eventapplication$login_parent_eventapplication$parent_eventapplication$login" ON "eventapplication$login_parent" ("eventapplication$parentid" ASC,"eventapplication$loginid" ASC);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name", 
"index_name")
 VALUES ('e54ab807-4f4f-4a3b-9914-21ba3176dfc6', 
'EventApplication.Login_Parent', 
'eventapplication$login_parent', 
'c9dcda51-c64f-43c9-a450-1b3d237d86a6', 
'd8eaa48a-47ff-46b5-8eb5-f17dbbff75bc', 
'eventapplication$loginid', 
'eventapplication$parentid', 
'idx_eventapplication$login_parent_eventapplication$parent_eventapplication$login');
INSERT INTO "mendixsystem$unique_constraint" ("name", 
"table_id", 
"column_id")
 VALUES ('uniq_eventapplication$login_parent_eventapplication$loginid', 
'e54ab807-4f4f-4a3b-9914-21ba3176dfc6', 
'a0136871-9107-3379-9989-0412fe993162');
CREATE TABLE "eventapplication$login_studentdetails" (
	"eventapplication$loginid" BIGINT NOT NULL,
	"eventapplication$studentdetailsid" BIGINT NOT NULL,
	PRIMARY KEY("eventapplication$loginid","eventapplication$studentdetailsid"),
	CONSTRAINT "uniq_eventapplication$login_studentdetails_eventapplication$loginid" UNIQUE ("eventapplication$loginid"));
CREATE INDEX "idx_eventapplication$login_studentdetails_eventapplication$studentdetails_eventapplication$login" ON "eventapplication$login_studentdetails" ("eventapplication$studentdetailsid" ASC,"eventapplication$loginid" ASC);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name", 
"index_name")
 VALUES ('34c8a8cf-49f4-434d-90c9-8fdcaa286062', 
'EventApplication.Login_StudentDetails', 
'eventapplication$login_studentdetails', 
'c9dcda51-c64f-43c9-a450-1b3d237d86a6', 
'5ff5609c-8019-499d-8ccf-16d3b6ddcff1', 
'eventapplication$loginid', 
'eventapplication$studentdetailsid', 
'idx_eventapplication$login_studentdetails_eventapplication$studentdetails_eventapplication$login');
INSERT INTO "mendixsystem$unique_constraint" ("name", 
"table_id", 
"column_id")
 VALUES ('uniq_eventapplication$login_studentdetails_eventapplication$loginid', 
'34c8a8cf-49f4-434d-90c9-8fdcaa286062', 
'dfc0ba60-b61e-3158-98f7-b39d6957ef60');
CREATE TABLE "eventapplication$login_registrant" (
	"eventapplication$loginid" BIGINT NOT NULL,
	"eventapplication$registrantid" BIGINT NOT NULL,
	PRIMARY KEY("eventapplication$loginid","eventapplication$registrantid"),
	CONSTRAINT "uniq_eventapplication$login_registrant_eventapplication$loginid" UNIQUE ("eventapplication$loginid"));
CREATE INDEX "idx_eventapplication$login_registrant_eventapplication$registrant_eventapplication$login" ON "eventapplication$login_registrant" ("eventapplication$registrantid" ASC,"eventapplication$loginid" ASC);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name", 
"index_name")
 VALUES ('bd123bc2-de3f-412a-9a91-1be2b7e56957', 
'EventApplication.Login_Registrant', 
'eventapplication$login_registrant', 
'c9dcda51-c64f-43c9-a450-1b3d237d86a6', 
'45b57eda-40c5-493b-9ddb-dc494b038731', 
'eventapplication$loginid', 
'eventapplication$registrantid', 
'idx_eventapplication$login_registrant_eventapplication$registrant_eventapplication$login');
INSERT INTO "mendixsystem$unique_constraint" ("name", 
"table_id", 
"column_id")
 VALUES ('uniq_eventapplication$login_registrant_eventapplication$loginid', 
'bd123bc2-de3f-412a-9a91-1be2b7e56957', 
'0da973c3-acdf-36f2-9bcb-aea0df7b8b94');
CREATE TABLE "eventapplication$registrant_staff" (
	"eventapplication$registrantid" BIGINT NOT NULL,
	"eventapplication$staffid" BIGINT NOT NULL,
	PRIMARY KEY("eventapplication$registrantid","eventapplication$staffid"),
	CONSTRAINT "uniq_eventapplication$registrant_staff_eventapplication$registrantid" UNIQUE ("eventapplication$registrantid"));
CREATE INDEX "idx_eventapplication$registrant_staff_eventapplication$staff_eventapplication$registrant" ON "eventapplication$registrant_staff" ("eventapplication$staffid" ASC,"eventapplication$registrantid" ASC);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name", 
"index_name")
 VALUES ('9662d057-0739-4273-8c02-9bdc8251a207', 
'EventApplication.Registrant_Staff', 
'eventapplication$registrant_staff', 
'45b57eda-40c5-493b-9ddb-dc494b038731', 
'a6c3cecd-a9ba-43ae-a34d-8ba35a961683', 
'eventapplication$registrantid', 
'eventapplication$staffid', 
'idx_eventapplication$registrant_staff_eventapplication$staff_eventapplication$registrant');
INSERT INTO "mendixsystem$unique_constraint" ("name", 
"table_id", 
"column_id")
 VALUES ('uniq_eventapplication$registrant_staff_eventapplication$registrantid', 
'9662d057-0739-4273-8c02-9bdc8251a207', 
'08ad3e43-a77a-3402-9c44-325e6bdebec6');
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20200128 16:15:51';
