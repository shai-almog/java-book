package com.debugagent.extensions.java.util.Collection;

import com.debugagent.extensions.Sizable;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Stream;

@Extension
public abstract class CollectionExt implements Sizable {
    public static <E, R> Stream<R> map( @This Collection<E> t, Function<? super E, R> mapper ) {
        return t.stream().map(mapper);
    }
}
