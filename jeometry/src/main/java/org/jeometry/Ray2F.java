package org.jeometry;

/**
 * A two dimensional ray, encoded with floats.
 */
public final class Ray2F {
  /**
   * The starting point of the ray.
   */
  final Vector2F origin;

  /**
   * The ray's NORMALIZED direction vector.
   */
  final Vector2F direction;

  /**
   * Get the starting point of this ray.
   */
  public Vector2F getOrigin() {
    return origin;
  }

  /**
   * Get the (normalized) direction vector of this ray.
   */
  public Vector2F getDirection() {
    return direction;
  }

  /**
   * Creates a new ray with a given origin and direction.
   *
   * @param origin the starting point of the ray
   * @param direction the ray's NORMALIZED direction vector
   */
  Ray2F(Vector2F origin, Vector2F direction) {
    this.origin = origin;
    this.direction = direction;
  }

  /**
   * Creates a new ray with a given origin and direction.
   *
   * @param origin the starting point of the ray
   * @param direction the ray's direction vector; does not need to be normalized
   * @return the ray represented by this origin and direction
   */
  public static Ray2F fromOriginAndDirection(Vector2F origin, Vector2F direction) {
    return new Ray2F(origin, direction.normalized());
  }

  public Vector2F getPoint(float distanceFromOrigin) {
    Check.that(distanceFromOrigin >= 0, "distance must be non-negative");
    return origin.plus(direction.scaled(distanceFromOrigin));
  }

  /**
   * Find the closest point on this ray to the given point.
   */
  public Vector2F getClosestPointTo(Vector2F p) {
    float t = p.minus(origin).dot(direction);
    if (t < 0.0) return origin;
    return origin.plus(direction.scaled(t));
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("origin", origin)
        .append("direction", direction)
        .toString();
  }
}
