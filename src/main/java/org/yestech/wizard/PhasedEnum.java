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
public enum PhasedEnum
{
    /** Message used to indicate Initialization phase. Value is less than zero. */
    MSG_INIT(-100),

    /** Message used to indicate Next logical phase. Value is less than zero. */
    MSG_NEXT(-105),

    /** Message used to indicate Previously visited phase. Value is less than zero. */
    MSG_PREV(-110),

    /** Message used to indicate a jump to a particular phase. Should be paired with
     * an <code>Integer</code> value indicating which new phase, for example:<p><pre>
     *       phasedProcessHandler(PhasedProcess.MSG_SKIP, new Integer(theNewPhase));
     * </pre>
     */
    MSG_SKIP(-115),

    /** Message used to cancellation of entire process. Value is less than zero. */
    MSG_CANCEL(-120),

    /** Message used to indicate completion of all phases. Value is less than zero. */
    MSG_FINISH(-125),


    /**
     * The current stage of the current Session. Typically
     * has values like <CODE>STAGE_XXX...</CODE>
     * The initial value is zero.
     */
    CURRENT_PHASE(-1);
    
    private int currentPhase;

    PhasedEnum(int currentPhase)
    {
        this.currentPhase = currentPhase;
    }

    public int getCurrentPhase()
    {
        return currentPhase;
    }

    public static PhasedEnum get(int phase)
    {
        PhasedEnum phaseEnum = null;
        for (PhasedEnum newPhase : PhasedEnum.values())
        {
            if (newPhase.getCurrentPhase() == phase)
            {
                phaseEnum = newPhase;
                break;
            }
        }
        return phaseEnum;
    }

    @Override
    public String toString()
    {
        return "PhasedEnum{" +
               "currentPhase=" + currentPhase +
               '}';
    }
}
