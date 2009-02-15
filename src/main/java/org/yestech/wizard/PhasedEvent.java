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
 * This is represents an Event that is passed to a {@link IPhasedScreen} from
 * a {@link PhasedProcessor}.
 *
 * @author $Author: $
 * @version $Revision: $
 */
public class PhasedEvent implements IPhasedEvent
{
    private IPhasedParameters parameters;
    private IPhasedProcessor processor;

    public PhasedEvent(IPhasedProcessor processor, IPhasedParameters parameters) {
        this.processor = processor;
        this.parameters = parameters;
    }

    /**
     * Returns the parameters sent to the {@link IPhasedProcessor} which need to
     * be passed to the {@link IPhasedProcessor}.
     *
     * @return the PhasedParameters
     */
    public IPhasedParameters getParameters() {
        return parameters;
    }

    /**
     * Returns the Concrete type of {@link IPhasedProcessor}.
     *
     * @return IPhasedProcess
     */
    public IPhasedProcessor getProcessor() {
        return processor;
    }
}