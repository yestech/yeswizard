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

/**
 * This interface represents a Bridge for a {@link IPhasedScreen} to allow them
 * to be decoupled from the top level view.  But still allow them to signal whether
 * or not certain navigation options should be activated or deactivated dynamically.
 *
 * @author $Author: $
 * @version $Revision: $
 */
public interface IPhasedDataBridge
{

    /**
     * Returns whether or not the {@link IPhasedScreen} should activate a next option.
     *
     * @return True if active else False to deactivate
     */
    public boolean getNext();

    /**
     * Returns whether or not the {@link IPhasedScreen} should activate a prev option.
     *
     * @return True if active else False to deactivate
     */
    public boolean getPrev();

    /**
     * Returns whether or not the {@link IPhasedScreen} should activate a cancel option.
     *
     * @return True if active else False to deactivate
     */
    public boolean getCancel();

    /**
     * Returns whether or not the {@link IPhasedScreen} should activate a finish option.
     *
     * @return True if active else False to deactivate
     */
    public boolean getFinish();

    /**
     * Returns whether or not the {@link IPhasedScreen} should activate a skip option.
     *
     * @return True if active else False to deactivate
     */
    public boolean getSkip();

}
