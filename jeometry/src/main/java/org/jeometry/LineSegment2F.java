package org.jeometry;

/**
 * A two dimensional line segment, encoded with floats.
 *
 * @see org.jeometry.Line2F
 */
public final class LineSegment2F {
  final Vector2F a, b;

  /**
   * Creates a line segment which runs between the given points.
   */
  public LineSegment2F(Vector2F a, Vector2F b) {
    this.a = a;
    this.b = b;
  }

  public Vector2F getFirstEndpoint() {
    return a;
  }

  public Vector2F getSecondEndpoint() {
    return b;
  }

  /**
   * Returns the (normalized) direction vector of this line segment. Since line segments are not
   * "directed" in the way rays are, they can be said to have two directions. This returns an
   * unspecified one of the two possible direction vectors.
   */
  public Vector2F getDirection() {
    return b.minus(a).normalized();
  }

  /**
   * Get the vector from the first endpoint to the second endpoint.
   */
  public Vector2F getDelta() {
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
   * Tests for an intersection against another line segment.
   */
  public boolean intersects(LineSegment2F that) {
    Vector2F p = this.a, q = that.a, r = this.getDelta(), s = that.getDelta();
    float t = q.minus(p).cross(s) / r.cross(s);
    float u = q.minus(p).cross(r) / r.cross(s);
    return 0 < t && t < 1 && 0 < u && u < 1;
  }

  /**
   * Find the closest point on this line segment to the given point.
   */
  public Vector2F getClosestPointTo(Vector2F p) {
    float t = p.minus(a).dot(getDelta()) / getLengthSquared();
    if (t < 0.0) return a;
    if (t > 1.0) return b;
    return a.plus(getDelta().scaled(t));
  }

  public AxisAlignedBox2F getBoundingBox() {
    return AxisAlignedBox2F.fromPoints(a, b);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append(a).append(b).toString();
  }
}
