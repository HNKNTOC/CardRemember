package com.cardRemember.controller;

import com.cardRemember.model.Data;
import com.cardRemember.view.MenuView;
import com.cardRemember.view.SelectExerciseView;
import com.cardRemember.view.View;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Control {@link com.cardRemember.view.MenuView}
 */
public class MenuController extends Controller {
    private static final Logger LOGGER = LogManager.getLogger(MenuController.class);
    private static ApplicationContext context =
            new ClassPathXmlApplicationContext("beans/dataSelectExercise.xml");

    public MenuController(MenuView menuView, Data data) {
        super(data, menuView);
    }

    public MenuController() {
        super();
    }

    public ListenerSelectExercise initListenerSelectExercise(){
        return new ListenerSelectExercise();
    }

    public ListenerItemOne initListenerItemOne(){
        return new ListenerItemOne();
    }

    private void showSelectExercise(){
        View view = new SelectExerciseView();
        Data dataSelectExercise = context.getBean("dataSelectExercise",Data.class);
        SelectExerciseController controller = new SelectExerciseController(dataSelectExercise,view);
        controller.update();
    }

    public class ListenerItemOne implements ActionListener{
        private  final Logger LOGGER = LogManager.getLogger(ListenerItemOne.class);

        @Override
        public void actionPerformed(ActionEvent e) {
            LOGGER.info(e);
        }
    }

    public class ListenerSelectExercise implements ActionListener{
        private final Logger LOGGER = LogManager.getLogger(ListenerSelectExercise.class);

        @Override
        public void actionPerformed(ActionEvent e) {
            LOGGER.info(e);
            showSelectExercise();
        }
    }

}
