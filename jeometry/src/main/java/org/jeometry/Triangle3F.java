package org.jeometry;

import java.util.HashSet;
import java.util.Set;

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

  public Set<LineSegment3F> getEdges() {
    Set<LineSegment3F> result = new HashSet<>();
    result.add(new LineSegment3F(a, b));
    result.add(new LineSegment3F(b, c));
    result.add(new LineSegment3F(c, a));
    return result;
  }

  /**
   * Returns a vector which is perpendicular to the plane of this triangle. The magnitude and
   * direction (among the two perpendicular directions) are undefined.
   */
  public Vector3F getNormal() {
    return b.minus(a).cross(c.minus(a));
  }

  public Vector3F getFirstIntersectionPoint(Ray3F ray) {
    ;
  }

  public AxisAlignedBox3F getBoundingBox() {
    return AxisAlignedBox3F.fromPoints(a, b, c);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append(a).append(b).append(c).toString();
  }
}
