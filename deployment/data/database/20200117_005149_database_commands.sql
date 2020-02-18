CREATE TABLE "eventapplication$login" (
	"id" BIGINT NOT NULL,
	"changeddate" TIMESTAMP NULL,
	"createddate" TIMESTAMP NULL,
	"username" VARCHAR_IGNORECASE(200) NULL,
	"password" VARCHAR_IGNORECASE(200) NULL,
	"system$owner" BIGINT NULL,
	"system$changedby" BIGINT NULL,
	PRIMARY KEY("id"));
CREATE INDEX "idx_eventapplication$login_system$owner" ON "eventapplication$login" ("system$owner" ASC,"id" ASC);
CREATE INDEX "idx_eventapplication$login_system$changedby" ON "eventapplication$login" ("system$changedby" ASC,"id" ASC);
INSERT INTO "mendixsystem$entity" ("id", 
"entity_name", 
"table_name")
 VALUES ('c9dcda51-c64f-43c9-a450-1b3d237d86a6', 
'EventApplication.Login', 
'eventapplication$login');
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('6fd81a62-9188-3b4f-9695-3a7ed79b39a9', 
'c9dcda51-c64f-43c9-a450-1b3d237d86a6', 
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
 VALUES ('0346019b-7e6c-3010-b410-c85cd06d18aa', 
'c9dcda51-c64f-43c9-a450-1b3d237d86a6', 
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
 VALUES ('98e9d7c0-9072-4297-9f86-0b9bd9b4f413', 
'c9dcda51-c64f-43c9-a450-1b3d237d86a6', 
'Username', 
'username', 
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
 VALUES ('57de0ae2-e599-41c3-a1b3-2bb06ef8c5b1', 
'c9dcda51-c64f-43c9-a450-1b3d237d86a6', 
'Password', 
'password', 
30, 
200, 
'', 
false);
INSERT INTO "mendixsystem$index" ("id", 
"table_id", 
"index_name")
 VALUES ('08236f3b-3504-3fe1-bfa3-33932f587b76', 
'c9dcda51-c64f-43c9-a450-1b3d237d86a6', 
'idx_eventapplication$login_system$owner');
INSERT INTO "mendixsystem$index_column" ("index_id", 
"column_id", 
"sort_order", 
"ordinal")
 VALUES ('08236f3b-3504-3fe1-bfa3-33932f587b76', 
'5387ab07-ef10-3a18-87cb-f1ca109f1d23', 
false, 
0);
INSERT INTO "mendixsystem$index" ("id", 
"table_id", 
"index_name")
 VALUES ('5ed877bf-e4db-3598-9a01-21438cb3dd41', 
'c9dcda51-c64f-43c9-a450-1b3d237d86a6', 
'idx_eventapplication$login_system$changedby');
INSERT INTO "mendixsystem$index_column" ("index_id", 
"column_id", 
"sort_order", 
"ordinal")
 VALUES ('5ed877bf-e4db-3598-9a01-21438cb3dd41', 
'150e6ddf-3f70-3882-9985-f57254c634d7', 
false, 
0);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name")
 VALUES ('5387ab07-ef10-3a18-87cb-f1ca109f1d23', 
'System.owner', 
'system$owner', 
'c9dcda51-c64f-43c9-a450-1b3d237d86a6', 
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
 VALUES ('150e6ddf-3f70-3882-9985-f57254c634d7', 
'System.changedBy', 
'system$changedby', 
'c9dcda51-c64f-43c9-a450-1b3d237d86a6', 
'282e2e60-88a5-469d-84a5-ba8d9151644f', 
'id', 
'system$changedby');
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20200117 00:51:49';
