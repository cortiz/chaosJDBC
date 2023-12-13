package com.jmpeax.chaosJDBC;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

  @Test
  void getMajorVersion() {
    assertEquals(0, new Driver().getMajorVersion());
  }

  @Test
  void getMinorVersion() {
    assertEquals(1, new Driver().getMinorVersion());
  }

  @Test
  void connect() {
    Properties connectionProps = new Properties();
    connectionProps.put("user", "");
    connectionProps.put("password", "");
    assertDoesNotThrow(() -> {
      var conn = DriverManager.getConnection("jdbc:chaos::h2:mem:testdb", connectionProps);
      assertEquals(conn.getMetaData().getDatabaseProductName(), "H2");
      conn.prepareStatement("CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255));").execute();
      conn.prepareStatement("INSERT INTO TEST VALUES(1, 'Hello');").execute();
      var rs = conn.prepareStatement("SELECT * FROM TEST;").executeQuery();
      rs.next();
      assertEquals(1,rs.getInt(1));
      assertEquals("Hello",rs.getString(2));
      rs.close();
      conn.close();
      }, "getConnection should not throw");
  }

  @Test
  void acceptsURL() throws SQLException {
    assertTrue(new Driver().acceptsURL("jdbc:chaos:"), "jdbc:chaos: should be accepted");
    assertFalse(new Driver().acceptsURL("jdbc:h2"), "jdbc:h2 should not be accepted");
    assertThrows(SQLException.class, () -> new Driver().acceptsURL(null), "null should throw SQLException");
  }

  @Test
  void getPropertyInfo() {
  }

  @Test
  void jdbcCompliant() {
    assertFalse(new Driver().jdbcCompliant());
  }

  @Test
  void getParentLogger() {
  }
}
