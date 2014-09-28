package org.jeometry;

final class Check {
  private Check() {}

  public static void notNull(Object value) {
    that(value != null);
  }

  public static void notNull(Object value, String message, Object... args) {
    that(value != null, message, args);
  }

  public static void that(boolean condition) {
    if (!condition) {
      throw new RuntimeException();
    }
  }

  public static void that(boolean condition, String message, Object... args) {
    if (!condition) {
      throw new RuntimeException(String.format(message, args));
    }
  }
}
