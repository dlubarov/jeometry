package org.jeometry;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class Matrix2FTest {
  private static final Offset<Float> EPSILON = offset(0.01f);

  @Test
  public void testForRotation() {
    Vector2F result = Matrix2F.forRotation(FloatMath.PI / 2)
        .transform(new Vector2F(1, 2));
    assertThat(result.x).isEqualTo(-2, EPSILON);
    assertThat(result.y).isEqualTo(1, EPSILON);
  }

  @Test
  public void testTimes() {
    Matrix2F a = new Matrix2F(1, 2, 3, 4);
    Matrix2F b = new Matrix2F(2, 0, 1, 2);
    Matrix2F aTimesB = a.times(b), bTimesA = b.times(a);

    assertThat(aTimesB.a11).isEqualTo(4, EPSILON);
    assertThat(aTimesB.a12).isEqualTo(4, EPSILON);
    assertThat(aTimesB.a21).isEqualTo(10, EPSILON);
    assertThat(aTimesB.a22).isEqualTo(8, EPSILON);

    assertThat(bTimesA.a11).isEqualTo(2, EPSILON);
    assertThat(bTimesA.a12).isEqualTo(4, EPSILON);
    assertThat(bTimesA.a21).isEqualTo(7, EPSILON);
    assertThat(bTimesA.a22).isEqualTo(10, EPSILON);
  }

  @Test
  public void testTimes_identity() {
    Matrix2F a = new Matrix2F(1, 2, 3, 4);
    Matrix2F aTimesI = a.times(Matrix2F.IDENTITY), iTimesA = Matrix2F.IDENTITY.times(a);

    assertThat(aTimesI.a11).isEqualTo(1, EPSILON);
    assertThat(aTimesI.a12).isEqualTo(2, EPSILON);
    assertThat(aTimesI.a21).isEqualTo(3, EPSILON);
    assertThat(aTimesI.a22).isEqualTo(4, EPSILON);

    assertThat(iTimesA.a11).isEqualTo(1, EPSILON);
    assertThat(iTimesA.a12).isEqualTo(2, EPSILON);
    assertThat(iTimesA.a21).isEqualTo(3, EPSILON);
    assertThat(iTimesA.a22).isEqualTo(4, EPSILON);
  }
}