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

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * @author $Author: $
 * @version $Revision: $
 */
public class PhasedParametersTest
{

    private PhasedParameters parameters;

    @Before
    public void setUp()
    {
        parameters = new PhasedParameters();
    }

    @Test
    public void testAddParameter()
    {
        parameters.addParameter(new Screen1State());
        parameters.addParameter(new Screen2State());
        assertEquals(2, parameters.getParameterCount());
        assertEquals(Screen1State.class, parameters.getParameter(0).getClass());
        assertEquals(Screen2State.class, parameters.getParameter(1).getClass());
    }

    private class Screen1State implements IPhasedState
    {

    }

    private class Screen2State implements IPhasedState
    {

    }
}
