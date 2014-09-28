package org.jeometry;

/**
 * A two dimensional triangle, encoded with floats.
 */
public final class Triangle2F {
  final Vector2F a, b, c;

  /**
   * Creates a new triangle with the three given vertices.
   */
  public Triangle2F(Vector2F a, Vector2F b, Vector2F c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public Vector2F getFirstVertex() {
    return a;
  }

  public Vector2F getSecondVertex() {
    return b;
  }

  public Vector2F getThirdVertex() {
    return c;
  }

  public AxisAlignedBox2F getBoundingBox() {
    return AxisAlignedBox2F.fromPoints(a, b, c);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append(a).append(b).append(c).toString();
  }
}
