package com.debugagent.properties;

import manifold.ext.props.rt.api.PropOption;
import manifold.ext.props.rt.api.set;
import manifold.ext.props.rt.api.val;

public class HelloScoping {
    @val(PropOption.Package) int number = 5;
    final @set String str;
}
