package org.jeometry;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class Ray2FTest {
  private static final Offset<Float> EPSILON = offset(0.01f);

  @Test
  public void testFromOriginAndDirection() {
    Ray2F ray = Ray2F.fromOriginAndDirection(Vector2F.ZERO, new Vector2F(3, 4));
    Vector2F direction = ray.direction;
    assertThat(direction.x).isEqualTo(0.6f, EPSILON);
    assertThat(direction.y).isEqualTo(0.8f, EPSILON);
  }

  @Test
  public void testGetClosestPointTo_behindOrigin() {
    Ray2F ray = Ray2F.fromOriginAndDirection(Vector2F.ZERO, Vector2F.UNIT_X);
    Vector2F closestPoint = ray.getClosestPointTo(new Vector2F(-1, -1));
    assertThat(closestPoint.x).isEqualTo(0, EPSILON);
    assertThat(closestPoint.y).isEqualTo(0, EPSILON);
  }

  @Test
  public void testGetClosestPointTo_aheadOfOrigin() {
    Ray2F ray = Ray2F.fromOriginAndDirection(Vector2F.ZERO, Vector2F.UNIT_X);
    Vector2F closestPoint = ray.getClosestPointTo(new Vector2F(1, 1));
    assertThat(closestPoint.x).isEqualTo(1, EPSILON);
    assertThat(closestPoint.y).isEqualTo(0, EPSILON);
  }
}
