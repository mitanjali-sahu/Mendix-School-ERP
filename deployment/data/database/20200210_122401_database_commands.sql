ALTER TABLE "mendixsystem$entity" ADD "remote" BOOLEAN NULL;
UPDATE "mendixsystem$version"
 SET "preanalysismigrationversionnumber" = '3.1.0';
