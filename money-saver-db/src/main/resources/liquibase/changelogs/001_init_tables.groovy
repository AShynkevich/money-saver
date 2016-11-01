databaseChangeLog {
    
 changeSet(id: '00001', author: 'deniel') {
        comment "Create users table"

        createTable(tableName: 'users') {
            column(name: 'user_id', type: 'VARCHAR(128)') {
                constraints(primaryKey: true, primaryKeyName: 'user_id')
            }
            column(name: 'user_name', type: 'VARCHAR(128)') {
                constraints(nullable: false)
            }
			column(name: 'login', type: 'VARCHAR(128)') {
                constraints(nullable: false)
            }
            column(name: 'pass', type: 'VARCHAR(128)') {
                constraints(nullable: false)
            }
			column(name: 'created_datetime', type: 'TIMESTAMP', defaultValueDate: "CURRENT_TIMESTAMP")
            column(name: 'updated_datetime', type: 'TIMESTAMP')
			column(name: 'active_flag', type: 'BOOLEAN') {
                constraints(nullable: false)
			}
		}
        rollback {
            // automatic rollback
        }
}
 
 changeSet(id: '00002', author: 'deniel') {
        comment "Create roles table"

        createTable(tableName: 'roles') {
            column(name: 'role_id', type: 'VARCHAR(128)') {
                constraints(primaryKey: true, primaryKeyName: 'role_id')
            }
            column(name: 'role_name', type: 'VARCHAR(128)') {
                constraints(nullable: false)
            }
            column(name: 'created_datetime', type: 'TIMESTAMP', defaultValueDate: "CURRENT_TIMESTAMP")
            column(name: 'updated_datetime', type: 'TIMESTAMP')
        }

        rollback {
            // automatic rollback
        }
 }
 
 changeSet(id: '00003', author: 'deniel') {
        comment "Create user_role_map table"

        createTable(tableName: 'user_role_map') {
            column(name: 'user_id', type: 'VARCHAR(128)') {
                constraints(nullable: false)
            }
            column(name: 'role_id', type: 'VARCHAR(512)') {
                constraints(nullable: false)
            }
   column(name: 'created_datetime', type: 'TIMESTAMP', defaultValueDate: "CURRENT_TIMESTAMP")
            column(name: 'updated_datetime', type: 'TIMESTAMP')
        }

        rollback {
            // automatic rollback
        }
    }
 
 changeSet(id: '00004', author: 'deniel') {
        addPrimaryKey(tableName: 'user_role_map', columnNames: 'user_id,role_id', constraintName: 'pk_user_role_map')

        addForeignKeyConstraint(constraintName: 'fk_user_role_map_user_id',
                baseTableName: 'user_role_map', baseColumnNames: 'user_id',
                referencedTableName: 'users', referencedColumnNames: 'user_id')

        addForeignKeyConstraint(constraintName: 'fk_user_role_map_role_id',
                baseTableName: 'user_role_map', baseColumnNames: 'role_id',
                referencedTableName: 'roles', referencedColumnNames: 'role_id')
        }
}