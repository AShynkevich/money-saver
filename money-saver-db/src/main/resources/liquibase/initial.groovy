package liquibase

databaseChangeLog {
    includeAll(path: 'money-saver-db/src/main/resources/liquibase/changelogs', relativeToChangelogFile: false)
}

