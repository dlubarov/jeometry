package org.jeometry;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class Triangle3FTest {
  private static final Offset<Float> EPSILON = offset(0.01f);

  @Test
  public void testGetBoundingBox() {
    Triangle3F triangle = new Triangle3F(Vector3F.UNIT_X, Vector3F.UNIT_Y, Vector3F.UNIT_Z);
    AxisAlignedBox3F boundingBox = triangle.getBoundingBox();

    assertThat(boundingBox.min.x).isEqualTo(0, EPSILON);
    assertThat(boundingBox.min.y).isEqualTo(0, EPSILON);
    assertThat(boundingBox.min.z).isEqualTo(0, EPSILON);

    assertThat(boundingBox.max.x).isEqualTo(1, EPSILON);
    assertThat(boundingBox.max.y).isEqualTo(1, EPSILON);
    assertThat(boundingBox.max.z).isEqualTo(1, EPSILON);
  }
}