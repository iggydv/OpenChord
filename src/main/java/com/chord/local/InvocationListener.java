/***************************************************************************
 *                                                                         *
 *                          InvocationListener.java                        *
 *                            -------------------                          *
 *   date                 : 06.10.2004, 13:42                              *
 *   copyright            : (C) 2004-2008 Distributed and                  *
 *                              Mobile Systems Group                       *
 *                              Lehrstuhl fuer Praktische Informatik       *
 *                              Universitaet Bamberg                       *
 *                              http://www.uni-bamberg.de/pi/              *
 *   email                : sven.kaffille@uni-bamberg.de                   *
 *                          karsten.loesing@uni-bamberg.de                 *
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

package com.chord.local;

/**
 * This interface has to be implemented by classes that want to be notified
 * about invocations made to a {@link ThreadEndpoint}.
 *
 * @author sven
 * @version 1.0.5
 */
public interface InvocationListener {

    /**
     *
     */
    int FIND_SUCCESSOR = 0;

    /**
     *
     */
    int INSERT_ENTRY = 1;

    /**
     *
     */
    int INSERT_REPLICAS = 2;

    /**
     *
     */
    int LEAVES_NETWORK = 3;

    /**
     *
     */
    int NOTIFY = 4;

    /**
     *
     */
    int NOTIFY_AND_COPY = 5;

    /**
     *
     */
    int PING = 6;

    /**
     *
     */
    int REMOVE_ENTRY = 7;

    /**
     *
     */
    int REMOVE_REPLICAS = 8;

    /**
     *
     */
    int RETRIEVE_ENTRIES = 9;

//    public final static String[] METHOD_NAMES = new String[] {
//                "findSuccessor", 
//                "insertEntry", 
//                "insertReplicas", 
//                "leavesNetwork", 
//                "notify", 
//                "notifyAndCopyEntries", 
//                "ping", 
//                "removeEntry", 
//                "removeReplicas",
//                "retrieveEntries"
//    };

    /**
     * @param method
     */
    void notifyInvocationOf(int method);

    /**
     * @param method
     */
    void notifyInvocationOfFinished(int method);

}
