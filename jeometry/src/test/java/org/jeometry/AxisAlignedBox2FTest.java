package org.jeometry;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AxisAlignedBox2FTest {
  @Test
  public void testContains() {
    AxisAlignedBox2F aab = AxisAlignedBox2F.fromPoints(Vector2F.UNIT_X, Vector2F.UNIT_Y);
    assertThat(aab.contains(new Vector2F(0.5f, 0.5f))).isTrue();
    assertThat(aab.contains(new Vector2F(-0.1f, 0.5f))).isFalse();
    assertThat(aab.contains(new Vector2F(1.1f, 0.5f))).isFalse();
    assertThat(aab.contains(new Vector2F(0.5f, -0.1f))).isFalse();
    assertThat(aab.contains(new Vector2F(0.5f, 1.1f))).isFalse();
  }

  @Test
  public void testPositiveIntersections() {
    AxisAlignedBox2F aab1 = AxisAlignedBox2F.fromMinAndMax(
        new Vector2F(0, 0),
        new Vector2F(10, 10));
    AxisAlignedBox2F aab2 = AxisAlignedBox2F.fromPoints(
        new Vector2F(4, 4),
        new Vector2F(6, 6));
    assertThat(aab1.intersects(aab1)).isTrue();
    assertThat(aab2.intersects(aab2)).isTrue();
    assertThat(aab1.intersects(aab2)).isTrue();
  }

  @Test
  public void testNegativeIntersection_xSeparation() {
    AxisAlignedBox2F aab1 = AxisAlignedBox2F.fromMinAndMax(
        new Vector2F(0, 0),
        new Vector2F(10, 10));
    AxisAlignedBox2F aab2 = AxisAlignedBox2F.fromPoints(
        new Vector2F(11, 0),
        new Vector2F(20, 10));
    assertThat(aab1.intersects(aab2)).isFalse();
    assertThat(aab2.intersects(aab1)).isFalse();
  }

  @Test
  public void testNegativeIntersection_ySeparation() {
    AxisAlignedBox2F aab1 = AxisAlignedBox2F.fromMinAndMax(
        new Vector2F(0, 0),
        new Vector2F(10, 10));
    AxisAlignedBox2F aab2 = AxisAlignedBox2F.fromPoints(
        new Vector2F(0, 11),
        new Vector2F(10, 20));
    assertThat(aab1.intersects(aab2)).isFalse();
    assertThat(aab2.intersects(aab1)).isFalse();
  }
}