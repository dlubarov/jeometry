package org.jeometry;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class Polygon3FTest {
  private static final Offset<Float> EPSILON = offset(0.01f);

  @Test
  public void testImmutability() {
    Vector3F[] vertices = new Vector3F[] {Vector3F.ZERO, Vector3F.ZERO, Vector3F.ZERO};
    Polygon3F polygon = Polygon3F.of(vertices);

    vertices[0] = Vector3F.UNIT_X;
    assertThat(polygon.getVertices()[0].getX()).isEqualTo(0, EPSILON);

    polygon.getVertices()[0] = Vector3F.UNIT_X;
    assertThat(polygon.getVertices()[0].getX()).isEqualTo(0, EPSILON);
  }

  @Test
  public void testGetBoundingBox() {
    Polygon3F polygon = Polygon3F.of(Vector3F.UNIT_X, Vector3F.UNIT_Y, Vector3F.UNIT_Z);
    AxisAlignedBox3F boundingBox = polygon.getBoundingBox();

    assertThat(boundingBox.min.x).isEqualTo(0, EPSILON);
    assertThat(boundingBox.min.y).isEqualTo(0, EPSILON);
    assertThat(boundingBox.min.z).isEqualTo(0, EPSILON);

    assertThat(boundingBox.max.x).isEqualTo(1, EPSILON);
    assertThat(boundingBox.max.y).isEqualTo(1, EPSILON);
    assertThat(boundingBox.max.z).isEqualTo(1, EPSILON);
  }
}