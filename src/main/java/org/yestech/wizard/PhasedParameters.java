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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is all the parameters that are passed to a {@link PhasedProcessor}.
 * The parameters are stored in sequential order.
 *
 * @author $Author: $
 * @version $Revision: $
 */
public class PhasedParameters<P extends IPhasedState> implements IPhasedParameters<P>
{
    //--------------------------------------------------------------------------
    // M E M B E R   V A R I A B L E S
    //--------------------------------------------------------------------------
    /**
     * Holds the logger
     */
    final private static Logger logger = LoggerFactory.getLogger(PhasedParameters.class);
    
    private ArrayList<P> params;

    /**
     * Creates new PhasedParameters
     */
    public PhasedParameters() {
        params = new ArrayList<P>();
    }

    /**
     * This method adds a Parameter to the parameters.
     * The parameter is always added to the end.
     *
     * @param param Parameter to add
     */
    public void addParameter(P param) {
        params.add(param);
    }

    /**
     * This method adds a Parameter to the parameters.
     *
     * @param idx index to add parameter
     * @param param Parameter to add
     */
    public void setParameter(int idx, P param) {
        params.set(idx, param);
    }

    /**
     * Returns the Parameter located @ the location index supplied.
     *
     * @param index Index parameter located @
     * @return The parameter
     */
    public P getParameter(int index) {
        return params.get(index);
    }

    /**
     * Returns the number of parameters stored
     *
     * @return The number of parameters
     */
    public int getParameterCount() {
        return params.size();
    }

    public Iterator<P> iterator()
    {
        return params.listIterator();
    }
}
