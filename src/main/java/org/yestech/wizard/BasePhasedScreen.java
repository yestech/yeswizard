/*
 * YES Technology - http://yestech.org
 *
 * Licensed using GPL Available - http://opensource.org/licenses/gpl-license.php
 *
 * File name:           $RCSfile: $
 * Revision:            $Revision: $
 * Last revised by:     $Author: $
 * Last revision date:  $Date: $
 *
 * Original Author:     Arthur Copeland
 *
 */
package org.yestech.wizard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstraction contains UI necessary to navigate the phased process (Previous,
 * Next, Finish, and Cancel buttons) and supporting structures for subclassers'
 * UI.
 *
 * @author $Author: $
 * @version $Revision: $
 */
public abstract class BasePhasedScreen implements IPhasedScreen
{
    //--------------------------------------------------------------------------
    // M E M B E R   V A R I A B L E S
    //--------------------------------------------------------------------------
    /**
     * Holds the logger
     */
    final private static Logger logger = LoggerFactory.getLogger(BasePhasedScreen.class);

    private IPhasedEvent event;

    /**
     * Creates new PhaseFrame.
     *
     */
    public BasePhasedScreen()
    {
    }

    protected IPhasedEvent getEvent()
    {
        return event;
    }

    protected void setEvent(IPhasedEvent event)
    {
        this.event = event;
    }

    /**
     * Typically, data is retrieved from the Screens UI
     * objects and tested for validity.
     * <p/>
     * If all of the data is valid, this should return true
     * so that the caller can proceed (usually by storing
     * the result somewhere and destroying the screen.)
     * Naturally, false should be returned if there is
     * any invalid data.
     * <p/>
     * This version in the abstract implementation does nothing and
     * generally should be overridden.
     *
     * @return <code>true</code> if the data in the dialog is acceptable,
     *         <code>false</code> if the data fails to meet validation criteria.
     */
    public boolean validateData()
    {
        // no data in abstract dialog, so this always returns true
        return true;
    }

    /**
     * Saves all the Parameter Data for a PhasedScreen and returns the Result
     * if there is any.
     *
     * @return the Saved Data
     */
    public abstract Object saveData();

    /**
     * Implements the action to occur when the <CODE>Next</CODE> button
     * is pressed.
     * <p/>
     * The default implementation calls <code>validateData</code>
     * and, if the data is valid, then calls <code>saveData</code>,
     * makes the frame invisible, and calls <code>
     * dispatcher.phasedProcessHandler(SimpleDispatcher.MSG_NEXT, null);</code>
     *
     * @see #validateData
     * @see #saveData
     * @param event
     */
    public void nextPressed(IPhasedEvent event)
    {
        setEvent(event);
        if (!validateData())
            return;

        saveData();

        getPhasedProcess().phasedProcessHandler(PhasedEnum.MSG_NEXT, null);
    }

    private IPhasedProcessor getPhasedProcess()
    {
        return getEvent().getProcessor();
    }

    /**
     * Implements the action to occur when the Previous button is pressed.
     * The default implementation is:<p><pre>
     *        dispatcher.phasedProcessHandler(PhasedProcess.MSG_PREV, null);
     * </pre>
     * @param event
     */
    public void prevPressed(IPhasedEvent event)
    {
        setEvent(event);
        getPhasedProcess().phasedProcessHandler(PhasedEnum.MSG_PREV, null);
    }

    /**
     * Implements the action to occur when the Cancel button
     * is pressed
     * @param event
     */
    public void cancelPressed(IPhasedEvent event)
    {
        setEvent(event);
        getPhasedProcess().phasedProcessHandler(PhasedEnum.MSG_CANCEL, null);
    }

    /**
     * Skip to the given phase.
     *
     * @param newPhase value identifying the new phase.
     */
    public void skipToPhase(int newPhase)
    {
        setEvent(event);
        getPhasedProcess().phasedProcessHandler(PhasedEnum.MSG_SKIP, newPhase);
    }

    /**
     * Implements the action to occur when the Finish button
     * is pressed
     * @param event
     */
    public void finishPressed(IPhasedEvent event)
    {
        setEvent(event);
        if (!validateData())
            return;

        saveData();
        getPhasedProcess().phasedProcessHandler(PhasedEnum.MSG_FINISH, null);
    }
}

