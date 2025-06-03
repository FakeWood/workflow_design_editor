package Drawables.Link;

import Drawables.Link.Arrow.DiamondArrow;
import Drawables.Link.Line.SolidLine;

public class CompositionLink extends Link {

    public CompositionLink() {
        arrow = new DiamondArrow();
        line = new SolidLine();
    }
}
