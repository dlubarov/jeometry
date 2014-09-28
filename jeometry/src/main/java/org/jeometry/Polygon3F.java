package org.jeometry;

import java.util.List;

/**
 * A three dimensional polygon, encoded with floats.
 */
public final class Polygon3F {
  final Vector3F[] vertices;

  Polygon3F(Vector3F... vertices) {
    this.vertices = vertices;
  }

  /**
   * Creates a polygon comprised of the given vertices. It is assumed that the given vertices share
   * a common plane. If this requirement is not satisfied, the behavior is undefined.
   */
  public static Polygon3F of(Vector3F... vertices) {
    Check.notNull(vertices, "the given array was null");
    vertices = vertices.clone(); // to enforce immutability
    for (Vector3F vertex : vertices)
      Check.notNull(vertex, "the given vertex array contained a null entry");
    return new Polygon3F(vertices);
  }

  /**
   * Creates a polygon comprised of the given vertices. It is assumed that the given vertices share
   * a common plane. If this requirement is not satisfied, the behavior is undefined.
   */
  public static Polygon3F of(List<Vector3F> vertices) {
    Check.notNull(vertices, "the given list was null");
    Vector3F[] vertexArray = vertices.toArray(new Vector3F[vertices.size()]);
    for (Vector3F vertex : vertexArray)
      Check.notNull(vertex, "the given vertex array contained a null entry");
    return new Polygon3F(vertexArray);
  }

  /**
   * Get the vertices of this polygon.
   */
  public Vector3F[] getVertices() {
    return vertices.clone();
  }

  /**
   * Get the edges of this polygon.
   */
  public LineSegment3F[] getEdges() {
    int n = vertices.length;
    LineSegment3F[] edges = new LineSegment3F[n];
    for (int i = 0; i < n; ++i)
      edges[i] = new LineSegment3F(vertices[i], vertices[(i + 1) % n]);
    return edges;
  }

  /**
   * Get a bounding box enclosing this polygon.
   */
  public AxisAlignedBox3F getBoundingBox() {
    return AxisAlignedBox3F.fromPoints(vertices);
  }

  @Override
  public String toString() {
    ToStringBuilder toStringBuilder = new ToStringBuilder(this);
    for (Vector3F vertex : vertices)
      toStringBuilder.append(vertex);
    return toStringBuilder.toString();
  }
}
