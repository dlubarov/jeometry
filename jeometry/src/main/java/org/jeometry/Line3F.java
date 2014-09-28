package org.jeometry;

/**
 * A two dimensional line, encoded with floats.
 *
 * @see LineSegment3F
 */
public final class Line3F {
  final Vector3F a, b;

  /**
   * Creates a line which runs between the given points.
   */
  public Line3F(Vector3F a, Vector3F b) {
    this.a = a;
    this.b = b;
  }

  /**
   * Returns some point on this line.
   */
  public Vector3F getPoint() {
    return a;
  }

  /**
   * Returns the (normalized) direction vector of this line. Since lines are not "directed" in the
   * way rays are, they can be said to have two directions. This returns an unspecified one of the
   * two possible direction vectors.
   */
  public Vector3F getDirection() {
    return b.minus(a).normalized();
  }

  /**
   * Like {@link #getDirection()}, but without normalization. This is faster, and should be used
   * when normalization is not required.
   */
  public Vector3F getUnnormalizedDirection() {
    return b.minus(a);
  }

  /**
   * Find the closest point on this line segment to the given point.
   */
  public Vector3F getClosestPointTo(Vector3F p) {
    Vector3F delta = b.minus(a);
    float t = p.minus(a).dot(delta) / delta.magnitudeSquared();
    return a.plus(delta.scaled(t));
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("point", a)
        .append("direction", getDirection())
        .toString();
  }
}
