package org.jeometry;

/**
 * An immutable two dimensional spatial vector, encoded with floats.
 */
public final class Vector2F {
  public static final Vector2F
      ZERO = new Vector2F(0, 0),
      UNIT_X = new Vector2F(1, 0),
      UNIT_Y = new Vector2F(0, 1);

  final float x, y;

  /**
   * Creates a new vector with the given components.
   *
   * @param x the first (x) component
   * @param y the second (y) component
   */
  public Vector2F(float x, float y) {
    this.x = x;
    this.y = y;
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
   * Replaces this vector's x component with another value.
   *
   * @param x the new x component
   * @return a new vector with the given x component
   */
  public Vector2F withX(float x) {
    return new Vector2F(x, y);
  }

  /**
   * Replaces this vector's y component with another value.
   *
   * @param y the new y component
   * @return a new vector with the given y component
   */
  public Vector2F withY(float y) {
    return new Vector2F(x, y);
  }

  /**
   * Returns the opposite of this vector, in particular, with each component negated.
   *
   * @return the opposite vector
   */
  public Vector2F opposite() {
    return new Vector2F(-x, -y);
  }

  /**
   * Multiplies each component of this vector by some scalar and returns the result.
   *
   * @param s the scalar to multiply by
   * @return the scaled vector
   */
  public Vector2F scaled(float s) {
    return new Vector2F(s * x, s * y);
  }

  /**
   * The l^2 Euclidean norm of this vector.
   */
  public float magnitude() {
    return FloatMath.sqrt(x * x + y * y);
  }

  /**
   * The square of the l^2 Euclidean norm of this vector.
   */
  public float magnitudeSquared() {
    return x * x + y * y;
  }

  /**
   * Adds a given vector to this vector.
   *
   * @param that the vector to add
   * @return the sum
   */
  public Vector2F plus(Vector2F that) {
    return new Vector2F(this.x + that.x, this.y + that.y);
  }

  /**
   * Subtracts a given vector from this vector.
   *
   * @param that the vector to subtract
   * @return the difference
   */
  public Vector2F minus(Vector2F that) {
    return new Vector2F(this.x - that.x, this.y - that.y);
  }

  /**
   * Computes the l^2 Euclidean distance from this vector to the given vector.
   *
   * @param that the other vector
   * @return the Euclidean distance between the vectors
   */
  public float distanceTo(Vector2F that) {
    return this.minus(that).magnitude();
  }

  /**
   * Computes the square of the l^2 Euclidean distance from this vector to the given vector.
   *
   * @param that the other vector
   * @return the Euclidean distance between the vectors
   */
  public float distanceSquaredTo(Vector2F that) {
    return this.minus(that).magnitudeSquared();
  }

  /**
   * Normalize this vector.
   *
   * @return the normalized vector, having the original vector's direction and a magnitude of 1
   */
  public Vector2F normalized() {
    return this.scaled(1f / magnitude());
  }

  /**
   * Computes this vector's dot product with another vector.
   */
  public float dot(Vector2F that) {
    return this.x * that.x + this.y * that.y;
  }

  /**
   * Computes a "two dimensional cross product". This is the z component of the two vectors' 3D
   * cross product, if the 2D vectors were treated as 3D vectors with z=0. Assumes a right handed
   * system.
   */
  public float cross(Vector2F that) {
    return this.x * that.y - this.y * that.x;
  }

  /**
   * Add an extra (z) component to this vector, resulting in a three dimensional vector.
   */
  public Vector3F addLastComponent(float z) {
    return new Vector3F(x, y, z);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append(x).append(y).toString();
  }
}
