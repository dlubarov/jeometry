package org.jeometry;

/**
 * A (three dimensional) sphere, encoded with floats.
 */
public final class Sphere3F {
  final Vector3F center;
  final float radius;

  /**
   * Creates a sphere with the given center and radius.
   */
  public Sphere3F(Vector3F center, float radius) {
    Check.notNull(center, "center must not be null");
    Check.that(radius >= 0, "radius must be non-negative");
    this.center = center;
    this.radius = radius;
  }

  public Vector3F getCenter() {
    return center;
  }

  public float getRadius() {
    return radius;
  }

  public boolean contains(Vector3F point) {
    return center.distanceSquaredTo(point) < radius * radius;
  }

  public boolean intersects(Sphere3F that) {
    float combinedRadius = this.radius + that.radius;
    return this.center.distanceSquaredTo(that.center) < combinedRadius * combinedRadius;
  }

  public boolean intersects(Line3F line) {
    return line.getClosestPointTo(center).distanceSquaredTo(center) < radius * radius;
  }

  public boolean intersects(LineSegment3F line) {
    return line.getClosestPointTo(center).distanceSquaredTo(center) < radius * radius;
  }

  public boolean intersects(Ray3F ray) {
    return ray.getClosestPointTo(center).distanceSquaredTo(center) < radius * radius;
  }

  /**
   * If the ray intersects this circle, returns the intersection point that is closest to the ray's
   * origin. Otherwise, returns null.
   */
  public Vector3F getFirstIntersectionPoint(Ray3F ray) {
    if (contains(ray.origin)) return ray.origin;

    Vector3F centerToOrigin = ray.origin.minus(center);
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

  public AxisAlignedBox3F getBoundingBox() {
    Vector3F rrr = new Vector3F(radius, radius, radius);
    return new AxisAlignedBox3F(center.minus(rrr), center.plus(rrr));
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("center", center)
        .append("radius", radius)
        .toString();
  }
}
