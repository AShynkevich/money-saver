package liquibase

databaseChangeLog {
    changeSet(id: 'ms-000000', author: 'deniel', runInTransaction: 'false') {
        sql() {
            "create database money_saver with owner=postgres encoding='UTF8'"
        }
    }
}