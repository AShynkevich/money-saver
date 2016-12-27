package com.deniel.ms.web.manager;

import java.util.Map;

/**
 * Created by DenielNote on 16.11.2016.
 */
public class ActionManager {
    private Map<String, IAction> actionList;

    public void setActionList(Map<String, IAction> actionList) {
        this.actionList = actionList;
    }

    public synchronized IAction findAction(String actionInstance) {
        IAction returnAction = actionList.get(actionInstance);
        if (returnAction == null) {
            return actionList.get("notfoundaction");
        }
        return returnAction;
    }
}
