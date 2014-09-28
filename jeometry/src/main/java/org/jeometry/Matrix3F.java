package org.jeometry;

import static org.jeometry.FloatMath.cos;
import static org.jeometry.FloatMath.sin;

/**
 * A 3 by 3 matrix of floats.
 */
public final class Matrix3F {
  public static final Matrix3F IDENTITY = new Matrix3F(
      1, 0, 0,
      0, 1, 0,
      0, 0, 1);

  final float
      a11, a12, a13,
      a21, a22, a23,
      a31, a32, a33;

  public Matrix3F(
      float a11, float a12, float a13,
      float a21, float a22, float a23,
      float a31, float a32, float a33) {
    this.a11 = a11;
    this.a12 = a12;
    this.a13 = a13;
    this.a21 = a21;
    this.a22 = a22;
    this.a23 = a23;
    this.a31 = a31;
    this.a32 = a32;
    this.a33 = a33;
  }

  /**
   * Creates a matrix for translating points by a specified delta.
   */
  public static Matrix3F forTranslation(float dx, float dy) {
    return new Matrix3F(
        1, 0, dx,
        0, 1, dy,
        0, 0, 1);
  }

  /**
   * Creates a matrix for translating points by a specified delta.
   */
  public static Matrix3F forTranslation(Vector2F delta) {
    return forTranslation(delta.x, delta.y);
  }

  /**
   * Creates a matrix for rotating points about the x axis, assuming a right-handed system.
   *
   * @param theta the rotation amount, in radians
   * @return a matrix encoding the desired rotation
   */
  public static Matrix3F forRotationX(float theta) {
    return new Matrix3F(
        1, 0, 0,
        0, cos(theta), -sin(theta),
        0, sin(theta), cos(theta));
  }

  /**
   * Creates a matrix for rotating points about the y axis, assuming a right-handed system.
   *
   * @param theta the rotation amount, in radians
   * @return a matrix encoding the desired rotation
   */
  public static Matrix3F forRotationY(float theta) {
    return new Matrix3F(
        cos(theta), 0, sin(theta),
        0, 1, 0,
        -sin(theta), 0, cos(theta));
  }

  /**
   * Creates a matrix for rotating points about the z axis, assuming a right-handed system.
   *
   * @param theta the rotation amount, in radians
   * @return a matrix encoding the desired rotation
   */
  public static Matrix3F forRotationZ(float theta) {
    return new Matrix3F(
        cos(theta), -sin(theta), 0,
        sin(theta), cos(theta), 0,
        0, 0, 1);
  }

  /**
   * Multiply this matrix by another matrix.
   */
  public Matrix3F times(Matrix3F that) {
    return new Matrix3F(
        this.a11 * that.a11 + this.a12 * that.a21 + this.a13 * that.a31,
        this.a11 * that.a12 + this.a12 * that.a22 + this.a13 * that.a32,
        this.a11 * that.a13 + this.a12 * that.a23 + this.a13 * that.a33,

        this.a21 * that.a11 + this.a22 * that.a21 + this.a23 * that.a31,
        this.a21 * that.a12 + this.a22 * that.a22 + this.a23 * that.a32,
        this.a21 * that.a13 + this.a22 * that.a23 + this.a23 * that.a33,

        this.a31 * that.a11 + this.a32 * that.a21 + this.a33 * that.a31,
        this.a31 * that.a12 + this.a32 * that.a22 + this.a33 * that.a32,
        this.a31 * that.a13 + this.a32 * that.a23 + this.a33 * that.a33);
  }

  /**
   * Multiply this matrix by the given vector.
   */
  public Vector3F transform(Vector3F v) {
    return new Vector3F(
        a11 * v.x + a12 * v.y + a13 * v.z,
        a21 * v.x + a22 * v.y + a23 * v.z,
        a31 * v.x + a32 * v.y + a33 * v.z);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append(a11).append(a12).append(a13)
        .append(a21).append(a22).append(a23)
        .append(a31).append(a32).append(a33)
        .toString();
  }
}
