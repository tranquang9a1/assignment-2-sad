package sad.teamone.common.util;

import org.reflections.Reflections;

/**
 * Created by Tuyen on 10/19/2014.
 */
public enum ProjectReflections {
    INSTANCE;
    protected static final Reflections reflections = new Reflections("sad.teamone");

    public Reflections getReflections() {
        return reflections;
    }
}
