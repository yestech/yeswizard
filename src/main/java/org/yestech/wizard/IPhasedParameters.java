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
 * @author $Author: $
 * @version $Revision: $
 */
public interface IPhasedParameters<P extends IPhasedState> extends Iterable<P>
{
    void addParameter(P param);

    P getParameter(int screenIndex);

    int getParameterCount();
}
