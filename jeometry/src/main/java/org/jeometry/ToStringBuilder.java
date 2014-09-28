package org.jeometry;

import java.util.ArrayList;
import java.util.List;

final class ToStringBuilder {
  private final Object object;
  private final List<String> fields;

  public ToStringBuilder(Object object) {
    this.object = object;
    this.fields = new ArrayList<>();
  }

  public ToStringBuilder append(Object field) {
    fields.add(field.toString());
    return this;
  }

  public ToStringBuilder append(String name, Object value) {
    return append(name + "=" + value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(object.getClass().getSimpleName()).append('[');
    boolean first = true;
    for (String field : fields) {
      if (first)
        first = false;
      else
        sb.append(", ");
      sb.append(field);
    }
    return sb.append(']').toString();
  }
}
