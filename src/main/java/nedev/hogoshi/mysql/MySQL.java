package nedev.hogoshi.mysql;

import nedev.hogoshi.ThePit;
import com.sun.rowset.CachedRowSetImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.SneakyThrows;
import lombok.val;

import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.concurrent.CompletableFuture;

public class MySQL {

    public Connection connection;

    @SneakyThrows
    public void connect() {
        val config = new HikariConfig();

        config.setUsername(ThePit.getInstance().getConfig().getString("MySQL.username"));
        config.setPassword(ThePit.getInstance().getConfig().getString("MySQL.password"));
        config.setAutoCommit(true);
        config.setConnectionTimeout(5000);
        config.setMaximumPoolSize(10);

        config.setJdbcUrl(String.format("jdbc:mysql://%s:%s/%s" +
                        "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                ThePit.getInstance().getConfig().getString("MySQL.host"),
                ThePit.getInstance().getConfig().getString("MySQL.port"),
                ThePit.getInstance().getConfig().getString("MySQL.dbname")));

        val dataSource = new HikariDataSource(config);

        this.connection = dataSource.getConnection();
    }

    public CompletableFuture<CachedRowSet> executeQuery(String sql, Object... objects) {
        return CompletableFuture.supplyAsync(() -> {
            try (val ps = prepare(sql, objects)) {
                val rs = new CachedRowSetImpl();
                rs.populate(ps.executeQuery());
                return rs;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    @SneakyThrows
    public PreparedStatement prepare(String query, Object[] objects) {
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setQueryTimeout(5);

        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                Object object = objects[i];

                if (object == null) {
                    ps.setNull(i + 1, Types.VARCHAR);
                } else {
                    ps.setObject(i + 1, objects[i]);
                }
            }
        }

        if (objects == null || objects.length == 0) {
            ps.clearParameters();
        }

        return ps;
    }


    public void execute(String sql, Object... objects) {
        ThePit.getInstance().fastAsync(() -> {
            try (val ps = prepare(sql, objects)) {
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void executeSync(String sql, Object... objects) {
        try (val ps = prepare(sql, objects)) {
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
