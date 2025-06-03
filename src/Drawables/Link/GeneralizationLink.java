package Drawables.Link;

import Drawables.Link.Arrow.TriangleArrow;
import Drawables.Link.Line.SolidLine;

public class GeneralizationLink extends Link {
    public GeneralizationLink() {
        arrow = new TriangleArrow();
        line = new SolidLine();
    }
}
