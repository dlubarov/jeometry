package org.jeometry;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class Line3FTest {
  private static final Offset<Float> EPSILON = offset(0.01f);

  @Test
  public void testGetDirection_unitX() {
    Vector3F direction = new Line3F(Vector3F.ZERO, Vector3F.UNIT_X.scaled(123)).getDirection();
    assertThat(direction.x).isEqualTo(1, EPSILON);
    assertThat(direction.y).isEqualTo(0, EPSILON);
    assertThat(direction.z).isEqualTo(0, EPSILON);
  }

  @Test
  public void testGetDirection_034() {
    Vector3F direction = new Line3F(new Vector3F(1, 2, 3), new Vector3F(1, 5, 7)).getDirection();
    assertThat(direction.x).isEqualTo(0.0f, EPSILON);
    assertThat(direction.y).isEqualTo(0.6f, EPSILON);
    assertThat(direction.z).isEqualTo(0.8f, EPSILON);
  }

  @Test
  public void testGetClosestPointTo() {
    Line3F line = new Line3F(Vector3F.UNIT_X, Vector3F.UNIT_Z);
    Vector3F closestPoint = line.getClosestPointTo(Vector3F.ZERO);
    assertThat(closestPoint.x).isEqualTo(0.5f, EPSILON);
    assertThat(closestPoint.y).isEqualTo(0.0f, EPSILON);
    assertThat(closestPoint.z).isEqualTo(0.5f, EPSILON);
  }
}
