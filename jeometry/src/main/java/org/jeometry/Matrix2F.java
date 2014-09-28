package org.jeometry;

import static org.jeometry.FloatMath.cos;
import static org.jeometry.FloatMath.sin;

/**
 * A 2 by 2 matrix of floats.
 */
public final class Matrix2F {
  public static final Matrix2F IDENTITY = new Matrix2F(
      1, 0,
      0, 1);

  final float
      a11, a12,
      a21, a22;

  public Matrix2F(
      float a11, float a12,
      float a21, float a22) {
    this.a11 = a11; this.a12 = a12;
    this.a21 = a21; this.a22 = a22;
  }

  /**
   * Creates a matrix for rotating points about the origin, in the direction from positive x to
   * positive y.
   *
   * @param theta the rotation amount, in radians
   * @return a matrix encoding the desired rotation
   */
  public static Matrix2F forRotation(float theta) {
    return new Matrix2F(
        cos(theta), -sin(theta),
        sin(theta), cos(theta));
  }

  /**
   * Multiply this matrix by another matrix.
   */
  public Matrix2F times(Matrix2F that) {
    return new Matrix2F(
        this.a11 * that.a11 + this.a12 * that.a21,
        this.a11 * that.a12 + this.a12 * that.a22,

        this.a21 * that.a11 + this.a22 * that.a21,
        this.a21 * that.a12 + this.a22 * that.a22);
  }

  /**
   * Multiply this matrix by the given vector.
   */
  public Vector2F transform(Vector2F v) {
    return new Vector2F(
        a11 * v.x + a12 * v.y,
        a21 * v.x + a22 * v.y);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append(a11).append(a12)
        .append(a21).append(a22)
        .toString();
  }
}
