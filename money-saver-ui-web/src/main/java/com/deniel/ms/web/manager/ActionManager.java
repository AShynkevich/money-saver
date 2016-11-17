package com.deniel.ms.web.manager;

import com.deniel.ms.web.action.HomeAction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DenielNote on 16.11.2016.
 */
public class ActionManager {
    private static final Map<String, IAction> actionList = new HashMap<>();

    static {
        actionList.put("homepage", new HomeAction());
    }

    public static synchronized IAction findAction(String actionInstance) {
        return actionList.get(actionInstance);
    }
}
