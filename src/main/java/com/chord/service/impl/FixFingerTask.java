/***************************************************************************
 *                                                                         *
 *                            FixFingerTask.java                           *
 *                            -------------------                          *
 *   date                 : 16.08.2004                                     *
 *   copyright            : (C) 2004-2008 Distributed and                  *
 *                              Mobile Systems Group                       *
 *                              Lehrstuhl fuer Praktische Informatik       *
 *                              Universitaet Bamberg                       *
 *                              http://www.uni-bamberg.de/pi/              *
 *   email                : sven.kaffille@uni-bamberg.de                   *
 *                      karsten.loesing@uni-bamberg.de                 *
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

import com.chord.Node;
import com.chord.data.ID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Looks up the node for a certain ID and stores the reference of the
 * responsible node in the local finger table.
 *
 * @author Sven Kaffille, Karsten Loesing
 * @version 1.0.5
 */
final class FixFingerTask implements Runnable {

    /**
     * Instance of random generator for randomly picking another finger to fix.
     */
    private final Random random = new Random();

    /**
     * Parent object for invoking findSuccessor.
     */
    private final NodeImpl parent;

    /**
     * Object logger.
     */
    private final Logger logger;

    /**
     * Copy of the local node's ID for determining which ID to look up.
     */
    private final ID localID;

    /**
     * Reference on routing table.
     */
    private final References references;

    /**
     * Creates a new instance, but without starting a thread running it.
     *
     * @param parent     Parent object for invoking findSuccessor.
     * @param localID    Copy of the local node's ID for determining which ID to look
     *                   up.
     * @param references Reference on routing table.
     * @throws NullPointerException If either of the parameters has value <code>null</code>.
     */
    FixFingerTask(NodeImpl parent, ID localID, References references) {
        if (parent == null || localID == null || references == null) {
            throw new NullPointerException(
                    "Neither parameter of constructor may be null!");
        }
        // June 21st, 2006. Corrected logger name from FixFingerTask.class to
        // actual version. sven
        this.logger = LoggerFactory.getLogger(FixFingerTask.class.getName() + "."
                + localID);

        this.parent = parent;
        this.localID = localID;
        this.references = references;
    }

    public void run() {

        try {

            int nextFingerToFix = this.random.nextInt(this.localID.getLength());
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("fixFingers tries to get finger for key "
                        + this.localID.addPowerOfTwo(nextFingerToFix));
            }

            // look up reference
            ID lookForID = this.localID.addPowerOfTwo(nextFingerToFix);
            Node newReference;
            // try {
            newReference = this.parent.findSuccessor(lookForID);

            // add new reference to finger table, if not yet included
            if (newReference != null
                    && !this.references.containsReference(newReference)) {
                if (this.logger.isInfoEnabled()) {
                    this.logger.info("Adding new reference "
                            + newReference.getNodeID().toString());
                }
                this.references.addReference(newReference);
            }

            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Invocation of fix fingers was successful");
            }

        } catch (Exception e) {
            this.logger.warn(
                    "Unexpected Exception caught in FixFingerTask!", e);
        }
    }
}