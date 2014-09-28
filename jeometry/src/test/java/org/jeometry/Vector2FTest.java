package org.jeometry;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class Vector2FTest {
  private static final Offset<Float> EPSILON = offset(0.01f);

  @Test
  public void testDistanceTo() {
    assertThat(Vector2F.UNIT_X.distanceTo(Vector2F.UNIT_Y)).isEqualTo(1.414f, EPSILON);
  }

  @Test
  public void testNormalized() {
    Vector2F normalized = new Vector2F(1, 2).normalized();
    assertThat(normalized.x).isEqualTo(0.447f, EPSILON);
    assertThat(normalized.y).isEqualTo(0.894f, EPSILON);
  }

  @Test
  public void testDot_orthogonal() {
    assertThat(Vector2F.UNIT_X.dot(Vector2F.UNIT_Y)).isEqualTo(0, EPSILON);
    assertThat(Vector2F.UNIT_Y.dot(Vector2F.UNIT_X)).isEqualTo(0, EPSILON);
  }

  @Test
  public void testDot_parallel() {
    assertThat(Vector2F.UNIT_X.dot(Vector2F.UNIT_X)).isEqualTo(1, EPSILON);
    assertThat(Vector2F.UNIT_Y.dot(Vector2F.UNIT_Y)).isEqualTo(1, EPSILON);
    assertThat(new Vector2F(2, 3).dot(new Vector2F(4, 6))).isEqualTo(26, EPSILON);
  }

  @Test
  public void testCross_orthogonal() {
    assertThat(Vector2F.UNIT_X.cross(Vector2F.UNIT_Y)).isEqualTo(1);
    assertThat(Vector2F.UNIT_Y.cross(Vector2F.UNIT_X)).isEqualTo(-1);
  }

  @Test
  public void testCross_parallel() {
    assertThat(Vector2F.UNIT_X.cross(Vector2F.UNIT_X)).isEqualTo(0);
    assertThat(Vector2F.UNIT_Y.cross(Vector2F.UNIT_Y)).isEqualTo(0);
  }
}