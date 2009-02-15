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

import java.io.Serializable;

/**
 * Holds the WizardConstants for the Wizard Framework
 *
 * @author $Author: $
 * @version $Revision: $
 */
public interface IPhasedConstants extends Serializable {
    /**
     * Holds the prefix to use on parameters for namespaces in the Event Parameters
     */
    final public static String WIZARD_EVENT_PARAMETERS_NAMESPACE_PREFIX = "__wizard__";

    /**
     * Holds the key for the WizardDataBridge
     */
    final public static String WIZARD_DATABRIDGE_KEY = WIZARD_EVENT_PARAMETERS_NAMESPACE_PREFIX + "dataBridge";
}
