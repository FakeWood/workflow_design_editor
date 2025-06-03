package Drawables.Link;

import Drawables.Link.Arrow.ClassicArrow;
import Drawables.Link.Line.SolidLine;

public class AssociationLink extends Link {

    public AssociationLink() {
        arrow = new ClassicArrow();
        line = new SolidLine();
    }
}
