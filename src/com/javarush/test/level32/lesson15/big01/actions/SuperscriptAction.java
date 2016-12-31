package com.javarush.test.level32.lesson15.big01.actions;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Created by butkoav on 29.12.2016.
 */
public class SuperscriptAction extends StyledEditorKit.StyledTextAction
{
    private View view;

    public SuperscriptAction()
    {
        super(StyleConstants.Superscript.toString());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        JEditorPane editor = getEditor(actionEvent);
        if (editor != null)
        {
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setSuperscript(simpleAttributeSet, !StyleConstants.isSuperscript(mutableAttributeSet));
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }
}
