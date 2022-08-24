package org.example.util;

import java.util.List;

public interface Convert<E, V> {
    V convert(E e);

    List<V> convert(List<E> eList);
}
