package org.jeometry;

/**
 * A three dimensional box which is axis-aligned, that is, its edges are parallel to the Cartesian
 * coordinate axes. Encoded with floats.
 */
public final class AxisAlignedBox3F {
  final Vector3F min, max;

  AxisAlignedBox3F(Vector3F min, Vector3F max) {
    this.min = min;
    this.max = max;
  }

  /**
   * Creates an axis-aligned box with the given "min" and "max" vertices.
   */
  public static AxisAlignedBox3F fromMinAndMax(Vector3F min, Vector3F max) {
    Check.that(min.x <= max.x, "min.x must not exceed max.x");
    Check.that(min.y <= max.y, "min.y must not exceed max.y");
    Check.that(min.z <= max.z, "min.z must not exceed max.z");
    return new AxisAlignedBox3F(min, max);
  }

  /**
   * Creates an axis-aligned box enclosing the given points
   *
   * @param points the points to enclose; must contain at least one element
   * @return the smallest possible AAB which encloses the given points
   */
  public static AxisAlignedBox3F fromPoints(Vector3F... points) {
    Check.notNull(points, "array of points was null");
    Check.that(points.length > 0, "expected non-empty array of points");
    float minX = Float.MAX_VALUE, minY = Float.MAX_VALUE, minZ = Float.MAX_VALUE;
    float maxX = Float.MIN_VALUE, maxY = Float.MIN_VALUE, maxZ = Float.MIN_VALUE;
    for (Vector3F point : points) {
      Check.notNull(point, "array of points contained a null entry");
      minX = Math.min(minX, point.x);
      minY = Math.min(minY, point.y);
      minZ = Math.min(minZ, point.z);
      maxX = Math.max(maxX, point.x);
      maxY = Math.max(maxY, point.y);
      maxZ = Math.max(maxZ, point.z);
    }
    return new AxisAlignedBox3F(
        new Vector3F(minX, minY, minZ),
        new Vector3F(maxX, maxY, maxZ));
  }

  public boolean contains(Vector3F point) {
    return min.x <= point.x && point.x <= max.x
        && min.y <= point.y && point.y <= max.y
        && min.z <= point.z && point.z <= max.z;
  }

  public boolean intersects(AxisAlignedBox3F that) {
    return this.max.x >= that.min.x && this.min.x <= that.max.x
        && this.max.y >= that.min.y && this.min.y <= that.max.y
        && this.max.z >= that.min.z && this.min.z <= that.max.z;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("min", min)
        .append("max", max)
        .toString();
  }
}
