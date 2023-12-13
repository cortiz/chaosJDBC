package com.jmpeax.chaosJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;

public class Driver implements java.sql.Driver {


  /**
   *
   */
  private static final String URL_PREFIX = "jdbc:chaos:";
  private static final Driver INSTANCE = new Driver();

  static {
    load();
  }

  private static synchronized void load() {
    try {
      DriverManager.registerDriver(INSTANCE);
    } catch (SQLException e) {
      throw new RuntimeException("Failed to register driver");
    }
  }

  /**
   * Empty constructor.
   */
  public Driver() {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Connection connect(final String url, final Properties info) throws SQLException {
    var realUrl = "jdbc" + url.replace(URL_PREFIX, "");
    return DriverManager.getDriver(realUrl).connect(realUrl, info);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean acceptsURL(final String url) throws SQLException {
    try {
      Objects.requireNonNull(url, "url cannot be null");
      return url.startsWith(URL_PREFIX);
    } catch (NullPointerException e) {
      throw new SQLException("url cannot be null");
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public DriverPropertyInfo[] getPropertyInfo(final String url, final Properties info)
          throws SQLException {
    return new DriverPropertyInfo[0];
  }

  /**
   * {@inheritDoc}
   */

  @Override
  public int getMajorVersion() {
    return 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getMinorVersion() {
    return 1;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean jdbcCompliant() {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Logger getParentLogger() throws SQLFeatureNotSupportedException {
    return null;
  }

}
