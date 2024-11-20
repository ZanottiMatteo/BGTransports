/*
 * This file is generated by jOOQ.
 */
package user.jooq.generated;


import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

import user.jooq.generated.tables.User;
import user.jooq.generated.tables.records.UserRecord;


/**
 * A class modelling foreign key relationships and constraints of tables in the
 * default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<UserRecord> USER__PK_USER = Internal.createUniqueKey(User.USER, DSL.name("PK_USER"), new TableField[] { User.USER.USERNAME }, true);
}
