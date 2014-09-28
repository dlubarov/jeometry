package org.jeometry;

import java.util.List;

/**
 * A two dimensional polygon, encoded with floats.
 */
public final class Polygon2F {
  final Vector2F[] vertices;

  Polygon2F(Vector2F... vertices) {
    this.vertices = vertices;
  }

  /**
   * Creates a polygon comprised of the given vertices.
   */
  public static Polygon2F of(Vector2F... vertices) {
    Check.notNull(vertices, "the given array was null");
    vertices = vertices.clone(); // to enforce immutability
    for (Vector2F vertex : vertices)
      Check.notNull(vertex, "the given vertex array contained a null entry");
    return new Polygon2F(vertices);
  }

  /**
   * Creates a polygon comprised of the given vertices.
   */
  public static Polygon2F of(List<Vector2F> vertices) {
    Check.notNull(vertices, "the given list was null");
    Vector2F[] vertexArray = vertices.toArray(new Vector2F[vertices.size()]);
    for (Vector2F vertex : vertexArray)
      Check.notNull(vertex, "the given vertex array contained a null entry");
    return new Polygon2F(vertexArray);
  }

  /**
   * Get the vertices of this polygon.
   */
  public Vector2F[] getVertices() {
    return vertices.clone();
  }

  /**
   * Get the edges of this polygon.
   */
  public LineSegment2F[] getEdges() {
    int n = vertices.length;
    LineSegment2F[] edges = new LineSegment2F[n];
    for (int i = 0; i < n; ++i)
      edges[i] = new LineSegment2F(vertices[i], vertices[(i + 1) % n]);
    return edges;
  }

  /**
   * Get a bounding box enclosing this polygon.
   */
  public AxisAlignedBox2F getBoundingBox() {
    return AxisAlignedBox2F.fromPoints(vertices);
  }

  @Override
  public String toString() {
    ToStringBuilder toStringBuilder = new ToStringBuilder(this);
    for (Vector2F vertex : vertices)
      toStringBuilder.append(vertex);
    return toStringBuilder.toString();
  }
}
