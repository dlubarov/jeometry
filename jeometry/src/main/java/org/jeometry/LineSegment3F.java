package org.jeometry;

/**
 * A three dimensional line segment, encoded with floats.
 */
public final class LineSegment3F {
  final Vector3F a, b;

  /**
   * Creates a line segment between the given points.
   *
   * @param a the first point of the line
   * @param b the second point of the line
   */
  public LineSegment3F(Vector3F a, Vector3F b) {
    this.a = a;
    this.b = b;
  }

  public Vector3F getFirstEndpoint() {
    return a;
  }

  public Vector3F getSecondEndpoint() {
    return b;
  }

  /**
   * Returns the (normalized) direction vector of this line segment. Since line segments are not
   * "directed" in the way rays are, they can be said to have two directions. This returns an
   * unspecified one of the two possible direction vectors.
   */
  public Vector3F getDirection() {
    return b.minus(a).normalized();
  }

  /**
   * Get the vector from the first endpoint to the second endpoint.
   */
  public Vector3F getDelta() {
    return b.minus(a);
  }

  /**
   * Get the l^2 Euclidean distance between the two endpoints.
   */
  public float getLength() {
    return getDelta().magnitude();
  }

  /**
   * Get the square of the l^2 Euclidean distance between the two endpoints.
   */
  public float getLengthSquared() {
    return getDelta().magnitudeSquared();
  }

  /**
   * Find the closest point on this line segment to the given point.
   */
  public Vector3F getClosestPointTo(Vector3F p) {
    float t = p.minus(a).dot(getDelta()) / getLengthSquared();
    if (t < 0.0) return a;
    if (t > 1.0) return b;
    return a.plus(getDelta().scaled(t));
  }

  public AxisAlignedBox3F getBoundingBox() {
    return AxisAlignedBox3F.fromPoints(a, b);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append(a).append(b).toString();
  }
}
