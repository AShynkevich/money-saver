package com.deniel.ms.web.manager;

import com.deniel.ms.web.action.HomeAction;
import com.deniel.ms.web.action.NotFoundAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DenielNote on 16.11.2016.
 */
public class ActionManager {
    private static final Map<String, IAction> actionList = new HashMap<>();
    private static ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
    static {

        actionList.put("homepage", context.getBean("homeaction", HomeAction.class));
    }

    public static synchronized IAction findAction(String actionInstance) {
        IAction returnAction = actionList.get(actionInstance);
        if (returnAction == null) {
            return context.getBean("notfoundaction", NotFoundAction.class);
        }
        return returnAction;
    }
}
