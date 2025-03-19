package repository;

import java.sql.SQLException;

public abstract class BaseRepository {
    String url = "jdbc:postgresql://localhost:5432/MusicLibrary";
    String dbUsername = "postgres";
    String dbPassword = "postgres";

    public abstract int getEntityId(String name) throws SQLException;

    public abstract int addEntity(String name) throws SQLException;

    public int getOrAddEntity(String name) throws SQLException {
        int entityId = getEntityId(name);
        if (entityId == -1) {
            entityId = addEntity(name);
        }
        return entityId;
    }
}
