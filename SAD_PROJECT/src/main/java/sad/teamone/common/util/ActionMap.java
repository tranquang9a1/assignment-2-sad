package sad.teamone.common.util;

import sad.teamone.common.action.Action;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Tuyen on 10/16/2014.
 */
public enum ActionMap {
    INSTANCE;

    private static final Map<String, Action> actionMap = new ConcurrentHashMap<String, Action>();

    public Action getAction(String url) {
        return actionMap.get(url);
    }

    public void addAction(String url, Action action) {
        actionMap.put(url, action);
    }

    public void viewAllMappedUrls() {
        for (String url : actionMap.keySet()) {
            System.out.println("Mapped url: " + url);
        }
    }
}
