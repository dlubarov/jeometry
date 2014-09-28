package org.jeometry;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class Matrix3FTest {
  private static final Offset<Float> EPSILON = offset(0.01f);

  @Test
  public void testForTranslation() {
    Matrix3F translation = Matrix3F.forTranslation(1, 2);
    Vector2F v = new Vector2F(10, 20);
    v = translation.transform(v.addLastComponent(1)).dropLastComponent();
    assertThat(v.x).isEqualTo(11, EPSILON);
    assertThat(v.y).isEqualTo(22, EPSILON);
  }

  @Test
  public void testForRotationX() {
    Vector3F result = Matrix3F.forRotationX(FloatMath.PI / 2)
        .transform(new Vector3F(1, 2, 3));
    assertThat(result.x).isEqualTo(1, EPSILON);
    assertThat(result.y).isEqualTo(-3, EPSILON);
    assertThat(result.z).isEqualTo(2, EPSILON);
  }

  @Test
  public void testForRotationY() {
    Vector3F result = Matrix3F.forRotationY(FloatMath.PI / 2)
        .transform(new Vector3F(1, 2, 3));
    assertThat(result.x).isEqualTo(3, EPSILON);
    assertThat(result.y).isEqualTo(2, EPSILON);
    assertThat(result.z).isEqualTo(-1, EPSILON);
  }

  @Test
  public void testForRotationZ() {
    Vector3F result = Matrix3F.forRotationZ(FloatMath.PI / 2)
        .transform(new Vector3F(1, 2, 3));
    assertThat(result.x).isEqualTo(-2, EPSILON);
    assertThat(result.y).isEqualTo(1, EPSILON);
    assertThat(result.z).isEqualTo(3, EPSILON);
  }
}