package Drawables.Link;

import Drawables.Link.Arrow.ClassicArrow;
import Drawables.Link.Line.DashedLine;

public class DependencyLink extends Link {

    public DependencyLink() {
        arrow = new ClassicArrow();
        line = new DashedLine();
    }
}
