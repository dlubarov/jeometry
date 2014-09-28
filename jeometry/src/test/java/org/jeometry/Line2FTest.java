package org.jeometry;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class Line2FTest {
  private static final Offset<Float> EPSILON = offset(0.01f);

  @Test
  public void testGetDirection_unitX() {
    Vector2F direction = new Line2F(Vector2F.ZERO, Vector2F.UNIT_X.scaled(123)).getDirection();
    assertThat(direction.x).isEqualTo(1, EPSILON);
    assertThat(direction.y).isEqualTo(0, EPSILON);
  }

  @Test
  public void testGetDirection_034() {
    Vector2F direction = new Line2F(new Vector2F(2, 3), new Vector2F(5, 7)).getDirection();
    assertThat(direction.x).isEqualTo(0.6f, EPSILON);
    assertThat(direction.y).isEqualTo(0.8f, EPSILON);
  }

  @Test
  public void testGetClosestPointTo() {
    Line2F line = new Line2F(Vector2F.UNIT_X, Vector2F.UNIT_Y);
    Vector2F closestPoint = line.getClosestPointTo(Vector2F.ZERO);
    assertThat(closestPoint.x).isEqualTo(0.5f, EPSILON);
    assertThat(closestPoint.y).isEqualTo(0.5f, EPSILON);
  }
}
