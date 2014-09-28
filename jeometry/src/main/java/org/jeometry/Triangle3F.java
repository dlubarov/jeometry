package org.jeometry;

/**
 * A two dimensional triangle, encoded with floats.
 */
public final class Triangle3F {
  final Vector3F a, b, c;

  /**
   * Creates a new triangle with the three given vertices.
   */
  public Triangle3F(Vector3F a, Vector3F b, Vector3F c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public Vector3F getFirstVertex() {
    return a;
  }

  public Vector3F getSecondVertex() {
    return b;
  }

  public Vector3F getThirdVertex() {
    return c;
  }

  public AxisAlignedBox3F getBoundingBox() {
    return AxisAlignedBox3F.fromPoints(a, b, c);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append(a).append(b).append(c).toString();
  }
}
