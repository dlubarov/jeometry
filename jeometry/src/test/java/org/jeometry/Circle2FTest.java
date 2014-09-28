package org.jeometry;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class Circle2FTest {
  private static final Offset<Float> EPSILON = offset(0.01f);

  @Test
  public void testIntersectsCircle() {
    Line2F line = new Line2F(Vector2F.UNIT_X, Vector2F.UNIT_Y);
    assertThat(new Circle2F(Vector2F.ZERO, 0.8f).intersects(line)).isTrue();
    assertThat(new Circle2F(Vector2F.ZERO, 0.7f).intersects(line)).isFalse();
  }

  @Test
  public void testIntersectsLine() {
    // TODO
  }

  @Test
  public void testIntersectsLineSegment() {
    // TODO
  }

  @Test
  public void testGetFirstIntersectionPoint() {
    // TODO
  }

  @Test
  public void testGetBoundingBox() {
    AxisAlignedBox2F boundingBox = new Circle2F(Vector2F.UNIT_Y, 5).getBoundingBox();
    Vector2F min = boundingBox.getMin(), max = boundingBox.getMax();
    assertThat(min.x).isEqualTo(-5, EPSILON);
    assertThat(min.y).isEqualTo(-4, EPSILON);
    assertThat(max.x).isEqualTo(5, EPSILON);
    assertThat(max.y).isEqualTo(6, EPSILON);
  }
}