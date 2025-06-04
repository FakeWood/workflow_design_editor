package Mode;

import Drawables.Link.*;

public class LinkFactory {
     public enum LinkType {
         ASSOCIATION,
         COMPOSITION,
         GENERALIZATION,
         DEPENDENCY
    }
    static Link createLink(LinkType type) {
        return switch (type) {
            case ASSOCIATION -> new AssociationLink();
            case COMPOSITION -> new CompositionLink();
            case GENERALIZATION -> new GeneralizationLink();
            case DEPENDENCY -> new DependencyLink();
        };
    }
}
