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

/*
 * File name:           $RCSfile: $
 *
 * Revision:            $Revision: $
 * Last revised by:     $Author: $
 * Last revision date:  $Date: $
 *
 * Original Author:     Arthur Copeland
 *
 * Licensed using GPL Available - http://opensource.org/licenses/gpl-license.php
 *
 */

package org.yestech.wizard;

import java.util.EventListener;

/**
 * Abstraction contains UI necessary to navigate the phased process
 *
 * @author $Author: $
 * @version $Revision: $
 *
 */
public interface IPhasedScreen {

    /**
     * Typically, data is retrieved from the Screens UI
     * objects and tested for validity.
     * <p>
     * If all of the data is valid, this should return true
     * so that the caller can proceed (usually by storing
     * the result somewhere and destroying the screen.)
     * Naturally, false should be returned if there is
     * any invalid data.
     *
     * @return <code>true</code> if the data in the dialog is acceptable,
     * <code>false</code> if the data fails to meet validation criteria.
     *
     * @see #nextPressed(IPhasedEvent)
     */
    public boolean validateData();

    /**
     * Saves all the Parameter Data for a PhasedScreen and returns the Result
     * if there is any.
     *
     * @return the Saved Data
     */
    public Object saveData();

    /**
     * Implements the action to occur when the <CODE>Next</CODE> button
     * is pressed.
     * @param event
     */
    public void nextPressed(IPhasedEvent event);

    /**
     * Implements the action to occur when the Previous button is pressed.
     * @param event
     */
    public void prevPressed(IPhasedEvent event);

    /**
     * Implements the action to occur when the Cancel button
     * is pressed
     * @param event
     */
    public void cancelPressed(IPhasedEvent event);

    /**
     * Implements the action to occur when the Finish button
     * is pressed
     * @param event
     */
    public void finishPressed(IPhasedEvent event);

    /**
     * Skip to the given phase.
     * @param newPhase value identifying the new phase.
     * @param event
     */
    public void skipToPhase(int newPhase, IPhasedEvent event);
}
