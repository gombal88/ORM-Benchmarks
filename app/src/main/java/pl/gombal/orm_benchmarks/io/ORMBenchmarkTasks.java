package pl.gombal.orm_benchmarks.io;


import android.content.Context;

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

    long createDB();
    long dropDB();

    long insert(EntityType entityType, int num, boolean withTransaction);
    long update(EntityType entityType, int num, boolean withTransaction);
    long selectAll(EntityType entityType, boolean lazy);
    long searchIndexed(EntityType entityType, int value);
    long search(EntityType entityType, String value);

}
