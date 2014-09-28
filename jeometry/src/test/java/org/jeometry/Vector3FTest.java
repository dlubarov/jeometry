package org.jeometry;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class Vector3FTest {
  private static final Offset<Float> EPSILON = offset(0.01f);

  @Test
  public void testMagnitude() {
    assertThat(Vector3F.ZERO.magnitude()).isEqualTo(0, EPSILON);
    assertThat(Vector3F.UNIT_X.magnitude()).isEqualTo(1, EPSILON);
    assertThat(new Vector3F(1, 1, 1).magnitude()).isEqualTo(1.732f, EPSILON);
  }

  @Test
  public void testDistanceTo() {
    assertThat(Vector3F.UNIT_X.distanceTo(Vector3F.UNIT_X)).isEqualTo(0, EPSILON);
    assertThat(Vector3F.ZERO.distanceTo(Vector3F.UNIT_X)).isEqualTo(1, EPSILON);
    assertThat(Vector3F.ZERO.distanceTo(new Vector3F(1, 1, 1))).isEqualTo(1.732f, EPSILON);
  }

  @Test(expected = RuntimeException.class)
  public void testNormalized_zero() {
    Vector3F.ZERO.normalized();
  }

  @Test
  public void testNormalized_unitX() {
    Vector3F normalized = Vector3F.UNIT_X.scaled(123).normalized();
    assertThat(normalized.x).isEqualTo(1, EPSILON);
    assertThat(normalized.y).isEqualTo(0, EPSILON);
    assertThat(normalized.z).isEqualTo(0, EPSILON);
  }

  @Test
  public void testDot_zero() {
    assertThat(Vector3F.ZERO.dot(Vector3F.UNIT_X)).isEqualTo(0, EPSILON);
    assertThat(Vector3F.ZERO.dot(Vector3F.UNIT_Y)).isEqualTo(0, EPSILON);
    assertThat(Vector3F.ZERO.dot(Vector3F.UNIT_Z)).isEqualTo(0, EPSILON);
  }

  @Test
  public void testDot_unitVectors() {
    assertThat(Vector3F.UNIT_X.dot(Vector3F.UNIT_Y)).isEqualTo(0, EPSILON);
    assertThat(Vector3F.UNIT_Y.dot(Vector3F.UNIT_Z)).isEqualTo(0, EPSILON);
    assertThat(Vector3F.UNIT_Z.dot(Vector3F.UNIT_X)).isEqualTo(0, EPSILON);
  }

  @Test
  public void testCross_unitXCrossUnitY() {
    Vector3F crossProduct = Vector3F.UNIT_X.cross(Vector3F.UNIT_Y);
    assertThat(crossProduct.x).isEqualTo(0, EPSILON);
    assertThat(crossProduct.y).isEqualTo(0, EPSILON);
    assertThat(crossProduct.z).isEqualTo(1, EPSILON);
  }

  @Test
  public void testCross_unitYCrossUnitX() {
    Vector3F crossProduct = Vector3F.UNIT_Y.cross(Vector3F.UNIT_X);
    assertThat(crossProduct.x).isEqualTo(0, EPSILON);
    assertThat(crossProduct.y).isEqualTo(0, EPSILON);
    assertThat(crossProduct.z).isEqualTo(-1, EPSILON);
  }

  @Test
  public void testCross_unitXCrossUnitX() {
    Vector3F crossProduct = Vector3F.UNIT_X.cross(Vector3F.UNIT_X);
    assertThat(crossProduct.x).isEqualTo(0, EPSILON);
    assertThat(crossProduct.y).isEqualTo(0, EPSILON);
    assertThat(crossProduct.z).isEqualTo(0, EPSILON);
  }
}