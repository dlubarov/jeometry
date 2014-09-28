package org.jeometry;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AxisAlignedBox3FTest {
  @Test
  public void testContains() {
    AxisAlignedBox3F aab = AxisAlignedBox3F.fromPoints(
        Vector3F.UNIT_X, Vector3F.UNIT_Y, Vector3F.UNIT_Z);
    assertThat(aab.contains(new Vector3F(0.5f, 0.5f, 0.5f))).isTrue();
    assertThat(aab.contains(new Vector3F(-0.1f, 0.5f, 0.5f))).isFalse();
    assertThat(aab.contains(new Vector3F(1.1f, 0.5f, 0.5f))).isFalse();
    assertThat(aab.contains(new Vector3F(0.5f, -0.1f, 0.5f))).isFalse();
    assertThat(aab.contains(new Vector3F(0.5f, 1.1f, 0.5f))).isFalse();
    assertThat(aab.contains(new Vector3F(0.5f, 0.5f, -0.1f))).isFalse();
    assertThat(aab.contains(new Vector3F(0.5f, 0.5f, 1.1f))).isFalse();
  }

  @Test
  public void testPositiveIntersections() {
    AxisAlignedBox3F aab1 = AxisAlignedBox3F.fromMinAndMax(
        new Vector3F(0, 0, 0),
        new Vector3F(10, 10, 10));
    AxisAlignedBox3F aab2 = AxisAlignedBox3F.fromPoints(
        new Vector3F(4, 4, 4),
        new Vector3F(6, 6, 6));
    assertThat(aab1.intersects(aab1)).isTrue();
    assertThat(aab2.intersects(aab2)).isTrue();
    assertThat(aab1.intersects(aab2)).isTrue();
  }

  @Test
  public void testNegativeIntersection_xSeparation() {
    AxisAlignedBox3F aab1 = AxisAlignedBox3F.fromMinAndMax(
        new Vector3F(0, 0, 0),
        new Vector3F(10, 10, 10));
    AxisAlignedBox3F aab2 = AxisAlignedBox3F.fromPoints(
        new Vector3F(11, 0, 0),
        new Vector3F(20, 10, 10));
    assertThat(aab1.intersects(aab2)).isFalse();
    assertThat(aab2.intersects(aab1)).isFalse();
  }

  @Test
  public void testNegativeIntersection_ySeparation() {
    AxisAlignedBox3F aab1 = AxisAlignedBox3F.fromMinAndMax(
        new Vector3F(0, 0, 0),
        new Vector3F(10, 10, 10));
    AxisAlignedBox3F aab2 = AxisAlignedBox3F.fromPoints(
        new Vector3F(0, 11, 0),
        new Vector3F(10, 20, 10));
    assertThat(aab1.intersects(aab2)).isFalse();
    assertThat(aab2.intersects(aab1)).isFalse();
  }

  @Test
  public void testNegativeIntersection_zSeparation() {
    AxisAlignedBox3F aab1 = AxisAlignedBox3F.fromMinAndMax(
        new Vector3F(0, 0, 0),
        new Vector3F(10, 10, 10));
    AxisAlignedBox3F aab2 = AxisAlignedBox3F.fromPoints(
        new Vector3F(0, 0, 11),
        new Vector3F(10, 10, 20));
    assertThat(aab1.intersects(aab2)).isFalse();
    assertThat(aab2.intersects(aab1)).isFalse();
  }
}