package org.jeometry;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class LineSegment2FTest {
  private static final Offset<Float> EPSILON = offset(0.01f);

  @Test
  public void testGetLength() {
    LineSegment2F line = new LineSegment2F(Vector2F.UNIT_X, Vector2F.UNIT_Y);
    assertThat(line.getLength()).isEqualTo(1.414f, EPSILON);
    assertThat(line.getLengthSquared()).isEqualTo(2, EPSILON);
  }

  @Test
  public void testPositiveLineIntersection() {
    LineSegment2F line1 = new LineSegment2F(new Vector2F(0, 0), new Vector2F(1, 1));
    LineSegment2F line2 = new LineSegment2F(new Vector2F(0, 1), new Vector2F(1, 0));
    assertThat(line1.intersects(line2)).isTrue();
    assertThat(line2.intersects(line1)).isTrue();
  }

  @Test
  public void testNegativeLineIntersection_parallelLines() {
    LineSegment2F line1 = new LineSegment2F(new Vector2F(0, 0), new Vector2F(10, 0));
    LineSegment2F line2 = new LineSegment2F(new Vector2F(0, 1), new Vector2F(10, 1));
    assertThat(line1.intersects(line2)).isFalse();
    assertThat(line2.intersects(line1)).isFalse();
  }

  @Test
  public void testGetClosestPointTo_inMiddle() {
    LineSegment2F line = new LineSegment2F(Vector2F.UNIT_X, Vector2F.UNIT_Y);
    Vector2F closestPoint = line.getClosestPointTo(Vector2F.ZERO);
    assertThat(closestPoint.x).isEqualTo(0.5f, EPSILON);
    assertThat(closestPoint.y).isEqualTo(0.5f, EPSILON);
  }

  @Test
  public void testGetClosestPointTo_atFirstVertex() {
    LineSegment2F line = new LineSegment2F(Vector2F.UNIT_X, Vector2F.UNIT_Y);
    Vector2F closestPoint = line.getClosestPointTo(new Vector2F(5, 0));
    assertThat(closestPoint.x).isEqualTo(1, EPSILON);
    assertThat(closestPoint.y).isEqualTo(0, EPSILON);
  }

  @Test
  public void testGetClosestPointTo_atSecondVertex() {
    LineSegment2F line = new LineSegment2F(Vector2F.UNIT_X, Vector2F.UNIT_Y);
    Vector2F closestPoint = line.getClosestPointTo(new Vector2F(-5, 1));
    assertThat(closestPoint.x).isEqualTo(0, EPSILON);
    assertThat(closestPoint.y).isEqualTo(1, EPSILON);
  }

  @Test
  public void testGetBoundingBox() {
    LineSegment2F line = new LineSegment2F(Vector2F.UNIT_X, Vector2F.UNIT_Y);
    AxisAlignedBox2F boundingBox = line.getBoundingBox();
    assertThat(boundingBox.min.x).isEqualTo(0, EPSILON);
    assertThat(boundingBox.min.y).isEqualTo(0, EPSILON);
    assertThat(boundingBox.max.x).isEqualTo(1, EPSILON);
    assertThat(boundingBox.max.y).isEqualTo(1, EPSILON);
  }
}