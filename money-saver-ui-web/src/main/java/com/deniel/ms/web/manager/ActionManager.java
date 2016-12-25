package com.deniel.ms.web.manager;

import com.deniel.ms.web.action.HomeAction;
import com.deniel.ms.web.action.NotFoundAction;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DenielNote on 16.11.2016.
 */
public class ActionManager {
    private final Map<String, IAction> actionList = new HashMap<>();
    private ApplicationContext context;

    public ActionManager(ApplicationContext context) {
        this.context = context;
        fillActionList();
    }

    public synchronized IAction findAction(String actionInstance) {
        IAction returnAction = actionList.get(actionInstance);
        if (returnAction == null) {
            return actionList.get("notfoundaction");
        }
        return returnAction;
    }

    private void fillActionList() {
        actionList.put("homepage", context.getBean("homeaction", HomeAction.class));
        actionList.put("notfoundaction", context.getBean("notfoundaction", NotFoundAction.class));
    }
}
