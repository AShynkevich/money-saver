Create SQL database:
>>> gradlew update -PrunList=createBase

Init SQL database:
>>> gradlew update

Set rollback tag:
>>> gradlew tag -PliquibaseCommandValue=<tagName>

Rollback:
>>> gradlew rollback -PliquibaseCommandValue=<tagName>