/***************************************************************************
 *                                                                         *
 *                           ChordFutureImpl.java                          *
 *                            -------------------                          *
 *   date                 : 15.10.2005                                     *
 *   copyright            : (C) 2004-2008 Distributed and                  *
 *                              Mobile Systems Group                       *
 *                              Lehrstuhl fuer Praktische Informatik       *
 *                              Universitaet Bamberg                       *
 *                              http://www.uni-bamberg.de/pi/              *
 *   email                : sven.kaffille@uni-bamberg.de                   *
 *   			    		karsten.loesing@uni-bamberg.de                 *
 *                                                                         *
 *                                                                         *
 ***************************************************************************/

/***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 *   A copy of the license can be found in the license.txt file supplied   *
 *   with this software or at: http://www.gnu.org/copyleft/gpl.html        *
 *                                                                         *
 ***************************************************************************/
package com.chord.service.impl;

import com.chord.service.AsynChord;
import com.chord.service.ChordFuture;
import com.chord.service.ServiceException;

/**
 * Abstract implementation of {@link ChordFuture}. Provides common
 * functionality for all {@link ChordFuture} implementations in this package.
 *
 * @author sven
 * @version 1.0.5
 */
abstract class ChordFutureImpl implements ChordFuture {

    /**
     * Indicates that the request to {@link AsynChord} has been completed.
     */
    private boolean isDone = false;

    /**
     * Any Exception/Throwable that occured during execution of request
     * associated with this future.
     */
    private Throwable throwable = null;

    /**
     * Instances of this can only be created by sub classes.
     */
    protected ChordFutureImpl() {
        /*
         * Nothing to do here.
         */
    }

    /**
     * Indicate that the method associated with this has completed.
     */
    final void setIsDone() {
        synchronized (this) {
            this.isDone = true;
            this.notifyAll();
        }
    }

    /**
     * @see ChordFuture
     */
    public Throwable getThrowable() {
        return this.throwable;
    }

    /**
     * Set a {@link Throwable} that occured during execution of method
     * associated with this.
     *
     * @param t
     */
    final void setThrowable(Throwable t) {
        this.throwable = t;
    }

    /**
     * @return <code>true</code> if operation associated with this has been performed.
     * @throws ServiceException
     * @see ChordFuture
     */
    public final boolean isDone() throws ServiceException {
        if (this.throwable != null) {
            throw new ServiceException(this.throwable.getMessage(),
                    this.throwable);
        }
        return this.isDone;
    }

    /**
     * @see ChordFuture
     */
    public void waitForBeingDone() throws ServiceException,
            InterruptedException {
        synchronized (this) {
            while (!this.isDone()) {
                this.wait();
            }
        }
    }

}
