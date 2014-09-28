package org.jeometry;

/**
 * A 4 by 4 matrix of floats.
 */
public final class Matrix4F {
  public static final Matrix4F IDENTITY = new Matrix4F(
      1, 0, 0, 0,
      0, 1, 0, 0,
      0, 0, 1, 0,
      0, 0, 0, 1);

  final float
      a11, a12, a13, a14,
      a21, a22, a23, a24,
      a31, a32, a33, a34,
      a41, a42, a43, a44;

  public Matrix4F(
      float a11, float a12, float a13, float a14,
      float a21, float a22, float a23, float a24,
      float a31, float a32, float a33, float a34,
      float a41, float a42, float a43, float a44) {
    this.a11 = a11; this.a12 = a12; this.a13 = a13; this.a14 = a14;
    this.a21 = a21; this.a22 = a22; this.a23 = a23; this.a24 = a24;
    this.a31 = a31; this.a32 = a32; this.a33 = a33; this.a34 = a34;
    this.a41 = a41; this.a42 = a42; this.a43 = a43; this.a44 = a44;
  }

  /**
   * Creates a matrix for translating points by a specified delta.
   */
  public static Matrix4F forTranslation(float dx, float dy, float dz) {
    return new Matrix4F(
        1, 0, 0, dx,
        0, 1, 0, dy,
        0, 0, 1, dz,
        0, 0, 0, 1);
  }

  /**
   * Creates a matrix for translating points by a specified delta.
   */
  public static Matrix4F forTranslation(Vector3F delta) {
    return forTranslation(delta.x, delta.y, delta.z);
  }

  /**
   * Multiply this matrix by another matrix.
   */
  public Matrix4F times(Matrix4F that) {
    return new Matrix4F(
        this.a11 * that.a11 + this.a12 * that.a21 + this.a13 * that.a31 + this.a14 * that.a41,
        this.a11 * that.a12 + this.a12 * that.a22 + this.a13 * that.a32 + this.a14 * that.a42,
        this.a11 * that.a13 + this.a12 * that.a23 + this.a13 * that.a33 + this.a14 * that.a43,
        this.a11 * that.a14 + this.a12 * that.a24 + this.a13 * that.a34 + this.a14 * that.a44,

        this.a21 * that.a11 + this.a22 * that.a21 + this.a23 * that.a31 + this.a24 * that.a41,
        this.a21 * that.a12 + this.a22 * that.a22 + this.a23 * that.a32 + this.a24 * that.a42,
        this.a21 * that.a13 + this.a22 * that.a23 + this.a23 * that.a33 + this.a24 * that.a43,
        this.a21 * that.a14 + this.a22 * that.a24 + this.a23 * that.a34 + this.a24 * that.a44,

        this.a31 * that.a11 + this.a32 * that.a21 + this.a33 * that.a31 + this.a34 * that.a41,
        this.a31 * that.a12 + this.a32 * that.a22 + this.a33 * that.a32 + this.a34 * that.a42,
        this.a31 * that.a13 + this.a32 * that.a23 + this.a33 * that.a33 + this.a34 * that.a43,
        this.a31 * that.a14 + this.a32 * that.a24 + this.a33 * that.a34 + this.a34 * that.a44,

        this.a41 * that.a11 + this.a42 * that.a21 + this.a43 * that.a31 + this.a44 * that.a41,
        this.a41 * that.a12 + this.a42 * that.a22 + this.a43 * that.a32 + this.a44 * that.a42,
        this.a41 * that.a13 + this.a42 * that.a23 + this.a43 * that.a33 + this.a44 * that.a43,
        this.a41 * that.a14 + this.a42 * that.a24 + this.a43 * that.a34 + this.a44 * that.a44);
  }

  /**
   * Multiply this matrix by the given vector.
   */
  public Vector4F transform(Vector4F v) {
    return new Vector4F(
        a11 * v.x + a12 * v.y + a13 * v.z + a14 * v.w,
        a21 * v.x + a22 * v.y + a23 * v.z + a24 * v.w,
        a31 * v.x + a32 * v.y + a33 * v.z + a34 * v.w,
        a41 * v.x + a42 * v.y + a43 * v.z + a44 * v.w);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append(a11).append(a12).append(a13).append(a14)
        .append(a21).append(a22).append(a23).append(a24)
        .append(a31).append(a32).append(a33).append(a34)
        .append(a41).append(a42).append(a43).append(a44)
        .toString();
  }
}
