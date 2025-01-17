/***************************************************************************
 *                                                                         *
 *                             HashFunction.java                           *
 *                            -------------------                          *
 *   date                 : 16.08.2004                                     *
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

import com.chord.data.ID;
import com.chord.data.URL;
import com.chord.service.Key;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Provides a hash function for calculating the hash value out of {@link Key} or
 * {@link URL} objects.
 *
 * @author Karsten Loesing, Sven Kaffille
 * @version 1.0.5
 */
final class HashFunction {

    /**
     * Singleton instance of this class.
     */
    private static HashFunction hashFunction = null;
    /**
     * Message digest for calculating hash values.
     */
    private final MessageDigest messageDigest;

    /**
     * Constructor is hidden and only invoked once by {@link #getHashFunction()}.
     *
     * @param digest1 Message digest for calculating hash values.
     */
    private HashFunction(MessageDigest digest1) {
        if (digest1 == null) {
            throw new NullPointerException("Parameter may not be null!");
        }
        this.messageDigest = digest1;
    }

    /**
     * Returns the singleton instance of this class.
     *
     * @return Singleton instance of HashFunction.
     * @throws RuntimeException If there is an internal problem with the specified hash
     *                          function of the Java API.
     */
    static HashFunction getHashFunction() {

        if (hashFunction == null) {
            try {
                hashFunction = new HashFunction(MessageDigest
                        .getInstance("SHA-1"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("No hash function available!", e);
            }
        }

        return hashFunction;

    }

    /**
     * Returns the length of IDs generated by this hash function.
     *
     * @return Number of bytes of generated IDs.
     */
    final int getLengthOfIDsInBytes() {
        return this.messageDigest.getDigestLength();
    }

    /**
     * Calculates the hash value for a given data Key.
     *
     * @param entry
     * @return ID for the given Key.
     */
    final ID getHashKey(Key entry) {

        if (entry == null) {
            throw new IllegalArgumentException(
                    "Parameter entry must not be null!");
        }
        if (entry.getBytes() == null || entry.getBytes().length == 0) {
            throw new IllegalArgumentException(
                    "Byte representation of Parameter must not be null or have length 0!");
        }

        byte[] testBytes = entry.getBytes();
        return this.createID(testBytes);
    }

    private final ID createID(byte[] testBytes) {
        /*
         * synchronize access to messageDigest, so that messageDigest cannot be
         * reset by another thread before calculating digest.
         */
        synchronized (this.messageDigest) {
            this.messageDigest.reset();
            this.messageDigest.update(testBytes);
            return new ID(this.messageDigest.digest());
        }
    }

    /**
     * Calculates the hash value for a given URL.
     *
     * @param incomingURL URL of current node which is used to create a pseudo-unique
     *                    ID.
     * @return ID for the given URL.
     * @throws IllegalArgumentException If <code>incomingURL</code> is null!
     */
    final ID createUniqueNodeID(URL incomingURL) {
        if (incomingURL == null) {
            throw new IllegalArgumentException("URL must not be null!");
        }
        String id = incomingURL.toString();
        ID resultKey = this.createID(id.getBytes());
        return resultKey;
    }

}