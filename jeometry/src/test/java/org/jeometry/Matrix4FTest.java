package org.jeometry;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class Matrix4FTest {
  private static final Offset<Float> EPSILON = offset(0.01f);

  @Test
  public void testForTranslation() {
    Vector3F v = new Vector3F(10, 20, 30);
    Matrix4F translation = Matrix4F.forTranslation(1, 2, 3);
    v = translation.transform(v.addLastComponent(1)).dropLastComponent();
    assertThat(v.x).isEqualTo(11, EPSILON);
    assertThat(v.y).isEqualTo(22, EPSILON);
    assertThat(v.z).isEqualTo(33, EPSILON);
  }
}