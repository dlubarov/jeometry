package org.jeometry;

/**
 * An immutable four dimensional spacial vector, encoded with floats.
 */
public final class Vector4F {
  public static final Vector4F
      ZERO = new Vector4F(0, 0, 0, 0),
      UNIT_X = new Vector4F(1, 0, 0, 0),
      UNIT_Y = new Vector4F(0, 1, 0, 0),
      UNIT_Z = new Vector4F(0, 0, 1, 0),
      UNIT_W = new Vector4F(0, 0, 0, 1);

  final float x, y, z, w;

  /**
   * Creates a new vector with the given components.
   *
   * @param x the first (x) component
   * @param y the second (y) component
   * @param z the third (z) component
   * @param w the fourth (w) component
   */
  public Vector4F(float x, float y, float z, float w) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.w = w;
  }

  /**
   * Get the first (x) component of this vector.
   */
  public float getX() {
    return x;
  }

  /**
   * Get the second (y) component of this vector.
   */
  public float getY() {
    return y;
  }

  /**
   * Get the third (z) component of this vector.
   */
  public float getZ() {
    return z;
  }

  /**
   * Get the fourth (w) component of this vector.
   */
  public float getW() {
    return w;
  }

  /**
   * Replaces this vector's x component with another value.
   *
   * @param x the new x component
   * @return a new vector with the given x component
   */
  public Vector4F withX(float x) {
    return new Vector4F(x, y, z, w);
  }

  /**
   * Replaces this vector's y component with another value.
   *
   * @param y the new y component
   * @return a new vector with the given y component
   */
  public Vector4F withY(float y) {
    return new Vector4F(x, y, z, w);
  }

  /**
   * Replaces this vector's z component with another value.
   *
   * @param z the new z component
   * @return a new vector with the given x component
   */
  public Vector4F withZ(float z) {
    return new Vector4F(x, y, z, w);
  }

  /**
   * Replaces this vector's w component with another value.
   *
   * @param w the new w component
   * @return a new vector with the given x component
   */
  public Vector4F withW(float w) {
    return new Vector4F(x, y, z, w);
  }

  /**
   * Returns the opposite of this vector, in particular, with each component negated.
   *
   * @return the opposite vector
   */
  public Vector4F opposite() {
    return new Vector4F(-x, -y, -z, -w);
  }

  /**
   * Multiplies each component of this vector by some scalar and returns the result.
   *
   * @param s the scalar to multiply by
   * @return the scaled vector
   */
  public Vector4F scaled(float s) {
    return new Vector4F(s * x, s * y, s * z, s * w);
  }

  /**
   * The l^2 Euclidean norm of this vector.
   */
  public float magnitude() {
    return FloatMath.sqrt(x * x + y * y + z * z + w * w);
  }

  /**
   * The square of the l^2 Euclidean norm of this vector.
   */
  public float magnitudeSquared() {
    return x * x + y * y + z * z + w * w;
  }

  /**
   * Adds a given vector to this vector.
   *
   * @param that the vector to add
   * @return the sum
   */
  public Vector4F plus(Vector4F that) {
    return new Vector4F(this.x + that.x, this.y + that.y, this.z + that.z, this.w - that.w);
  }

  /**
   * Subtracts a given vector from this vector.
   *
   * @param that the vector to subtract
   * @return the difference
   */
  public Vector4F minus(Vector4F that) {
    return new Vector4F(this.x - that.x, this.y - that.y, this.z - that.z, this.w - that.w);
  }

  /**
   * Computes the l^2 Euclidean distance from this vector to the given vector.
   *
   * @param that the other vector
   * @return the Euclidean distance between the vectors
   */
  public float distanceTo(Vector4F that) {
    return this.minus(that).magnitude();
  }

  /**
   * Computes the square of the l^2 Euclidean distance from this vector to the given vector.
   *
   * @param that the other vector
   * @return the Euclidean distance between the vectors
   */
  public float distanceSquaredTo(Vector4F that) {
    return this.minus(that).magnitudeSquared();
  }

  /**
   * Normalize this vector.
   *
   * @return the normalized vector, having the original vector's direction and a magnitude of 1
   */
  public Vector4F normalized() {
    return this.scaled(1f / magnitude());
  }

  /**
   * Computes this vector's dot product with another vector.
   */
  public float dot(Vector4F that) {
    return this.x * that.x + this.y * that.y + this.z * that.z + this.w * that.w;
  }

  /**
   * Drop the last (w) component of this vector, resulting in a three dimensional vector.
   */
  public Vector3F dropLastComponent() {
    return new Vector3F(x, y, z);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append(x).append(y).append(z).append(w).toString();
  }
}
