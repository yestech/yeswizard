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
import java.util.List;

/**
 * An abstraction of a phased dispatch object. This object handles moving
 * through various phases of a process, finishing, cancelling, incrementing
 * to the next, and moving backward to a previous phase.
 *
 * @author $Author: $
 * @version $Revision: $
 */
public abstract class PhasedProcessor<R,D> implements IPhasedProcessor<R,D>
{
    //--------------------------------------------------------------------------
    // M E M B E R   V A R I A B L E S
    //--------------------------------------------------------------------------
    /**
     * Holds the logger
     */
    final private static Logger logger = LoggerFactory.getLogger(PhasedProcessor.class);

    /**
     * This stack tracks the progression through the frames.
     * It makes it simple to implement the Previous button.
     */
    private List<Integer> frameStack;

    private int currentPhase;

    /**
     * Creates new PhasedProcess
     */
    public PhasedProcessor()
    {
        frameStack = new ArrayList<Integer>();
    }

    /**
     * Sets <code>currentPhase</code> to its next value. "advance" is a slight
     * misnomer since <code>currentPhase</code> can be incremented, decremented,
     * or, in fact set to any value, with this method. Typically, however,
     * it is incremented.
     *
     * @param phase
     * @param data  Any data the message wishes to pass along to the {@link IPhasedScreen}.
     *              May safely be <code>null</code>.
     *              <p/>
     *              <b>Note</b> If the <code>data</code> param is an <code>Integer</code> when
     *              <code>msg</code> is <code>MSG_INIT</code> or <code>MSG_SKIP</code>, then
     *              the value of the <code>data</code> paramter will be used to set
     *              the value of <code>{@link PhasedEnum#CURRENT_PHASE currentPhase}</code>. @return Return any data returned by the Phase
     */
    public R phasedProcessHandler(PhasedEnum phase, D data)
    {
        switch (phase)
        {
            case MSG_INIT:
                // set currentPhase to data value if passed, or set to zero
                if (null != data && data instanceof Integer)
                {
                    currentPhase = (Integer) data;
                }
                else
                {
                    currentPhase = 0;
                }
                // push stage onto stack so next frame's Previous button works
                frameStack.add(currentPhase);
                break;
            case MSG_NEXT:
                currentPhase++;
                frameStack.add(currentPhase);
                break;
            case MSG_PREV:
                if (frameStack.size() <= 1)
                {
                    logger.error("Error: Popped too much off the stack!");
                    throw new RuntimeException("Error: Popped too much off the stack!");
                }
                // grab previous frame id from the stack
                int prevPhase = frameStack.get(frameStack.size() - 2);
                frameStack.remove(frameStack.size() - 1);  // remove frame we just came from
                currentPhase = prevPhase;
                break;
            case MSG_SKIP:
                if (null != data && data instanceof Integer)
                {
                    currentPhase = (Integer) data;
                }
                else
                {
                    logger.error("Error: phasedProcessHandler got MSG_SKIP with bad phase parameter.");
                    throw new RuntimeException("Error: phasedProcessHandler got MSG_SKIP with bad phase parameter.");
                }
                break;
            case MSG_FINISH:
                return processFinished(data);
            case MSG_CANCEL:
                return processCancelled(data);
            default:
                logger.error("Error: phasedProcessHandler: Unknown msg: " + phase);
                throw new RuntimeException("Error: phasedProcessHandler: Unknown msg: " + phase);
        } // switch(msg)

        return performCurrentPhase(data);
    }


    /**
     * This dispatch method uses <code>currentPhase</code> to switch among one or more
     * possible operations.
     * <p/>
     * Typically, the approach used here looks something like this:
     * <p><pre><font color="blue">
     *         switch (currentPhase) {
     *             case PHASE_ABC:
     *                 <i>[...]</i>
     *                 break;
     *             case PHASE_XYZ:
     *                 <i>[...]</i>
     *             default:
     *                 System.out.println("Error: performCurrentPhase: Unknown phase: " + currentPhase);
     *         }
     * </font></pre>
     *
     * @param data Data to pass to {@link IPhasedScreen}
     * @return Data return by {@link IPhasedScreen}
     */
    abstract public R performCurrentPhase(D data);

    /**
     * Begins the process.
     */
    public R beginProcess()
    {
        return beginProcess(null);
    }

    /**
     * Begins the process with configuration options
     *
     * @param data Parameters to pass
     */
    public R beginProcess(D data)
    {
        return phasedProcessHandler(PhasedEnum.MSG_INIT, data);
    }

    /**
     * Cancels the current phased process.
     */
    public R cancelProcess()
    {
        return cancelProcess(null);
    }

    /**
     * Cancels the current phased process with configuration options.
     *
     * @param data Parameters to pass
     */
    public R cancelProcess(D data)
    {
        return phasedProcessHandler(PhasedEnum.MSG_CANCEL, data);
    }

    /**
     * Finish the current phased process.
     */
    public R finishProcess()
    {
        return finishProcess(null);
    }

    /**
     * Finish the current phased process with configuration options.
     *
     * @param data Parameters to pass
     */
    public R finishProcess(D data)
    {
        return phasedProcessHandler(PhasedEnum.MSG_FINISH, data);
    }

    /**
     * Returns the id of the current phase to process.
     *
     * @return the id
     */
    protected int getCurrentPhase()
    {
        return currentPhase;
    }

    /**
     * Returns the id of the current phase to process.
     *
     * @param phase the id
     */
    protected void setCurrentPhase(int phase)
    {
        this.currentPhase = phase;
    }

    /**
     * Sets the id of the message used to trigger process.
     *
     * @param msg the id
     */
    protected void setCurrentMessage(int msg)
    {
        this.currentPhase = msg;
    }

    /**
     * Returns the id of the message used to trigger process.
     *
     * @return the id
     */
    protected int getCurrentMessage()
    {
        return currentPhase;
    }

    /**
     * This method is called when the entire process has been cancelled.
     * Normally, this occurs when <code>phasedProcessHandler</code>
     * gets a <code>MSG_CANCEL</code> message.
     * <p/>
     * it resets currentPhase to -1
     *
     * @param data Data to pass along
     */
    protected R processCancelled(D data)
    {
        currentPhase = -1;
        return null;
    }

    /**
     * This method is called when the entire process is complete, either
     * by naturally moving through all the phases, or possibly by the
     * user pressing the Finish button.
     * <p/>
     * it resets currentPhase to -1
     *
     * @param data Data to pass along
     */
    protected R processFinished(D data)
    {
        currentPhase = -1;
        return null;
    }


}
