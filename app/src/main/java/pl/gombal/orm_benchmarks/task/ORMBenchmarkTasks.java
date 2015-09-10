package pl.gombal.orm_benchmarks.task;


import android.content.Context;

import java.sql.SQLException;

public interface ORMBenchmarkTasks {

    enum EntityType {
        SINGLE_TAB("Single Tab"),
        BIG_SINGLE_TAB("Big Single Tab"),
        MULTI_TAB_RELATION_TO_ONE("Cascade tables"),
        SINGLE_TAB_RELATION_TO_MANY("Tab - relations to many");

        private String entityName;

        EntityType(String entityName) {
            this.entityName = entityName;
        }

        public String getEntityName() {
            return entityName;
        }
    }

    enum SelectionType {
        WITH_LAZY_INIT("Selection with lazy initialization"),
        WITHOUT_LAZY_INIT("Selection with full data loading"),
        COUNT_ONLY("Count only");

        private String selectionTypeName;

        SelectionType( String selectionTypeName) {
            this.selectionTypeName = selectionTypeName;
        }

        public String getSelectionTypeName() {
            return selectionTypeName;
        }

        public static SelectionType byOrdinal(int ordinal) {
            return SelectionType.values()[ordinal];
        }
    }

    String getName();

    void init(Context context, boolean copyDBFormAssets, boolean inMemoryDB);
    boolean isInitialized();

    long createDB() throws SQLException;
    long dropDB() throws SQLException;

    long insert(EntityType entityType, int num, boolean withTransaction) throws SQLException;
    long update(EntityType entityType, int num, boolean withTransaction) throws SQLException;
    long selectAll(EntityType entityType, SelectionType selectionType) throws SQLException;
    long searchIndexed(EntityType entityType, int value) throws SQLException;
    long search(EntityType entityType, String value) throws SQLException;

}
