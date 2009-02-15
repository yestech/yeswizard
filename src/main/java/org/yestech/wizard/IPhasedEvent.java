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
 * YES Technology - http://yestech.org
 *
 * Licensed using GPL Available - http://opensource.org/licenses/gpl-license.php
 *
 */

package org.yestech.wizard;

import java.io.Serializable;

/**
 * @author $Author: $
 * @version $Revision: $
 */
public interface IPhasedEvent extends Serializable
{
    IPhasedParameters getParameters();

    IPhasedProcessor getProcessor();

    
}
