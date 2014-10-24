package org.jeometry;

import java.util.HashSet;
import java.util.Set;

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

  public Set<LineSegment2F> getEdges() {
    Set<LineSegment2F> result = new HashSet<>();
    result.add(new LineSegment2F(a, b));
    result.add(new LineSegment2F(b, c));
    result.add(new LineSegment2F(c, a));
    return result;
  }

  public boolean contains(Vector2F point) {
    boolean sideA = getSideOfPoint(point, a, b);
    boolean sideB = getSideOfPoint(point, b, c);
    boolean sideC = getSideOfPoint(point, c, a);
    return sideA == sideB && sideB == sideC;
  }

  public Vector2F getFirstIntersectionPoint(Ray2F ray) {
    ;
  }

  public AxisAlignedBox2F getBoundingBox() {
    return AxisAlignedBox2F.fromPoints(a, b, c);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append(a).append(b).append(c).toString();
  }

  private static boolean getSideOfPoint(Vector2F point, Vector2F lineA, Vector2F lineB) {
    return (point.x - lineB.x) * (lineA.y - lineB.y) - (lineA.x - lineB.x) * (point.y - lineB.y) < 0;
  }
}
