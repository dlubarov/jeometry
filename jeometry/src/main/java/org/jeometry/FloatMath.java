package org.jeometry;

// TODO: Optimize the methods that current just do double math.
final class FloatMath {
  public static final float PI = (float) Math.PI;

  private FloatMath() {}

  public static float sin(float a) {
    return (float) Math.sin(a);
  }

  public static float cos(float a) {
    return (float) Math.cos(a);
  }

  public static float sqrt(float a) {
    return (float) Math.sqrt(a);
  }
}
