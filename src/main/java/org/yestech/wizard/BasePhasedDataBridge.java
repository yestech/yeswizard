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


/**
 * This represents the Base class for a {@link IPhasedDataBridge}.  By default it
 * <b>ALWAYS</b> returns false.
 *
 * @author $Author: $
 * @version $Revision: $
 */
public abstract class BasePhasedDataBridge implements IPhasedDataBridge
{

    public BasePhasedDataBridge() {
        super();
    }

    /**
     * Returns whether or not the {@link IPhasedScreen} should activate a next option.
     *
     * @return True if active else False to deactivate
     */
    public boolean getNext() {
        return false;
    }

    /**
     * Returns whether or not the {@link IPhasedScreen} should activate a prev option.
     *
     * @return True if active else False to deactivate
     */
    public boolean getPrev() {
        return false;
    }

    /**
     * Returns whether or not the {@link IPhasedScreen} should activate a cancel option.
     *
     * @return True if active else False to deactivate
     */
    public boolean getCancel() {
        return false;
    }

    /**
     * Returns whether or not the {@link IPhasedScreen} should activate a finish option.
     *
     * @return True if active else False to deactivate
     */
    public boolean getFinish() {
        return false;
    }

    /**
     * Returns whether or not the {@link IPhasedScreen} should activate a skip option.
     *
     * @return True if active else False to deactivate
     */
    public boolean getSkip() {
        return false;
    }

}
