package com.cardRemember.view;

import com.cardRemember.model.Data;
import com.cardRemember.model.DataType;
import com.cardRemember.model.Exercise;

import javax.swing.*;
import java.util.List;

/**
 * Display Menu Select Exercise.
 */
public class SelectExerciseView extends  SwingView{

    public static final String listExercise = "ListExercise";

    public SelectExerciseView() {
        super(DataType.SelectExercise);
    }

    @Override
    void processingDataFromModel(Data data) throws ClassCastException {
        List<Exercise> listExercise = (List<Exercise>) data.getValue(this.listExercise);
        String[] listName = new String[listExercise.size()];

        for (int i = 0; i < listExercise.size(); i++) {
            listName[i] = listExercise.get(i).getName();
        }

        mainFrame.add(new JList<>(listName));
    }
}
