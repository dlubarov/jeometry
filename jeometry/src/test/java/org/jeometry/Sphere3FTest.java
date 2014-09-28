package org.jeometry;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class Sphere3FTest {
  private static final Offset<Float> EPSILON = offset(0.01f);

  @Test
  public void testIntersectsSphere_positive() {
    Sphere3F sphere1 = new Sphere3F(new Vector3F(0, 0, 0), 1);
    Sphere3F sphere2 = new Sphere3F(new Vector3F(1, 1, 1), 0.8f);
    assertThat(sphere1.intersects(sphere1)).isTrue();
    assertThat(sphere2.intersects(sphere2)).isTrue();
    assertThat(sphere1.intersects(sphere2)).isTrue();
    assertThat(sphere2.intersects(sphere1)).isTrue();
  }

  @Test
  public void testIntersectsSphere_negative() {
    Sphere3F sphere1 = new Sphere3F(new Vector3F(0, 0, 0), 1);
    Sphere3F sphere2 = new Sphere3F(new Vector3F(1, 1, 1), 0.7f);
    assertThat(sphere1.intersects(sphere2)).isFalse();
    assertThat(sphere2.intersects(sphere1)).isFalse();
  }

  @Test
  public void testIntersectsLine() {
    Sphere3F sphere = new Sphere3F(new Vector3F(0, 0, 0), 1);
    assertThat(sphere.intersects(new Line3F(Vector3F.ZERO, Vector3F.UNIT_X))).isTrue();
    assertThat(sphere.intersects(new Line3F(Vector3F.UNIT_X, Vector3F.UNIT_Y))).isTrue();
    assertThat(sphere.intersects(new Line3F(Vector3F.UNIT_X, Vector3F.UNIT_Y))).isTrue();
    assertThat(sphere.intersects(new Line3F(Vector3F.UNIT_X.scaled(2), Vector3F.UNIT_Y.scaled(2))))
        .isFalse();
  }

  @Test
  public void testIntersectsLineSegment() {
    Sphere3F sphere = new Sphere3F(new Vector3F(0, 0, 0), 1);
    assertThat(sphere.intersects(new LineSegment3F(Vector3F.ZERO, Vector3F.UNIT_X))).isTrue();
    assertThat(sphere.intersects(new LineSegment3F(Vector3F.UNIT_X, Vector3F.UNIT_Y))).isTrue();
    assertThat(sphere.intersects(new LineSegment3F(Vector3F.UNIT_X, Vector3F.UNIT_Y))).isTrue();
    assertThat(sphere.intersects(new LineSegment3F(Vector3F.UNIT_X.scaled(2), Vector3F.UNIT_Y.scaled(2))))
        .isFalse();
    // TODO: Add case where an unbounded line would intersect, but a line segment doesn't.
  }

  @Test
  public void testGetFirstIntersectionPoint() {
    // TODO
  }

  @Test
  public void testGetBoundingBox() {
    Sphere3F sphere = new Sphere3F(new Vector3F(0, 0, 0), 5);
    AxisAlignedBox3F boundingBox = sphere.getBoundingBox();
    assertThat(boundingBox.min.x).isEqualTo(-5, EPSILON);
    assertThat(boundingBox.min.y).isEqualTo(-5, EPSILON);
    assertThat(boundingBox.min.z).isEqualTo(-5, EPSILON);
    assertThat(boundingBox.max.x).isEqualTo(5, EPSILON);
    assertThat(boundingBox.max.y).isEqualTo(5, EPSILON);
    assertThat(boundingBox.max.z).isEqualTo(5, EPSILON);
  }
}