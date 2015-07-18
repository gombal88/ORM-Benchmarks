package pl.gombal.orm_benchmarks.io;


import android.content.Context;

import java.sql.SQLException;

public interface ORMBenchmarkTasks {

    enum EntityType {
        SINGLE_TAB("Single Table"),
        BIG_SINGLE_TAB("Big Single Table"),
        MULTI_TAB_RELATION_TO_ONE("Multi Tables with relations to one"),
        SINGLE_TAB_RELATION_TO_MANY("Single Table with relations to many");

        private String entityName;

        EntityType(String entityName) {
            this.entityName = entityName;
        }

        public String getEntityName() {
            return entityName;
        }
    }

    String getName();

    void init(Context context, boolean copyDBFormAssets, boolean inMemoryDB);
    boolean isInitialized();

    long createDB() throws SQLException;
    long dropDB() throws SQLException;

    long insert(EntityType entityType, int num, boolean withTransaction) throws SQLException;
    long update(EntityType entityType, int num, boolean withTransaction) throws SQLException;
    long selectAll(EntityType entityType, boolean lazy) throws SQLException;
    long searchIndexed(EntityType entityType, int value) throws SQLException;
    long search(EntityType entityType, String value) throws SQLException;

}
