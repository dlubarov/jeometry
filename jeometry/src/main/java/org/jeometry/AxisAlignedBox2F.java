package org.jeometry;

/**
 * A two dimensional box which is axis-aligned, that is, its edges are parallel to the Cartesian
 * coordinate axes. Encoded with floats.
 */
public final class AxisAlignedBox2F {
  final Vector2F min, max;

  AxisAlignedBox2F(Vector2F min, Vector2F max) {
    this.min = min;
    this.max = max;
  }

  /**
   * Creates an axis-aligned box with the given "min" and "max" vertices.
   */
  public static AxisAlignedBox2F fromMinAndMax(Vector2F min, Vector2F max) {
    Check.that(min.x <= max.x, "min.x must not exceed max.x");
    Check.that(min.y <= max.y, "min.y must not exceed max.y");
    return new AxisAlignedBox2F(min, max);
  }

  /**
   * Creates an axis-aligned box enclosing the given points
   *
   * @param points the points to enclose; must contain at least one element
   * @return the smallest possible AAB which encloses the given points
   */
  public static AxisAlignedBox2F fromPoints(Vector2F... points) {
    Check.notNull(points, "array of points was null");
    Check.that(points.length > 0, "expected non-empty array of points");
    float minX = Float.MAX_VALUE, minY = Float.MAX_VALUE;
    float maxX = Float.MIN_VALUE, maxY = Float.MIN_VALUE;
    for (Vector2F point : points) {
      Check.notNull(point, "array of points contained a null entry");
      minX = Math.min(minX, point.x);
      minY = Math.min(minY, point.y);
      maxX = Math.max(maxX, point.x);
      maxY = Math.max(maxY, point.y);
    }
    return new AxisAlignedBox2F(
        new Vector2F(minX, minY),
        new Vector2F(maxX, maxY));
  }

  public Vector2F getMin() {
    return min;
  }

  public Vector2F getMax() {
    return max;
  }

  public boolean contains(Vector2F point) {
    return min.x <= point.x && point.x <= max.x
        && min.y <= point.y && point.y <= max.y;
  }

  public boolean intersects(AxisAlignedBox2F that) {
    return this.max.x >= that.min.x && this.min.x <= that.max.x
        && this.max.y >= that.min.y && this.min.y <= that.max.y;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("min", min)
        .append("max", max)
        .toString();
  }
}
