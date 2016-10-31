package liquibase

databaseChangeLog {
    includeAll(path: 'src/main/resources/liquibase/changelogs', relativeToChangelogFile: false)
}

