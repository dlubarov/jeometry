package org.jeometry;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class Triangle2FTest {
  private static final Offset<Float> EPSILON = offset(0.01f);

  @Test
  public void testGetBoundingBox() {
    Triangle2F triangle = new Triangle2F(Vector2F.UNIT_X, Vector2F.UNIT_Y, Vector2F.ZERO);
    AxisAlignedBox2F boundingBox = triangle.getBoundingBox();

    assertThat(boundingBox.min.x).isEqualTo(0, EPSILON);
    assertThat(boundingBox.min.y).isEqualTo(0, EPSILON);

    assertThat(boundingBox.max.x).isEqualTo(1, EPSILON);
    assertThat(boundingBox.max.y).isEqualTo(1, EPSILON);
  }
}