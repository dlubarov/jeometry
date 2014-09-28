package org.jeometry;

/**
 * A right circular cylinder, encoded with floats.
 */
public class Cylinder3F {
  final LineSegment3F centerLine;
  final float radius;

  public Cylinder3F(LineSegment3F centerLine, float radius) {
    this.centerLine = centerLine;
    this.radius = radius;
  }

  /**
   * Get the line running through the center of this cylinder, from one "cap" to the other.
   */
  public LineSegment3F getCenterLine() {
    return centerLine;
  }

  /**
   * Get the distance between the "caps" of this cylinder.
   */
  public float getHeight() {
    return centerLine.getLength();
  }

  /**
   * Get the radius of the circular cross section of this cylinder.
   */
  public float getRadius() {
    return radius;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("centerLine", centerLine)
        .append("radius", radius)
        .toString();
  }
}
