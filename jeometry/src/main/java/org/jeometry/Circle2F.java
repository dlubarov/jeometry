package org.jeometry;

/**
 * A (two dimensional) circle, encoded with floats.
 */
public final class Circle2F {
  final Vector2F center;
  final float radius;

  /**
   * Creates a circle with the given center and radius.
   */
  public Circle2F(Vector2F center, float radius) {
    this.center = center;
    this.radius = radius;
  }

  public Vector2F getCenter() {
    return center;
  }

  public float getRadius() {
    return radius;
  }

  public boolean contains(Vector2F point) {
    return center.distanceSquaredTo(point) < radius * radius;
  }

  public boolean intersects(Circle2F that) {
    float combinedRadius = this.radius + that.radius;
    return this.center.distanceSquaredTo(that.center) < combinedRadius * combinedRadius;
  }

  public boolean intersects(Line2F line) {
    return line.getClosestPointTo(center).distanceSquaredTo(center) < radius * radius;
  }

  public boolean intersects(LineSegment2F line) {
    return line.getClosestPointTo(center).distanceSquaredTo(center) < radius * radius;
  }

  public boolean intersects(Ray2F ray) {
    return ray.getClosestPointTo(center).distanceSquaredTo(center) < radius * radius;
  }

  /**
   * If the ray intersects this circle, returns the intersection point that is closest to the ray's
   * origin. Otherwise, returns null.
   */
  public Vector2F getFirstIntersectionPoint(Ray2F ray) {
    if (contains(ray.origin)) return ray.origin;

    Vector2F centerToOrigin = ray.origin.minus(center);
    float projection = ray.direction.dot(centerToOrigin);
    float insideSqrt = projection * projection
        - centerToOrigin.magnitudeSquared()
        + radius * radius;

    if (insideSqrt < 0) {
      // The line on which the ray lies does not intersect this circle.
      return null;
    }

    for (float sign : new float[] {-1, 1}) {
      float dist = -projection + sign * FloatMath.sqrt(insideSqrt);
      if (dist >= 0) return ray.getPoint(dist);
    }

    // The line on which the ray lies intersects this circle, but the intersections are behind the
    // ray's origin.
    return null;
  }

  public AxisAlignedBox2F getBoundingBox() {
    Vector2F rr = new Vector2F(radius, radius);
    return AxisAlignedBox2F.fromMinAndMax(center.minus(rr), center.plus(rr));
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("center", center)
        .append("radius", radius)
        .toString();
  }
}
