package org.jeometry;

/**
 * An immutable three dimensional spatial vector, encoded with floats.
 */
public final class Vector3F {
  public static final Vector3F
      ZERO = new Vector3F(0, 0, 0),
      UNIT_X = new Vector3F(1, 0, 0),
      UNIT_Y = new Vector3F(0, 1, 0),
      UNIT_Z = new Vector3F(0, 0, 1);

  final float x, y, z;

  /**
   * Creates a new vector with the given components.
   *
   * @param x the first (x) component
   * @param y the second (y) component
   * @param z the third (z) component
   */
  public Vector3F(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
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
   * Replaces this vector's x component with another value.
   *
   * @param x the new x component
   * @return a new vector with the given x component
   */
  public Vector3F withX(float x) {
    return new Vector3F(x, y, z);
  }

  /**
   * Replaces this vector's y component with another value.
   *
   * @param y the new y component
   * @return a new vector with the given y component
   */
  public Vector3F withY(float y) {
    return new Vector3F(x, y, z);
  }

  /**
   * Replaces this vector's z component with another value.
   *
   * @param z the new z component
   * @return a new vector with the given z component
   */
  public Vector3F withZ(float z) {
    return new Vector3F(x, y, z);
  }

  /**
   * Returns the opposite of this vector, in particular, with each component negated.
   *
   * @return the opposite vector
   */
  public Vector3F opposite() {
    return new Vector3F(-x, -y, -z);
  }

  /**
   * Multiplies each component of this vector by some scalar and returns the result.
   *
   * @param s the scalar to multiply by
   * @return the scaled vector
   */
  public Vector3F scaled(float s) {
    return new Vector3F(s * x, s * y, s * z);
  }

  /**
   * The l^2 Euclidean norm of this vector.
   */
  public float magnitude() {
    return FloatMath.sqrt(x * x + y * y + z * z);
  }

  /**
   * The square of the l^2 Euclidean norm of this vector.
   */
  public float magnitudeSquared() {
    return x * x + y * y + z * z;
  }

  /**
   * Adds a given vector to this vector.
   *
   * @param that the vector to add
   * @return the sum
   */
  public Vector3F plus(Vector3F that) {
    return new Vector3F(this.x + that.x, this.y + that.y, this.z + that.z);
  }

  /**
   * Subtracts a given vector from this vector.
   *
   * @param that the vector to subtract
   * @return the difference
   */
  public Vector3F minus(Vector3F that) {
    return new Vector3F(this.x - that.x, this.y - that.y, this.z - that.z);
  }

  /**
   * Computes the l^2 Euclidean distance from this vector to the given vector.
   *
   * @param that the other vector
   * @return the Euclidean distance between the vectors
   */
  public float distanceTo(Vector3F that) {
    return this.minus(that).magnitude();
  }

  /**
   * Computes the square of the l^2 Euclidean distance from this vector to the given vector.
   *
   * @param that the other vector
   * @return the Euclidean distance between the vectors
   */
  public float distanceSquaredTo(Vector3F that) {
    return this.minus(that).magnitudeSquared();
  }

  /**
   * Normalize this vector. Undefined behavior if called on the zero vector.
   *
   * @return the normalized vector, having the original vector's direction and a magnitude of 1
   */
  public Vector3F normalized() {
    float magnitude = magnitude();
    if (magnitude == 0)
      throw new RuntimeException("cannot normalize the zero vector");
    return this.scaled(1f / magnitude);
  }

  /**
   * Computes this vector's dot product with another vector.
   */
  public float dot(Vector3F that) {
    return this.x * that.x + this.y * that.y + this.z * that.z;
  }

  /**
   * Computes this vector's cross-product with another vector, assuming a right handed system.
   */
  public Vector3F cross(Vector3F that) {
    return new Vector3F(
        this.y * that.z - this.z * that.y,
        this.z * that.x - this.x * that.z,
        this.x * that.y - this.y * that.x);
  }

  /**
   * Add an extra (w) component to this vector, resulting in a four dimensional vector.
   */
  public Vector4F addLastComponent(float w) {
    return new Vector4F(x, y, z, w);
  }

  /**
   * Drop the last (z) component of this vector, resulting in a two dimensional vector.
   */
  public Vector2F dropLastComponent() {
    return new Vector2F(x, y);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append(x).append(y).append(z).toString();
  }
}
