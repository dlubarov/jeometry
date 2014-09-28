package org.jeometry;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class LineSegment3FTest {
  private static final Offset<Float> EPSILON = offset(0.01f);

  @Test
  public void testGetLength() {
    LineSegment3F line = new LineSegment3F(Vector3F.UNIT_X, Vector3F.UNIT_Y);
    assertThat(line.getLength()).isEqualTo(1.414f, EPSILON);
    assertThat(line.getLengthSquared()).isEqualTo(2, EPSILON);
  }

  @Test
  public void testGetClosestPointTo_inMiddle() {
    LineSegment3F line = new LineSegment3F(Vector3F.UNIT_X, Vector3F.UNIT_Y);
    Vector3F closestPoint = line.getClosestPointTo(Vector3F.ZERO);
    assertThat(closestPoint.x).isEqualTo(0.5f, EPSILON);
    assertThat(closestPoint.y).isEqualTo(0.5f, EPSILON);
  }

  @Test
  public void testGetClosestPointTo_atFirstVertex() {
    LineSegment3F line = new LineSegment3F(Vector3F.ZERO, Vector3F.UNIT_Y);
    Vector3F closestPoint = line.getClosestPointTo(new Vector3F(5, -1, 10));
    assertThat(closestPoint.x).isEqualTo(0, EPSILON);
    assertThat(closestPoint.y).isEqualTo(0, EPSILON);
  }

  @Test
  public void testGetClosestPointTo_atSecondVertex() {
    LineSegment3F line = new LineSegment3F(Vector3F.UNIT_X, Vector3F.UNIT_Y);
    Vector3F closestPoint = line.getClosestPointTo(new Vector3F(-5, 2, -7));
    assertThat(closestPoint.x).isEqualTo(0, EPSILON);
    assertThat(closestPoint.y).isEqualTo(1, EPSILON);
  }

  @Test
  public void testGetBoundingBox() {
    LineSegment3F line = new LineSegment3F(Vector3F.ZERO, new Vector3F(1, 1, 1));
    AxisAlignedBox3F boundingBox = line.getBoundingBox();
    assertThat(boundingBox.min.x).isEqualTo(0, EPSILON);
    assertThat(boundingBox.min.y).isEqualTo(0, EPSILON);
    assertThat(boundingBox.min.z).isEqualTo(0, EPSILON);
    assertThat(boundingBox.max.x).isEqualTo(1, EPSILON);
    assertThat(boundingBox.max.y).isEqualTo(1, EPSILON);
    assertThat(boundingBox.max.z).isEqualTo(1, EPSILON);
  }
}