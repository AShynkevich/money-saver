databaseChangeLog {

    changeSet(id: '00002', author: 'deniel') {
        insert(tableName: 'users') {
            column(name: 'user_id', value: '11123005va')
            column(name: 'user_name', value: 'admin')
            column(name: 'login', value: 'deniel')
            column(name: 'pass', value: "12345678")
            column(name: 'created_datetime', value: 'now()')
            column(name: 'updated_datetime', value: "now()")
            column(name: 'active_flag', value: 'false')
        }

        insert(tableName: 'roles') {
            column(name: 'role_id', value: 'adminId')
            column(name: 'role_name', value: 'admin')
            column(name: 'created_datetime', value: 'now()')
            column(name: 'updated_datetime', value: "now()")
        }

        insert(tableName: 'user_role_map') {
            column(name: 'user_id', value: '11123005va')
            column(name: 'role_id', value: 'adminId')
            column(name: 'created_datetime', value: 'now()')
            column(name: 'updated_datetime', value: "now()")
        }

        rollback {
            delete(tableName: 'user_role_map') {
                where "user_id = '11123005va' AND role_id = 'adminId'"
            }
            delete(tableName: 'users') {
                where "user_id = '11123005va'"
            }
            delete(tableName: 'roles') {
                where "role_id = 'adminId'"
            }
        }
    }
}